// Generated from src/main/java/org/uva/sea/qls/parser/antlr/QLS.g by ANTLR 4.7.1

package org.uva.sea.languages.qls.parser.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLSLexer extends Lexer {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            IDENT = 18, NUM = 19, COLOR_CODE = 20, STR = 21, WS = 22, COMMENT = 23, SINGLE_COMMENT = 24;
    public static final String[] ruleNames = {
            "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
            "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
            "IDENT", "NUM", "COLOR_CODE", "STR", "WS", "COMMENT", "SINGLE_COMMENT"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00c3\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5" +
                    "\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3" +
                    "\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3" +
                    "\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17" +
                    "\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21" +
                    "\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\7\23\u008e\n\23\f\23\16" +
                    "\23\u0091\13\23\3\24\6\24\u0094\n\24\r\24\16\24\u0095\3\25\3\25\6\25\u009a" +
                    "\n\25\r\25\16\25\u009b\3\26\3\26\7\26\u00a0\n\26\f\26\16\26\u00a3\13\26" +
                    "\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u00af\n\30\f\30" +
                    "\16\30\u00b2\13\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00bd" +
                    "\n\31\f\31\16\31\u00c0\13\31\3\31\3\31\4\u00a1\u00b0\2\32\3\3\5\4\7\5" +
                    "\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23" +
                    "%\24\'\25)\26+\27-\30/\31\61\32\3\2\7\4\2C\\c|\6\2\62;C\\aac|\5\2\62;" +
                    "CHch\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00c8\2\3\3\2\2\2\2\5\3\2\2\2" +
                    "\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3" +
                    "\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2" +
                    "\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2" +
                    "\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2" +
                    "\2\2\5>\3\2\2\2\7@\3\2\2\2\tB\3\2\2\2\13G\3\2\2\2\rO\3\2\2\2\17X\3\2\2" +
                    "\2\21_\3\2\2\2\23a\3\2\2\2\25c\3\2\2\2\27e\3\2\2\2\31m\3\2\2\2\33s\3\2" +
                    "\2\2\35u\3\2\2\2\37z\3\2\2\2!\u0083\3\2\2\2#\u0089\3\2\2\2%\u008b\3\2" +
                    "\2\2\'\u0093\3\2\2\2)\u0097\3\2\2\2+\u009d\3\2\2\2-\u00a6\3\2\2\2/\u00aa" +
                    "\3\2\2\2\61\u00b8\3\2\2\2\63\64\7u\2\2\64\65\7v\2\2\65\66\7{\2\2\66\67" +
                    "\7n\2\2\678\7g\2\289\7u\2\29:\7j\2\2:;\7g\2\2;<\7g\2\2<=\7v\2\2=\4\3\2" +
                    "\2\2>?\7}\2\2?\6\3\2\2\2@A\7\177\2\2A\b\3\2\2\2BC\7r\2\2CD\7c\2\2DE\7" +
                    "i\2\2EF\7g\2\2F\n\3\2\2\2GH\7u\2\2HI\7g\2\2IJ\7e\2\2JK\7v\2\2KL\7k\2\2" +
                    "LM\7q\2\2MN\7p\2\2N\f\3\2\2\2OP\7s\2\2PQ\7w\2\2QR\7g\2\2RS\7u\2\2ST\7" +
                    "v\2\2TU\7k\2\2UV\7q\2\2VW\7p\2\2W\16\3\2\2\2XY\7y\2\2YZ\7k\2\2Z[\7f\2" +
                    "\2[\\\7i\2\2\\]\7g\2\2]^\7v\2\2^\20\3\2\2\2_`\7*\2\2`\22\3\2\2\2ab\7+" +
                    "\2\2b\24\3\2\2\2cd\7.\2\2d\26\3\2\2\2ef\7f\2\2fg\7g\2\2gh\7h\2\2hi\7c" +
                    "\2\2ij\7w\2\2jk\7n\2\2kl\7v\2\2l\30\3\2\2\2mn\7y\2\2no\7k\2\2op\7f\2\2" +
                    "pq\7v\2\2qr\7j\2\2r\32\3\2\2\2st\7<\2\2t\34\3\2\2\2uv\7h\2\2vw\7q\2\2" +
                    "wx\7p\2\2xy\7v\2\2y\36\3\2\2\2z{\7h\2\2{|\7q\2\2|}\7p\2\2}~\7v\2\2~\177" +
                    "\7u\2\2\177\u0080\7k\2\2\u0080\u0081\7|\2\2\u0081\u0082\7g\2\2\u0082 " +
                    "\3\2\2\2\u0083\u0084\7e\2\2\u0084\u0085\7q\2\2\u0085\u0086\7n\2\2\u0086" +
                    "\u0087\7q\2\2\u0087\u0088\7t\2\2\u0088\"\3\2\2\2\u0089\u008a\7$\2\2\u008a" +
                    "$\3\2\2\2\u008b\u008f\t\2\2\2\u008c\u008e\t\3\2\2\u008d\u008c\3\2\2\2" +
                    "\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090&\3" +
                    "\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\4\62;\2\u0093\u0092\3\2\2\2\u0094" +
                    "\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096(\3\2\2\2" +
                    "\u0097\u0099\7%\2\2\u0098\u009a\t\4\2\2\u0099\u0098\3\2\2\2\u009a\u009b" +
                    "\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c*\3\2\2\2\u009d" +
                    "\u00a1\7$\2\2\u009e\u00a0\13\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2" +
                    "\2\2\u00a1\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3" +
                    "\u00a1\3\2\2\2\u00a4\u00a5\7$\2\2\u00a5,\3\2\2\2\u00a6\u00a7\t\5\2\2\u00a7" +
                    "\u00a8\3\2\2\2\u00a8\u00a9\b\27\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7\61\2" +
                    "\2\u00ab\u00ac\7,\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00af\13\2\2\2\u00ae\u00ad" +
                    "\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1" +
                    "\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4\u00b5\7\61" +
                    "\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\30\2\2\u00b7\60\3\2\2\2\u00b8\u00b9" +
                    "\7\61\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\n\6\2\2" +
                    "\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf" +
                    "\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\b\31\2\2" +
                    "\u00c2\62\3\2\2\2\t\2\u008f\u0095\u009b\u00a1\u00b0\u00be\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'stylesheet'", "'{'", "'}'", "'page'", "'section'", "'questionData'",
            "'widget'", "'('", "')'", "','", "'default'", "'width'", "':'", "'font'",
            "'fontsize'", "'color'", "'\"'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, "IDENT", "NUM", "COLOR_CODE", "STR",
            "WS", "COMMENT", "SINGLE_COMMENT"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public QLSLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String getGrammarFileName() {
        return "QLS.g";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}