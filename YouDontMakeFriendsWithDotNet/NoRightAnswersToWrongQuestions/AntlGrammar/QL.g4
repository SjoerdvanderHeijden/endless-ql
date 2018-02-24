grammar QL;

questionnaire: 'form' IDENTIFIER '{' statement* '}'; 

statement : question 
          | conditional
          ; 

question: IDENTIFIER ':' TEXT questiontype 
        | TEXT IDENTIFIER  ':' questiontype 
        ;

questiontype: qtype=(BOOLTYPE | STRINGTYPE | INTTYPE | DATETYPE | DECIMALTYPE);

conditional: 'if' '(' condition ')' '{' statement* '}' ('else' '{' statement* '}')?;

condition : IDENTIFIER                         #questionId
	      | TEXT                               #textLiteral
          | conditionvalue                     #relativeLiteral
          | booleanvalue                       #booleanLiteral
          | '(' condition ')'                  #expressionGroup
		  | '!'condition                       #negationExpression
          | leftExpression=condition 
              relationaloperator 
      	    rightExpression=condition          #relativeExpression
		  | mathexpression                     #calcualationExpression
          ;

mathexpression : IDENTIFIER                             #numberId
               | mathvalue                               #numberLiteral
			   | '(' mathexpression ')'                  #mathexpressionGroup
		       | leftExpression=mathexpression 
      	           operator=(MULTIPLY | DIVIDE) 
      		     rightExpression=mathexpression          #multiplyDivideExpression
      	       | leftExpression=mathexpression 
      	           operator=(ADD | MINUS) 
      		     rightExpression=mathexpression          #addSubtractExpression
			   ;

relationaloperator: ISGREATERTHAN 
                  | ISGREATERTHANOREQUAL 
				  | ISLESSTHAN 
				  | ISLESSTHANOREQUAL 
				  | booleanoperator
                  ;

booleanoperator: ISEQUAL 
               | ISNOTEQUAL 
               | AND 
               | OR
               ;

booleanvalue: TRUE 
            | FALSE
            ;

mathvalue: INTEGER 
         | DECIMAL
         ;

conditionvalue: INTEGER 
              | DECIMAL 
			  | DATE
              ;


BOOLTYPE: 'boolean';
STRINGTYPE: 'string';
INTTYPE: 'integer';
DATETYPE: 'date';
DECIMALTYPE: 'decimal';

ISNOTEQUAL : '!=';
ISEQUAL : '==';
ISGREATERTHAN : '>';
ISGREATERTHANOREQUAL : '>=';
ISLESSTHAN : '<';
ISLESSTHANOREQUAL : '<=';

ADD: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';

AND: '&&';
OR: '||';

TRUE : ('true'| 'True'| 'TRUE');
FALSE : ('false' | 'False' | 'FALSE');

DATE: [0-9]?[0-9]'/'[0-9]?[0-9]'/'([0-9][0-9])?([0-9][0-9]);
DECIMAL: '-'?[0-9]+ '.' [0-9]+;
INTEGER: '-'?[0-9]+;


TEXT: '"' (~'"')* '"';
IDENTIFIER : [a-zA-Z] [a-zA-Z0-9_]* ;

NEWLINE:'\r'? '\n' -> skip;
WS  :   [ \t]+ -> skip ;
LINECOMMENT :  '//' ~[\r\n]* -> skip;
BLOCKCOMMENT :   '/*' .*? '*/' -> skip;
