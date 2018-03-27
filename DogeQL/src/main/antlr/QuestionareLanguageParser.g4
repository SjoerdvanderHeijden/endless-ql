parser grammar QuestionareLanguageParser;

import SharedParser;

options {
    tokenVocab = QuestionareLanguageLexer;
}

form
    : FORM NAME block
    ;

block
    : LBRACE statement* RBRACE
    ;

statement
    : ifStatement
    | questionStatement
    ;

questionStatement
    : LIT_STRING NAME COLON TYPE (ASSIGN expression)?
    ;

ifStatement
    : IF LPAREN expression RPAREN block
    ;

expression
    : NOT expression
    | expression (MUL | DIV) expression
    | expression (ADD | SUB) expression
    | expression (LT | GT | LE | GE) expression
    | expression (EQUAL | NOTEQUAL) expression
    | expression AND expression
    | expression OR expression
    | LPAREN expression RPAREN
    | literal
    | NAME
    ;


