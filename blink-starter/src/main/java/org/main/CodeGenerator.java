package org.main;

import org.main.decl.Type;
import org.main.node.*;

public class CodeGenerator implements BlinkASTVisitor<String> {
    private SymbolTable symbolTable;
    public CodeGenerator(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public String visit(StartNode node) {
        String s = "";
        s += "# visit StartNode\n";

        s += ".data\n";

        for (int i = 0; i < symbolTable.getGlobalVariables().size(); ++i) {
            s += "\t.comm\t_" + symbolTable.getGlobalVariables().get(i).getName() + ", 8, 4\n";
        }

        s += "\n.text\n\n";

        for (int i = 0; i < node.getGlobalMembers().size(); ++i) {
            s += visit(node.getGlobalMembers().get(i));
        }

        s += ".globl main\n";
        s += "main:\n";
        s += "\tpushq\t%rbp\n";
        s += "\tmovq\t%rsp, %rbp\n";
        s += "\tcallq\tstart\n";
        s += "\tleave\n";
        s += "\tret\n";

        return s;
    }

    @Override
    public String visit(TypeDeclarationNode node) {
        return null;
    }

    @Override
    public String visit(DeclarationNode.MethodDeclaration node) {
        String s = "";
        s += "# visit DeclarationNode.MethodDeclaration\n";

        s += ".globl start\n";
        s += node.getIdentifier() + ":\n";
        s += "\tpushq\t%rbp\n";
        s += "\tmovq\t%rsp, %rbp\n";
        s += "\tsubq\t$48, %rsp\n";

        for (int i = 0; i < node.getMembers().size(); ++i) {
            s += visit(node.getMembers().get(i));
        }

        s += visit(node.getStatement());
        s += "\tpopq\t%rax\n";
        s += "\tleave\n";
        s += "\tret\n";

        return s;
    }

    @Override
    public String visit(DeclarationNode.VariableDeclaration node) {
        String s = "";
        s += "# visit DeclarationNode.VariableDeclaration\n";

        s += visit(node.getValue());
        s += "\tpopq\t_" + node.getIdentifier() + "(%rip)\n";

        return s;
    }

    // NO
    @Override
    public String visit(ArgumentDeclarationNode node) {
        return null;
    }

    // NO
    @Override
    public String visit(TypeNode.Int node) {
        return null;
    }

    // NO
    @Override
    public String visit(TypeNode.Str node) {
        return null;
    }

    // NO
    @Override
    public String visit(TypeNode.Bool node) {
        return null;
    }

    // NO
    @Override
    public String visit(TypeNode.Id node) {
        return null;
    }

    private int ifCtr = 0;
    @Override
    public String visit(StatementNode.If node) {
        String s = "";
        s += "# visit StatementNode.If\n";
        int ifCt = ifCtr++;

        s += visit(node.getCondition());
        s += "\tpopq\t%r10\n";
        s += "\tcmpq\t$1, %r10\n";
        s += "\tje\t._ifTrue" + ifCt + "\n";
        s += "\tjmp\t._ifFalse" + ifCt + "\n";
        s += "._ifTrue" + ifCt + ":\n";
        s += visit(node.getIfTrue());
        s += "\tjmp\t._ifEnd" + ifCt + "\n";
        s += "._ifFalse" + ifCt + ":\n";
        if (node.getIfFalse() != null) {
            s += visit(node.getIfFalse());
        }
        else {
            s += "\tpushq $0\n";
        }
        s += "._ifEnd" + ifCt + ":\n";

        return s;
    }

    private int loopCtr = 0;
    @Override
    public String visit(StatementNode.Loop node) {
        String s = "";
        s += "# visit StatementNode.Loop\n";
        int loopCt = loopCtr++;

        s += "._while" + loopCt + ":\n";
        s += visit(node.getCondition());
        s += "\tpopq\t%r10\n";
        s += "\tcmpq\t$1, %r10\n";
        s += "\tjne\t._whileTrue" + loopCt + "\n";
        s += "\tjmp\t._whileFalse" + loopCt + "\n";
        s += "._whileTrue" + loopCt + ":\n";
        s += visit(node.getIfTrue());
        s += "\tjmp\t._while" + loopCt + "\n";
        s += "._whileFalse" + loopCt + ":\n";
        s += "\tpushq\t$0\n";

        return s;
    }

    @Override
    public String visit(StatementNode.Expression node) {
        return visit(node.getValue());
    }

    // NO
    @Override
    public String visit(ArrayInitializationNode.ArrayInitialization node, Type desiredType, Integer dimensions) {
        return null;
    }

    @Override
    public String visit(ExpressionNode.Or node) {
        String s = "";
        s += "# visit ExpressionNode.Or\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%r11\n";
        s += "\tor\t%r10, %r11\n";
        s += "\tpushq\t%r11\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.And node) {
        String s = "";
        s += "# visit ExpressionNode.And\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%r11\n";
        s += "\tand\t%r10, %r11\n";
        s += "\tpushq\t%r11\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Greater node) {
        String s = "";
        s += "# visit ExpressionNode.Greater\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%r11\n";
        s += "\tmovq\t$0, %rax\n";
        s += "\tcmpq\t%r10, %r11\n";
        s += "\tsetg\t%al\n";
        s += "\tandq\t$1, %rax\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.GreaterEqual node) {
        String s = "";
        s += "# visit ExpressionNode.GreaterEqual\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq \t%r11\n";
        s += "\tmovq\t$0, %rax\n";
        s += "\tcmpq\t%r10, %r11\n";
        s += "\tsetge\t%al\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Less node) {
        String s = "";
        s += "# visit ExpressionNode.Less\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%r11\n";
        s += "\tmovq\t$0, %rax\n";
        s += "\tcmpq\t%r10, %r11\n";
        s += "\tsetl\t%al\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.LessEqual node) {
        String s = "";
        s += "# visit ExpressionNode.LessEqual\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%r11\n";
        s += "\tmovq\t$0, %rax\n";
        s += "\tcmpq\t%r10, %r11\n";
        s += "\tsetle\t%al\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Equal node) {
        String s = "";
        s += "# visit ExpressionNode.Equal\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%r11\n";
        s += "\tmovq\t$0, %rax\n";
        s += "\tcmpq\t%r10, %r11\n";
        s += "\tsete\t%al\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    // NO
    @Override
    public String visit(ExpressionNode.Concat node) {
        return null;
    }

    @Override
    public String visit(ExpressionNode.Add node) {
        String s = "";
        s += "# visit ExpressionNode.Add\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%rax\n";
        s += "\taddq\t%r10, %rax\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Subtract node) {
        String s = "";
        s += "# visit ExpressionNode.Subtract\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%rax\n";
        s += "\tsubq\t%r10, %rax\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Multiply node) {
        String s = "";
        s += "# visit ExpressionNode.Multiply\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%rax\n";
        s += "\timul\t%r10\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Divide node) {
        String s = "";
        s += "# visit ExpressionNode.Divide\n";

        s += visit(node.getLeft());
        s += visit(node.getRight());
        s += "\tpopq\t%r10\n";
        s += "\tpopq\t%rax\n";
        s += "\tidiv\t%r10\n";
        s += "\tpushq\t%rax\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Negate node) {
        String s = "";
        s += "# visit ExpressionNode.Negate\n";

        s += visit(node.getValue());
        s += "\tpopq\t%r10\n";
        s += "\tnegq\t%r10\n";
        s += "\tpushq\t%r10\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Not node) {
        String s = "";
        s += "# visit ExpressionNode.Not\n";

        s += visit(node.getValue());
        s += "\tpopq\t%r10\n";
        s += "\txorq\t$1, %r10\n";
        s += "\tpushq\t%r10\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Bool node) {
        return "\tpushq\t$" + (node.getValue() ? "1": "0") + " # visit ExpressionNode.Bool\n";
    }

    @Override
    public String visit(ExpressionNode.Nil node) {
        return "\tpushq\t$0" + " # visit ExpressionNode.Nil\n";
    }

    @Override
    public String visit(ExpressionNode.Method node) {
        // save 6 ret registers into shadow space made earlier
        // eval params (visit expression and then pop) and pop into correct param regs, rdi
        // call method
        // restore at end
        // pop rax at end after restore

        String s = "";
        s += "# visit ExpressionNode.Method\n";

        s += "\tmovq\t%rdi, -8(%rbp)\n";
        s += "\tmovq\t%rsi, -16(%rbp)\n";
        s += "\tmovq\t%rdx, -24(%rbp)\n";
        s += "\tmovq\t%rcx, -32(%rbp)\n";
        s += "\tmovq\t%r8, -40(%rbp)\n";
        s += "\tmovq\t%r9, -48(%rbp)\n";
        s += "\tsubq\t$16, %rsp\n";

        for (int i = 0; i < node.getArguments().size(); ++i) {
            s += visit(node.getArguments().get(i));
        }

        s += "\tpopq\t%rdi\n";
        s += "\tcallq\t" + node.getIdentifier() + "\n";
        s += "\taddq\t$16, %rsp\n";
        s += "\tpushq\t%rax\n";

        s += "\tmovq\t-8(%rbp), %rdi\n";
        s += "\tmovq\t-16(%rbp), %rsi\n";
        s += "\tmovq\t-24(%rbp), %rdx\n";
        s += "\tmovq\t-32(%rbp), %rcx\n";
        s += "\tmovq\t-40(%rbp), %r8\n";
        s += "\tmovq\t-48(%rbp), %r9\n";

        return s;
    }

    @Override
    public String visit(ExpressionNode.Identifier node) {
        return "\tpushq\t_" + node.getIdentifier() + "(%rip)" + " # visit ExpressionNode.Identifier\n";
    }

    // NO
    @Override
    public String visit(ExpressionNode.Str node) {
        return null;
    }

    // NO
    @Override
    public String visit(ExpressionNode.Me node) {
        return null;
    }

    // NO
    @Override
    public String visit(ExpressionNode.New node) {
        return null;
    }

    @Override
    public String visit(ExpressionNode.Int node) {
        return "\tpushq\t$" + node.getValue().intValue() + " # visit ExpressionNode.Int\n";
    }

    @Override
    public String visit(ExpressionNode.Assignment node) {
        String s = "";
        s += "# visit ExpressionNode.Assignment\n";

        s += visit(node.getValue());
        s += "\tpopq\t_" + node.getIdentifier() + "(%rip)\n";
        s += "\tpushq\t_" + node.getIdentifier() + "(%rip)\n";

        return s;
    }
}
