// Generated from C:/git/ITMO/Parsers/ANTLRGrammar/src/ru/ifmo/ctddev/shovkoplias/parsers/lab3\Pascal.g4 by ANTLR 4.5.1
package ru.ifmo.ctddev.shovkoplias.parsers.lab3.gen.ru.ifmo.ctddev.shovkoplias.parsers.lab3;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Collections;
import ru.ifmo.ctddev.shovkoplias.parsers.lab3.VariableChanger;
import java.util.Random;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, ARRAY=2, BEGIN=3, BOOLEAN=4, CASE=5, CHAR=6, CHR=7, CONST=8, DIV=9, 
		DO=10, DOWNTO=11, ELSE=12, END=13, FILE=14, FOR=15, FUNCTION=16, GOTO=17, 
		IF=18, IN=19, INTEGER=20, LABEL=21, MOD=22, NIL=23, NOT=24, OF=25, OR=26, 
		PACKED=27, PROCEDURE=28, PROGRAM=29, REAL=30, RECORD=31, REPEAT=32, SET=33, 
		THEN=34, TO=35, TYPE=36, UNTIL=37, VAR=38, WHILE=39, WITH=40, PLUS=41, 
		MINUS=42, STAR=43, SLASH=44, ASSIGN=45, COMMA=46, SEMI=47, COLON=48, EQUAL=49, 
		NOT_EQUAL=50, LT=51, LE=52, GE=53, GT=54, LPAREN=55, RPAREN=56, LBRACK=57, 
		LBRACK2=58, RBRACK=59, RBRACK2=60, POINTER=61, AT=62, DOT=63, DOTDOT=64, 
		LCURLY=65, RCURLY=66, UNIT=67, INTERFACE=68, USES=69, STRING=70, IMPLEMENTATION=71, 
		WS=72, COMMENT_1=73, COMMENT_2=74, IDENT=75, STRING_LITERAL=76, NUM_INT=77;
	public static final int
		RULE_eval = 0, RULE_programStart = 1, RULE_identifier = 2, RULE_block = 3, 
		RULE_usesUnitsPart = 4, RULE_label = 5, RULE_constantDefinitionPart = 6, 
		RULE_constantDefinition = 7, RULE_constantChr = 8, RULE_constant = 9, 
		RULE_unsignedNumber = 10, RULE_unsignedInteger = 11, RULE_unsignedReal = 12, 
		RULE_sign = 13, RULE_string = 14, RULE_typeDefinitionPart = 15, RULE_typeDefinition = 16, 
		RULE_functionType = 17, RULE_procedureType = 18, RULE_type = 19, RULE_simpleType = 20, 
		RULE_scalarType = 21, RULE_subrangeType = 22, RULE_typeIdentifier = 23, 
		RULE_structuredType = 24, RULE_unpackedStructuredType = 25, RULE_stringtype = 26, 
		RULE_arrayType = 27, RULE_recordType = 28, RULE_fieldList = 29, RULE_fixedPart = 30, 
		RULE_recordSection = 31, RULE_variantPart = 32, RULE_tag = 33, RULE_variant = 34, 
		RULE_setType = 35, RULE_baseType = 36, RULE_fileType = 37, RULE_pointerType = 38, 
		RULE_variableDeclarationPart = 39, RULE_variableDeclaration = 40, RULE_procedureAndFunctionDeclarationPart = 41, 
		RULE_procedureDeclaration = 42, RULE_functionDeclaration = 43, RULE_formalParameterList = 44, 
		RULE_formalParameterSection = 45, RULE_parameterGroup = 46, RULE_identifierList = 47, 
		RULE_constList = 48, RULE_resultType = 49, RULE_statement = 50, RULE_unlabelledStatement = 51, 
		RULE_simpleStatement = 52, RULE_assignmentStatement = 53, RULE_variable = 54, 
		RULE_expression = 55, RULE_simpleExpression = 56, RULE_term = 57, RULE_signedFactor = 58, 
		RULE_factor = 59, RULE_unsignedConstant = 60, RULE_functionDesignator = 61, 
		RULE_parameterList = 62, RULE_set = 63, RULE_elementList = 64, RULE_element = 65, 
		RULE_procedureStatement = 66, RULE_actualParameter = 67, RULE_gotoStatement = 68, 
		RULE_emptyStatement = 69, RULE_empty = 70, RULE_structuredStatement = 71, 
		RULE_compoundStatement = 72, RULE_statements = 73, RULE_conditionalStatement = 74, 
		RULE_ifStatement = 75, RULE_caseStatement = 76, RULE_caseListElement = 77, 
		RULE_repetetiveStatement = 78, RULE_whileStatement = 79, RULE_repeatStatement = 80, 
		RULE_forStatement = 81, RULE_forList = 82, RULE_initialValue = 83, RULE_finalValue = 84, 
		RULE_withStatement = 85, RULE_recordVariableList = 86;
	public static final String[] ruleNames = {
		"eval", "programStart", "identifier", "block", "usesUnitsPart", "label", 
		"constantDefinitionPart", "constantDefinition", "constantChr", "constant", 
		"unsignedNumber", "unsignedInteger", "unsignedReal", "sign", "string", 
		"typeDefinitionPart", "typeDefinition", "functionType", "procedureType", 
		"type", "simpleType", "scalarType", "subrangeType", "typeIdentifier", 
		"structuredType", "unpackedStructuredType", "stringtype", "arrayType", 
		"recordType", "fieldList", "fixedPart", "recordSection", "variantPart", 
		"tag", "variant", "setType", "baseType", "fileType", "pointerType", "variableDeclarationPart", 
		"variableDeclaration", "procedureAndFunctionDeclarationPart", "procedureDeclaration", 
		"functionDeclaration", "formalParameterList", "formalParameterSection", 
		"parameterGroup", "identifierList", "constList", "resultType", "statement", 
		"unlabelledStatement", "simpleStatement", "assignmentStatement", "variable", 
		"expression", "simpleExpression", "term", "signedFactor", "factor", "unsignedConstant", 
		"functionDesignator", "parameterList", "set", "elementList", "element", 
		"procedureStatement", "actualParameter", "gotoStatement", "emptyStatement", 
		"empty", "structuredStatement", "compoundStatement", "statements", "conditionalStatement", 
		"ifStatement", "caseStatement", "caseListElement", "repetetiveStatement", 
		"whileStatement", "repeatStatement", "forStatement", "forList", "initialValue", 
		"finalValue", "withStatement", "recordVariableList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", "':='", "','", 
		"';'", "':'", "'='", "'<>'", "'<'", "'<='", "'>='", "'>'", "'('", "')'", 
		"'['", "'(.'", "']'", "'.)'", "'^'", "'@'", "'.'", "'..'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "ARRAY", "BEGIN", "BOOLEAN", "CASE", "CHAR", "CHR", "CONST", 
		"DIV", "DO", "DOWNTO", "ELSE", "END", "FILE", "FOR", "FUNCTION", "GOTO", 
		"IF", "IN", "INTEGER", "LABEL", "MOD", "NIL", "NOT", "OF", "OR", "PACKED", 
		"PROCEDURE", "PROGRAM", "REAL", "RECORD", "REPEAT", "SET", "THEN", "TO", 
		"TYPE", "UNTIL", "VAR", "WHILE", "WITH", "PLUS", "MINUS", "STAR", "SLASH", 
		"ASSIGN", "COMMA", "SEMI", "COLON", "EQUAL", "NOT_EQUAL", "LT", "LE", 
		"GE", "GT", "LPAREN", "RPAREN", "LBRACK", "LBRACK2", "RBRACK", "RBRACK2", 
		"POINTER", "AT", "DOT", "DOTDOT", "LCURLY", "RCURLY", "UNIT", "INTERFACE", 
		"USES", "STRING", "IMPLEMENTATION", "WS", "COMMENT_1", "COMMENT_2", "IDENT", 
		"STRING_LITERAL", "NUM_INT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pascal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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



	public PascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public String code;
		public ProgramStartContext programStart;
		public BlockContext block;
		public ProgramStartContext programStart() {
			return getRuleContext(ProgramStartContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PascalParser.DOT, 0); }
		public TerminalNode INTERFACE() { return getToken(PascalParser.INTERFACE, 0); }
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((EvalContext)_localctx).programStart = programStart();
			setState(176);
			_la = _input.LA(1);
			if (_la==INTERFACE) {
				{
				setState(175);
				match(INTERFACE);
				}
			}

			setState(178);
			((EvalContext)_localctx).block = block();
			setState(179);
			match(DOT);

			        ((EvalContext)_localctx).code =  ((EvalContext)_localctx).programStart.code + "\n";
			        _localctx.code += addNewline(((EvalContext)_localctx).block.variables);
			        for (String s : ((EvalContext)_localctx).block.functions) {
			            _localctx.code += addNewline(s);
			        }
			        _localctx.code += addNewline(((EvalContext)_localctx).block.mainFunctionCode + ".");
			        VariableChanger.clean();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramStartContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier;
		public TerminalNode PROGRAM() { return getToken(PascalParser.PROGRAM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PascalParser.SEMI, 0); }
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public TerminalNode UNIT() { return getToken(PascalParser.UNIT, 0); }
		public ProgramStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProgramStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProgramStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitProgramStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramStartContext programStart() throws RecognitionException {
		ProgramStartContext _localctx = new ProgramStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programStart);
		int _la;
		try {
			setState(198);
			switch (_input.LA(1)) {
			case PROGRAM:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(PROGRAM);
				setState(183);
				((ProgramStartContext)_localctx).identifier = identifier();
				setState(188);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(184);
					match(LPAREN);
					setState(185);
					identifierList();
					setState(186);
					match(RPAREN);
					}
				}

				setState(190);
				match(SEMI);
				((ProgramStartContext)_localctx).code =  "program " + (((ProgramStartContext)_localctx).identifier!=null?_input.getText(((ProgramStartContext)_localctx).identifier.start,((ProgramStartContext)_localctx).identifier.stop):null) + ";";
				}
				break;
			case UNIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(UNIT);
				setState(194);
				((ProgramStartContext)_localctx).identifier = identifier();
				setState(195);
				match(SEMI);
				((ProgramStartContext)_localctx).code =  "unit " + (((ProgramStartContext)_localctx).identifier!=null?_input.getText(((ProgramStartContext)_localctx).identifier.start,((ProgramStartContext)_localctx).identifier.stop):null) + ";";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(PascalParser.IDENT, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public String variables =  "";
		public List<String> functions =  new ArrayList<String>();
		public String mainFunctionCode =  "";
		public ConstantDefinitionPartContext constantDefinitionPart;
		public VariableDeclarationPartContext variableDeclarationPart;
		public ProcedureAndFunctionDeclarationPartContext procedureAndFunctionDeclarationPart;
		public CompoundStatementContext compoundStatement;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public List<ConstantDefinitionPartContext> constantDefinitionPart() {
			return getRuleContexts(ConstantDefinitionPartContext.class);
		}
		public ConstantDefinitionPartContext constantDefinitionPart(int i) {
			return getRuleContext(ConstantDefinitionPartContext.class,i);
		}
		public List<TypeDefinitionPartContext> typeDefinitionPart() {
			return getRuleContexts(TypeDefinitionPartContext.class);
		}
		public TypeDefinitionPartContext typeDefinitionPart(int i) {
			return getRuleContext(TypeDefinitionPartContext.class,i);
		}
		public List<VariableDeclarationPartContext> variableDeclarationPart() {
			return getRuleContexts(VariableDeclarationPartContext.class);
		}
		public VariableDeclarationPartContext variableDeclarationPart(int i) {
			return getRuleContext(VariableDeclarationPartContext.class,i);
		}
		public List<ProcedureAndFunctionDeclarationPartContext> procedureAndFunctionDeclarationPart() {
			return getRuleContexts(ProcedureAndFunctionDeclarationPartContext.class);
		}
		public ProcedureAndFunctionDeclarationPartContext procedureAndFunctionDeclarationPart(int i) {
			return getRuleContext(ProcedureAndFunctionDeclarationPartContext.class,i);
		}
		public List<UsesUnitsPartContext> usesUnitsPart() {
			return getRuleContexts(UsesUnitsPartContext.class);
		}
		public UsesUnitsPartContext usesUnitsPart(int i) {
			return getRuleContext(UsesUnitsPartContext.class,i);
		}
		public List<TerminalNode> IMPLEMENTATION() { return getTokens(PascalParser.IMPLEMENTATION); }
		public TerminalNode IMPLEMENTATION(int i) {
			return getToken(PascalParser.IMPLEMENTATION, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (CONST - 8)) | (1L << (FUNCTION - 8)) | (1L << (PROCEDURE - 8)) | (1L << (TYPE - 8)) | (1L << (VAR - 8)) | (1L << (USES - 8)) | (1L << (IMPLEMENTATION - 8)))) != 0)) {
				{
				setState(214);
				switch (_input.LA(1)) {
				case CONST:
					{
					setState(202);
					((BlockContext)_localctx).constantDefinitionPart = constantDefinitionPart();
					 _localctx.variables += ((BlockContext)_localctx).constantDefinitionPart.code + "\n"; 
					}
					break;
				case TYPE:
					{
					setState(205);
					typeDefinitionPart();
					}
					break;
				case VAR:
					{
					setState(206);
					((BlockContext)_localctx).variableDeclarationPart = variableDeclarationPart();
					 _localctx.variables += ((BlockContext)_localctx).variableDeclarationPart.code + "\n"; 
					}
					break;
				case FUNCTION:
				case PROCEDURE:
					{
					setState(209);
					((BlockContext)_localctx).procedureAndFunctionDeclarationPart = procedureAndFunctionDeclarationPart();
					_localctx.functions.add(((BlockContext)_localctx).procedureAndFunctionDeclarationPart.code);
					}
					break;
				case USES:
					{
					setState(212);
					usesUnitsPart();
					}
					break;
				case IMPLEMENTATION:
					{
					setState(213);
					match(IMPLEMENTATION);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 addLeft(); 
			setState(220);
			((BlockContext)_localctx).compoundStatement = compoundStatement();
			 updateIndent(); 
			((BlockContext)_localctx).mainFunctionCode =  ((BlockContext)_localctx).compoundStatement.code.substring(0, ((BlockContext)_localctx).compoundStatement.code.length() - 1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsesUnitsPartContext extends ParserRuleContext {
		public TerminalNode USES() { return getToken(PascalParser.USES, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PascalParser.SEMI, 0); }
		public UsesUnitsPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usesUnitsPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUsesUnitsPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUsesUnitsPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUsesUnitsPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsesUnitsPartContext usesUnitsPart() throws RecognitionException {
		UsesUnitsPartContext _localctx = new UsesUnitsPartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_usesUnitsPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(USES);
			setState(225);
			identifierList();
			setState(226);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public UnsignedIntegerContext unsignedInteger() {
			return getRuleContext(UnsignedIntegerContext.class,0);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			unsignedInteger();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDefinitionPartContext extends ParserRuleContext {
		public String code;
		public ConstantDefinitionContext constantDefinition;
		public TerminalNode CONST() { return getToken(PascalParser.CONST, 0); }
		public List<ConstantDefinitionContext> constantDefinition() {
			return getRuleContexts(ConstantDefinitionContext.class);
		}
		public ConstantDefinitionContext constantDefinition(int i) {
			return getRuleContext(ConstantDefinitionContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public ConstantDefinitionPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDefinitionPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConstantDefinitionPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConstantDefinitionPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitConstantDefinitionPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDefinitionPartContext constantDefinitionPart() throws RecognitionException {
		ConstantDefinitionPartContext _localctx = new ConstantDefinitionPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constantDefinitionPart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(CONST);
			setState(231);
			((ConstantDefinitionPartContext)_localctx).constantDefinition = constantDefinition();
			((ConstantDefinitionPartContext)_localctx).code =  "const\n"; addLeft(); _localctx.code += indent + ((ConstantDefinitionPartContext)_localctx).constantDefinition.code;
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					match(SEMI);
					setState(234);
					((ConstantDefinitionPartContext)_localctx).constantDefinition = constantDefinition();
					_localctx.code += "\n" + indent + ((ConstantDefinitionPartContext)_localctx).constantDefinition.code;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(242);
			match(SEMI);
			updateIndent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDefinitionContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier;
		public ConstantContext constant;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PascalParser.EQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConstantDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConstantDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitConstantDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDefinitionContext constantDefinition() throws RecognitionException {
		ConstantDefinitionContext _localctx = new ConstantDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constantDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			((ConstantDefinitionContext)_localctx).identifier = identifier();
			setState(246);
			match(EQUAL);
			setState(247);
			((ConstantDefinitionContext)_localctx).constant = constant();
			((ConstantDefinitionContext)_localctx).code =  (((ConstantDefinitionContext)_localctx).identifier!=null?_input.getText(((ConstantDefinitionContext)_localctx).identifier.start,((ConstantDefinitionContext)_localctx).identifier.stop):null) + " = " + ((ConstantDefinitionContext)_localctx).constant.code + ";";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantChrContext extends ParserRuleContext {
		public TerminalNode CHR() { return getToken(PascalParser.CHR, 0); }
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public UnsignedIntegerContext unsignedInteger() {
			return getRuleContext(UnsignedIntegerContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public ConstantChrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantChr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConstantChr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConstantChr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitConstantChr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantChrContext constantChr() throws RecognitionException {
		ConstantChrContext _localctx = new ConstantChrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constantChr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(CHR);
			setState(251);
			match(LPAREN);
			setState(252);
			unsignedInteger();
			setState(253);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public String code;
		public UnsignedNumberContext unsignedNumber;
		public SignContext sign;
		public IdentifierContext identifier;
		public StringContext string;
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ConstantChrContext constantChr() {
			return getRuleContext(ConstantChrContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constant);
		try {
			setState(273);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				((ConstantContext)_localctx).unsignedNumber = unsignedNumber();
				((ConstantContext)_localctx).code =  (((ConstantContext)_localctx).unsignedNumber!=null?_input.getText(((ConstantContext)_localctx).unsignedNumber.start,((ConstantContext)_localctx).unsignedNumber.stop):null);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				((ConstantContext)_localctx).sign = sign();
				setState(259);
				((ConstantContext)_localctx).unsignedNumber = unsignedNumber();
				((ConstantContext)_localctx).code =  (((ConstantContext)_localctx).sign!=null?_input.getText(((ConstantContext)_localctx).sign.start,((ConstantContext)_localctx).sign.stop):null) + (((ConstantContext)_localctx).unsignedNumber!=null?_input.getText(((ConstantContext)_localctx).unsignedNumber.start,((ConstantContext)_localctx).unsignedNumber.stop):null);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				((ConstantContext)_localctx).identifier = identifier();
				((ConstantContext)_localctx).code =  (((ConstantContext)_localctx).identifier!=null?_input.getText(((ConstantContext)_localctx).identifier.start,((ConstantContext)_localctx).identifier.stop):null);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				((ConstantContext)_localctx).sign = sign();
				setState(266);
				((ConstantContext)_localctx).identifier = identifier();
				((ConstantContext)_localctx).code =  (((ConstantContext)_localctx).sign!=null?_input.getText(((ConstantContext)_localctx).sign.start,((ConstantContext)_localctx).sign.stop):null) + (((ConstantContext)_localctx).identifier!=null?_input.getText(((ConstantContext)_localctx).identifier.start,((ConstantContext)_localctx).identifier.stop):null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(269);
				((ConstantContext)_localctx).string = string();
				((ConstantContext)_localctx).code =  ((ConstantContext)_localctx).string.code;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(272);
				constantChr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedNumberContext extends ParserRuleContext {
		public UnsignedIntegerContext unsignedInteger() {
			return getRuleContext(UnsignedIntegerContext.class,0);
		}
		public UnsignedRealContext unsignedReal() {
			return getRuleContext(UnsignedRealContext.class,0);
		}
		public UnsignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUnsignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUnsignedNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUnsignedNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedNumberContext unsignedNumber() throws RecognitionException {
		UnsignedNumberContext _localctx = new UnsignedNumberContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unsignedNumber);
		try {
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				unsignedInteger();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				unsignedReal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedIntegerContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(PascalParser.NUM_INT, 0); }
		public UnsignedIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUnsignedInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUnsignedInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUnsignedInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedIntegerContext unsignedInteger() throws RecognitionException {
		UnsignedIntegerContext _localctx = new UnsignedIntegerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_unsignedInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(NUM_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedRealContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(PascalParser.NUM_INT, 0); }
		public UnsignedRealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedReal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUnsignedReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUnsignedReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUnsignedReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedRealContext unsignedReal() throws RecognitionException {
		UnsignedRealContext _localctx = new UnsignedRealContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unsignedReal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(NUM_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public String code;
		public Token STRING_LITERAL;
		public TerminalNode STRING_LITERAL() { return getToken(PascalParser.STRING_LITERAL, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			((StringContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);

			        String t = (((StringContext)_localctx).STRING_LITERAL!=null?((StringContext)_localctx).STRING_LITERAL.getText():null);
			        ((StringContext)_localctx).code =  "'" + t.substring(1, t.length() - 1) + "'";
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDefinitionPartContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(PascalParser.TYPE, 0); }
		public List<TypeDefinitionContext> typeDefinition() {
			return getRuleContexts(TypeDefinitionContext.class);
		}
		public TypeDefinitionContext typeDefinition(int i) {
			return getRuleContext(TypeDefinitionContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public TypeDefinitionPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinitionPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTypeDefinitionPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTypeDefinitionPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitTypeDefinitionPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionPartContext typeDefinitionPart() throws RecognitionException {
		TypeDefinitionPartContext _localctx = new TypeDefinitionPartContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeDefinitionPart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(TYPE);
			setState(289);
			typeDefinition();
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(290);
					match(SEMI);
					setState(291);
					typeDefinition();
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(297);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PascalParser.EQUAL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public ProcedureTypeContext procedureType() {
			return getRuleContext(ProcedureTypeContext.class,0);
		}
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTypeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			identifier();
			setState(300);
			match(EQUAL);
			setState(304);
			switch (_input.LA(1)) {
			case ARRAY:
			case BOOLEAN:
			case CHAR:
			case CHR:
			case FILE:
			case INTEGER:
			case PACKED:
			case REAL:
			case RECORD:
			case SET:
			case PLUS:
			case MINUS:
			case LPAREN:
			case POINTER:
			case STRING:
			case IDENT:
			case STRING_LITERAL:
			case NUM_INT:
				{
				setState(301);
				type();
				}
				break;
			case FUNCTION:
				{
				setState(302);
				functionType();
				}
				break;
			case PROCEDURE:
				{
				setState(303);
				procedureType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PascalParser.FUNCTION, 0); }
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public ResultTypeContext resultType() {
			return getRuleContext(ResultTypeContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFunctionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(FUNCTION);
			setState(308);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(307);
				formalParameterList();
				}
			}

			setState(310);
			match(COLON);
			setState(311);
			resultType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureTypeContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(PascalParser.PROCEDURE, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ProcedureTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProcedureType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProcedureType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitProcedureType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureTypeContext procedureType() throws RecognitionException {
		ProcedureTypeContext _localctx = new ProcedureTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_procedureType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(PROCEDURE);
			setState(315);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(314);
				formalParameterList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public String code;
		public SimpleTypeContext simpleType;
		public StructuredTypeContext structuredType;
		public PointerTypeContext pointerType;
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public StructuredTypeContext structuredType() {
			return getRuleContext(StructuredTypeContext.class,0);
		}
		public PointerTypeContext pointerType() {
			return getRuleContext(PointerTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		try {
			setState(326);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case CHR:
			case INTEGER:
			case REAL:
			case PLUS:
			case MINUS:
			case LPAREN:
			case STRING:
			case IDENT:
			case STRING_LITERAL:
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				((TypeContext)_localctx).simpleType = simpleType();
				((TypeContext)_localctx).code =  ((TypeContext)_localctx).simpleType.code;
				}
				break;
			case ARRAY:
			case FILE:
			case PACKED:
			case RECORD:
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				((TypeContext)_localctx).structuredType = structuredType();
				((TypeContext)_localctx).code =  ((TypeContext)_localctx).structuredType.code;
				}
				break;
			case POINTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
				((TypeContext)_localctx).pointerType = pointerType();
				((TypeContext)_localctx).code =  (((TypeContext)_localctx).pointerType!=null?_input.getText(((TypeContext)_localctx).pointerType.start,((TypeContext)_localctx).pointerType.stop):null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTypeContext extends ParserRuleContext {
		public String code;
		public TypeIdentifierContext typeIdentifier;
		public SubrangeTypeContext subrangeType;
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public SubrangeTypeContext subrangeType() {
			return getRuleContext(SubrangeTypeContext.class,0);
		}
		public ScalarTypeContext scalarType() {
			return getRuleContext(ScalarTypeContext.class,0);
		}
		public StringtypeContext stringtype() {
			return getRuleContext(StringtypeContext.class,0);
		}
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSimpleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSimpleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_simpleType);
		try {
			setState(338);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				((SimpleTypeContext)_localctx).typeIdentifier = typeIdentifier();
				((SimpleTypeContext)_localctx).code =  ((SimpleTypeContext)_localctx).typeIdentifier.code;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				((SimpleTypeContext)_localctx).subrangeType = subrangeType();
				((SimpleTypeContext)_localctx).code =  ((SimpleTypeContext)_localctx).subrangeType.upperBound;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(334);
				scalarType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(335);
				stringtype();
				((SimpleTypeContext)_localctx).code =  "string";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScalarTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public ScalarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterScalarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitScalarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitScalarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarTypeContext scalarType() throws RecognitionException {
		ScalarTypeContext _localctx = new ScalarTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_scalarType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(LPAREN);
			setState(341);
			identifierList();
			setState(342);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubrangeTypeContext extends ParserRuleContext {
		public String upperBound;
		public ConstantContext constant;
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode DOTDOT() { return getToken(PascalParser.DOTDOT, 0); }
		public SubrangeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrangeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSubrangeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSubrangeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSubrangeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrangeTypeContext subrangeType() throws RecognitionException {
		SubrangeTypeContext _localctx = new SubrangeTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_subrangeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			((SubrangeTypeContext)_localctx).constant = constant();
			setState(345);
			match(DOTDOT);
			setState(346);
			((SubrangeTypeContext)_localctx).constant = constant();
			((SubrangeTypeContext)_localctx).upperBound =  ((SubrangeTypeContext)_localctx).constant.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdentifierContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CHAR() { return getToken(PascalParser.CHAR, 0); }
		public TerminalNode BOOLEAN() { return getToken(PascalParser.BOOLEAN, 0); }
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(PascalParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(PascalParser.STRING, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTypeIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitTypeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeIdentifier);
		try {
			setState(364);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				((TypeIdentifierContext)_localctx).identifier = identifier();
				 ((TypeIdentifierContext)_localctx).code =  (((TypeIdentifierContext)_localctx).identifier!=null?_input.getText(((TypeIdentifierContext)_localctx).identifier.start,((TypeIdentifierContext)_localctx).identifier.stop):null); 
				}
				break;
			case BOOLEAN:
			case CHAR:
			case INTEGER:
			case REAL:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				switch (_input.LA(1)) {
				case CHAR:
					{
					setState(352);
					match(CHAR);
					((TypeIdentifierContext)_localctx).code =  "char";
					}
					break;
				case BOOLEAN:
					{
					setState(354);
					match(BOOLEAN);
					((TypeIdentifierContext)_localctx).code =  "boolean";
					}
					break;
				case INTEGER:
					{
					setState(356);
					match(INTEGER);
					((TypeIdentifierContext)_localctx).code =  "integer";
					}
					break;
				case REAL:
					{
					setState(358);
					match(REAL);
					((TypeIdentifierContext)_localctx).code =  "real";
					}
					break;
				case STRING:
					{
					setState(360);
					match(STRING);
					((TypeIdentifierContext)_localctx).code =  "string";
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructuredTypeContext extends ParserRuleContext {
		public String code;
		public UnpackedStructuredTypeContext unpackedStructuredType;
		public TerminalNode PACKED() { return getToken(PascalParser.PACKED, 0); }
		public UnpackedStructuredTypeContext unpackedStructuredType() {
			return getRuleContext(UnpackedStructuredTypeContext.class,0);
		}
		public StructuredTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structuredType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterStructuredType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitStructuredType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitStructuredType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructuredTypeContext structuredType() throws RecognitionException {
		StructuredTypeContext _localctx = new StructuredTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_structuredType);
		try {
			setState(371);
			switch (_input.LA(1)) {
			case PACKED:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				match(PACKED);
				setState(367);
				unpackedStructuredType();
				}
				break;
			case ARRAY:
			case FILE:
			case RECORD:
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				((StructuredTypeContext)_localctx).unpackedStructuredType = unpackedStructuredType();
				((StructuredTypeContext)_localctx).code =  ((StructuredTypeContext)_localctx).unpackedStructuredType.code;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnpackedStructuredTypeContext extends ParserRuleContext {
		public String code;
		public ArrayTypeContext arrayType;
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public RecordTypeContext recordType() {
			return getRuleContext(RecordTypeContext.class,0);
		}
		public SetTypeContext setType() {
			return getRuleContext(SetTypeContext.class,0);
		}
		public FileTypeContext fileType() {
			return getRuleContext(FileTypeContext.class,0);
		}
		public UnpackedStructuredTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpackedStructuredType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUnpackedStructuredType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUnpackedStructuredType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUnpackedStructuredType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnpackedStructuredTypeContext unpackedStructuredType() throws RecognitionException {
		UnpackedStructuredTypeContext _localctx = new UnpackedStructuredTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unpackedStructuredType);
		try {
			setState(379);
			switch (_input.LA(1)) {
			case ARRAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				((UnpackedStructuredTypeContext)_localctx).arrayType = arrayType();
				((UnpackedStructuredTypeContext)_localctx).code =  ((UnpackedStructuredTypeContext)_localctx).arrayType.code;
				}
				break;
			case RECORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				recordType();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
				setType();
				}
				break;
			case FILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(378);
				fileType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringtypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PascalParser.STRING, 0); }
		public TerminalNode LBRACK() { return getToken(PascalParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PascalParser.RBRACK, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public StringtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterStringtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitStringtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitStringtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringtypeContext stringtype() throws RecognitionException {
		StringtypeContext _localctx = new StringtypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_stringtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(STRING);
			setState(382);
			match(LBRACK);
			setState(385);
			switch (_input.LA(1)) {
			case IDENT:
				{
				setState(383);
				identifier();
				}
				break;
			case NUM_INT:
				{
				setState(384);
				unsignedNumber();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(387);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public String code;
		public SimpleTypeContext simpleType;
		public TypeContext type;
		public TerminalNode ARRAY() { return getToken(PascalParser.ARRAY, 0); }
		public TerminalNode LBRACK() { return getToken(PascalParser.LBRACK, 0); }
		public List<SimpleTypeContext> simpleType() {
			return getRuleContexts(SimpleTypeContext.class);
		}
		public SimpleTypeContext simpleType(int i) {
			return getRuleContext(SimpleTypeContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(PascalParser.RBRACK, 0); }
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(ARRAY);
			setState(390);
			match(LBRACK);
			setState(391);
			((ArrayTypeContext)_localctx).simpleType = simpleType();
			((ArrayTypeContext)_localctx).code =  "array[" + (((ArrayTypeContext)_localctx).simpleType!=null?_input.getText(((ArrayTypeContext)_localctx).simpleType.start,((ArrayTypeContext)_localctx).simpleType.stop):null);
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(393);
				match(COMMA);
				setState(394);
				((ArrayTypeContext)_localctx).simpleType = simpleType();
				_localctx.code += ", " + (((ArrayTypeContext)_localctx).simpleType!=null?_input.getText(((ArrayTypeContext)_localctx).simpleType.start,((ArrayTypeContext)_localctx).simpleType.stop):null);
				}
				}
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
			match(RBRACK);
			setState(403);
			match(OF);
			setState(404);
			((ArrayTypeContext)_localctx).type = type();
			_localctx.code += "] of " + ((ArrayTypeContext)_localctx).type.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordTypeContext extends ParserRuleContext {
		public TerminalNode RECORD() { return getToken(PascalParser.RECORD, 0); }
		public FieldListContext fieldList() {
			return getRuleContext(FieldListContext.class,0);
		}
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public RecordTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRecordType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRecordType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitRecordType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordTypeContext recordType() throws RecognitionException {
		RecordTypeContext _localctx = new RecordTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_recordType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(RECORD);
			setState(408);
			fieldList();
			setState(409);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldListContext extends ParserRuleContext {
		public FixedPartContext fixedPart() {
			return getRuleContext(FixedPartContext.class,0);
		}
		public VariantPartContext variantPart() {
			return getRuleContext(VariantPartContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PascalParser.SEMI, 0); }
		public FieldListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFieldList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFieldList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFieldList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldListContext fieldList() throws RecognitionException {
		FieldListContext _localctx = new FieldListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_fieldList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			switch (_input.LA(1)) {
			case IDENT:
				{
				setState(411);
				fixedPart();
				setState(415);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(412);
					match(SEMI);
					setState(413);
					variantPart();
					}
					break;
				case 2:
					{
					setState(414);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case CASE:
				{
				setState(417);
				variantPart();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FixedPartContext extends ParserRuleContext {
		public List<RecordSectionContext> recordSection() {
			return getRuleContexts(RecordSectionContext.class);
		}
		public RecordSectionContext recordSection(int i) {
			return getRuleContext(RecordSectionContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public FixedPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixedPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFixedPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFixedPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFixedPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FixedPartContext fixedPart() throws RecognitionException {
		FixedPartContext _localctx = new FixedPartContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_fixedPart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			recordSection();
			setState(425);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(421);
					match(SEMI);
					setState(422);
					recordSection();
					}
					} 
				}
				setState(427);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordSectionContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public RecordSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRecordSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRecordSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitRecordSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordSectionContext recordSection() throws RecognitionException {
		RecordSectionContext _localctx = new RecordSectionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_recordSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			identifierList();
			setState(429);
			match(COLON);
			setState(430);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariantPartContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(PascalParser.CASE, 0); }
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public List<VariantContext> variant() {
			return getRuleContexts(VariantContext.class);
		}
		public VariantContext variant(int i) {
			return getRuleContext(VariantContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public VariantPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variantPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariantPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariantPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVariantPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariantPartContext variantPart() throws RecognitionException {
		VariantPartContext _localctx = new VariantPartContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_variantPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(CASE);
			setState(433);
			tag();
			setState(434);
			match(OF);
			setState(435);
			variant();
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				setState(439);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(436);
					match(SEMI);
					setState(437);
					variant();
					}
					break;
				case 2:
					{
					setState(438);
					match(SEMI);
					}
					break;
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_tag);
		try {
			setState(449);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				identifier();
				setState(445);
				match(COLON);
				setState(446);
				typeIdentifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				typeIdentifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariantContext extends ParserRuleContext {
		public ConstListContext constList() {
			return getRuleContext(ConstListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public FieldListContext fieldList() {
			return getRuleContext(FieldListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public VariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVariant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariantContext variant() throws RecognitionException {
		VariantContext _localctx = new VariantContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_variant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			constList();
			setState(452);
			match(COLON);
			setState(453);
			match(LPAREN);
			setState(454);
			fieldList();
			setState(455);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetTypeContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(PascalParser.SET, 0); }
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public SetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSetType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetTypeContext setType() throws RecognitionException {
		SetTypeContext _localctx = new SetTypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_setType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(SET);
			setState(458);
			match(OF);
			setState(459);
			baseType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_baseType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			simpleType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileTypeContext extends ParserRuleContext {
		public TerminalNode FILE() { return getToken(PascalParser.FILE, 0); }
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FileTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFileType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFileType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFileType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileTypeContext fileType() throws RecognitionException {
		FileTypeContext _localctx = new FileTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_fileType);
		try {
			setState(467);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				match(FILE);
				setState(464);
				match(OF);
				setState(465);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				match(FILE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerTypeContext extends ParserRuleContext {
		public TerminalNode POINTER() { return getToken(PascalParser.POINTER, 0); }
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public PointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterPointerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitPointerType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerTypeContext pointerType() throws RecognitionException {
		PointerTypeContext _localctx = new PointerTypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_pointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(POINTER);
			setState(470);
			typeIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationPartContext extends ParserRuleContext {
		public String code;
		public VariableDeclarationContext variableDeclaration;
		public TerminalNode VAR() { return getToken(PascalParser.VAR, 0); }
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public VariableDeclarationPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariableDeclarationPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariableDeclarationPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVariableDeclarationPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationPartContext variableDeclarationPart() throws RecognitionException {
		VariableDeclarationPartContext _localctx = new VariableDeclarationPartContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variableDeclarationPart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(VAR);
			setState(473);
			((VariableDeclarationPartContext)_localctx).variableDeclaration = variableDeclaration();
			((VariableDeclarationPartContext)_localctx).code =  "var\n"; addLeft();  _localctx.code += indent + ((VariableDeclarationPartContext)_localctx).variableDeclaration.code;
			setState(481);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(475);
					match(SEMI);
					setState(476);
					((VariableDeclarationPartContext)_localctx).variableDeclaration = variableDeclaration();
					_localctx.code += "\n" + indent + ((VariableDeclarationPartContext)_localctx).variableDeclaration.code;
					}
					} 
				}
				setState(483);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(484);
			match(SEMI);
			updateIndent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public String code;
		public IdentifierListContext identifierList;
		public TypeContext type;
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			((VariableDeclarationContext)_localctx).identifierList = identifierList();
			setState(488);
			match(COLON);
			setState(489);
			((VariableDeclarationContext)_localctx).type = type();

			        ((VariableDeclarationContext)_localctx).code =  "";
			        for (String id: ((VariableDeclarationContext)_localctx).identifierList.idl) {
			            VariableChanger.add(id);
			            _localctx.code += VariableChanger.change(id) + ", ";
			        }
			        int k = rnd.nextInt() % 3 + 1;
			        for (int i = 0; i < k; i++) {
			            String id = "a" + String.valueOf(addedVars++);
			            VariableChanger.addNew(id);
			            _localctx.code += VariableChanger.change(id) + ", ";
			        }
			        ((VariableDeclarationContext)_localctx).code =  _localctx.code.substring(0, _localctx.code.length() - 2);
			        _localctx.code += ": " + ((VariableDeclarationContext)_localctx).type.code + ";";
			    //((VariableDeclarationContext)_localctx).code =  ((VariableDeclarationContext)_localctx).identifierList.code + ": " + ((VariableDeclarationContext)_localctx).type.code + ";";
			   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureAndFunctionDeclarationPartContext extends ParserRuleContext {
		public String code;
		public ProcedureDeclarationContext procedureDeclaration;
		public FunctionDeclarationContext functionDeclaration;
		public ProcedureDeclarationContext procedureDeclaration() {
			return getRuleContext(ProcedureDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ProcedureAndFunctionDeclarationPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureAndFunctionDeclarationPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProcedureAndFunctionDeclarationPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProcedureAndFunctionDeclarationPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitProcedureAndFunctionDeclarationPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureAndFunctionDeclarationPartContext procedureAndFunctionDeclarationPart() throws RecognitionException {
		ProcedureAndFunctionDeclarationPartContext _localctx = new ProcedureAndFunctionDeclarationPartContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_procedureAndFunctionDeclarationPart);
		try {
			setState(498);
			switch (_input.LA(1)) {
			case PROCEDURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				((ProcedureAndFunctionDeclarationPartContext)_localctx).procedureDeclaration = procedureDeclaration();
				((ProcedureAndFunctionDeclarationPartContext)_localctx).code =  ((ProcedureAndFunctionDeclarationPartContext)_localctx).procedureDeclaration.code;
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				((ProcedureAndFunctionDeclarationPartContext)_localctx).functionDeclaration = functionDeclaration();
				((ProcedureAndFunctionDeclarationPartContext)_localctx).code =  ((ProcedureAndFunctionDeclarationPartContext)_localctx).functionDeclaration.code;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureDeclarationContext extends ParserRuleContext {
		public String code;
		public TerminalNode PROCEDURE() { return getToken(PascalParser.PROCEDURE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PascalParser.SEMI, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ProcedureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProcedureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProcedureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitProcedureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureDeclarationContext procedureDeclaration() throws RecognitionException {
		ProcedureDeclarationContext _localctx = new ProcedureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_procedureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			match(PROCEDURE);
			setState(501);
			identifier();
			setState(503);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(502);
				formalParameterList();
				}
			}

			setState(505);
			match(SEMI);
			setState(506);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public String code;
		public TerminalNode FUNCTION() { return getToken(PascalParser.FUNCTION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public ResultTypeContext resultType() {
			return getRuleContext(ResultTypeContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PascalParser.SEMI, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(FUNCTION);
			setState(509);
			identifier();
			setState(511);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(510);
				formalParameterList();
				}
			}

			setState(513);
			match(COLON);
			setState(514);
			resultType();
			setState(515);
			match(SEMI);
			setState(516);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public String code;
		public FormalParameterSectionContext formalParameterSection;
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public List<FormalParameterSectionContext> formalParameterSection() {
			return getRuleContexts(FormalParameterSectionContext.class);
		}
		public FormalParameterSectionContext formalParameterSection(int i) {
			return getRuleContext(FormalParameterSectionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			match(LPAREN);
			setState(519);
			((FormalParameterListContext)_localctx).formalParameterSection = formalParameterSection();
			((FormalParameterListContext)_localctx).code =  ((FormalParameterListContext)_localctx).formalParameterSection.code;
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(521);
				match(SEMI);
				setState(522);
				((FormalParameterListContext)_localctx).formalParameterSection = formalParameterSection();
				_localctx.code += ", " + ((FormalParameterListContext)_localctx).formalParameterSection.code;
				}
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(530);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterSectionContext extends ParserRuleContext {
		public String code;
		public ParameterGroupContext parameterGroup;
		public ParameterGroupContext parameterGroup() {
			return getRuleContext(ParameterGroupContext.class,0);
		}
		public TerminalNode VAR() { return getToken(PascalParser.VAR, 0); }
		public TerminalNode FUNCTION() { return getToken(PascalParser.FUNCTION, 0); }
		public TerminalNode PROCEDURE() { return getToken(PascalParser.PROCEDURE, 0); }
		public FormalParameterSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFormalParameterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFormalParameterSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFormalParameterSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterSectionContext formalParameterSection() throws RecognitionException {
		FormalParameterSectionContext _localctx = new FormalParameterSectionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_formalParameterSection);
		try {
			setState(543);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				((FormalParameterSectionContext)_localctx).parameterGroup = parameterGroup();
				((FormalParameterSectionContext)_localctx).code =  ((FormalParameterSectionContext)_localctx).parameterGroup.code;
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				match(VAR);
				setState(536);
				((FormalParameterSectionContext)_localctx).parameterGroup = parameterGroup();
				((FormalParameterSectionContext)_localctx).code =  "var " + ((FormalParameterSectionContext)_localctx).parameterGroup.code;
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(539);
				match(FUNCTION);
				setState(540);
				parameterGroup();
				}
				break;
			case PROCEDURE:
				enterOuterAlt(_localctx, 4);
				{
				setState(541);
				match(PROCEDURE);
				setState(542);
				parameterGroup();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterGroupContext extends ParserRuleContext {
		public String code;
		public IdentifierListContext identifierList;
		public TypeIdentifierContext typeIdentifier;
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public ParameterGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterParameterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitParameterGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitParameterGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterGroupContext parameterGroup() throws RecognitionException {
		ParameterGroupContext _localctx = new ParameterGroupContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_parameterGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			((ParameterGroupContext)_localctx).identifierList = identifierList();
			setState(546);
			match(COLON);
			setState(547);
			((ParameterGroupContext)_localctx).typeIdentifier = typeIdentifier();
			 ((ParameterGroupContext)_localctx).code =  ((ParameterGroupContext)_localctx).identifierList.code + ": " + ((ParameterGroupContext)_localctx).typeIdentifier.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public String code;
		public List<String> idl =  new ArrayList<String>();
		public IdentifierContext identifier;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			((IdentifierListContext)_localctx).identifier = identifier();
			((IdentifierListContext)_localctx).code =  (((IdentifierListContext)_localctx).identifier!=null?_input.getText(((IdentifierListContext)_localctx).identifier.start,((IdentifierListContext)_localctx).identifier.stop):null); _localctx.idl.add((((IdentifierListContext)_localctx).identifier!=null?_input.getText(((IdentifierListContext)_localctx).identifier.start,((IdentifierListContext)_localctx).identifier.stop):null));
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(552);
				match(COMMA);
				setState(553);
				((IdentifierListContext)_localctx).identifier = identifier();
				_localctx.code += ", " + (((IdentifierListContext)_localctx).identifier!=null?_input.getText(((IdentifierListContext)_localctx).identifier.start,((IdentifierListContext)_localctx).identifier.stop):null); _localctx.idl.add((((IdentifierListContext)_localctx).identifier!=null?_input.getText(((IdentifierListContext)_localctx).identifier.start,((IdentifierListContext)_localctx).identifier.stop):null));
				}
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstListContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public ConstListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConstList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConstList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitConstList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstListContext constList() throws RecognitionException {
		ConstListContext _localctx = new ConstListContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_constList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			constant();
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(562);
				match(COMMA);
				setState(563);
				constant();
				}
				}
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultTypeContext extends ParserRuleContext {
		public String code;
		public TypeIdentifierContext typeIdentifier;
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public ResultTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterResultType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitResultType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitResultType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultTypeContext resultType() throws RecognitionException {
		ResultTypeContext _localctx = new ResultTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_resultType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			((ResultTypeContext)_localctx).typeIdentifier = typeIdentifier();
			((ResultTypeContext)_localctx).code =  ((ResultTypeContext)_localctx).typeIdentifier.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public String code =  "";
		public UnlabelledStatementContext unlabelledStatement;
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public UnlabelledStatementContext unlabelledStatement() {
			return getRuleContext(UnlabelledStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_statement);
		try {
			setState(580);
			switch (_input.LA(1)) {
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(572);
				label();
				setState(573);
				match(COLON);
				setState(574);
				((StatementContext)_localctx).unlabelledStatement = unlabelledStatement();
				((StatementContext)_localctx).code =  ((StatementContext)_localctx).unlabelledStatement.code;
				}
				break;
			case BEGIN:
			case CASE:
			case ELSE:
			case END:
			case FOR:
			case IF:
			case REPEAT:
			case UNTIL:
			case WHILE:
			case WITH:
			case SEMI:
			case AT:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(577);
				((StatementContext)_localctx).unlabelledStatement = unlabelledStatement();
				((StatementContext)_localctx).code =  ((StatementContext)_localctx).unlabelledStatement.code;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnlabelledStatementContext extends ParserRuleContext {
		public String code;
		public SimpleStatementContext simpleStatement;
		public StructuredStatementContext structuredStatement;
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public StructuredStatementContext structuredStatement() {
			return getRuleContext(StructuredStatementContext.class,0);
		}
		public UnlabelledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unlabelledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUnlabelledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUnlabelledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUnlabelledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnlabelledStatementContext unlabelledStatement() throws RecognitionException {
		UnlabelledStatementContext _localctx = new UnlabelledStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_unlabelledStatement);
		try {
			setState(588);
			switch (_input.LA(1)) {
			case ELSE:
			case END:
			case UNTIL:
			case SEMI:
			case AT:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(582);
				((UnlabelledStatementContext)_localctx).simpleStatement = simpleStatement();
				((UnlabelledStatementContext)_localctx).code =  ((UnlabelledStatementContext)_localctx).simpleStatement.code;
				}
				break;
			case BEGIN:
			case CASE:
			case FOR:
			case IF:
			case REPEAT:
			case WHILE:
			case WITH:
				enterOuterAlt(_localctx, 2);
				{
				setState(585);
				((UnlabelledStatementContext)_localctx).structuredStatement = structuredStatement();
				((UnlabelledStatementContext)_localctx).code =  ((UnlabelledStatementContext)_localctx).structuredStatement.code;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleStatementContext extends ParserRuleContext {
		public String code;
		public AssignmentStatementContext assignmentStatement;
		public ProcedureStatementContext procedureStatement;
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public ProcedureStatementContext procedureStatement() {
			return getRuleContext(ProcedureStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSimpleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_simpleStatement);
		try {
			setState(599);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				((SimpleStatementContext)_localctx).assignmentStatement = assignmentStatement();
				((SimpleStatementContext)_localctx).code =  ((SimpleStatementContext)_localctx).assignmentStatement.code;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				((SimpleStatementContext)_localctx).procedureStatement = procedureStatement();
				((SimpleStatementContext)_localctx).code =  ((SimpleStatementContext)_localctx).procedureStatement.code;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(596);
				emptyStatement();
				((SimpleStatementContext)_localctx).code =  "";
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public String code;
		public VariableContext variable;
		public ExpressionContext expression;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PascalParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			((AssignmentStatementContext)_localctx).variable = variable();
			setState(602);
			match(ASSIGN);
			setState(603);
			((AssignmentStatementContext)_localctx).expression = expression();
			((AssignmentStatementContext)_localctx).code =  ((AssignmentStatementContext)_localctx).variable.code + " := " + ((AssignmentStatementContext)_localctx).expression.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier;
		public ExpressionContext expression;
		public TerminalNode AT() { return getToken(PascalParser.AT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(PascalParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(PascalParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(PascalParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(PascalParser.RBRACK, i);
		}
		public List<TerminalNode> LBRACK2() { return getTokens(PascalParser.LBRACK2); }
		public TerminalNode LBRACK2(int i) {
			return getToken(PascalParser.LBRACK2, i);
		}
		public List<TerminalNode> RBRACK2() { return getTokens(PascalParser.RBRACK2); }
		public TerminalNode RBRACK2(int i) {
			return getToken(PascalParser.RBRACK2, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PascalParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PascalParser.DOT, i);
		}
		public List<TerminalNode> POINTER() { return getTokens(PascalParser.POINTER); }
		public TerminalNode POINTER(int i) {
			return getToken(PascalParser.POINTER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			switch (_input.LA(1)) {
			case AT:
				{
				setState(606);
				match(AT);
				setState(607);
				((VariableContext)_localctx).identifier = identifier();
				}
				break;
			case IDENT:
				{
				setState(608);
				((VariableContext)_localctx).identifier = identifier();
				((VariableContext)_localctx).code =  VariableChanger.change((((VariableContext)_localctx).identifier!=null?_input.getText(((VariableContext)_localctx).identifier.start,((VariableContext)_localctx).identifier.stop):null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << LBRACK2) | (1L << POINTER) | (1L << DOT))) != 0)) {
				{
				setState(642);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					setState(613);
					match(LBRACK);
					setState(614);
					((VariableContext)_localctx).expression = expression();
					_localctx.code += "[" + ((VariableContext)_localctx).expression.code;
					setState(622);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(616);
						match(COMMA);
						setState(617);
						((VariableContext)_localctx).expression = expression();
						_localctx.code += ", " + ((VariableContext)_localctx).expression.code;
						}
						}
						setState(624);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(625);
					match(RBRACK);
					_localctx.code += "]";
					}
					break;
				case LBRACK2:
					{
					setState(628);
					match(LBRACK2);
					setState(629);
					((VariableContext)_localctx).expression = expression();
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(630);
						match(COMMA);
						setState(631);
						((VariableContext)_localctx).expression = expression();
						}
						}
						setState(636);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(637);
					match(RBRACK2);
					}
					break;
				case DOT:
					{
					setState(639);
					match(DOT);
					setState(640);
					((VariableContext)_localctx).identifier = identifier();
					}
					break;
				case POINTER:
					{
					setState(641);
					match(POINTER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public String code;
		public SimpleExpressionContext simpleExpression;
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(PascalParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(PascalParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(PascalParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(PascalParser.NOT_EQUAL, i);
		}
		public List<TerminalNode> LT() { return getTokens(PascalParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(PascalParser.LT, i);
		}
		public List<TerminalNode> LE() { return getTokens(PascalParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(PascalParser.LE, i);
		}
		public List<TerminalNode> GE() { return getTokens(PascalParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(PascalParser.GE, i);
		}
		public List<TerminalNode> GT() { return getTokens(PascalParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(PascalParser.GT, i);
		}
		public List<TerminalNode> IN() { return getTokens(PascalParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(PascalParser.IN, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			((ExpressionContext)_localctx).simpleExpression = simpleExpression();
			((ExpressionContext)_localctx).code =  ((ExpressionContext)_localctx).simpleExpression.code;
			setState(670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IN) | (1L << EQUAL) | (1L << NOT_EQUAL) | (1L << LT) | (1L << LE) | (1L << GE) | (1L << GT))) != 0)) {
				{
				{
				setState(663);
				switch (_input.LA(1)) {
				case EQUAL:
					{
					setState(649);
					match(EQUAL);
					_localctx.code += "=";
					}
					break;
				case NOT_EQUAL:
					{
					setState(651);
					match(NOT_EQUAL);
					_localctx.code += "<>";
					}
					break;
				case LT:
					{
					setState(653);
					match(LT);
					_localctx.code += "<";
					}
					break;
				case LE:
					{
					setState(655);
					match(LE);
					_localctx.code += "<=";
					}
					break;
				case GE:
					{
					setState(657);
					match(GE);
					_localctx.code += ">=";
					}
					break;
				case GT:
					{
					setState(659);
					match(GT);
					_localctx.code += ">";
					}
					break;
				case IN:
					{
					setState(661);
					match(IN);
					_localctx.code += "in";
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(665);
				((ExpressionContext)_localctx).simpleExpression = simpleExpression();
				_localctx.code += ((ExpressionContext)_localctx).simpleExpression.code;
				}
				}
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExpressionContext extends ParserRuleContext {
		public String code;
		public TermContext term;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(PascalParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(PascalParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(PascalParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(PascalParser.MINUS, i);
		}
		public List<TerminalNode> OR() { return getTokens(PascalParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PascalParser.OR, i);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_simpleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			((SimpleExpressionContext)_localctx).term = term();
			((SimpleExpressionContext)_localctx).code =  ((SimpleExpressionContext)_localctx).term.code;
			setState(688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << PLUS) | (1L << MINUS))) != 0)) {
				{
				{
				setState(681);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(675);
					match(PLUS);
					_localctx.code += " + ";
					}
					break;
				case MINUS:
					{
					setState(677);
					match(MINUS);
					_localctx.code += " - ";
					}
					break;
				case OR:
					{
					setState(679);
					match(OR);
					_localctx.code += " or ";
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(683);
				((SimpleExpressionContext)_localctx).term = term();
				_localctx.code += ((SimpleExpressionContext)_localctx).term.code;
				}
				}
				setState(690);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public String code;
		public SignedFactorContext signedFactor;
		public List<SignedFactorContext> signedFactor() {
			return getRuleContexts(SignedFactorContext.class);
		}
		public SignedFactorContext signedFactor(int i) {
			return getRuleContext(SignedFactorContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(PascalParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(PascalParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(PascalParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(PascalParser.SLASH, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PascalParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PascalParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(PascalParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(PascalParser.MOD, i);
		}
		public List<TerminalNode> AND() { return getTokens(PascalParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PascalParser.AND, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			((TermContext)_localctx).signedFactor = signedFactor();
			((TermContext)_localctx).code =  ((TermContext)_localctx).signedFactor.code;
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << DIV) | (1L << MOD) | (1L << STAR) | (1L << SLASH))) != 0)) {
				{
				{
				setState(703);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(693);
					match(STAR);
					_localctx.code += " * ";
					}
					break;
				case SLASH:
					{
					setState(695);
					match(SLASH);
					_localctx.code += " / ";
					}
					break;
				case DIV:
					{
					setState(697);
					match(DIV);
					_localctx.code += " div ";
					}
					break;
				case MOD:
					{
					setState(699);
					match(MOD);
					_localctx.code += " mod ";
					}
					break;
				case AND:
					{
					setState(701);
					match(AND);
					_localctx.code += " and ";
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(705);
				((TermContext)_localctx).signedFactor = signedFactor();
				_localctx.code += ((TermContext)_localctx).signedFactor.code;
				}
				}
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedFactorContext extends ParserRuleContext {
		public String code =  "";
		public FactorContext factor;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public SignedFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSignedFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSignedFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSignedFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedFactorContext signedFactor() throws RecognitionException {
		SignedFactorContext _localctx = new SignedFactorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_signedFactor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(713);
				match(PLUS);
				_localctx.code += "+";
				}
				break;
			case MINUS:
				{
				setState(715);
				match(MINUS);
				_localctx.code += "-";
				}
				break;
			case CHR:
			case NIL:
			case NOT:
			case LPAREN:
			case LBRACK:
			case LBRACK2:
			case AT:
			case IDENT:
			case STRING_LITERAL:
			case NUM_INT:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(719);
			((SignedFactorContext)_localctx).factor = factor();
			_localctx.code += ((SignedFactorContext)_localctx).factor.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public String code;
		public VariableContext variable;
		public ExpressionContext expression;
		public FunctionDesignatorContext functionDesignator;
		public UnsignedConstantContext unsignedConstant;
		public FactorContext factor;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public FunctionDesignatorContext functionDesignator() {
			return getRuleContext(FunctionDesignatorContext.class,0);
		}
		public UnsignedConstantContext unsignedConstant() {
			return getRuleContext(UnsignedConstantContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PascalParser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_factor);
		try {
			setState(741);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(722);
				((FactorContext)_localctx).variable = variable();
				((FactorContext)_localctx).code =  ((FactorContext)_localctx).variable.code;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(725);
				match(LPAREN);
				setState(726);
				((FactorContext)_localctx).expression = expression();
				setState(727);
				match(RPAREN);
				((FactorContext)_localctx).code =  ((FactorContext)_localctx).expression.code;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(730);
				((FactorContext)_localctx).functionDesignator = functionDesignator();
				((FactorContext)_localctx).code =  ((FactorContext)_localctx).functionDesignator.code;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(733);
				((FactorContext)_localctx).unsignedConstant = unsignedConstant();
				((FactorContext)_localctx).code =  ((FactorContext)_localctx).unsignedConstant.code;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(736);
				set();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(737);
				match(NOT);
				setState(738);
				((FactorContext)_localctx).factor = factor();
				((FactorContext)_localctx).code =  "not " + _localctx.code;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedConstantContext extends ParserRuleContext {
		public String code;
		public UnsignedNumberContext unsignedNumber;
		public StringContext string;
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public ConstantChrContext constantChr() {
			return getRuleContext(ConstantChrContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode NIL() { return getToken(PascalParser.NIL, 0); }
		public UnsignedConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterUnsignedConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitUnsignedConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitUnsignedConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedConstantContext unsignedConstant() throws RecognitionException {
		UnsignedConstantContext _localctx = new UnsignedConstantContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_unsignedConstant);
		try {
			setState(751);
			switch (_input.LA(1)) {
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(743);
				((UnsignedConstantContext)_localctx).unsignedNumber = unsignedNumber();
				((UnsignedConstantContext)_localctx).code =  (((UnsignedConstantContext)_localctx).unsignedNumber!=null?_input.getText(((UnsignedConstantContext)_localctx).unsignedNumber.start,((UnsignedConstantContext)_localctx).unsignedNumber.stop):null);
				}
				break;
			case CHR:
				enterOuterAlt(_localctx, 2);
				{
				setState(746);
				constantChr();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(747);
				((UnsignedConstantContext)_localctx).string = string();
				((UnsignedConstantContext)_localctx).code =  ((UnsignedConstantContext)_localctx).string.code;
				}
				break;
			case NIL:
				enterOuterAlt(_localctx, 4);
				{
				setState(750);
				match(NIL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDesignatorContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public FunctionDesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDesignator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFunctionDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFunctionDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFunctionDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDesignatorContext functionDesignator() throws RecognitionException {
		FunctionDesignatorContext _localctx = new FunctionDesignatorContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_functionDesignator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			identifier();
			setState(754);
			match(LPAREN);
			setState(755);
			parameterList();
			setState(756);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public String code;
		public ActualParameterContext actualParameter;
		public List<ActualParameterContext> actualParameter() {
			return getRuleContexts(ActualParameterContext.class);
		}
		public ActualParameterContext actualParameter(int i) {
			return getRuleContext(ActualParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			((ParameterListContext)_localctx).actualParameter = actualParameter();
			((ParameterListContext)_localctx).code =  ((ParameterListContext)_localctx).actualParameter.code;
			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(760);
				match(COMMA);
				setState(761);
				((ParameterListContext)_localctx).actualParameter = actualParameter();
				_localctx.code += ", " + ((ParameterListContext)_localctx).actualParameter.code;
				}
				}
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(PascalParser.LBRACK, 0); }
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PascalParser.RBRACK, 0); }
		public TerminalNode LBRACK2() { return getToken(PascalParser.LBRACK2, 0); }
		public TerminalNode RBRACK2() { return getToken(PascalParser.RBRACK2, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_set);
		try {
			setState(777);
			switch (_input.LA(1)) {
			case LBRACK:
				enterOuterAlt(_localctx, 1);
				{
				setState(769);
				match(LBRACK);
				setState(770);
				elementList();
				setState(771);
				match(RBRACK);
				}
				break;
			case LBRACK2:
				enterOuterAlt(_localctx, 2);
				{
				setState(773);
				match(LBRACK2);
				setState(774);
				elementList();
				setState(775);
				match(RBRACK2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementListContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitElementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_elementList);
		int _la;
		try {
			setState(788);
			switch (_input.LA(1)) {
			case CHR:
			case NIL:
			case NOT:
			case PLUS:
			case MINUS:
			case LPAREN:
			case LBRACK:
			case LBRACK2:
			case AT:
			case IDENT:
			case STRING_LITERAL:
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(779);
				element();
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(780);
					match(COMMA);
					setState(781);
					element();
					}
					}
					setState(786);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RBRACK:
			case RBRACK2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOTDOT() { return getToken(PascalParser.DOTDOT, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			expression();
			setState(793);
			_la = _input.LA(1);
			if (_la==DOTDOT) {
				{
				setState(791);
				match(DOTDOT);
				setState(792);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureStatementContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier;
		public ParameterListContext parameterList;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PascalParser.LPAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PascalParser.RPAREN, 0); }
		public ProcedureStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProcedureStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProcedureStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitProcedureStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureStatementContext procedureStatement() throws RecognitionException {
		ProcedureStatementContext _localctx = new ProcedureStatementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_procedureStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			((ProcedureStatementContext)_localctx).identifier = identifier();
			((ProcedureStatementContext)_localctx).code =  (((ProcedureStatementContext)_localctx).identifier!=null?_input.getText(((ProcedureStatementContext)_localctx).identifier.start,((ProcedureStatementContext)_localctx).identifier.stop):null);
			setState(802);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(797);
				match(LPAREN);
				setState(798);
				((ProcedureStatementContext)_localctx).parameterList = parameterList();
				setState(799);
				match(RPAREN);
				_localctx.code += "(" + ((ProcedureStatementContext)_localctx).parameterList.code + ")";
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParameterContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ActualParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterActualParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitActualParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitActualParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParameterContext actualParameter() throws RecognitionException {
		ActualParameterContext _localctx = new ActualParameterContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_actualParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			((ActualParameterContext)_localctx).expression = expression();
			((ActualParameterContext)_localctx).code =  ((ActualParameterContext)_localctx).expression.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GotoStatementContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(PascalParser.GOTO, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public GotoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterGotoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitGotoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitGotoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoStatementContext gotoStatement() throws RecognitionException {
		GotoStatementContext _localctx = new GotoStatementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_gotoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			match(GOTO);
			setState(808);
			label();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyContext extends ParserRuleContext {
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructuredStatementContext extends ParserRuleContext {
		public String code;
		public CompoundStatementContext compoundStatement;
		public ConditionalStatementContext conditionalStatement;
		public RepetetiveStatementContext repetetiveStatement;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public RepetetiveStatementContext repetetiveStatement() {
			return getRuleContext(RepetetiveStatementContext.class,0);
		}
		public WithStatementContext withStatement() {
			return getRuleContext(WithStatementContext.class,0);
		}
		public StructuredStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structuredStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterStructuredStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitStructuredStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitStructuredStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructuredStatementContext structuredStatement() throws RecognitionException {
		StructuredStatementContext _localctx = new StructuredStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_structuredStatement);
		try {
			setState(824);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(814);
				((StructuredStatementContext)_localctx).compoundStatement = compoundStatement();
				((StructuredStatementContext)_localctx).code =  ((StructuredStatementContext)_localctx).compoundStatement.code;
				}
				break;
			case CASE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(817);
				((StructuredStatementContext)_localctx).conditionalStatement = conditionalStatement();
				((StructuredStatementContext)_localctx).code =  ((StructuredStatementContext)_localctx).conditionalStatement.code;
				}
				break;
			case FOR:
			case REPEAT:
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(820);
				((StructuredStatementContext)_localctx).repetetiveStatement = repetetiveStatement();
				((StructuredStatementContext)_localctx).code =  ((StructuredStatementContext)_localctx).repetetiveStatement.code;
				}
				break;
			case WITH:
				enterOuterAlt(_localctx, 4);
				{
				setState(823);
				withStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public String code;
		public StatementsContext statements;
		public TerminalNode BEGIN() { return getToken(PascalParser.BEGIN, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_compoundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			match(BEGIN);
			setState(827);
			((CompoundStatementContext)_localctx).statements = statements();
			setState(828);
			match(END);
			((CompoundStatementContext)_localctx).code =  "begin\n" + ((CompoundStatementContext)_localctx).statements.code + "\nend;";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public String code =  "";
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			((StatementsContext)_localctx).statement = statement();

			        ((StatementsContext)_localctx).code =  (((StatementsContext)_localctx).statement.code.isEmpty() || ((StatementsContext)_localctx).statement.code.equals("\n")) ? "" : ((StatementsContext)_localctx).statement.code + ";";
			        if (rnd.nextInt() % 4 == 0) {
			            _localctx.code += "\n" + VariableChanger.trash();
			        }
			   
			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(833);
				match(SEMI);
				setState(834);
				((StatementsContext)_localctx).statement = statement();

				        _localctx.code += (((StatementsContext)_localctx).statement.code.isEmpty() || ((StatementsContext)_localctx).statement.code.equals("\n")) ? "" : "\n" + ((StatementsContext)_localctx).statement.code + ";";
				        if (rnd.nextInt() % 4 == 0) {
				            _localctx.code += "\n" + VariableChanger.trash();
				        }
				   
				}
				}
				setState(841);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalStatementContext extends ParserRuleContext {
		public String code;
		public IfStatementContext ifStatement;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public CaseStatementContext caseStatement() {
			return getRuleContext(CaseStatementContext.class,0);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_conditionalStatement);
		try {
			setState(846);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(842);
				((ConditionalStatementContext)_localctx).ifStatement = ifStatement();
				((ConditionalStatementContext)_localctx).code =  ((ConditionalStatementContext)_localctx).ifStatement.code;
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 2);
				{
				setState(845);
				caseStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public StatementContext statement;
		public TerminalNode IF() { return getToken(PascalParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PascalParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PascalParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848);
			match(IF);
			setState(849);
			((IfStatementContext)_localctx).expression = expression();
			setState(850);
			match(THEN);
			setState(851);
			((IfStatementContext)_localctx).statement = statement();
			((IfStatementContext)_localctx).code =  "if " + ((IfStatementContext)_localctx).expression.code + " then\n" + ((IfStatementContext)_localctx).statement.code + ";" + "\n"; 
			setState(857);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(853);
				match(ELSE);
				setState(854);
				((IfStatementContext)_localctx).statement = statement();

				        if (((IfStatementContext)_localctx).statement.code.trim().startsWith("if")) {
				            _localctx.code += " else " + ((IfStatementContext)_localctx).statement.code;
				        } else {
				            _localctx.code += " else\n" + (((IfStatementContext)_localctx).statement.code.isEmpty() ? "" : ((IfStatementContext)_localctx).statement.code + ";") + "\n";
				        }
				    
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseStatementContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(PascalParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public List<CaseListElementContext> caseListElement() {
			return getRuleContexts(CaseListElementContext.class);
		}
		public CaseListElementContext caseListElement(int i) {
			return getRuleContext(CaseListElementContext.class,i);
		}
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public List<TerminalNode> SEMI() { return getTokens(PascalParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PascalParser.SEMI, i);
		}
		public TerminalNode ELSE() { return getToken(PascalParser.ELSE, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public CaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterCaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitCaseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitCaseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseStatementContext caseStatement() throws RecognitionException {
		CaseStatementContext _localctx = new CaseStatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_caseStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			match(CASE);
			setState(860);
			expression();
			setState(861);
			match(OF);
			setState(862);
			caseListElement();
			setState(867);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(863);
					match(SEMI);
					setState(864);
					caseListElement();
					}
					} 
				}
				setState(869);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(873);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(870);
				match(SEMI);
				setState(871);
				match(ELSE);
				setState(872);
				statements();
				}
			}

			setState(875);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseListElementContext extends ParserRuleContext {
		public ConstListContext constList() {
			return getRuleContext(ConstListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public CaseListElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseListElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterCaseListElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitCaseListElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitCaseListElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseListElementContext caseListElement() throws RecognitionException {
		CaseListElementContext _localctx = new CaseListElementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_caseListElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			constList();
			setState(878);
			match(COLON);
			setState(879);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepetetiveStatementContext extends ParserRuleContext {
		public String code;
		public WhileStatementContext whileStatement;
		public RepeatStatementContext repeatStatement;
		public ForStatementContext forStatement;
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public RepetetiveStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetetiveStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRepetetiveStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRepetetiveStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitRepetetiveStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepetetiveStatementContext repetetiveStatement() throws RecognitionException {
		RepetetiveStatementContext _localctx = new RepetetiveStatementContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_repetetiveStatement);
		try {
			setState(890);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(881);
				((RepetetiveStatementContext)_localctx).whileStatement = whileStatement();
				((RepetetiveStatementContext)_localctx).code =  ((RepetetiveStatementContext)_localctx).whileStatement.code;
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(884);
				((RepetetiveStatementContext)_localctx).repeatStatement = repeatStatement();
				((RepetetiveStatementContext)_localctx).code =  ((RepetetiveStatementContext)_localctx).repeatStatement.code;
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(887);
				((RepetetiveStatementContext)_localctx).forStatement = forStatement();
				((RepetetiveStatementContext)_localctx).code =  ((RepetetiveStatementContext)_localctx).forStatement.code;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public StatementContext statement;
		public TerminalNode WHILE() { return getToken(PascalParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			match(WHILE);
			setState(893);
			((WhileStatementContext)_localctx).expression = expression();
			setState(894);
			match(DO);
			setState(895);
			((WhileStatementContext)_localctx).statement = statement();
			((WhileStatementContext)_localctx).code =  "while " + ((WhileStatementContext)_localctx).expression.code + " do \n" + ((WhileStatementContext)_localctx).statement.code + "\n";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatStatementContext extends ParserRuleContext {
		public String code;
		public StatementsContext statements;
		public ExpressionContext expression;
		public TerminalNode REPEAT() { return getToken(PascalParser.REPEAT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(PascalParser.UNTIL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRepeatStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRepeatStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_repeatStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			match(REPEAT);
			setState(899);
			((RepeatStatementContext)_localctx).statements = statements();
			setState(900);
			match(UNTIL);
			setState(901);
			((RepeatStatementContext)_localctx).expression = expression();
			((RepeatStatementContext)_localctx).code =  "repeat\n" + ((RepeatStatementContext)_localctx).statements.code + "\nuntil " + ((RepeatStatementContext)_localctx).expression.code + ";";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public String code;
		public IdentifierContext identifier;
		public ForListContext forList;
		public StatementContext statement;
		public TerminalNode FOR() { return getToken(PascalParser.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(PascalParser.ASSIGN, 0); }
		public ForListContext forList() {
			return getRuleContext(ForListContext.class,0);
		}
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			match(FOR);
			setState(905);
			((ForStatementContext)_localctx).identifier = identifier();
			setState(906);
			match(ASSIGN);
			setState(907);
			((ForStatementContext)_localctx).forList = forList();
			setState(908);
			match(DO);
			setState(909);
			((ForStatementContext)_localctx).statement = statement();
			((ForStatementContext)_localctx).code =  "for " + VariableChanger.change((((ForStatementContext)_localctx).identifier!=null?_input.getText(((ForStatementContext)_localctx).identifier.start,((ForStatementContext)_localctx).identifier.stop):null)) + " := " + ((ForStatementContext)_localctx).forList.code + " do\n" + ((ForStatementContext)_localctx).statement.code + "\n";
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForListContext extends ParserRuleContext {
		public String code;
		public InitialValueContext initialValue;
		public FinalValueContext finalValue;
		public InitialValueContext initialValue() {
			return getRuleContext(InitialValueContext.class,0);
		}
		public FinalValueContext finalValue() {
			return getRuleContext(FinalValueContext.class,0);
		}
		public TerminalNode TO() { return getToken(PascalParser.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(PascalParser.DOWNTO, 0); }
		public ForListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterForList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitForList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitForList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForListContext forList() throws RecognitionException {
		ForListContext _localctx = new ForListContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_forList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(912);
			((ForListContext)_localctx).initialValue = initialValue();
			((ForListContext)_localctx).code =  ((ForListContext)_localctx).initialValue.code;
			setState(918);
			switch (_input.LA(1)) {
			case TO:
				{
				setState(914);
				match(TO);
				_localctx.code += " to ";
				}
				break;
			case DOWNTO:
				{
				setState(916);
				match(DOWNTO);
				_localctx.code += " downto ";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(920);
			((ForListContext)_localctx).finalValue = finalValue();
			_localctx.code += ((ForListContext)_localctx).finalValue.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitialValueContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitialValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterInitialValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitInitialValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitInitialValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialValueContext initialValue() throws RecognitionException {
		InitialValueContext _localctx = new InitialValueContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_initialValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(923);
			((InitialValueContext)_localctx).expression = expression();
			((InitialValueContext)_localctx).code =  ((InitialValueContext)_localctx).expression.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalValueContext extends ParserRuleContext {
		public String code;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFinalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFinalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitFinalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalValueContext finalValue() throws RecognitionException {
		FinalValueContext _localctx = new FinalValueContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_finalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			((FinalValueContext)_localctx).expression = expression();
			((FinalValueContext)_localctx).code =  ((FinalValueContext)_localctx).expression.code;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithStatementContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(PascalParser.WITH, 0); }
		public RecordVariableListContext recordVariableList() {
			return getRuleContext(RecordVariableListContext.class,0);
		}
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WithStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterWithStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitWithStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitWithStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithStatementContext withStatement() throws RecognitionException {
		WithStatementContext _localctx = new WithStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_withStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929);
			match(WITH);
			setState(930);
			recordVariableList();
			setState(931);
			match(DO);
			setState(932);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordVariableListContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public RecordVariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordVariableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRecordVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRecordVariableList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalVisitor ) return ((PascalVisitor<? extends T>)visitor).visitRecordVariableList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordVariableListContext recordVariableList() throws RecognitionException {
		RecordVariableListContext _localctx = new RecordVariableListContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_recordVariableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(934);
			variable();
			setState(939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(935);
				match(COMMA);
				setState(936);
				variable();
				}
				}
				setState(941);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u03b1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\3\2\3\2\5\2\u00b3\n\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\u00bf\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c9"+
		"\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00d9"+
		"\n\5\f\5\16\5\u00dc\13\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00f0\n\b\f\b\16\b\u00f3\13\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0114"+
		"\n\13\3\f\3\f\5\f\u0118\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\7\21\u0127\n\21\f\21\16\21\u012a\13\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0133\n\22\3\23\3\23\5\23\u0137\n\23\3"+
		"\23\3\23\3\23\3\24\3\24\5\24\u013e\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u0149\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u0155\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u016d\n\31\5\31\u016f\n\31\3\32\3\32\3\32\3\32\3\32\5\32\u0176\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\5\33\u017e\n\33\3\34\3\34\3\34\3\34\5\34"+
		"\u0184\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0190"+
		"\n\35\f\35\16\35\u0193\13\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\5\37\u01a2\n\37\3\37\5\37\u01a5\n\37\3 \3 \3 "+
		"\7 \u01aa\n \f \16 \u01ad\13 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\7\"\u01ba\n\"\f\"\16\"\u01bd\13\"\3#\3#\3#\3#\3#\5#\u01c4\n#\3$\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\5\'\u01d6\n\'\3(\3(\3(\3"+
		")\3)\3)\3)\3)\3)\3)\7)\u01e2\n)\f)\16)\u01e5\13)\3)\3)\3)\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\3+\3+\3+\5+\u01f5\n+\3,\3,\3,\5,\u01fa\n,\3,\3,\3,\3-\3-"+
		"\3-\5-\u0202\n-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\7.\u0210\n.\f.\16"+
		".\u0213\13.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0222\n/\3\60\3"+
		"\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u022f\n\61\f\61"+
		"\16\61\u0232\13\61\3\62\3\62\3\62\7\62\u0237\n\62\f\62\16\62\u023a\13"+
		"\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0247"+
		"\n\64\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u024f\n\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\5\66\u025a\n\66\3\67\3\67\3\67\3\67\3\67\38"+
		"\38\38\38\38\58\u0266\n8\38\38\38\38\38\38\38\78\u026f\n8\f8\168\u0272"+
		"\138\38\38\38\38\38\38\38\78\u027b\n8\f8\168\u027e\138\38\38\38\38\38"+
		"\78\u0285\n8\f8\168\u0288\138\39\39\39\39\39\39\39\39\39\39\39\39\39\3"+
		"9\39\39\59\u029a\n9\39\39\39\79\u029f\n9\f9\169\u02a2\139\3:\3:\3:\3:"+
		"\3:\3:\3:\3:\5:\u02ac\n:\3:\3:\3:\7:\u02b1\n:\f:\16:\u02b4\13:\3;\3;\3"+
		";\3;\3;\3;\3;\3;\3;\3;\3;\3;\5;\u02c2\n;\3;\3;\3;\7;\u02c7\n;\f;\16;\u02ca"+
		"\13;\3<\3<\3<\3<\5<\u02d0\n<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\3=\5=\u02e8\n=\3>\3>\3>\3>\3>\3>\3>\3>\5>\u02f2"+
		"\n>\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\7@\u02ff\n@\f@\16@\u0302\13@\3A\3"+
		"A\3A\3A\3A\3A\3A\3A\5A\u030c\nA\3B\3B\3B\7B\u0311\nB\fB\16B\u0314\13B"+
		"\3B\5B\u0317\nB\3C\3C\3C\5C\u031c\nC\3D\3D\3D\3D\3D\3D\3D\5D\u0325\nD"+
		"\3E\3E\3E\3F\3F\3F\3G\3G\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u033b"+
		"\nI\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\7K\u0348\nK\fK\16K\u034b\13K\3L\3"+
		"L\3L\3L\5L\u0351\nL\3M\3M\3M\3M\3M\3M\3M\3M\3M\5M\u035c\nM\3N\3N\3N\3"+
		"N\3N\3N\7N\u0364\nN\fN\16N\u0367\13N\3N\3N\3N\5N\u036c\nN\3N\3N\3O\3O"+
		"\3O\3O\3P\3P\3P\3P\3P\3P\3P\3P\3P\5P\u037d\nP\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R"+
		"\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\5T\u0399\nT\3T"+
		"\3T\3T\3U\3U\3U\3V\3V\3V\3W\3W\3W\3W\3W\3X\3X\3X\7X\u03ac\nX\fX\16X\u03af"+
		"\13X\3X\2\2Y\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\2\3\3\2+,\u03c6\2\u00b0\3\2"+
		"\2\2\4\u00c8\3\2\2\2\6\u00ca\3\2\2\2\b\u00da\3\2\2\2\n\u00e2\3\2\2\2\f"+
		"\u00e6\3\2\2\2\16\u00e8\3\2\2\2\20\u00f7\3\2\2\2\22\u00fc\3\2\2\2\24\u0113"+
		"\3\2\2\2\26\u0117\3\2\2\2\30\u0119\3\2\2\2\32\u011b\3\2\2\2\34\u011d\3"+
		"\2\2\2\36\u011f\3\2\2\2 \u0122\3\2\2\2\"\u012d\3\2\2\2$\u0134\3\2\2\2"+
		"&\u013b\3\2\2\2(\u0148\3\2\2\2*\u0154\3\2\2\2,\u0156\3\2\2\2.\u015a\3"+
		"\2\2\2\60\u016e\3\2\2\2\62\u0175\3\2\2\2\64\u017d\3\2\2\2\66\u017f\3\2"+
		"\2\28\u0187\3\2\2\2:\u0199\3\2\2\2<\u01a4\3\2\2\2>\u01a6\3\2\2\2@\u01ae"+
		"\3\2\2\2B\u01b2\3\2\2\2D\u01c3\3\2\2\2F\u01c5\3\2\2\2H\u01cb\3\2\2\2J"+
		"\u01cf\3\2\2\2L\u01d5\3\2\2\2N\u01d7\3\2\2\2P\u01da\3\2\2\2R\u01e9\3\2"+
		"\2\2T\u01f4\3\2\2\2V\u01f6\3\2\2\2X\u01fe\3\2\2\2Z\u0208\3\2\2\2\\\u0221"+
		"\3\2\2\2^\u0223\3\2\2\2`\u0228\3\2\2\2b\u0233\3\2\2\2d\u023b\3\2\2\2f"+
		"\u0246\3\2\2\2h\u024e\3\2\2\2j\u0259\3\2\2\2l\u025b\3\2\2\2n\u0265\3\2"+
		"\2\2p\u0289\3\2\2\2r\u02a3\3\2\2\2t\u02b5\3\2\2\2v\u02cf\3\2\2\2x\u02e7"+
		"\3\2\2\2z\u02f1\3\2\2\2|\u02f3\3\2\2\2~\u02f8\3\2\2\2\u0080\u030b\3\2"+
		"\2\2\u0082\u0316\3\2\2\2\u0084\u0318\3\2\2\2\u0086\u031d\3\2\2\2\u0088"+
		"\u0326\3\2\2\2\u008a\u0329\3\2\2\2\u008c\u032c\3\2\2\2\u008e\u032e\3\2"+
		"\2\2\u0090\u033a\3\2\2\2\u0092\u033c\3\2\2\2\u0094\u0341\3\2\2\2\u0096"+
		"\u0350\3\2\2\2\u0098\u0352\3\2\2\2\u009a\u035d\3\2\2\2\u009c\u036f\3\2"+
		"\2\2\u009e\u037c\3\2\2\2\u00a0\u037e\3\2\2\2\u00a2\u0384\3\2\2\2\u00a4"+
		"\u038a\3\2\2\2\u00a6\u0392\3\2\2\2\u00a8\u039d\3\2\2\2\u00aa\u03a0\3\2"+
		"\2\2\u00ac\u03a3\3\2\2\2\u00ae\u03a8\3\2\2\2\u00b0\u00b2\5\4\3\2\u00b1"+
		"\u00b3\7F\2\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b5\5\b\5\2\u00b5\u00b6\7A\2\2\u00b6\u00b7\b\2\1\2\u00b7"+
		"\3\3\2\2\2\u00b8\u00b9\7\37\2\2\u00b9\u00be\5\6\4\2\u00ba\u00bb\79\2\2"+
		"\u00bb\u00bc\5`\61\2\u00bc\u00bd\7:\2\2\u00bd\u00bf\3\2\2\2\u00be\u00ba"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\61\2\2"+
		"\u00c1\u00c2\b\3\1\2\u00c2\u00c9\3\2\2\2\u00c3\u00c4\7E\2\2\u00c4\u00c5"+
		"\5\6\4\2\u00c5\u00c6\7\61\2\2\u00c6\u00c7\b\3\1\2\u00c7\u00c9\3\2\2\2"+
		"\u00c8\u00b8\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c9\5\3\2\2\2\u00ca\u00cb\7"+
		"M\2\2\u00cb\7\3\2\2\2\u00cc\u00cd\5\16\b\2\u00cd\u00ce\b\5\1\2\u00ce\u00d9"+
		"\3\2\2\2\u00cf\u00d9\5 \21\2\u00d0\u00d1\5P)\2\u00d1\u00d2\b\5\1\2\u00d2"+
		"\u00d9\3\2\2\2\u00d3\u00d4\5T+\2\u00d4\u00d5\b\5\1\2\u00d5\u00d9\3\2\2"+
		"\2\u00d6\u00d9\5\n\6\2\u00d7\u00d9\7I\2\2\u00d8\u00cc\3\2\2\2\u00d8\u00cf"+
		"\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\b\5\1\2\u00de"+
		"\u00df\5\u0092J\2\u00df\u00e0\b\5\1\2\u00e0\u00e1\b\5\1\2\u00e1\t\3\2"+
		"\2\2\u00e2\u00e3\7G\2\2\u00e3\u00e4\5`\61\2\u00e4\u00e5\7\61\2\2\u00e5"+
		"\13\3\2\2\2\u00e6\u00e7\5\30\r\2\u00e7\r\3\2\2\2\u00e8\u00e9\7\n\2\2\u00e9"+
		"\u00ea\5\20\t\2\u00ea\u00f1\b\b\1\2\u00eb\u00ec\7\61\2\2\u00ec\u00ed\5"+
		"\20\t\2\u00ed\u00ee\b\b\1\2\u00ee\u00f0\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0"+
		"\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f6\b\b\1\2\u00f6"+
		"\17\3\2\2\2\u00f7\u00f8\5\6\4\2\u00f8\u00f9\7\63\2\2\u00f9\u00fa\5\24"+
		"\13\2\u00fa\u00fb\b\t\1\2\u00fb\21\3\2\2\2\u00fc\u00fd\7\t\2\2\u00fd\u00fe"+
		"\79\2\2\u00fe\u00ff\5\30\r\2\u00ff\u0100\7:\2\2\u0100\23\3\2\2\2\u0101"+
		"\u0102\5\26\f\2\u0102\u0103\b\13\1\2\u0103\u0114\3\2\2\2\u0104\u0105\5"+
		"\34\17\2\u0105\u0106\5\26\f\2\u0106\u0107\b\13\1\2\u0107\u0114\3\2\2\2"+
		"\u0108\u0109\5\6\4\2\u0109\u010a\b\13\1\2\u010a\u0114\3\2\2\2\u010b\u010c"+
		"\5\34\17\2\u010c\u010d\5\6\4\2\u010d\u010e\b\13\1\2\u010e\u0114\3\2\2"+
		"\2\u010f\u0110\5\36\20\2\u0110\u0111\b\13\1\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0114\5\22\n\2\u0113\u0101\3\2\2\2\u0113\u0104\3\2\2\2\u0113\u0108\3"+
		"\2\2\2\u0113\u010b\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\25\3\2\2\2\u0115\u0118\5\30\r\2\u0116\u0118\5\32\16\2\u0117\u0115\3\2"+
		"\2\2\u0117\u0116\3\2\2\2\u0118\27\3\2\2\2\u0119\u011a\7O\2\2\u011a\31"+
		"\3\2\2\2\u011b\u011c\7O\2\2\u011c\33\3\2\2\2\u011d\u011e\t\2\2\2\u011e"+
		"\35\3\2\2\2\u011f\u0120\7N\2\2\u0120\u0121\b\20\1\2\u0121\37\3\2\2\2\u0122"+
		"\u0123\7&\2\2\u0123\u0128\5\"\22\2\u0124\u0125\7\61\2\2\u0125\u0127\5"+
		"\"\22\2\u0126\u0124\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7\61"+
		"\2\2\u012c!\3\2\2\2\u012d\u012e\5\6\4\2\u012e\u0132\7\63\2\2\u012f\u0133"+
		"\5(\25\2\u0130\u0133\5$\23\2\u0131\u0133\5&\24\2\u0132\u012f\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0131\3\2\2\2\u0133#\3\2\2\2\u0134\u0136\7\22\2\2"+
		"\u0135\u0137\5Z.\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138\u0139\7\62\2\2\u0139\u013a\5d\63\2\u013a%\3\2\2\2\u013b"+
		"\u013d\7\36\2\2\u013c\u013e\5Z.\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013e\'\3\2\2\2\u013f\u0140\5*\26\2\u0140\u0141\b\25\1\2\u0141\u0149"+
		"\3\2\2\2\u0142\u0143\5\62\32\2\u0143\u0144\b\25\1\2\u0144\u0149\3\2\2"+
		"\2\u0145\u0146\5N(\2\u0146\u0147\b\25\1\2\u0147\u0149\3\2\2\2\u0148\u013f"+
		"\3\2\2\2\u0148\u0142\3\2\2\2\u0148\u0145\3\2\2\2\u0149)\3\2\2\2\u014a"+
		"\u014b\5\60\31\2\u014b\u014c\b\26\1\2\u014c\u0155\3\2\2\2\u014d\u014e"+
		"\5.\30\2\u014e\u014f\b\26\1\2\u014f\u0155\3\2\2\2\u0150\u0155\5,\27\2"+
		"\u0151\u0152\5\66\34\2\u0152\u0153\b\26\1\2\u0153\u0155\3\2\2\2\u0154"+
		"\u014a\3\2\2\2\u0154\u014d\3\2\2\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2"+
		"\2\2\u0155+\3\2\2\2\u0156\u0157\79\2\2\u0157\u0158\5`\61\2\u0158\u0159"+
		"\7:\2\2\u0159-\3\2\2\2\u015a\u015b\5\24\13\2\u015b\u015c\7B\2\2\u015c"+
		"\u015d\5\24\13\2\u015d\u015e\b\30\1\2\u015e/\3\2\2\2\u015f\u0160\5\6\4"+
		"\2\u0160\u0161\b\31\1\2\u0161\u016f\3\2\2\2\u0162\u0163\7\b\2\2\u0163"+
		"\u016d\b\31\1\2\u0164\u0165\7\6\2\2\u0165\u016d\b\31\1\2\u0166\u0167\7"+
		"\26\2\2\u0167\u016d\b\31\1\2\u0168\u0169\7 \2\2\u0169\u016d\b\31\1\2\u016a"+
		"\u016b\7H\2\2\u016b\u016d\b\31\1\2\u016c\u0162\3\2\2\2\u016c\u0164\3\2"+
		"\2\2\u016c\u0166\3\2\2\2\u016c\u0168\3\2\2\2\u016c\u016a\3\2\2\2\u016d"+
		"\u016f\3\2\2\2\u016e\u015f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\61\3\2\2"+
		"\2\u0170\u0171\7\35\2\2\u0171\u0176\5\64\33\2\u0172\u0173\5\64\33\2\u0173"+
		"\u0174\b\32\1\2\u0174\u0176\3\2\2\2\u0175\u0170\3\2\2\2\u0175\u0172\3"+
		"\2\2\2\u0176\63\3\2\2\2\u0177\u0178\58\35\2\u0178\u0179\b\33\1\2\u0179"+
		"\u017e\3\2\2\2\u017a\u017e\5:\36\2\u017b\u017e\5H%\2\u017c\u017e\5L\'"+
		"\2\u017d\u0177\3\2\2\2\u017d\u017a\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017c"+
		"\3\2\2\2\u017e\65\3\2\2\2\u017f\u0180\7H\2\2\u0180\u0183\7;\2\2\u0181"+
		"\u0184\5\6\4\2\u0182\u0184\5\26\f\2\u0183\u0181\3\2\2\2\u0183\u0182\3"+
		"\2\2\2\u0184\u0185\3\2\2\2\u0185\u0186\7=\2\2\u0186\67\3\2\2\2\u0187\u0188"+
		"\7\4\2\2\u0188\u0189\7;\2\2\u0189\u018a\5*\26\2\u018a\u0191\b\35\1\2\u018b"+
		"\u018c\7\60\2\2\u018c\u018d\5*\26\2\u018d\u018e\b\35\1\2\u018e\u0190\3"+
		"\2\2\2\u018f\u018b\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0195\7="+
		"\2\2\u0195\u0196\7\33\2\2\u0196\u0197\5(\25\2\u0197\u0198\b\35\1\2\u0198"+
		"9\3\2\2\2\u0199\u019a\7!\2\2\u019a\u019b\5<\37\2\u019b\u019c\7\17\2\2"+
		"\u019c;\3\2\2\2\u019d\u01a1\5> \2\u019e\u019f\7\61\2\2\u019f\u01a2\5B"+
		"\"\2\u01a0\u01a2\7\61\2\2\u01a1\u019e\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a5\5B\"\2\u01a4\u019d\3\2"+
		"\2\2\u01a4\u01a3\3\2\2\2\u01a5=\3\2\2\2\u01a6\u01ab\5@!\2\u01a7\u01a8"+
		"\7\61\2\2\u01a8\u01aa\5@!\2\u01a9\u01a7\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac?\3\2\2\2\u01ad\u01ab\3\2\2\2"+
		"\u01ae\u01af\5`\61\2\u01af\u01b0\7\62\2\2\u01b0\u01b1\5(\25\2\u01b1A\3"+
		"\2\2\2\u01b2\u01b3\7\7\2\2\u01b3\u01b4\5D#\2\u01b4\u01b5\7\33\2\2\u01b5"+
		"\u01bb\5F$\2\u01b6\u01b7\7\61\2\2\u01b7\u01ba\5F$\2\u01b8\u01ba\7\61\2"+
		"\2\u01b9\u01b6\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9"+
		"\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bcC\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be"+
		"\u01bf\5\6\4\2\u01bf\u01c0\7\62\2\2\u01c0\u01c1\5\60\31\2\u01c1\u01c4"+
		"\3\2\2\2\u01c2\u01c4\5\60\31\2\u01c3\u01be\3\2\2\2\u01c3\u01c2\3\2\2\2"+
		"\u01c4E\3\2\2\2\u01c5\u01c6\5b\62\2\u01c6\u01c7\7\62\2\2\u01c7\u01c8\7"+
		"9\2\2\u01c8\u01c9\5<\37\2\u01c9\u01ca\7:\2\2\u01caG\3\2\2\2\u01cb\u01cc"+
		"\7#\2\2\u01cc\u01cd\7\33\2\2\u01cd\u01ce\5J&\2\u01ceI\3\2\2\2\u01cf\u01d0"+
		"\5*\26\2\u01d0K\3\2\2\2\u01d1\u01d2\7\20\2\2\u01d2\u01d3\7\33\2\2\u01d3"+
		"\u01d6\5(\25\2\u01d4\u01d6\7\20\2\2\u01d5\u01d1\3\2\2\2\u01d5\u01d4\3"+
		"\2\2\2\u01d6M\3\2\2\2\u01d7\u01d8\7?\2\2\u01d8\u01d9\5\60\31\2\u01d9O"+
		"\3\2\2\2\u01da\u01db\7(\2\2\u01db\u01dc\5R*\2\u01dc\u01e3\b)\1\2\u01dd"+
		"\u01de\7\61\2\2\u01de\u01df\5R*\2\u01df\u01e0\b)\1\2\u01e0\u01e2\3\2\2"+
		"\2\u01e1\u01dd\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4"+
		"\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\7\61\2\2"+
		"\u01e7\u01e8\b)\1\2\u01e8Q\3\2\2\2\u01e9\u01ea\5`\61\2\u01ea\u01eb\7\62"+
		"\2\2\u01eb\u01ec\5(\25\2\u01ec\u01ed\b*\1\2\u01edS\3\2\2\2\u01ee\u01ef"+
		"\5V,\2\u01ef\u01f0\b+\1\2\u01f0\u01f5\3\2\2\2\u01f1\u01f2\5X-\2\u01f2"+
		"\u01f3\b+\1\2\u01f3\u01f5\3\2\2\2\u01f4\u01ee\3\2\2\2\u01f4\u01f1\3\2"+
		"\2\2\u01f5U\3\2\2\2\u01f6\u01f7\7\36\2\2\u01f7\u01f9\5\6\4\2\u01f8\u01fa"+
		"\5Z.\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb"+
		"\u01fc\7\61\2\2\u01fc\u01fd\5\b\5\2\u01fdW\3\2\2\2\u01fe\u01ff\7\22\2"+
		"\2\u01ff\u0201\5\6\4\2\u0200\u0202\5Z.\2\u0201\u0200\3\2\2\2\u0201\u0202"+
		"\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\7\62\2\2\u0204\u0205\5d\63\2"+
		"\u0205\u0206\7\61\2\2\u0206\u0207\5\b\5\2\u0207Y\3\2\2\2\u0208\u0209\7"+
		"9\2\2\u0209\u020a\5\\/\2\u020a\u0211\b.\1\2\u020b\u020c\7\61\2\2\u020c"+
		"\u020d\5\\/\2\u020d\u020e\b.\1\2\u020e\u0210\3\2\2\2\u020f\u020b\3\2\2"+
		"\2\u0210\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212\u0214"+
		"\3\2\2\2\u0213\u0211\3\2\2\2\u0214\u0215\7:\2\2\u0215[\3\2\2\2\u0216\u0217"+
		"\5^\60\2\u0217\u0218\b/\1\2\u0218\u0222\3\2\2\2\u0219\u021a\7(\2\2\u021a"+
		"\u021b\5^\60\2\u021b\u021c\b/\1\2\u021c\u0222\3\2\2\2\u021d\u021e\7\22"+
		"\2\2\u021e\u0222\5^\60\2\u021f\u0220\7\36\2\2\u0220\u0222\5^\60\2\u0221"+
		"\u0216\3\2\2\2\u0221\u0219\3\2\2\2\u0221\u021d\3\2\2\2\u0221\u021f\3\2"+
		"\2\2\u0222]\3\2\2\2\u0223\u0224\5`\61\2\u0224\u0225\7\62\2\2\u0225\u0226"+
		"\5\60\31\2\u0226\u0227\b\60\1\2\u0227_\3\2\2\2\u0228\u0229\5\6\4\2\u0229"+
		"\u0230\b\61\1\2\u022a\u022b\7\60\2\2\u022b\u022c\5\6\4\2\u022c\u022d\b"+
		"\61\1\2\u022d\u022f\3\2\2\2\u022e\u022a\3\2\2\2\u022f\u0232\3\2\2\2\u0230"+
		"\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231a\3\2\2\2\u0232\u0230\3\2\2\2"+
		"\u0233\u0238\5\24\13\2\u0234\u0235\7\60\2\2\u0235\u0237\5\24\13\2\u0236"+
		"\u0234\3\2\2\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2"+
		"\2\2\u0239c\3\2\2\2\u023a\u0238\3\2\2\2\u023b\u023c\5\60\31\2\u023c\u023d"+
		"\b\63\1\2\u023de\3\2\2\2\u023e\u023f\5\f\7\2\u023f\u0240\7\62\2\2\u0240"+
		"\u0241\5h\65\2\u0241\u0242\b\64\1\2\u0242\u0247\3\2\2\2\u0243\u0244\5"+
		"h\65\2\u0244\u0245\b\64\1\2\u0245\u0247\3\2\2\2\u0246\u023e\3\2\2\2\u0246"+
		"\u0243\3\2\2\2\u0247g\3\2\2\2\u0248\u0249\5j\66\2\u0249\u024a\b\65\1\2"+
		"\u024a\u024f\3\2\2\2\u024b\u024c\5\u0090I\2\u024c\u024d\b\65\1\2\u024d"+
		"\u024f\3\2\2\2\u024e\u0248\3\2\2\2\u024e\u024b\3\2\2\2\u024fi\3\2\2\2"+
		"\u0250\u0251\5l\67\2\u0251\u0252\b\66\1\2\u0252\u025a\3\2\2\2\u0253\u0254"+
		"\5\u0086D\2\u0254\u0255\b\66\1\2\u0255\u025a\3\2\2\2\u0256\u0257\5\u008c"+
		"G\2\u0257\u0258\b\66\1\2\u0258\u025a\3\2\2\2\u0259\u0250\3\2\2\2\u0259"+
		"\u0253\3\2\2\2\u0259\u0256\3\2\2\2\u025ak\3\2\2\2\u025b\u025c\5n8\2\u025c"+
		"\u025d\7/\2\2\u025d\u025e\5p9\2\u025e\u025f\b\67\1\2\u025fm\3\2\2\2\u0260"+
		"\u0261\7@\2\2\u0261\u0266\5\6\4\2\u0262\u0263\5\6\4\2\u0263\u0264\b8\1"+
		"\2\u0264\u0266\3\2\2\2\u0265\u0260\3\2\2\2\u0265\u0262\3\2\2\2\u0266\u0286"+
		"\3\2\2\2\u0267\u0268\7;\2\2\u0268\u0269\5p9\2\u0269\u0270\b8\1\2\u026a"+
		"\u026b\7\60\2\2\u026b\u026c\5p9\2\u026c\u026d\b8\1\2\u026d\u026f\3\2\2"+
		"\2\u026e\u026a\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271"+
		"\3\2\2\2\u0271\u0273\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0274\7=\2\2\u0274"+
		"\u0275\b8\1\2\u0275\u0285\3\2\2\2\u0276\u0277\7<\2\2\u0277\u027c\5p9\2"+
		"\u0278\u0279\7\60\2\2\u0279\u027b\5p9\2\u027a\u0278\3\2\2\2\u027b\u027e"+
		"\3\2\2\2\u027c\u027a\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027f\3\2\2\2\u027e"+
		"\u027c\3\2\2\2\u027f\u0280\7>\2\2\u0280\u0285\3\2\2\2\u0281\u0282\7A\2"+
		"\2\u0282\u0285\5\6\4\2\u0283\u0285\7?\2\2\u0284\u0267\3\2\2\2\u0284\u0276"+
		"\3\2\2\2\u0284\u0281\3\2\2\2\u0284\u0283\3\2\2\2\u0285\u0288\3\2\2\2\u0286"+
		"\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287o\3\2\2\2\u0288\u0286\3\2\2\2"+
		"\u0289\u028a\5r:\2\u028a\u02a0\b9\1\2\u028b\u028c\7\63\2\2\u028c\u029a"+
		"\b9\1\2\u028d\u028e\7\64\2\2\u028e\u029a\b9\1\2\u028f\u0290\7\65\2\2\u0290"+
		"\u029a\b9\1\2\u0291\u0292\7\66\2\2\u0292\u029a\b9\1\2\u0293\u0294\7\67"+
		"\2\2\u0294\u029a\b9\1\2\u0295\u0296\78\2\2\u0296\u029a\b9\1\2\u0297\u0298"+
		"\7\25\2\2\u0298\u029a\b9\1\2\u0299\u028b\3\2\2\2\u0299\u028d\3\2\2\2\u0299"+
		"\u028f\3\2\2\2\u0299\u0291\3\2\2\2\u0299\u0293\3\2\2\2\u0299\u0295\3\2"+
		"\2\2\u0299\u0297\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\5r:\2\u029c\u029d"+
		"\b9\1\2\u029d\u029f\3\2\2\2\u029e\u0299\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0"+
		"\u029e\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1q\3\2\2\2\u02a2\u02a0\3\2\2\2"+
		"\u02a3\u02a4\5t;\2\u02a4\u02b2\b:\1\2\u02a5\u02a6\7+\2\2\u02a6\u02ac\b"+
		":\1\2\u02a7\u02a8\7,\2\2\u02a8\u02ac\b:\1\2\u02a9\u02aa\7\34\2\2\u02aa"+
		"\u02ac\b:\1\2\u02ab\u02a5\3\2\2\2\u02ab\u02a7\3\2\2\2\u02ab\u02a9\3\2"+
		"\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\5t;\2\u02ae\u02af\b:\1\2\u02af\u02b1"+
		"\3\2\2\2\u02b0\u02ab\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2"+
		"\u02b3\3\2\2\2\u02b3s\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02b6\5v<\2\u02b6"+
		"\u02c8\b;\1\2\u02b7\u02b8\7-\2\2\u02b8\u02c2\b;\1\2\u02b9\u02ba\7.\2\2"+
		"\u02ba\u02c2\b;\1\2\u02bb\u02bc\7\13\2\2\u02bc\u02c2\b;\1\2\u02bd\u02be"+
		"\7\30\2\2\u02be\u02c2\b;\1\2\u02bf\u02c0\7\3\2\2\u02c0\u02c2\b;\1\2\u02c1"+
		"\u02b7\3\2\2\2\u02c1\u02b9\3\2\2\2\u02c1\u02bb\3\2\2\2\u02c1\u02bd\3\2"+
		"\2\2\u02c1\u02bf\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4\5v<\2\u02c4\u02c5"+
		"\b;\1\2\u02c5\u02c7\3\2\2\2\u02c6\u02c1\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8"+
		"\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9u\3\2\2\2\u02ca\u02c8\3\2\2\2"+
		"\u02cb\u02cc\7+\2\2\u02cc\u02d0\b<\1\2\u02cd\u02ce\7,\2\2\u02ce\u02d0"+
		"\b<\1\2\u02cf\u02cb\3\2\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0"+
		"\u02d1\3\2\2\2\u02d1\u02d2\5x=\2\u02d2\u02d3\b<\1\2\u02d3w\3\2\2\2\u02d4"+
		"\u02d5\5n8\2\u02d5\u02d6\b=\1\2\u02d6\u02e8\3\2\2\2\u02d7\u02d8\79\2\2"+
		"\u02d8\u02d9\5p9\2\u02d9\u02da\7:\2\2\u02da\u02db\b=\1\2\u02db\u02e8\3"+
		"\2\2\2\u02dc\u02dd\5|?\2\u02dd\u02de\b=\1\2\u02de\u02e8\3\2\2\2\u02df"+
		"\u02e0\5z>\2\u02e0\u02e1\b=\1\2\u02e1\u02e8\3\2\2\2\u02e2\u02e8\5\u0080"+
		"A\2\u02e3\u02e4\7\32\2\2\u02e4\u02e5\5x=\2\u02e5\u02e6\b=\1\2\u02e6\u02e8"+
		"\3\2\2\2\u02e7\u02d4\3\2\2\2\u02e7\u02d7\3\2\2\2\u02e7\u02dc\3\2\2\2\u02e7"+
		"\u02df\3\2\2\2\u02e7\u02e2\3\2\2\2\u02e7\u02e3\3\2\2\2\u02e8y\3\2\2\2"+
		"\u02e9\u02ea\5\26\f\2\u02ea\u02eb\b>\1\2\u02eb\u02f2\3\2\2\2\u02ec\u02f2"+
		"\5\22\n\2\u02ed\u02ee\5\36\20\2\u02ee\u02ef\b>\1\2\u02ef\u02f2\3\2\2\2"+
		"\u02f0\u02f2\7\31\2\2\u02f1\u02e9\3\2\2\2\u02f1\u02ec\3\2\2\2\u02f1\u02ed"+
		"\3\2\2\2\u02f1\u02f0\3\2\2\2\u02f2{\3\2\2\2\u02f3\u02f4\5\6\4\2\u02f4"+
		"\u02f5\79\2\2\u02f5\u02f6\5~@\2\u02f6\u02f7\7:\2\2\u02f7}\3\2\2\2\u02f8"+
		"\u02f9\5\u0088E\2\u02f9\u0300\b@\1\2\u02fa\u02fb\7\60\2\2\u02fb\u02fc"+
		"\5\u0088E\2\u02fc\u02fd\b@\1\2\u02fd\u02ff\3\2\2\2\u02fe\u02fa\3\2\2\2"+
		"\u02ff\u0302\3\2\2\2\u0300\u02fe\3\2\2\2\u0300\u0301\3\2\2\2\u0301\177"+
		"\3\2\2\2\u0302\u0300\3\2\2\2\u0303\u0304\7;\2\2\u0304\u0305\5\u0082B\2"+
		"\u0305\u0306\7=\2\2\u0306\u030c\3\2\2\2\u0307\u0308\7<\2\2\u0308\u0309"+
		"\5\u0082B\2\u0309\u030a\7>\2\2\u030a\u030c\3\2\2\2\u030b\u0303\3\2\2\2"+
		"\u030b\u0307\3\2\2\2\u030c\u0081\3\2\2\2\u030d\u0312\5\u0084C\2\u030e"+
		"\u030f\7\60\2\2\u030f\u0311\5\u0084C\2\u0310\u030e\3\2\2\2\u0311\u0314"+
		"\3\2\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0317\3\2\2\2\u0314"+
		"\u0312\3\2\2\2\u0315\u0317\3\2\2\2\u0316\u030d\3\2\2\2\u0316\u0315\3\2"+
		"\2\2\u0317\u0083\3\2\2\2\u0318\u031b\5p9\2\u0319\u031a\7B\2\2\u031a\u031c"+
		"\5p9\2\u031b\u0319\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u0085\3\2\2\2\u031d"+
		"\u031e\5\6\4\2\u031e\u0324\bD\1\2\u031f\u0320\79\2\2\u0320\u0321\5~@\2"+
		"\u0321\u0322\7:\2\2\u0322\u0323\bD\1\2\u0323\u0325\3\2\2\2\u0324\u031f"+
		"\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u0087\3\2\2\2\u0326\u0327\5p9\2\u0327"+
		"\u0328\bE\1\2\u0328\u0089\3\2\2\2\u0329\u032a\7\23\2\2\u032a\u032b\5\f"+
		"\7\2\u032b\u008b\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u008d\3\2\2\2\u032e"+
		"\u032f\3\2\2\2\u032f\u008f\3\2\2\2\u0330\u0331\5\u0092J\2\u0331\u0332"+
		"\bI\1\2\u0332\u033b\3\2\2\2\u0333\u0334\5\u0096L\2\u0334\u0335\bI\1\2"+
		"\u0335\u033b\3\2\2\2\u0336\u0337\5\u009eP\2\u0337\u0338\bI\1\2\u0338\u033b"+
		"\3\2\2\2\u0339\u033b\5\u00acW\2\u033a\u0330\3\2\2\2\u033a\u0333\3\2\2"+
		"\2\u033a\u0336\3\2\2\2\u033a\u0339\3\2\2\2\u033b\u0091\3\2\2\2\u033c\u033d"+
		"\7\5\2\2\u033d\u033e\5\u0094K\2\u033e\u033f\7\17\2\2\u033f\u0340\bJ\1"+
		"\2\u0340\u0093\3\2\2\2\u0341\u0342\5f\64\2\u0342\u0349\bK\1\2\u0343\u0344"+
		"\7\61\2\2\u0344\u0345\5f\64\2\u0345\u0346\bK\1\2\u0346\u0348\3\2\2\2\u0347"+
		"\u0343\3\2\2\2\u0348\u034b\3\2\2\2\u0349\u0347\3\2\2\2\u0349\u034a\3\2"+
		"\2\2\u034a\u0095\3\2\2\2\u034b\u0349\3\2\2\2\u034c\u034d\5\u0098M\2\u034d"+
		"\u034e\bL\1\2\u034e\u0351\3\2\2\2\u034f\u0351\5\u009aN\2\u0350\u034c\3"+
		"\2\2\2\u0350\u034f\3\2\2\2\u0351\u0097\3\2\2\2\u0352\u0353\7\24\2\2\u0353"+
		"\u0354\5p9\2\u0354\u0355\7$\2\2\u0355\u0356\5f\64\2\u0356\u035b\bM\1\2"+
		"\u0357\u0358\7\16\2\2\u0358\u0359\5f\64\2\u0359\u035a\bM\1\2\u035a\u035c"+
		"\3\2\2\2\u035b\u0357\3\2\2\2\u035b\u035c\3\2\2\2\u035c\u0099\3\2\2\2\u035d"+
		"\u035e\7\7\2\2\u035e\u035f\5p9\2\u035f\u0360\7\33\2\2\u0360\u0365\5\u009c"+
		"O\2\u0361\u0362\7\61\2\2\u0362\u0364\5\u009cO\2\u0363\u0361\3\2\2\2\u0364"+
		"\u0367\3\2\2\2\u0365\u0363\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u036b\3\2"+
		"\2\2\u0367\u0365\3\2\2\2\u0368\u0369\7\61\2\2\u0369\u036a\7\16\2\2\u036a"+
		"\u036c\5\u0094K\2\u036b\u0368\3\2\2\2\u036b\u036c\3\2\2\2\u036c\u036d"+
		"\3\2\2\2\u036d\u036e\7\17\2\2\u036e\u009b\3\2\2\2\u036f\u0370\5b\62\2"+
		"\u0370\u0371\7\62\2\2\u0371\u0372\5f\64\2\u0372\u009d\3\2\2\2\u0373\u0374"+
		"\5\u00a0Q\2\u0374\u0375\bP\1\2\u0375\u037d\3\2\2\2\u0376\u0377\5\u00a2"+
		"R\2\u0377\u0378\bP\1\2\u0378\u037d\3\2\2\2\u0379\u037a\5\u00a4S\2\u037a"+
		"\u037b\bP\1\2\u037b\u037d\3\2\2\2\u037c\u0373\3\2\2\2\u037c\u0376\3\2"+
		"\2\2\u037c\u0379\3\2\2\2\u037d\u009f\3\2\2\2\u037e\u037f\7)\2\2\u037f"+
		"\u0380\5p9\2\u0380\u0381\7\f\2\2\u0381\u0382\5f\64\2\u0382\u0383\bQ\1"+
		"\2\u0383\u00a1\3\2\2\2\u0384\u0385\7\"\2\2\u0385\u0386\5\u0094K\2\u0386"+
		"\u0387\7\'\2\2\u0387\u0388\5p9\2\u0388\u0389\bR\1\2\u0389\u00a3\3\2\2"+
		"\2\u038a\u038b\7\21\2\2\u038b\u038c\5\6\4\2\u038c\u038d\7/\2\2\u038d\u038e"+
		"\5\u00a6T\2\u038e\u038f\7\f\2\2\u038f\u0390\5f\64\2\u0390\u0391\bS\1\2"+
		"\u0391\u00a5\3\2\2\2\u0392\u0393\5\u00a8U\2\u0393\u0398\bT\1\2\u0394\u0395"+
		"\7%\2\2\u0395\u0399\bT\1\2\u0396\u0397\7\r\2\2\u0397\u0399\bT\1\2\u0398"+
		"\u0394\3\2\2\2\u0398\u0396\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039b\5\u00aa"+
		"V\2\u039b\u039c\bT\1\2\u039c\u00a7\3\2\2\2\u039d\u039e\5p9\2\u039e\u039f"+
		"\bU\1\2\u039f\u00a9\3\2\2\2\u03a0\u03a1\5p9\2\u03a1\u03a2\bV\1\2\u03a2"+
		"\u00ab\3\2\2\2\u03a3\u03a4\7*\2\2\u03a4\u03a5\5\u00aeX\2\u03a5\u03a6\7"+
		"\f\2\2\u03a6\u03a7\5f\64\2\u03a7\u00ad\3\2\2\2\u03a8\u03ad\5n8\2\u03a9"+
		"\u03aa\7\60\2\2\u03aa\u03ac\5n8\2\u03ab\u03a9\3\2\2\2\u03ac\u03af\3\2"+
		"\2\2\u03ad\u03ab\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u00af\3\2\2\2\u03af"+
		"\u03ad\3\2\2\2E\u00b2\u00be\u00c8\u00d8\u00da\u00f1\u0113\u0117\u0128"+
		"\u0132\u0136\u013d\u0148\u0154\u016c\u016e\u0175\u017d\u0183\u0191\u01a1"+
		"\u01a4\u01ab\u01b9\u01bb\u01c3\u01d5\u01e3\u01f4\u01f9\u0201\u0211\u0221"+
		"\u0230\u0238\u0246\u024e\u0259\u0265\u0270\u027c\u0284\u0286\u0299\u02a0"+
		"\u02ab\u02b2\u02c1\u02c8\u02cf\u02e7\u02f1\u0300\u030b\u0312\u0316\u031b"+
		"\u0324\u033a\u0349\u0350\u035b\u0365\u036b\u037c\u0398\u03ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}