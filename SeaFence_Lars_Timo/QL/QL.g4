/* https://tomassetti.me/antlr-mega-tutorial/ */

grammar QL;

/*
 * Parser rules
 */

form: 'form' form_id block EOF;
block: '{' statement* '}';
statement: question
         | conditional
         | assignment
         ;

assignment: STR variable ':' variable_type '=' expression;
question: STR variable ':' variable_type;
conditional: if_cond elif_cond* else_cond?;
expression: BOOL 
          | STR
          | INT
          | variable
          | '(' expression ')'
          | NOT expression
          | left=expression COMPARER right=expression
          | left=expression DIVMULOPERATOR right=expression
          | left=expression ADDSUBOPERATOR right=expression
          | left=expression AND right=expression
          | left=expression OR right=expression
          ;

form_id: NAME;
variable: NAME;
variable_type: 'int'
       | 'boolean';

if_cond: 'if' '(' expression ')' block;
elif_cond: 'elif' '(' expression ')' block;
else_cond: 'else' block;

/*
 * Lexer rules
 */

BOOL: TRUE | FALSE;
INT: NUMBER;
NOT: '!';
COMPARER: '<'
        | '>'
        | '<='
        | '>='
        | '!='
        | '=='
        ;
ADDSUBOPERATOR: ADD
              | SUB
              ;
DIVMULOPERATOR: DIV
              | MUL
              ;
ADD: '+';
DIV: '/';
SUB: '-';
MUL: '*';
AND: '&&';
OR: '||';
TRUE: 'true';
FALSE: 'false';

WS: [ \t\n\r]+ -> skip;
COMMENT: '/*' .*? '*/' -> skip;

NUMBER: [0-9]+;
STR: '"' .*? '"';
NAME: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;