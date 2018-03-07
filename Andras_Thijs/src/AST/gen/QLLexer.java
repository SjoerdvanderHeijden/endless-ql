// Generated from C:/Users/Gebruiker/IdeaProjects/endless-ql/Andras_Thijs/src/AST\QL.g4 by ANTLR 4.7
package AST.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, WS=8, NOT=9, EXPONENT=10, 
		ADDITION=11, SUBTRACTION=12, DIVISION=13, MULTIPLICATION=14, GREATER=15, 
		LESS=16, GREATEREQ=17, LESSEQ=18, EQUAL=19, NOTEQUAL=20, AND=21, OR=22, 
		TYPE=23, BOOLEAN=24, STRING=25, INTEGER=26, DECIMAL=27, VARIABLE=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "WS", "NOT", "EXPONENT", 
		"ADDITION", "SUBTRACTION", "DIVISION", "MULTIPLICATION", "GREATER", "LESS", 
		"GREATEREQ", "LESSEQ", "EQUAL", "NOTEQUAL", "AND", "OR", "TYPE", "BOOLEAN", 
		"STRING", "INTEGER", "DECIMAL", "VARIABLE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'form'", "'{'", "'}'", "':'", "'if'", "'('", "')'", null, "'!'", 
		"'^'", "'+'", "'-'", "'/'", "'*'", "'>'", "'<'", "'>='", "'<='", "'=='", 
		"'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "WS", "NOT", "EXPONENT", 
		"ADDITION", "SUBTRACTION", "DIVISION", "MULTIPLICATION", "GREATER", "LESS", 
		"GREATEREQ", "LESSEQ", "EQUAL", "NOTEQUAL", "AND", "OR", "TYPE", "BOOLEAN", 
		"STRING", "INTEGER", "DECIMAL", "VARIABLE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00c5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\6\tO\n\t\r\t\16\t"+
		"P\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u009b\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u00a6\n\31\3\32\3\32\6\32\u00aa\n\32\r\32\16\32\u00ab\3\32\3\32\3\33"+
		"\6\33\u00b1\n\33\r\33\16\33\u00b2\3\34\6\34\u00b6\n\34\r\34\16\34\u00b7"+
		"\3\34\3\34\6\34\u00bc\n\34\r\34\16\34\u00bd\3\35\3\35\6\35\u00c2\n\35"+
		"\r\35\16\35\u00c3\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36\3\2\7\5\2\13\f\17\17\"\"\t\2\13\13\"#*+\60=AAC\\c"+
		"|\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\2\u00d0\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5@\3\2\2\2\7B\3\2\2\2"+
		"\tD\3\2\2\2\13F\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21N\3\2\2\2\23T\3\2\2\2"+
		"\25V\3\2\2\2\27X\3\2\2\2\31Z\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37`\3\2"+
		"\2\2!b\3\2\2\2#d\3\2\2\2%g\3\2\2\2\'j\3\2\2\2)m\3\2\2\2+p\3\2\2\2-s\3"+
		"\2\2\2/\u009a\3\2\2\2\61\u00a5\3\2\2\2\63\u00a7\3\2\2\2\65\u00b0\3\2\2"+
		"\2\67\u00b5\3\2\2\29\u00bf\3\2\2\2;<\7h\2\2<=\7q\2\2=>\7t\2\2>?\7o\2\2"+
		"?\4\3\2\2\2@A\7}\2\2A\6\3\2\2\2BC\7\177\2\2C\b\3\2\2\2DE\7<\2\2E\n\3\2"+
		"\2\2FG\7k\2\2GH\7h\2\2H\f\3\2\2\2IJ\7*\2\2J\16\3\2\2\2KL\7+\2\2L\20\3"+
		"\2\2\2MO\t\2\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\b"+
		"\t\2\2S\22\3\2\2\2TU\7#\2\2U\24\3\2\2\2VW\7`\2\2W\26\3\2\2\2XY\7-\2\2"+
		"Y\30\3\2\2\2Z[\7/\2\2[\32\3\2\2\2\\]\7\61\2\2]\34\3\2\2\2^_\7,\2\2_\36"+
		"\3\2\2\2`a\7@\2\2a \3\2\2\2bc\7>\2\2c\"\3\2\2\2de\7@\2\2ef\7?\2\2f$\3"+
		"\2\2\2gh\7>\2\2hi\7?\2\2i&\3\2\2\2jk\7?\2\2kl\7?\2\2l(\3\2\2\2mn\7#\2"+
		"\2no\7?\2\2o*\3\2\2\2pq\7(\2\2qr\7(\2\2r,\3\2\2\2st\7~\2\2tu\7~\2\2u."+
		"\3\2\2\2vw\7d\2\2wx\7q\2\2xy\7q\2\2yz\7n\2\2z{\7g\2\2{|\7c\2\2|\u009b"+
		"\7p\2\2}~\7u\2\2~\177\7v\2\2\177\u0080\7t\2\2\u0080\u0081\7k\2\2\u0081"+
		"\u0082\7p\2\2\u0082\u009b\7i\2\2\u0083\u0084\7k\2\2\u0084\u0085\7p\2\2"+
		"\u0085\u0086\7v\2\2\u0086\u0087\7g\2\2\u0087\u0088\7i\2\2\u0088\u0089"+
		"\7g\2\2\u0089\u009b\7t\2\2\u008a\u008b\7f\2\2\u008b\u008c\7c\2\2\u008c"+
		"\u008d\7v\2\2\u008d\u009b\7g\2\2\u008e\u008f\7f\2\2\u008f\u0090\7g\2\2"+
		"\u0090\u0091\7e\2\2\u0091\u0092\7k\2\2\u0092\u0093\7o\2\2\u0093\u0094"+
		"\7c\2\2\u0094\u009b\7n\2\2\u0095\u0096\7o\2\2\u0096\u0097\7q\2\2\u0097"+
		"\u0098\7p\2\2\u0098\u0099\7g\2\2\u0099\u009b\7{\2\2\u009av\3\2\2\2\u009a"+
		"}\3\2\2\2\u009a\u0083\3\2\2\2\u009a\u008a\3\2\2\2\u009a\u008e\3\2\2\2"+
		"\u009a\u0095\3\2\2\2\u009b\60\3\2\2\2\u009c\u009d\7v\2\2\u009d\u009e\7"+
		"t\2\2\u009e\u009f\7w\2\2\u009f\u00a6\7g\2\2\u00a0\u00a1\7h\2\2\u00a1\u00a2"+
		"\7c\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a6\7g\2\2\u00a5"+
		"\u009c\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a6\62\3\2\2\2\u00a7\u00a9\7$\2\2"+
		"\u00a8\u00aa\t\3\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7$\2\2\u00ae"+
		"\64\3\2\2\2\u00af\u00b1\t\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2"+
		"\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\66\3\2\2\2\u00b4\u00b6"+
		"\t\4\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\7\60\2\2\u00ba\u00bc\t"+
		"\4\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be8\3\2\2\2\u00bf\u00c1\t\5\2\2\u00c0\u00c2\t\6\2\2"+
		"\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4:\3\2\2\2\13\2P\u009a\u00a5\u00ab\u00b2\u00b7\u00bd\u00c3"+
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