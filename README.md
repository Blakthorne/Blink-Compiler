# Created by David Polar

## A more detailed description can be found [here](report.pdf), in the *Technical Report.*

# Overview

This project translates Blink files to Nix assembly with the help of ANTLR. It receives a Blink file and performs lexical, syntactic, and semantic analysis, finishing with code generation. When passing through the lexer, tokens are extracted from the Blink file. This process outputs a stream of lexical tokens, which gets fed into the syntactical analysis phase. This uses a grammar to ensure that the stream of lexical tokens is arranged in a syntactically acceptable manner. The result of this process is a Parse tree. The parse tree is passed to the semantic checker, which ensures correct operations and types among the nodes of the parse tree. After the program passes all the syntactic and semantic checks, the assembly code is generated.

# Target Platform

Linux

# Command Line Switch Documentation

 * `-ds` flag: output a list of the lexical tokens in the program
 * `-dp` flag: display a graphical parse tree
 * `-S` flag: produce an assembly file