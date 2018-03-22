// Generated from C:/Users/Michael/Desktop/Software Construction/endless-ql/GunOli/src/main/antlr\QL.g4 by ANTLR 4.7
package QL.QLAntlrGen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, PLUS=7, MINUS=8, MUL=9, 
		DIV=10, GT=11, GE=12, LT=13, LE=14, EQ=15, NE=16, AND=17, OR=18, NOT=19, 
		FORM=20, IF=21, ELSE=22, BOOLEANTYPE=23, STRINGTYPE=24, MONEYTYPE=25, 
		INTEGERTYPE=26, DATETYPE=27, DECIMALTYPE=28, BOOLEAN=29, INTEGER=30, DECIMAL=31, 
		MONEY=32, DATE=33, DAY=34, MONTH=35, YEAR=36, STRING=37, IDENTIFIER=38, 
		WHITESPCAE=39, MULTI_COMMENT=40, SINGLE_COMMENT=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "PLUS", "MINUS", "MUL", 
		"DIV", "GT", "GE", "LT", "LE", "EQ", "NE", "AND", "OR", "NOT", "FORM", 
		"IF", "ELSE", "BOOLEANTYPE", "STRINGTYPE", "MONEYTYPE", "INTEGERTYPE", 
		"DATETYPE", "DECIMALTYPE", "BOOLEAN", "INTEGER", "DECIMAL", "MONEY", "DATE", 
		"DAY", "MONTH", "YEAR", "STRING", "IDENTIFIER", "WHITESPCAE", "MULTI_COMMENT", 
		"SINGLE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "':'", "'='", "'+'", "'-'", "'*'", "'/'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'form'", 
		"'if'", "'else'", "'boolean'", "'string'", "'money'", "'integer'", "'date'", 
		"'decimal'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "PLUS", "MINUS", "MUL", "DIV", 
		"GT", "GE", "LT", "LE", "EQ", "NE", "AND", "OR", "NOT", "FORM", "IF", 
		"ELSE", "BOOLEANTYPE", "STRINGTYPE", "MONEYTYPE", "INTEGERTYPE", "DATETYPE", 
		"DECIMALTYPE", "BOOLEAN", "INTEGER", "DECIMAL", "MONEY", "DATE", "DAY", 
		"MONTH", "YEAR", "STRING", "IDENTIFIER", "WHITESPCAE", "MULTI_COMMENT", 
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


	public QLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u012c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u00c2\n\36\3\37\6\37\u00c5\n\37\r\37\16\37\u00c6"+
		"\3 \6 \u00ca\n \r \16 \u00cb\3 \3 \6 \u00d0\n \r \16 \u00d1\3!\6!\u00d5"+
		"\n!\r!\16!\u00d6\3!\3!\6!\u00db\n!\r!\16!\u00dc\3!\6!\u00e0\n!\r!\16!"+
		"\u00e1\5!\u00e4\n!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\5#\u00f2"+
		"\n#\3$\3$\3$\3$\5$\u00f8\n$\3%\3%\3%\3%\3%\3&\3&\7&\u0101\n&\f&\16&\u0104"+
		"\13&\3&\3&\3\'\6\'\u0109\n\'\r\'\16\'\u010a\3(\6(\u010e\n(\r(\16(\u010f"+
		"\3(\3(\3)\3)\3)\3)\7)\u0118\n)\f)\16)\u011b\13)\3)\3)\3)\3)\3)\3*\3*\3"+
		"*\3*\7*\u0126\n*\f*\16*\u0129\13*\3*\3*\4\u0102\u0119\2+\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+\3\2\n\3\2\62;\3\2\63\64\3\2\62\63\3\2\63;\3\2\62\64\5\2"+
		"\62;C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u013b\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7"+
		"Y\3\2\2\2\t[\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17a\3\2\2\2\21c\3\2\2\2\23"+
		"e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33n\3\2\2\2\35p\3\2\2\2"+
		"\37s\3\2\2\2!v\3\2\2\2#y\3\2\2\2%|\3\2\2\2\'\177\3\2\2\2)\u0081\3\2\2"+
		"\2+\u0086\3\2\2\2-\u0089\3\2\2\2/\u008e\3\2\2\2\61\u0096\3\2\2\2\63\u009d"+
		"\3\2\2\2\65\u00a3\3\2\2\2\67\u00ab\3\2\2\29\u00b0\3\2\2\2;\u00c1\3\2\2"+
		"\2=\u00c4\3\2\2\2?\u00c9\3\2\2\2A\u00e3\3\2\2\2C\u00e5\3\2\2\2E\u00f1"+
		"\3\2\2\2G\u00f7\3\2\2\2I\u00f9\3\2\2\2K\u00fe\3\2\2\2M\u0108\3\2\2\2O"+
		"\u010d\3\2\2\2Q\u0113\3\2\2\2S\u0121\3\2\2\2UV\7}\2\2V\4\3\2\2\2WX\7\177"+
		"\2\2X\6\3\2\2\2YZ\7*\2\2Z\b\3\2\2\2[\\\7+\2\2\\\n\3\2\2\2]^\7<\2\2^\f"+
		"\3\2\2\2_`\7?\2\2`\16\3\2\2\2ab\7-\2\2b\20\3\2\2\2cd\7/\2\2d\22\3\2\2"+
		"\2ef\7,\2\2f\24\3\2\2\2gh\7\61\2\2h\26\3\2\2\2ij\7@\2\2j\30\3\2\2\2kl"+
		"\7@\2\2lm\7?\2\2m\32\3\2\2\2no\7>\2\2o\34\3\2\2\2pq\7>\2\2qr\7?\2\2r\36"+
		"\3\2\2\2st\7?\2\2tu\7?\2\2u \3\2\2\2vw\7#\2\2wx\7?\2\2x\"\3\2\2\2yz\7"+
		"(\2\2z{\7(\2\2{$\3\2\2\2|}\7~\2\2}~\7~\2\2~&\3\2\2\2\177\u0080\7#\2\2"+
		"\u0080(\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7q\2\2\u0083\u0084\7t\2"+
		"\2\u0084\u0085\7o\2\2\u0085*\3\2\2\2\u0086\u0087\7k\2\2\u0087\u0088\7"+
		"h\2\2\u0088,\3\2\2\2\u0089\u008a\7g\2\2\u008a\u008b\7n\2\2\u008b\u008c"+
		"\7u\2\2\u008c\u008d\7g\2\2\u008d.\3\2\2\2\u008e\u008f\7d\2\2\u008f\u0090"+
		"\7q\2\2\u0090\u0091\7q\2\2\u0091\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7c\2\2\u0094\u0095\7p\2\2\u0095\60\3\2\2\2\u0096\u0097\7u\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2"+
		"\u009b\u009c\7i\2\2\u009c\62\3\2\2\2\u009d\u009e\7o\2\2\u009e\u009f\7"+
		"q\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7{\2\2\u00a2\64"+
		"\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7v\2\2\u00a6"+
		"\u00a7\7g\2\2\u00a7\u00a8\7i\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7t\2\2"+
		"\u00aa\66\3\2\2\2\u00ab\u00ac\7f\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7"+
		"v\2\2\u00ae\u00af\7g\2\2\u00af8\3\2\2\2\u00b0\u00b1\7f\2\2\u00b1\u00b2"+
		"\7g\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7o\2\2\u00b5"+
		"\u00b6\7c\2\2\u00b6\u00b7\7n\2\2\u00b7:\3\2\2\2\u00b8\u00b9\7v\2\2\u00b9"+
		"\u00ba\7t\2\2\u00ba\u00bb\7w\2\2\u00bb\u00c2\7g\2\2\u00bc\u00bd\7h\2\2"+
		"\u00bd\u00be\7c\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c2"+
		"\7g\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c2<\3\2\2\2\u00c3\u00c5"+
		"\t\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7>\3\2\2\2\u00c8\u00ca\t\2\2\2\u00c9\u00c8\3\2\2\2"+
		"\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00cf\7\60\2\2\u00ce\u00d0\t\2\2\2\u00cf\u00ce\3\2\2\2"+
		"\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2@\3"+
		"\2\2\2\u00d3\u00d5\t\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\7\60"+
		"\2\2\u00d9\u00db\t\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e4\3\2\2\2\u00de\u00e0\t\2"+
		"\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00d4\3\2\2\2\u00e3\u00df\3\2"+
		"\2\2\u00e4B\3\2\2\2\u00e5\u00e6\5E#\2\u00e6\u00e7\7/\2\2\u00e7\u00e8\5"+
		"G$\2\u00e8\u00e9\7/\2\2\u00e9\u00ea\5I%\2\u00eaD\3\2\2\2\u00eb\u00ec\7"+
		"\62\2\2\u00ec\u00f2\t\2\2\2\u00ed\u00ee\t\3\2\2\u00ee\u00f2\t\2\2\2\u00ef"+
		"\u00f0\7\65\2\2\u00f0\u00f2\t\4\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ed\3"+
		"\2\2\2\u00f1\u00ef\3\2\2\2\u00f2F\3\2\2\2\u00f3\u00f4\7\62\2\2\u00f4\u00f8"+
		"\t\5\2\2\u00f5\u00f6\7\63\2\2\u00f6\u00f8\t\6\2\2\u00f7\u00f3\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f8H\3\2\2\2\u00f9\u00fa\t\6\2\2\u00fa\u00fb\t"+
		"\2\2\2\u00fb\u00fc\t\2\2\2\u00fc\u00fd\t\2\2\2\u00fdJ\3\2\2\2\u00fe\u0102"+
		"\7$\2\2\u00ff\u0101\13\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0105\u0106\7$\2\2\u0106L\3\2\2\2\u0107\u0109\t\7\2\2\u0108\u0107"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"N\3\2\2\2\u010c\u010e\t\b\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2"+
		"\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112"+
		"\b(\2\2\u0112P\3\2\2\2\u0113\u0114\7\61\2\2\u0114\u0115\7,\2\2\u0115\u0119"+
		"\3\2\2\2\u0116\u0118\13\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2"+
		"\u0119\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119"+
		"\3\2\2\2\u011c\u011d\7,\2\2\u011d\u011e\7\61\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\b)\2\2\u0120R\3\2\2\2\u0121\u0122\7\61\2\2\u0122\u0123\7\61\2\2"+
		"\u0123\u0127\3\2\2\2\u0124\u0126\n\t\2\2\u0125\u0124\3\2\2\2\u0126\u0129"+
		"\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u012a\u012b\b*\2\2\u012bT\3\2\2\2\22\2\u00c1\u00c6\u00cb"+
		"\u00d1\u00d6\u00dc\u00e1\u00e3\u00f1\u00f7\u0102\u010a\u010f\u0119\u0127"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}