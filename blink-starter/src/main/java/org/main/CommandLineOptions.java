package org.main;

import lombok.Data;

@Data
public class CommandLineOptions {
    private Boolean printLexerOutput = false;
    private Boolean printParserOutput = false;
    private Boolean generateAssembly = false;

    private static CommandLineOptions commandLineOptions;
    // singleton implementation of command line options holder
    public static CommandLineOptions get() {
        if(commandLineOptions == null) {
            commandLineOptions = new CommandLineOptions();
        }
        return commandLineOptions;
    }
}
