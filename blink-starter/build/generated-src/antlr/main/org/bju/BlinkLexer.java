// Generated from org\bju\Blink.g4 by ANTLR 4.7.2

	package org.bju;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BlinkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, INTEGER_LITERAL=2, STRING_LITERAL=3, BAD_ESCAPE=4, UNTERMINATED=5, 
		TYPE=6, INHERITS=7, FROM=8, END=9, LET=10, MEMBER=11, INT_TYPE=12, STRING_TYPE=13, 
		BOOL_TYPE=14, IF=15, THEN=16, ELSE=17, LOOP=18, WHILE=19, DO=20, TRUE=21, 
		FALSE=22, NIL=23, ME=24, NEW=25, IDENTIFIER=26, ASSIGNMENT=27, COMMA=28, 
		COLON=29, L_PAREN=30, R_PAREN=31, L_SQUARE=32, R_SQUARE=33, L_CURLY=34, 
		R_CURLY=35, OR=36, AND=37, GREATER_EQUAL=38, GREATER=39, LESS_EQUAL=40, 
		LESS=41, EQUAL=42, CONCAT=43, PLUS=44, SUBTRACT=45, MULTIPLY=46, DIVIDE=47, 
		NEGATE=48, NOT=49, DOT=50, OTHER_CHARACTER=51, WHITESPACE=52, NEWLINE=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VALID_ID_START", "VALID_ID_CHAR", "CHARACTER_ESCAPE", "OCTAL_ESCAPE", 
			"ESCAPE", "NOT_QUOTE_OR_BACKSLASH", "NOT_QUOTE", "NOT_NEWLINE", "LINE_FEED_CARRIAGE_RETURN", 
			"SPACE_AND_TAB", "NOT_NEWLINE_OR_WHITESPACE", "COMMENT", "INTEGER_LITERAL", 
			"STRING_LITERAL", "BAD_ESCAPE", "UNTERMINATED", "TYPE", "INHERITS", "FROM", 
			"END", "LET", "MEMBER", "INT_TYPE", "STRING_TYPE", "BOOL_TYPE", "IF", 
			"THEN", "ELSE", "LOOP", "WHILE", "DO", "TRUE", "FALSE", "NIL", "ME", 
			"NEW", "IDENTIFIER", "ASSIGNMENT", "COMMA", "COLON", "L_PAREN", "R_PAREN", 
			"L_SQUARE", "R_SQUARE", "L_CURLY", "R_CURLY", "OR", "AND", "GREATER_EQUAL", 
			"GREATER", "LESS_EQUAL", "LESS", "EQUAL", "CONCAT", "PLUS", "SUBTRACT", 
			"MULTIPLY", "DIVIDE", "NEGATE", "NOT", "DOT", "OTHER_CHARACTER", "WHITESPACE", 
			"NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'type'", "'inherits'", "'from'", 
			"'end'", "'let'", "'member'", "'int'", "'string'", "'bool'", "'if'", 
			"'then'", "'else'", "'loop'", "'while'", "'do'", "'true'", "'false'", 
			"'nil'", "'me'", "'new'", null, "':='", "','", "':'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'||'", "'&&'", "'>='", "'>'", "'<='", "'<'", "'='", 
			"'&'", "'+'", "'-'", "'*'", "'/'", "'~'", "'!'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "INTEGER_LITERAL", "STRING_LITERAL", "BAD_ESCAPE", "UNTERMINATED", 
			"TYPE", "INHERITS", "FROM", "END", "LET", "MEMBER", "INT_TYPE", "STRING_TYPE", 
			"BOOL_TYPE", "IF", "THEN", "ELSE", "LOOP", "WHILE", "DO", "TRUE", "FALSE", 
			"NIL", "ME", "NEW", "IDENTIFIER", "ASSIGNMENT", "COMMA", "COLON", "L_PAREN", 
			"R_PAREN", "L_SQUARE", "R_SQUARE", "L_CURLY", "R_CURLY", "OR", "AND", 
			"GREATER_EQUAL", "GREATER", "LESS_EQUAL", "LESS", "EQUAL", "CONCAT", 
			"PLUS", "SUBTRACT", "MULTIPLY", "DIVIDE", "NEGATE", "NOT", "DOT", "OTHER_CHARACTER", 
			"WHITESPACE", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public BlinkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Blink.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0179\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\3\2\5\2\u0085\n\2\3\3\3\3\5\3\u0089\n\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6\u0095\n\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\7\r\u00a5\n\r\f\r\16\r\u00a8\13"+
		"\r\3\r\3\r\3\16\6\16\u00ad\n\16\r\16\16\16\u00ae\3\16\3\16\6\16\u00b3"+
		"\n\16\r\16\16\16\u00b4\5\16\u00b7\n\16\3\17\3\17\3\17\7\17\u00bc\n\17"+
		"\f\17\16\17\u00bf\13\17\3\17\3\17\3\20\3\20\6\20\u00c5\n\20\r\20\16\20"+
		"\u00c6\3\20\3\20\3\21\3\21\6\21\u00cd\n\21\r\21\16\21\u00ce\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3$\3$\3$\3%\3%\3%\3%\3&\3&\7&\u0136\n&\f&\16&\u0139\13&\3\'\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\3@\3"+
		"A\3A\3A\3A\2\2B\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\3"+
		"\33\4\35\5\37\6!\7#\b%\t\'\n)\13+\f-\r/\16\61\17\63\20\65\21\67\229\23"+
		";\24=\25?\26A\27C\30E\31G\32I\33K\34M\35O\36Q\37S U!W\"Y#[$]%_&a\'c(e"+
		")g*i+k,m-o.q/s\60u\61w\62y\63{\64}\65\177\66\u0081\67\3\2\n\5\2C\\aac"+
		"|\b\2$$^^hhppttvv\7\2\2\13\r\16\20#%]_\1\6\2\2\13\r\16\20#%\1\5\2\2\13"+
		"\r\16\20\1\4\2\f\f\17\17\4\2\13\13\"\"\6\2\2\n\r\16\20\33#\1\2\u0178\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{"+
		"\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\3\u0084\3\2\2\2\5\u0088"+
		"\3\2\2\2\7\u008a\3\2\2\2\t\u008d\3\2\2\2\13\u0094\3\2\2\2\r\u0096\3\2"+
		"\2\2\17\u0098\3\2\2\2\21\u009a\3\2\2\2\23\u009c\3\2\2\2\25\u009e\3\2\2"+
		"\2\27\u00a0\3\2\2\2\31\u00a2\3\2\2\2\33\u00ac\3\2\2\2\35\u00b8\3\2\2\2"+
		"\37\u00c2\3\2\2\2!\u00ca\3\2\2\2#\u00d0\3\2\2\2%\u00d5\3\2\2\2\'\u00de"+
		"\3\2\2\2)\u00e3\3\2\2\2+\u00e7\3\2\2\2-\u00eb\3\2\2\2/\u00f2\3\2\2\2\61"+
		"\u00f6\3\2\2\2\63\u00fd\3\2\2\2\65\u0102\3\2\2\2\67\u0105\3\2\2\29\u010a"+
		"\3\2\2\2;\u010f\3\2\2\2=\u0114\3\2\2\2?\u011a\3\2\2\2A\u011d\3\2\2\2C"+
		"\u0122\3\2\2\2E\u0128\3\2\2\2G\u012c\3\2\2\2I\u012f\3\2\2\2K\u0133\3\2"+
		"\2\2M\u013a\3\2\2\2O\u013d\3\2\2\2Q\u013f\3\2\2\2S\u0141\3\2\2\2U\u0143"+
		"\3\2\2\2W\u0145\3\2\2\2Y\u0147\3\2\2\2[\u0149\3\2\2\2]\u014b\3\2\2\2_"+
		"\u014d\3\2\2\2a\u0150\3\2\2\2c\u0153\3\2\2\2e\u0156\3\2\2\2g\u0158\3\2"+
		"\2\2i\u015b\3\2\2\2k\u015d\3\2\2\2m\u015f\3\2\2\2o\u0161\3\2\2\2q\u0163"+
		"\3\2\2\2s\u0165\3\2\2\2u\u0167\3\2\2\2w\u0169\3\2\2\2y\u016b\3\2\2\2{"+
		"\u016d\3\2\2\2}\u016f\3\2\2\2\177\u0171\3\2\2\2\u0081\u0175\3\2\2\2\u0083"+
		"\u0085\t\2\2\2\u0084\u0083\3\2\2\2\u0085\4\3\2\2\2\u0086\u0089\5\3\2\2"+
		"\u0087\u0089\4\62;\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\6\3"+
		"\2\2\2\u008a\u008b\7^\2\2\u008b\u008c\t\3\2\2\u008c\b\3\2\2\2\u008d\u008e"+
		"\7^\2\2\u008e\u008f\4\629\2\u008f\u0090\4\629\2\u0090\u0091\4\629\2\u0091"+
		"\n\3\2\2\2\u0092\u0095\5\7\4\2\u0093\u0095\5\t\5\2\u0094\u0092\3\2\2\2"+
		"\u0094\u0093\3\2\2\2\u0095\f\3\2\2\2\u0096\u0097\t\4\2\2\u0097\16\3\2"+
		"\2\2\u0098\u0099\t\5\2\2\u0099\20\3\2\2\2\u009a\u009b\t\6\2\2\u009b\22"+
		"\3\2\2\2\u009c\u009d\t\7\2\2\u009d\24\3\2\2\2\u009e\u009f\t\b\2\2\u009f"+
		"\26\3\2\2\2\u00a0\u00a1\t\t\2\2\u00a1\30\3\2\2\2\u00a2\u00a6\7%\2\2\u00a3"+
		"\u00a5\5\21\t\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\b\r\2\2\u00aa\32\3\2\2\2\u00ab\u00ad\4\62;\2\u00ac\u00ab\3\2\2"+
		"\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b6"+
		"\3\2\2\2\u00b0\u00b2\7\60\2\2\u00b1\u00b3\4\62;\2\u00b2\u00b1\3\2\2\2"+
		"\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\34\3\2\2\2\u00b8"+
		"\u00bd\7$\2\2\u00b9\u00bc\5\r\7\2\u00ba\u00bc\5\13\6\2\u00bb\u00b9\3\2"+
		"\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\7$"+
		"\2\2\u00c1\36\3\2\2\2\u00c2\u00c4\7$\2\2\u00c3\u00c5\5\17\b\2\u00c4\u00c3"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c9\7$\2\2\u00c9 \3\2\2\2\u00ca\u00cc\7$\2\2\u00cb"+
		"\u00cd\5\17\b\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3"+
		"\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\"\3\2\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2"+
		"\7{\2\2\u00d2\u00d3\7r\2\2\u00d3\u00d4\7g\2\2\u00d4$\3\2\2\2\u00d5\u00d6"+
		"\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7j\2\2\u00d8\u00d9\7g\2\2\u00d9"+
		"\u00da\7t\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7u\2\2"+
		"\u00dd&\3\2\2\2\u00de\u00df\7h\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7q\2"+
		"\2\u00e1\u00e2\7o\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7"+
		"p\2\2\u00e5\u00e6\7f\2\2\u00e6*\3\2\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9"+
		"\7g\2\2\u00e9\u00ea\7v\2\2\u00ea,\3\2\2\2\u00eb\u00ec\7o\2\2\u00ec\u00ed"+
		"\7g\2\2\u00ed\u00ee\7o\2\2\u00ee\u00ef\7d\2\2\u00ef\u00f0\7g\2\2\u00f0"+
		"\u00f1\7t\2\2\u00f1.\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4"+
		"\u00f5\7v\2\2\u00f5\60\3\2\2\2\u00f6\u00f7\7u\2\2\u00f7\u00f8\7v\2\2\u00f8"+
		"\u00f9\7t\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc\7i\2\2"+
		"\u00fc\62\3\2\2\2\u00fd\u00fe\7d\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7"+
		"q\2\2\u0100\u0101\7n\2\2\u0101\64\3\2\2\2\u0102\u0103\7k\2\2\u0103\u0104"+
		"\7h\2\2\u0104\66\3\2\2\2\u0105\u0106\7v\2\2\u0106\u0107\7j\2\2\u0107\u0108"+
		"\7g\2\2\u0108\u0109\7p\2\2\u01098\3\2\2\2\u010a\u010b\7g\2\2\u010b\u010c"+
		"\7n\2\2\u010c\u010d\7u\2\2\u010d\u010e\7g\2\2\u010e:\3\2\2\2\u010f\u0110"+
		"\7n\2\2\u0110\u0111\7q\2\2\u0111\u0112\7q\2\2\u0112\u0113\7r\2\2\u0113"+
		"<\3\2\2\2\u0114\u0115\7y\2\2\u0115\u0116\7j\2\2\u0116\u0117\7k\2\2\u0117"+
		"\u0118\7n\2\2\u0118\u0119\7g\2\2\u0119>\3\2\2\2\u011a\u011b\7f\2\2\u011b"+
		"\u011c\7q\2\2\u011c@\3\2\2\2\u011d\u011e\7v\2\2\u011e\u011f\7t\2\2\u011f"+
		"\u0120\7w\2\2\u0120\u0121\7g\2\2\u0121B\3\2\2\2\u0122\u0123\7h\2\2\u0123"+
		"\u0124\7c\2\2\u0124\u0125\7n\2\2\u0125\u0126\7u\2\2\u0126\u0127\7g\2\2"+
		"\u0127D\3\2\2\2\u0128\u0129\7p\2\2\u0129\u012a\7k\2\2\u012a\u012b\7n\2"+
		"\2\u012bF\3\2\2\2\u012c\u012d\7o\2\2\u012d\u012e\7g\2\2\u012eH\3\2\2\2"+
		"\u012f\u0130\7p\2\2\u0130\u0131\7g\2\2\u0131\u0132\7y\2\2\u0132J\3\2\2"+
		"\2\u0133\u0137\5\3\2\2\u0134\u0136\5\5\3\2\u0135\u0134\3\2\2\2\u0136\u0139"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138L\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013b\7<\2\2\u013b\u013c\7?\2\2\u013cN\3\2\2\2\u013d"+
		"\u013e\7.\2\2\u013eP\3\2\2\2\u013f\u0140\7<\2\2\u0140R\3\2\2\2\u0141\u0142"+
		"\7*\2\2\u0142T\3\2\2\2\u0143\u0144\7+\2\2\u0144V\3\2\2\2\u0145\u0146\7"+
		"]\2\2\u0146X\3\2\2\2\u0147\u0148\7_\2\2\u0148Z\3\2\2\2\u0149\u014a\7}"+
		"\2\2\u014a\\\3\2\2\2\u014b\u014c\7\177\2\2\u014c^\3\2\2\2\u014d\u014e"+
		"\7~\2\2\u014e\u014f\7~\2\2\u014f`\3\2\2\2\u0150\u0151\7(\2\2\u0151\u0152"+
		"\7(\2\2\u0152b\3\2\2\2\u0153\u0154\7@\2\2\u0154\u0155\7?\2\2\u0155d\3"+
		"\2\2\2\u0156\u0157\7@\2\2\u0157f\3\2\2\2\u0158\u0159\7>\2\2\u0159\u015a"+
		"\7?\2\2\u015ah\3\2\2\2\u015b\u015c\7>\2\2\u015cj\3\2\2\2\u015d\u015e\7"+
		"?\2\2\u015el\3\2\2\2\u015f\u0160\7(\2\2\u0160n\3\2\2\2\u0161\u0162\7-"+
		"\2\2\u0162p\3\2\2\2\u0163\u0164\7/\2\2\u0164r\3\2\2\2\u0165\u0166\7,\2"+
		"\2\u0166t\3\2\2\2\u0167\u0168\7\61\2\2\u0168v\3\2\2\2\u0169\u016a\7\u0080"+
		"\2\2\u016ax\3\2\2\2\u016b\u016c\7#\2\2\u016cz\3\2\2\2\u016d\u016e\7\60"+
		"\2\2\u016e|\3\2\2\2\u016f\u0170\5\27\f\2\u0170~\3\2\2\2\u0171\u0172\5"+
		"\25\13\2\u0172\u0173\3\2\2\2\u0173\u0174\b@\2\2\u0174\u0080\3\2\2\2\u0175"+
		"\u0176\5\23\n\2\u0176\u0177\3\2\2\2\u0177\u0178\bA\2\2\u0178\u0082\3\2"+
		"\2\2\17\2\u0084\u0088\u0094\u00a6\u00ae\u00b4\u00b6\u00bb\u00bd\u00c6"+
		"\u00ce\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}