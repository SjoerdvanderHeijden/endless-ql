// Generated from C:/Users/laure/Documents/Git-repositories/software-construction/endless-ql/LDG_TV/SC-Java-LDG-TV/src/main/java/antlr\Form.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, CURLY_BRACKET_OPEN=5, CURLY_BRACKET_CLOSE=6, 
		BRACKET_OPEN=7, BRACKET_CLOSE=8, PLUS=9, MINUS=10, TIMES=11, DIV=12, QUESTION_LABEL=13, 
		QUESTION_VARIABLE_SEPERATOR=14, QUESTION_VARIABLE_VALUE_SEPERATOR=15, 
		IF=16, WHITESPACE=17, NEWLINE=18, CHARACTERS=19, NUMBERS=20;
	public static final int
		RULE_formBuilder = 0, RULE_formData = 1, RULE_questionStructure = 2, RULE_ifStructure = 3, 
		RULE_statementBlockStructure = 4, RULE_questionLabel = 5, RULE_questionVariable = 6, 
		RULE_questionVariableType = 7, RULE_questionVariableValue = 8, RULE_expression = 9, 
		RULE_value = 10, RULE_operator = 11;
	public static final String[] ruleNames = {
		"formBuilder", "formData", "questionStructure", "ifStructure", "statementBlockStructure", 
		"questionLabel", "questionVariable", "questionVariableType", "questionVariableValue", 
		"expression", "value", "operator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'boolean'", "'money'", "'string'", "'{'", "'}'", "'('", 
		"')'", "'+'", "'-'", "'*'", "'/'", null, "':'", "'='", "'if'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "CURLY_BRACKET_OPEN", "CURLY_BRACKET_CLOSE", 
		"BRACKET_OPEN", "BRACKET_CLOSE", "PLUS", "MINUS", "TIMES", "DIV", "QUESTION_LABEL", 
		"QUESTION_VARIABLE_SEPERATOR", "QUESTION_VARIABLE_VALUE_SEPERATOR", "IF", 
		"WHITESPACE", "NEWLINE", "CHARACTERS", "NUMBERS"
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
	public String getGrammarFileName() { return "Form.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormBuilderContext extends ParserRuleContext {
		public TerminalNode CHARACTERS() { return getToken(FormParser.CHARACTERS, 0); }
		public TerminalNode CURLY_BRACKET_OPEN() { return getToken(FormParser.CURLY_BRACKET_OPEN, 0); }
		public FormDataContext formData() {
			return getRuleContext(FormDataContext.class,0);
		}
		public TerminalNode CURLY_BRACKET_CLOSE() { return getToken(FormParser.CURLY_BRACKET_CLOSE, 0); }
		public FormBuilderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formBuilder; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterFormBuilder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitFormBuilder(this);
		}
	}

	public final FormBuilderContext formBuilder() throws RecognitionException {
		FormBuilderContext _localctx = new FormBuilderContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formBuilder);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(CHARACTERS);
			setState(26);
			match(CURLY_BRACKET_OPEN);
			setState(27);
			formData();
			setState(28);
			match(CURLY_BRACKET_CLOSE);
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

	public static class FormDataContext extends ParserRuleContext {
		public List<QuestionStructureContext> questionStructure() {
			return getRuleContexts(QuestionStructureContext.class);
		}
		public QuestionStructureContext questionStructure(int i) {
			return getRuleContext(QuestionStructureContext.class,i);
		}
		public List<IfStructureContext> ifStructure() {
			return getRuleContexts(IfStructureContext.class);
		}
		public IfStructureContext ifStructure(int i) {
			return getRuleContext(IfStructureContext.class,i);
		}
		public FormDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterFormData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitFormData(this);
		}
	}

	public final FormDataContext formData() throws RecognitionException {
		FormDataContext _localctx = new FormDataContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formData);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				questionStructure();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION_LABEL );
			setState(36); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(35);
					ifStructure();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(38); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class QuestionStructureContext extends ParserRuleContext {
		public QuestionLabelContext questionLabel() {
			return getRuleContext(QuestionLabelContext.class,0);
		}
		public QuestionVariableContext questionVariable() {
			return getRuleContext(QuestionVariableContext.class,0);
		}
		public TerminalNode QUESTION_VARIABLE_SEPERATOR() { return getToken(FormParser.QUESTION_VARIABLE_SEPERATOR, 0); }
		public QuestionVariableTypeContext questionVariableType() {
			return getRuleContext(QuestionVariableTypeContext.class,0);
		}
		public TerminalNode QUESTION_VARIABLE_VALUE_SEPERATOR() { return getToken(FormParser.QUESTION_VARIABLE_VALUE_SEPERATOR, 0); }
		public QuestionVariableValueContext questionVariableValue() {
			return getRuleContext(QuestionVariableValueContext.class,0);
		}
		public QuestionStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterQuestionStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitQuestionStructure(this);
		}
	}

	public final QuestionStructureContext questionStructure() throws RecognitionException {
		QuestionStructureContext _localctx = new QuestionStructureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			questionLabel();
			setState(41);
			questionVariable();
			setState(42);
			match(QUESTION_VARIABLE_SEPERATOR);
			setState(43);
			questionVariableType();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION_VARIABLE_VALUE_SEPERATOR) {
				{
				setState(44);
				match(QUESTION_VARIABLE_VALUE_SEPERATOR);
				}
			}

			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BRACKET_OPEN) | (1L << CHARACTERS) | (1L << NUMBERS))) != 0)) {
				{
				setState(47);
				questionVariableValue();
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

	public static class IfStructureContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FormParser.IF, 0); }
		public StatementBlockStructureContext statementBlockStructure() {
			return getRuleContext(StatementBlockStructureContext.class,0);
		}
		public TerminalNode CURLY_BRACKET_OPEN() { return getToken(FormParser.CURLY_BRACKET_OPEN, 0); }
		public TerminalNode CURLY_BRACKET_CLOSE() { return getToken(FormParser.CURLY_BRACKET_CLOSE, 0); }
		public List<QuestionStructureContext> questionStructure() {
			return getRuleContexts(QuestionStructureContext.class);
		}
		public QuestionStructureContext questionStructure(int i) {
			return getRuleContext(QuestionStructureContext.class,i);
		}
		public IfStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterIfStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitIfStructure(this);
		}
	}

	public final IfStructureContext ifStructure() throws RecognitionException {
		IfStructureContext _localctx = new IfStructureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(IF);
			setState(51);
			statementBlockStructure();
			setState(52);
			match(CURLY_BRACKET_OPEN);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				questionStructure();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION_LABEL );
			setState(58);
			match(CURLY_BRACKET_CLOSE);
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

	public static class StatementBlockStructureContext extends ParserRuleContext {
		public TerminalNode BRACKET_OPEN() { return getToken(FormParser.BRACKET_OPEN, 0); }
		public QuestionVariableContext questionVariable() {
			return getRuleContext(QuestionVariableContext.class,0);
		}
		public TerminalNode BRACKET_CLOSE() { return getToken(FormParser.BRACKET_CLOSE, 0); }
		public StatementBlockStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlockStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterStatementBlockStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitStatementBlockStructure(this);
		}
	}

	public final StatementBlockStructureContext statementBlockStructure() throws RecognitionException {
		StatementBlockStructureContext _localctx = new StatementBlockStructureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statementBlockStructure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(BRACKET_OPEN);
			setState(61);
			questionVariable();
			setState(62);
			match(BRACKET_CLOSE);
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

	public static class QuestionLabelContext extends ParserRuleContext {
		public TerminalNode QUESTION_LABEL() { return getToken(FormParser.QUESTION_LABEL, 0); }
		public QuestionLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterQuestionLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitQuestionLabel(this);
		}
	}

	public final QuestionLabelContext questionLabel() throws RecognitionException {
		QuestionLabelContext _localctx = new QuestionLabelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_questionLabel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(QUESTION_LABEL);
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

	public static class QuestionVariableContext extends ParserRuleContext {
		public TerminalNode CHARACTERS() { return getToken(FormParser.CHARACTERS, 0); }
		public QuestionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterQuestionVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitQuestionVariable(this);
		}
	}

	public final QuestionVariableContext questionVariable() throws RecognitionException {
		QuestionVariableContext _localctx = new QuestionVariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_questionVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(CHARACTERS);
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

	public static class QuestionVariableTypeContext extends ParserRuleContext {
		public QuestionVariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionVariableType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterQuestionVariableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitQuestionVariableType(this);
		}
	}

	public final QuestionVariableTypeContext questionVariableType() throws RecognitionException {
		QuestionVariableTypeContext _localctx = new QuestionVariableTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_questionVariableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class QuestionVariableValueContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public QuestionVariableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionVariableValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterQuestionVariableValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitQuestionVariableValue(this);
		}
	}

	public final QuestionVariableValueContext questionVariableValue() throws RecognitionException {
		QuestionVariableValueContext _localctx = new QuestionVariableValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_questionVariableValue);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				expression();
				}
				break;
			case CHARACTERS:
			case NUMBERS:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				value();
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode BRACKET_OPEN() { return getToken(FormParser.BRACKET_OPEN, 0); }
		public List<QuestionVariableContext> questionVariable() {
			return getRuleContexts(QuestionVariableContext.class);
		}
		public QuestionVariableContext questionVariable(int i) {
			return getRuleContext(QuestionVariableContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode BRACKET_CLOSE() { return getToken(FormParser.BRACKET_CLOSE, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(BRACKET_OPEN);
			setState(75);
			questionVariable();
			setState(76);
			operator();
			setState(77);
			questionVariable();
			setState(78);
			match(BRACKET_CLOSE);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode CHARACTERS() { return getToken(FormParser.CHARACTERS, 0); }
		public TerminalNode NUMBERS() { return getToken(FormParser.NUMBERS, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !(_la==CHARACTERS || _la==NUMBERS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(FormParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FormParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(FormParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(FormParser.DIV, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormListener ) ((FormListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << DIV))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26W\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3\"\n\3\r\3\16\3#\3\3\6\3"+
		"\'\n\3\r\3\16\3(\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\4\5\4\63\n\4\3\5\3\5"+
		"\3\5\3\5\6\59\n\5\r\5\16\5:\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\5\nK\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\r\3(\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\3\2\4\6\3\2\25\26\3\2\13"+
		"\16\2P\2\32\3\2\2\2\4!\3\2\2\2\6*\3\2\2\2\b\64\3\2\2\2\n>\3\2\2\2\fB\3"+
		"\2\2\2\16D\3\2\2\2\20F\3\2\2\2\22J\3\2\2\2\24L\3\2\2\2\26R\3\2\2\2\30"+
		"T\3\2\2\2\32\33\7\3\2\2\33\34\7\25\2\2\34\35\7\7\2\2\35\36\5\4\3\2\36"+
		"\37\7\b\2\2\37\3\3\2\2\2 \"\5\6\4\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3"+
		"\2\2\2$&\3\2\2\2%\'\5\b\5\2&%\3\2\2\2\'(\3\2\2\2()\3\2\2\2(&\3\2\2\2)"+
		"\5\3\2\2\2*+\5\f\7\2+,\5\16\b\2,-\7\20\2\2-/\5\20\t\2.\60\7\21\2\2/.\3"+
		"\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61\63\5\22\n\2\62\61\3\2\2\2\62\63\3"+
		"\2\2\2\63\7\3\2\2\2\64\65\7\22\2\2\65\66\5\n\6\2\668\7\7\2\2\679\5\6\4"+
		"\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\b\2\2=\t\3"+
		"\2\2\2>?\7\t\2\2?@\5\16\b\2@A\7\n\2\2A\13\3\2\2\2BC\7\17\2\2C\r\3\2\2"+
		"\2DE\7\25\2\2E\17\3\2\2\2FG\t\2\2\2G\21\3\2\2\2HK\5\24\13\2IK\5\26\f\2"+
		"JH\3\2\2\2JI\3\2\2\2K\23\3\2\2\2LM\7\t\2\2MN\5\16\b\2NO\5\30\r\2OP\5\16"+
		"\b\2PQ\7\n\2\2Q\25\3\2\2\2RS\t\3\2\2S\27\3\2\2\2TU\t\4\2\2U\31\3\2\2\2"+
		"\b#(/\62:J";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}