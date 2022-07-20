package org.main;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.apache.commons.cli.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.bju.BlinkParser;
import org.main.node.StartNode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        List<String> files = parseCommandLineArgs(args);

        String contents = "";
        for(String file : files) {
            String fileContents = Files.readString(Paths.get(file));
            if(!fileContents.endsWith("\n")) {
                fileContents += "\n";
            }
            ErrorReporter.get().addFile(file, fileContents.split("\n").length);
            contents += fileContents;
        }

        CharStream input = CharStreams.fromStream(IOUtils.toInputStream(contents, Charset.defaultCharset()));
        BlinkLexerImpl lexer = new BlinkLexerImpl(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlinkParser parser = new BlinkParser(tokens);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.addErrorListener(new BlinkParseErrorListener());
        BlinkParser.StartContext tree = parser.start();

        if(CommandLineOptions.get().getPrintParserOutput()) {
            Trees.inspect(tree, parser);
        }

        // perform a tree conversion before moving on
        StartNode startNode = (StartNode) new CSTToASTTransformer().visit(tree);
        if(!ErrorReporter.get().hasErrors()) {
            var symTable = (SymbolTable) new BlinkSemanticChecker().visit(startNode);
            if(!ErrorReporter.get().hasErrors()) {
                String assembly = new CodeGenerator(symTable).visit(startNode);
                Files.writeString(Paths.get(files.get(0).replace(".blink", ".s")), assembly);
                Runtime.getRuntime().exec("gcc -o " + files.get(0).replace(".blink", "") + "stdlib.o " +
                        files.get(0).replace(".blink", ".s"));
            }
        }
        System.out.println(ErrorReporter.get().getLexerErrors() + " lexer error(s), " + ErrorReporter.get().getParseErrors() + " syntax error(s), " + ErrorReporter.get().getSemanticErrors() + " semantic error(s)");
    }

    // parse the command line arguments and return all non arg arguments as an ArrayList
    private static List<String> parseCommandLineArgs(String[] args) throws ParseException {
        Options options = new Options();

        // add test option
        options.addOption("ds", "print-lexer-output", false, "Print lexer output");
        options.addOption("dp", "print-parser-output", false, "Print parser output");
        options.addOption("S", "generate-assembly", false, "Generate assembly file");

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

        if(commandLine.hasOption("ds")) {
            CommandLineOptions.get().setPrintLexerOutput(true);
        }
        if(commandLine.hasOption("dp")) {
            CommandLineOptions.get().setPrintParserOutput(true);
        }
        if(commandLine.hasOption("S")) {
            CommandLineOptions.get().setGenerateAssembly(true);
        }

        // all non matched things get returned
        return commandLine.getArgList();
    }
}
