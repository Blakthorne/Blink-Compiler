grammar Blink;

@header {
	package org.bju;
}

/**
 * Parser Rules
 */

start: children+=primary+ EOF;

primary: cls=blink_class | decl=declaration;

blink_class: TYPE id=IDENTIFIER L_PAREN args=arguments? R_PAREN parent=inherits? ASSIGNMENT members+=member_declaration+ END;

inherits: INHERITS FROM id=IDENTIFIER L_PAREN args=expressions? R_PAREN;

declaration: LET variable # var_decl
		   | LET method # method_decl;

member_declaration: MEMBER variable # member_var_decl
				  | MEMBER method # member_method_decl;

variable: id=IDENTIFIER typ=declared_type? ASSIGNMENT value=statement;

method: id=IDENTIFIER L_PAREN args=arguments? R_PAREN typ=declared_type? ASSIGNMENT members+=declaration* value=statement;

arguments: first=argument (COMMA last+=argument)*;

argument: id=IDENTIFIER typ=declared_type;

declared_type: COLON typ=type;

type: typ=types (L_SQUARE sizes+=expression? R_SQUARE)*;

types: INT_TYPE # int_type | STRING_TYPE # string_type | BOOL_TYPE # bool_type | id=IDENTIFIER # custom_type;

statement: blink_if | loop | expression;

blink_if: IF expr=expression THEN true_value=statement false_value=blink_else? END;

blink_else: ELSE false_value=statement;

loop: LOOP WHILE expr=expression DO value=statement END;

expressions: first=expression (COMMA last+=expression)*;

array_init: expressions # expressioninit
            | L_CURLY init=array_init? R_CURLY (COMMA L_CURLY rest+=array_init? R_CURLY)* # subexpressioninit;

expression: INTEGER_LITERAL # int
            | TRUE # true
            | FALSE # false
            | NIL # nil
            | expression DOT id=IDENTIFIER L_PAREN values=expressions? R_PAREN  # function1
            | id=IDENTIFIER L_PAREN values=expressions? R_PAREN # function2
            | id=IDENTIFIER # id
            | STRING_LITERAL # string
            | ME # me
            | NEW typ=type L_PAREN value=expressions? R_PAREN (L_CURLY init=array_init? R_CURLY)? # new
            | op=(NEGATE|NOT) expression # nn
            | first=expression op=(MULTIPLY|DIVIDE) rest=expression # md
            | first=expression op=(PLUS|SUBTRACT) rest=expression # as
            | first=expression CONCAT rest=expression # concat
            | first=expression op=(EQUAL|GREATER|GREATER_EQUAL|LESS|LESS_EQUAL) rest=expression # checks
            | first=expression AND rest=expression # and
            | first=expression OR rest=expression # or
	        | assignto=expression (L_SQUARE values+=expression R_SQUARE)+ ASSIGNMENT value=expression # arrayassign
            | assignto=IDENTIFIER ASSIGNMENT value=expression # idassign
            | L_PAREN expr=expression R_PAREN # paren_expr;

/**
 * Lexer Rules
 */

fragment VALID_ID_START: ('a' .. 'z') | ('A' .. 'Z') | '_';
fragment VALID_ID_CHAR: VALID_ID_START | ('0' .. '9');
fragment CHARACTER_ESCAPE: '\\' ('t' | 'n' | 'f' | 'r' | '"' | '\\');
fragment OCTAL_ESCAPE: '\\' ('0' .. '7') ('0' .. '7') ('0' .. '7');
fragment ESCAPE: CHARACTER_ESCAPE | OCTAL_ESCAPE;
fragment NOT_QUOTE_OR_BACKSLASH: [\u0000-\u0009\u000B-\u000C\u000E-\u0021\u0023-\u005B\u005D-\uFFFF];
fragment NOT_QUOTE: [\u0000-\u0009\u000B-\u000C\u000E-\u0021\u0023-\uFFFF];
fragment NOT_NEWLINE: [\u0000-\u0009\u000B-\u000C\u000E-\uFFFF];
fragment LINE_FEED_CARRIAGE_RETURN: [\u000A\u000D];
fragment SPACE_AND_TAB: [\u0009\u0020];
fragment NOT_NEWLINE_OR_WHITESPACE: [\u0000-\u0008\u000B-\u000C\u000E-\u0019\u0021-\uFFFF];

COMMENT: '#' NOT_NEWLINE* -> skip;
INTEGER_LITERAL: ('0' .. '9')+ ('.' ('0' .. '9')+)?;
STRING_LITERAL: '"' (NOT_QUOTE_OR_BACKSLASH | ESCAPE)* '"';
BAD_ESCAPE: '"' NOT_QUOTE+ '"';
UNTERMINATED: '"' NOT_QUOTE+;
TYPE: 'type';
INHERITS: 'inherits';
FROM: 'from';
END: 'end';
LET: 'let';
MEMBER: 'member';
INT_TYPE: 'int';
STRING_TYPE: 'string';
BOOL_TYPE: 'bool';
IF: 'if';
THEN: 'then';
ELSE: 'else';
LOOP: 'loop';
WHILE: 'while';
DO: 'do';
TRUE: 'true';
FALSE: 'false';
NIL: 'nil';
ME: 'me';
NEW: 'new';
IDENTIFIER: VALID_ID_START VALID_ID_CHAR*;
ASSIGNMENT: ':=';
COMMA: ',';
COLON: ':';
L_PAREN: '(';
R_PAREN: ')';
L_SQUARE: '[';
R_SQUARE: ']';
L_CURLY: '{';
R_CURLY: '}';
OR: '||';
AND: '&&';
GREATER_EQUAL: '>=';
GREATER: '>';
LESS_EQUAL: '<=';
LESS: '<';
EQUAL: '=';
CONCAT: '&';
PLUS: '+';
SUBTRACT: '-';
MULTIPLY: '*';
DIVIDE: '/';
NEGATE: '~';
NOT: '!';
DOT: '.';
OTHER_CHARACTER: NOT_NEWLINE_OR_WHITESPACE;
WHITESPACE: SPACE_AND_TAB -> skip;
NEWLINE: LINE_FEED_CARRIAGE_RETURN -> skip;
