// Generated from C:/Users/Michael/Desktop/Software Construction/endless-ql/GunOli/src/main/antlr\QLS.g4 by ANTLR 4.7
package QLS.QLSAntlrGen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STYLESHEET=6, PAGE=7, SECTION=8, 
		DEFAULT=9, QUESTION=10, WIDGET=11, RADIO=12, CHECKBOX=13, SPINBOX=14, 
		WIDTH=15, FONT=16, FONTSIZE=17, COLOR=18, BOOLEANTYPE=19, STRINGTYPE=20, 
		MONEYTYPE=21, INTEGERTYPE=22, DATETYPE=23, DECIMALTYPE=24, INTEGER=25, 
		DECIMAL=26, MONEY=27, DATE=28, DAY=29, MONTH=30, YEAR=31, STRING=32, IDENTIFIER=33, 
		HEXVALUE=34, WHITESPACE=35, MULTI_COMMENT=36, SINGLE_COMMENT=37;
	public static final int
		RULE_head = 0, RULE_block = 1, RULE_page = 2, RULE_section = 3, RULE_question = 4, 
		RULE_defaultSec = 5, RULE_widget = 6, RULE_type = 7;
	public static final String[] ruleNames = {
		"head", "block", "page", "section", "question", "defaultSec", "widget", 
		"type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "','", "')'", "'stylesheet'", "'page'", "'section'", 
		"'default'", "'question'", "'widget'", "'radio'", "'checkbox'", "'spinbox'", 
		"'width:'", "'font:'", "'fontsize:'", "'color:'", "'boolean'", "'string'", 
		"'money'", "'integer'", "'date'", "'decimal'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "STYLESHEET", "PAGE", "SECTION", "DEFAULT", 
		"QUESTION", "WIDGET", "RADIO", "CHECKBOX", "SPINBOX", "WIDTH", "FONT", 
		"FONTSIZE", "COLOR", "BOOLEANTYPE", "STRINGTYPE", "MONEYTYPE", "INTEGERTYPE", 
		"DATETYPE", "DECIMALTYPE", "INTEGER", "DECIMAL", "MONEY", "DATE", "DAY", 
		"MONTH", "YEAR", "STRING", "IDENTIFIER", "HEXVALUE", "WHITESPACE", "MULTI_COMMENT", 
		"SINGLE_COMMENT"
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
	public String getGrammarFileName() { return "QLS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class HeadContext extends ParserRuleContext {
		public TerminalNode STYLESHEET() { return getToken(QLSParser.STYLESHEET, 0); }
		public TerminalNode IDENTIFIER() { return getToken(QLSParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QLSParser.EOF, 0); }
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_head);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(STYLESHEET);
			setState(17);
			match(IDENTIFIER);
			setState(18);
			block();
			setState(19);
			match(EOF);
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
		public List<PageContext> page() {
			return getRuleContexts(PageContext.class);
		}
		public PageContext page(int i) {
			return getRuleContext(PageContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__0);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				page();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PAGE );
			setState(27);
			match(T__1);
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

	public static class PageContext extends ParserRuleContext {
		public TerminalNode PAGE() { return getToken(QLSParser.PAGE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(QLSParser.IDENTIFIER, 0); }
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<DefaultSecContext> defaultSec() {
			return getRuleContexts(DefaultSecContext.class);
		}
		public DefaultSecContext defaultSec(int i) {
			return getRuleContext(DefaultSecContext.class,i);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitPage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitPage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(PAGE);
			setState(30);
			match(IDENTIFIER);
			setState(31);
			match(T__0);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SECTION:
					{
					setState(32);
					section();
					}
					break;
				case DEFAULT:
					{
					setState(33);
					defaultSec();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SECTION || _la==DEFAULT );
			setState(38);
			match(T__1);
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

	public static class SectionContext extends ParserRuleContext {
		public TerminalNode SECTION() { return getToken(QLSParser.SECTION, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<DefaultSecContext> defaultSec() {
			return getRuleContexts(DefaultSecContext.class);
		}
		public DefaultSecContext defaultSec(int i) {
			return getRuleContext(DefaultSecContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(SECTION);
			setState(41);
			match(STRING);
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUESTION:
				{
				setState(42);
				question();
				}
				break;
			case T__0:
				{
				setState(43);
				match(T__0);
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(47);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case QUESTION:
						{
						setState(44);
						question();
						}
						break;
					case SECTION:
						{
						setState(45);
						section();
						}
						break;
					case DEFAULT:
						{
						setState(46);
						defaultSec();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(49); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SECTION) | (1L << DEFAULT) | (1L << QUESTION))) != 0) );
				setState(51);
				match(T__1);
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

	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(QLSParser.QUESTION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(QLSParser.IDENTIFIER, 0); }
		public List<WidgetContext> widget() {
			return getRuleContexts(WidgetContext.class);
		}
		public WidgetContext widget(int i) {
			return getRuleContext(WidgetContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(QUESTION);
			setState(56);
			match(IDENTIFIER);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDGET) | (1L << WIDTH) | (1L << FONT) | (1L << FONTSIZE) | (1L << COLOR))) != 0)) {
				{
				{
				setState(57);
				widget();
				}
				}
				setState(62);
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

	public static class DefaultSecContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(QLSParser.DEFAULT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<WidgetContext> widget() {
			return getRuleContexts(WidgetContext.class);
		}
		public WidgetContext widget(int i) {
			return getRuleContext(WidgetContext.class,i);
		}
		public DefaultSecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultSec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterDefaultSec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitDefaultSec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitDefaultSec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultSecContext defaultSec() throws RecognitionException {
		DefaultSecContext _localctx = new DefaultSecContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defaultSec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(DEFAULT);
			setState(64);
			type();
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WIDGET:
			case WIDTH:
			case FONT:
			case FONTSIZE:
			case COLOR:
				{
				setState(65);
				widget();
				}
				break;
			case T__0:
				{
				setState(66);
				match(T__0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WIDGET) | (1L << WIDTH) | (1L << FONT) | (1L << FONTSIZE) | (1L << COLOR))) != 0)) {
					{
					{
					setState(67);
					widget();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
				match(T__1);
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

	public static class WidgetContext extends ParserRuleContext {
		public WidgetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widget; }
	 
		public WidgetContext() { }
		public void copyFrom(WidgetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FontSizeWidgetContext extends WidgetContext {
		public TerminalNode FONTSIZE() { return getToken(QLSParser.FONTSIZE, 0); }
		public TerminalNode INTEGER() { return getToken(QLSParser.INTEGER, 0); }
		public FontSizeWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterFontSizeWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitFontSizeWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFontSizeWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpinWidgetContext extends WidgetContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode SPINBOX() { return getToken(QLSParser.SPINBOX, 0); }
		public SpinWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterSpinWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitSpinWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitSpinWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColorWidgetContext extends WidgetContext {
		public TerminalNode COLOR() { return getToken(QLSParser.COLOR, 0); }
		public TerminalNode HEXVALUE() { return getToken(QLSParser.HEXVALUE, 0); }
		public ColorWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterColorWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitColorWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitColorWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WidthWidgetContext extends WidgetContext {
		public TerminalNode WIDTH() { return getToken(QLSParser.WIDTH, 0); }
		public TerminalNode INTEGER() { return getToken(QLSParser.INTEGER, 0); }
		public WidthWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterWidthWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitWidthWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitWidthWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FontWidgetContext extends WidgetContext {
		public TerminalNode FONT() { return getToken(QLSParser.FONT, 0); }
		public TerminalNode STRING() { return getToken(QLSParser.STRING, 0); }
		public FontWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterFontWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitFontWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitFontWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RadioWidgetContext extends WidgetContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode RADIO() { return getToken(QLSParser.RADIO, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLSParser.STRING, i);
		}
		public RadioWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterRadioWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitRadioWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitRadioWidget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CheckWidgetContext extends WidgetContext {
		public TerminalNode WIDGET() { return getToken(QLSParser.WIDGET, 0); }
		public TerminalNode CHECKBOX() { return getToken(QLSParser.CHECKBOX, 0); }
		public CheckWidgetContext(WidgetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterCheckWidget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitCheckWidget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitCheckWidget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidgetContext widget() throws RecognitionException {
		WidgetContext _localctx = new WidgetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_widget);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new RadioWidgetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(WIDGET);
				setState(77);
				match(RADIO);
				setState(78);
				match(T__2);
				setState(79);
				match(STRING);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(80);
					match(T__3);
					setState(81);
					match(STRING);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new CheckWidgetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(WIDGET);
				setState(89);
				match(CHECKBOX);
				}
				break;
			case 3:
				_localctx = new SpinWidgetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(WIDGET);
				setState(91);
				match(SPINBOX);
				}
				break;
			case 4:
				_localctx = new WidthWidgetContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				match(WIDTH);
				setState(93);
				match(INTEGER);
				}
				break;
			case 5:
				_localctx = new FontWidgetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				match(FONT);
				setState(95);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new FontSizeWidgetContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				match(FONTSIZE);
				setState(97);
				match(INTEGER);
				}
				break;
			case 7:
				_localctx = new ColorWidgetContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				match(COLOR);
				setState(99);
				match(HEXVALUE);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOLEANTYPE() { return getToken(QLSParser.BOOLEANTYPE, 0); }
		public TerminalNode STRINGTYPE() { return getToken(QLSParser.STRINGTYPE, 0); }
		public TerminalNode MONEYTYPE() { return getToken(QLSParser.MONEYTYPE, 0); }
		public TerminalNode INTEGERTYPE() { return getToken(QLSParser.INTEGERTYPE, 0); }
		public TerminalNode DATETYPE() { return getToken(QLSParser.DATETYPE, 0); }
		public TerminalNode DECIMALTYPE() { return getToken(QLSParser.DECIMALTYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLSListener ) ((QLSListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLSVisitor ) return ((QLSVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEANTYPE) | (1L << STRINGTYPE) | (1L << MONEYTYPE) | (1L << INTEGERTYPE) | (1L << DATETYPE) | (1L << DECIMALTYPE))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'k\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\6\3\32\n\3\r\3\16\3\33\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4%\n\4\r"+
		"\4\16\4&\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\62\n\5\r\5\16\5\63\3"+
		"\5\3\5\5\58\n\5\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\7\3\7\3\7\3\7\3"+
		"\7\7\7G\n\7\f\7\16\7J\13\7\3\7\5\7M\n\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bU\n"+
		"\b\f\b\16\bX\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bg\n\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\25\32\2s\2\22\3"+
		"\2\2\2\4\27\3\2\2\2\6\37\3\2\2\2\b*\3\2\2\2\n9\3\2\2\2\fA\3\2\2\2\16f"+
		"\3\2\2\2\20h\3\2\2\2\22\23\7\b\2\2\23\24\7#\2\2\24\25\5\4\3\2\25\26\7"+
		"\2\2\3\26\3\3\2\2\2\27\31\7\3\2\2\30\32\5\6\4\2\31\30\3\2\2\2\32\33\3"+
		"\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\4\2\2\36\5\3"+
		"\2\2\2\37 \7\t\2\2 !\7#\2\2!$\7\3\2\2\"%\5\b\5\2#%\5\f\7\2$\"\3\2\2\2"+
		"$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\4\2\2)\7\3\2"+
		"\2\2*+\7\n\2\2+\67\7\"\2\2,8\5\n\6\2-\61\7\3\2\2.\62\5\n\6\2/\62\5\b\5"+
		"\2\60\62\5\f\7\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\4\2\2\668\3\2\2\2\67,"+
		"\3\2\2\2\67-\3\2\2\28\t\3\2\2\29:\7\f\2\2:>\7#\2\2;=\5\16\b\2<;\3\2\2"+
		"\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@>\3\2\2\2AB\7\13\2\2BL\5"+
		"\20\t\2CM\5\16\b\2DH\7\3\2\2EG\5\16\b\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2"+
		"HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KM\7\4\2\2LC\3\2\2\2LD\3\2\2\2M\r\3\2\2"+
		"\2NO\7\r\2\2OP\7\16\2\2PQ\7\5\2\2QV\7\"\2\2RS\7\6\2\2SU\7\"\2\2TR\3\2"+
		"\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2Yg\7\7\2\2Z[\7\r"+
		"\2\2[g\7\17\2\2\\]\7\r\2\2]g\7\20\2\2^_\7\21\2\2_g\7\33\2\2`a\7\22\2\2"+
		"ag\7\"\2\2bc\7\23\2\2cg\7\33\2\2de\7\24\2\2eg\7$\2\2fN\3\2\2\2fZ\3\2\2"+
		"\2f\\\3\2\2\2f^\3\2\2\2f`\3\2\2\2fb\3\2\2\2fd\3\2\2\2g\17\3\2\2\2hi\t"+
		"\2\2\2i\21\3\2\2\2\r\33$&\61\63\67>HLVf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}