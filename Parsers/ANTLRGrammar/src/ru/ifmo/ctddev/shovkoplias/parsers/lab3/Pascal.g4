grammar Pascal;

@parser::header {
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collections;
import ru.ifmo.ctddev.shovkoplias.parsers.lab3.VariableChanger;
import java.util.Random;
}

@parser::members {
    private static String addNewline(String s) {
        if (s == null) {
            return "";
        }
        if (s.equals("\n")) {
            return "";
        }
        return s + "\n";
    }

    String indent = "";
    Random rnd = new Random(328);
    int addedVars = 0;

    void updateIndent() {
        indent = indent.isEmpty() ? "" : indent.substring(2);
    }

    void addLeft() {
        indent = "  " + indent;
    }


}


eval returns [String code]
   : programStart (INTERFACE)? block DOT {
        $code = $programStart.code + "\n";
        $code += addNewline($block.variables);
        for (String s : $block.functions) {
            $code += addNewline(s);
        }
        $code += addNewline($block.mainFunctionCode + ".");
        VariableChanger.clean();
    }
   ;

programStart returns [String code]
   : PROGRAM identifier (LPAREN identifierList RPAREN)? SEMI {$code = "program " + $identifier.text + ";";}
   | UNIT identifier SEMI {$code = "unit " + $identifier.text + ";";}
   ;

identifier
   : IDENT
   ;

block returns [String variables = "", List<String> functions = new ArrayList<String>(), String mainFunctionCode = ""]
   : (constantDefinitionPart { $variables += $constantDefinitionPart.code + "\n"; }
        | typeDefinitionPart
        | variableDeclarationPart { $variables += $variableDeclarationPart.code + "\n"; }
        | procedureAndFunctionDeclarationPart {$functions.add($procedureAndFunctionDeclarationPart.code);}
        | usesUnitsPart
        | IMPLEMENTATION
    )*
    { addLeft(); } compoundStatement { updateIndent(); } {$mainFunctionCode = $compoundStatement.code.substring(0, $compoundStatement.code.length() - 1);}
   ;

usesUnitsPart
   : USES identifierList SEMI
   ;

label
   : unsignedInteger
   ;

constantDefinitionPart returns [String code]
   : CONST constantDefinition {$code = "const\n"; addLeft(); $code += indent + $constantDefinition.code;} (SEMI constantDefinition {$code += "\n" + indent + $constantDefinition.code;})* SEMI {updateIndent();}
   ;

constantDefinition returns [String code]
   : identifier EQUAL constant {$code = $identifier.text + " = " + $constant.code + ";";}
   ;

constantChr
   : CHR LPAREN unsignedInteger RPAREN
   ;

constant returns [String code]
   : unsignedNumber {$code = $unsignedNumber.text;}
   | sign unsignedNumber {$code = $sign.text + $unsignedNumber.text;}
   | identifier {$code = $identifier.text;}
   | sign identifier {$code = $sign.text + $identifier.text;}
   | string {$code = $string.code;}
   | constantChr
   ;

unsignedNumber
   : unsignedInteger
   | unsignedReal
   ;

unsignedInteger
   : NUM_INT
   ;

unsignedReal
   : NUM_INT
   ;

sign
   : PLUS
   | MINUS
   ;

string returns [String code]
   : STRING_LITERAL {
        String t = $STRING_LITERAL.text;
        $code = "'" + t.substring(1, t.length() - 1) + "'";
    }
   ;

typeDefinitionPart
   : TYPE typeDefinition (SEMI typeDefinition)* SEMI
   ;

typeDefinition
   : identifier EQUAL (type | functionType | procedureType)
   ;

functionType
   : FUNCTION (formalParameterList)? COLON resultType
   ;

procedureType
   : PROCEDURE (formalParameterList)?
   ;

type returns [String code]
   : simpleType {$code = $simpleType.code;}
   | structuredType {$code = $structuredType.code;}
   | pointerType {$code = $pointerType.text;}
   ;

simpleType returns [String code]
   : typeIdentifier {$code = $typeIdentifier.code;}
   | subrangeType {$code = $subrangeType.upperBound;}
   | scalarType
   | stringtype {$code = "string";}
   ;

scalarType
   : LPAREN identifierList RPAREN
   ;

subrangeType returns [String upperBound]
   : constant DOTDOT constant {$upperBound = $constant.code;}
   ;

typeIdentifier returns [String code]
   : identifier { $code = $identifier.text; }
   | (CHAR {$code = "char";} | BOOLEAN {$code = "boolean";} | INTEGER {$code = "integer";} | REAL {$code = "real";} | STRING {$code = "string";} )
   ;

structuredType returns [String code]
   : PACKED unpackedStructuredType
   | unpackedStructuredType {$code = $unpackedStructuredType.code;}
   ;

unpackedStructuredType returns [String code]
   : arrayType {$code = $arrayType.code;}
   | recordType
   | setType
   | fileType
   ;

stringtype
   : STRING LBRACK (identifier | unsignedNumber) RBRACK
   ;

arrayType returns [String code]
   : ARRAY LBRACK simpleType {$code = "array[" + $simpleType.text;} (COMMA simpleType {$code += ", " + $simpleType.text;})* RBRACK OF type {$code += "] of " + $type.code;}
   ;

recordType
   : RECORD fieldList END
   ;

fieldList
   : (fixedPart (SEMI variantPart | SEMI)? | variantPart)
   ;

fixedPart
   : recordSection (SEMI recordSection)*
   ;

recordSection
   : identifierList COLON type
   ;

variantPart
   : CASE tag OF variant (SEMI variant | SEMI)*
   ;

tag
   : identifier COLON typeIdentifier
   | typeIdentifier
   ;

variant
   : constList COLON LPAREN fieldList RPAREN
   ;

setType
   : SET OF baseType
   ;

baseType
   : simpleType
   ;

fileType
   : FILE OF type
   | FILE
   ;

pointerType
   : POINTER typeIdentifier
   ;

variableDeclarationPart returns [String code]

   : VAR variableDeclaration {$code = "var\n"; addLeft();  $code += indent + $variableDeclaration.code;} (SEMI variableDeclaration {$code += "\n" + indent + $variableDeclaration.code;} )* SEMI {updateIndent();}
   ;

variableDeclaration returns [String code]
   : identifierList COLON type {
        $code = "";
        for (String id: $identifierList.idl) {
            VariableChanger.add(id);
            $code += VariableChanger.change(id) + ", ";
        }
        int k = rnd.nextInt() % 3 + 1;
        for (int i = 0; i < k; i++) {
            String id = "a" + String.valueOf(addedVars++);
            VariableChanger.addNew(id);
            $code += VariableChanger.change(id) + ", ";
        }
        $code = $code.substring(0, $code.length() - 2);
        $code += ": " + $type.code + ";";
    //$code = $identifierList.code + ": " + $type.code + ";";
   }
   ;

procedureAndFunctionDeclarationPart returns [String code]
   : procedureDeclaration {$code = $procedureDeclaration.code;}
   | functionDeclaration {$code = $functionDeclaration.code;}
   ;

procedureDeclaration returns [String code]
   : PROCEDURE identifier (formalParameterList)? SEMI block
   ;

functionDeclaration returns [String code]
   : FUNCTION identifier (formalParameterList)? COLON resultType SEMI block
   ;

formalParameterList returns [String code]
   : LPAREN formalParameterSection {$code = $formalParameterSection.code;} (SEMI formalParameterSection {$code += ", " + $formalParameterSection.code;})* RPAREN
   ;

formalParameterSection returns [String code]
   : parameterGroup {$code = $parameterGroup.code;}
   | VAR parameterGroup {$code = "var " + $parameterGroup.code;}
   | FUNCTION parameterGroup
   | PROCEDURE parameterGroup
   ;

parameterGroup returns [String code]
   : identifierList COLON typeIdentifier { $code = $identifierList.code + ": " + $typeIdentifier.code;}
   ;

identifierList returns [String code, List<String> idl = new ArrayList<String>()]
   : identifier {$code = $identifier.text; $idl.add($identifier.text);} (COMMA identifier {$code += ", " + $identifier.text; $idl.add($identifier.text);})*
   ;

constList
   : constant (COMMA constant)*
   ;

resultType returns [String code]
   : typeIdentifier {$code = $typeIdentifier.code;}
   ;

statement returns [String code = ""]
//@after {
//    $code = printWithIndent($code);
//}
   : label COLON unlabelledStatement {$code = $unlabelledStatement.code;}
   | unlabelledStatement {$code = $unlabelledStatement.code;}
   ;

unlabelledStatement returns [String code]
   : simpleStatement {$code = $simpleStatement.code;}
   | structuredStatement {$code = $structuredStatement.code;}
   ;

simpleStatement returns [String code]
   : assignmentStatement {$code = $assignmentStatement.code;}
   | procedureStatement {$code = $procedureStatement.code;}
   | emptyStatement {$code = "";}
   ;

assignmentStatement returns [String code]
   : variable ASSIGN expression {$code = $variable.code + " := " + $expression.code;}
   ;

variable returns [String code]
   : (AT identifier | identifier {$code = VariableChanger.change($identifier.text);}) (LBRACK expression {$code += "[" + $expression.code;} (COMMA expression {$code += ", " + $expression.code;})* RBRACK {$code += "]";}| LBRACK2 expression (COMMA expression)* RBRACK2 | DOT identifier | POINTER)*
   ;

expression returns [String code]
   : simpleExpression {$code = $simpleExpression.code;}
   (
        (EQUAL {$code += "=";} | NOT_EQUAL {$code += "<>";} | LT {$code += "<";} | LE {$code += "<=";} | GE {$code += ">=";} | GT {$code += ">";} | IN {$code += "in";})
        simpleExpression {$code += $simpleExpression.code;}
    )*
   ;

simpleExpression returns [String code]
   : term {$code = $term.code;} ((PLUS {$code += " + ";} | MINUS {$code += " - ";} | OR {$code += " or ";}) term {$code += $term.code;})*
   ;

term returns [String code]
   : signedFactor {$code = $signedFactor.code;} ((STAR {$code += " * ";} | SLASH {$code += " / ";} | DIV {$code += " div ";} | MOD {$code += " mod ";} | AND {$code += " and ";}) signedFactor {$code += $signedFactor.code;})*
   ;

signedFactor returns [String code = ""]
   : (PLUS {$code += "+";} | MINUS {$code += "-";})? factor {$code += $factor.code;}
   ;

factor returns [String code]
   : variable {$code = $variable.code;}
   | LPAREN expression RPAREN {$code = $expression.code;}
   | functionDesignator {$code = $functionDesignator.code;}
   | unsignedConstant {$code = $unsignedConstant.code;}
   | set
   | NOT factor {$code = "not " + $factor.code;}
   ;

unsignedConstant returns [String code]
   : unsignedNumber {$code = $unsignedNumber.text;}
   | constantChr
   | string {$code = $string.code;}
   | NIL
   ;

functionDesignator returns [String code]
   : identifier LPAREN parameterList RPAREN
   ;

parameterList returns [String code]
   : actualParameter {$code = $actualParameter.code;} (COMMA actualParameter {$code += ", " + $actualParameter.code;} )*
   ;

set
   : LBRACK elementList RBRACK
   | LBRACK2 elementList RBRACK2
   ;

elementList
   : element (COMMA element)*
   |
   ;

element
   : expression (DOTDOT expression)?
   ;

procedureStatement returns [String code]
   : identifier {$code = $identifier.text;} (LPAREN parameterList RPAREN {$code += "(" + $parameterList.code + ")";})? //TODO
   ;

actualParameter returns [String code]
   : expression {$code = $expression.code;}
   ;

gotoStatement
   : GOTO label
   ;

emptyStatement
   :
   ;

empty
   :/* empty */
   ;

structuredStatement returns [String code]
   : compoundStatement {$code = $compoundStatement.code;}
   | conditionalStatement {$code = $conditionalStatement.code;}
   | repetetiveStatement {$code = $repetetiveStatement.code;}
   | withStatement
   ;

compoundStatement returns [String code]
   : BEGIN statements END {$code = "begin\n" + $statements.code + "\nend;";}
   ;

statements returns [String code = ""]
   : statement {
        $code = ($statement.code.isEmpty() || $statement.code.equals("\n")) ? "" : $statement.code + ";";
        if (rnd.nextInt() % 4 == 0) {
            $code += "\n" + VariableChanger.trash();
        }
   } (SEMI statement {
        $code += ($statement.code.isEmpty() || $statement.code.equals("\n")) ? "" : "\n" + $statement.code + ";";
        if (rnd.nextInt() % 4 == 0) {
            $code += "\n" + VariableChanger.trash();
        }
   })*
   ;

conditionalStatement returns [String code]
   : ifStatement {$code = $ifStatement.code;}
   | caseStatement
   ;

ifStatement returns [String code]
   : IF expression THEN statement {$code = "if " + $expression.code + " then\n" + $statement.code + ";" + "\n"; }
   (: ELSE statement {
        if ($statement.code.trim().startsWith("if")) {
            $code += " else " + $statement.code;
        } else {
            $code += " else\n" + ($statement.code.isEmpty() ? "" : $statement.code + ";") + "\n";
        }
    }
    )?
   ;

caseStatement
   : CASE expression OF caseListElement (SEMI caseListElement)* (SEMI ELSE statements)? END
   ;

caseListElement
   : constList COLON statement
   ;

repetetiveStatement returns [String code]
   : whileStatement {$code = $whileStatement.code;}
   | repeatStatement {$code = $repeatStatement.code;}
   | forStatement {$code = $forStatement.code;}
   ;

whileStatement returns [String code]
   : WHILE expression DO statement {$code = "while " + $expression.code + " do \n" + $statement.code + "\n";}
   ;

repeatStatement returns [String code]
   : REPEAT statements UNTIL expression {$code = "repeat\n" + $statements.code + "\nuntil " + $expression.code + ";";}
   ;

forStatement returns [String code]
   : FOR identifier ASSIGN forList DO statement {$code = "for " + VariableChanger.change($identifier.text) + " := " + $forList.code + " do\n" + $statement.code + "\n";}
   ;

forList returns [String code]
   : initialValue {$code = $initialValue.code;}(TO {$code += " to ";}| DOWNTO {$code += " downto ";}) finalValue {$code += $finalValue.code;}
   ;

initialValue returns [String code]
   : expression {$code = $expression.code;}
   ;

finalValue returns [String code]
   : expression {$code = $expression.code;}
   ;

withStatement
   : WITH recordVariableList DO statement
   ;

recordVariableList
   : variable (COMMA variable)*
   ;


fragment A
   : ('a' | 'A')
   ;


fragment B
   : ('b' | 'B')
   ;


fragment C
   : ('c' | 'C')
   ;


fragment D
   : ('d' | 'D')
   ;


fragment E
   : ('e' | 'E')
   ;


fragment F
   : ('f' | 'F')
   ;


fragment G
   : ('g' | 'G')
   ;


fragment H
   : ('h' | 'H')
   ;


fragment I
   : ('i' | 'I')
   ;


fragment J
   : ('j' | 'J')
   ;


fragment K
   : ('k' | 'K')
   ;


fragment L
   : ('l' | 'L')
   ;


fragment M
   : ('m' | 'M')
   ;


fragment N
   : ('n' | 'N')
   ;


fragment O
   : ('o' | 'O')
   ;


fragment P
   : ('p' | 'P')
   ;


fragment Q
   : ('q' | 'Q')
   ;


fragment R
   : ('r' | 'R')
   ;


fragment S
   : ('s' | 'S')
   ;


fragment T
   : ('t' | 'T')
   ;


fragment U
   : ('u' | 'U')
   ;


fragment V
   : ('v' | 'V')
   ;


fragment W
   : ('w' | 'W')
   ;


fragment X
   : ('x' | 'X')
   ;


fragment Y
   : ('y' | 'Y')
   ;


fragment Z
   : ('z' | 'Z')
   ;


AND
   : A N D
   ;


ARRAY
   : A R R A Y
   ;


BEGIN
   : B E G I N
   ;


BOOLEAN
   : B O O L E A N
   ;


CASE
   : C A S E
   ;


CHAR
   : C H A R
   ;


CHR
   : C H R
   ;


CONST
   : C O N S T
   ;


DIV
   : D I V
   ;


DO
   : D O
   ;


DOWNTO
   : D O W N T O
   ;


ELSE
   : E L S E
   ;


END
   : E N D
   ;


FILE
   : F I L E
   ;


FOR
   : F O R
   ;


FUNCTION
   : F U N C T I O N
   ;


GOTO
   : G O T O
   ;


IF
   : I F
   ;


IN
   : I N
   ;


INTEGER
   : I N T E G E R
   ;


LABEL
   : L A B E L
   ;


MOD
   : M O D
   ;


NIL
   : N I L
   ;


NOT
   : N O T
   ;


OF
   : O F
   ;


OR
   : O R
   ;


PACKED
   : P A C K E D
   ;


PROCEDURE
   : P R O C E D U R E
   ;


PROGRAM
   : P R O G R A M
   ;


REAL
   : R E A L
   ;


RECORD
   : R E C O R D
   ;


REPEAT
   : R E P E A T
   ;


SET
   : S E T
   ;


THEN
   : T H E N
   ;


TO
   : T O
   ;


TYPE
   : T Y P E
   ;


UNTIL
   : U N T I L
   ;


VAR
   : V A R
   ;


WHILE
   : W H I L E
   ;


WITH
   : W I T H
   ;


PLUS
   : '+'
   ;


MINUS
   : '-'
   ;


STAR
   : '*'
   ;


SLASH
   : '/'
   ;


ASSIGN
   : ':='
   ;


COMMA
   : ','
   ;


SEMI
   : ';'
   ;


COLON
   : ':'
   ;


EQUAL
   : '='
   ;


NOT_EQUAL
   : '<>'
   ;


LT
   : '<'
   ;


LE
   : '<='
   ;


GE
   : '>='
   ;


GT
   : '>'
   ;


LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;


LBRACK
   : '['
   ;


LBRACK2
   : '(.'
   ;


RBRACK
   : ']'
   ;


RBRACK2
   : '.)'
   ;


POINTER
   : '^'
   ;


AT
   : '@'
   ;


DOT
   : '.'
   ;


DOTDOT
   : '..'
   ;


LCURLY
   : '{'
   ;


RCURLY
   : '}'
   ;


UNIT
   : U N I T
   ;


INTERFACE
   : I N T E R F A C E
   ;


USES
   : U S E S
   ;


STRING
   : S T R I N G
   ;


IMPLEMENTATION
   : I M P L E M E N T A T I O N
   ;


WS
   : [ \t\r\n] -> skip
   ;


COMMENT_1
   : '(*' .*? '*)' -> skip
   ;


COMMENT_2
   : '{' .*? '}' -> skip
   ;


IDENT
   : ('a' .. 'z' | 'A' .. 'Z') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
   ;


STRING_LITERAL
   : '\'' ('\'\'' | ~ ('\''))* '\''
   ;


NUM_INT
   : ('0' .. '9') + (('.' ('0' .. '9') + (EXPONENT)?)? | EXPONENT)
   ;


fragment EXPONENT
   : ('e') ('+' | '-')? ('0' .. '9') +
   ;