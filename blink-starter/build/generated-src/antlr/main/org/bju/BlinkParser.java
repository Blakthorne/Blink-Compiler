// Generated from org\bju\Blink.g4 by ANTLR 4.7.2

	package org.bju;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BlinkParser extends Parser {
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
	public static final int
		RULE_start = 0, RULE_primary = 1, RULE_blink_class = 2, RULE_inherits = 3, 
		RULE_declaration = 4, RULE_member_declaration = 5, RULE_variable = 6, 
		RULE_method = 7, RULE_arguments = 8, RULE_argument = 9, RULE_declared_type = 10, 
		RULE_type = 11, RULE_types = 12, RULE_statement = 13, RULE_blink_if = 14, 
		RULE_blink_else = 15, RULE_loop = 16, RULE_expressions = 17, RULE_array_init = 18, 
		RULE_expression = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "primary", "blink_class", "inherits", "declaration", "member_declaration", 
			"variable", "method", "arguments", "argument", "declared_type", "type", 
			"types", "statement", "blink_if", "blink_else", "loop", "expressions", 
			"array_init", "expression"
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

	@Override
	public String getGrammarFileName() { return "Blink.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BlinkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public PrimaryContext primary;
		public List<PrimaryContext> children = new ArrayList<PrimaryContext>();
		public TerminalNode EOF() { return getToken(BlinkParser.EOF, 0); }
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				((StartContext)_localctx).primary = primary();
				((StartContext)_localctx).children.add(((StartContext)_localctx).primary);
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TYPE || _la==LET );
			setState(45);
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

	public static class PrimaryContext extends ParserRuleContext {
		public Blink_classContext cls;
		public DeclarationContext decl;
		public Blink_classContext blink_class() {
			return getRuleContext(Blink_classContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primary);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				((PrimaryContext)_localctx).cls = blink_class();
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				((PrimaryContext)_localctx).decl = declaration();
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

	public static class Blink_classContext extends ParserRuleContext {
		public Token id;
		public ArgumentsContext args;
		public InheritsContext parent;
		public Member_declarationContext member_declaration;
		public List<Member_declarationContext> members = new ArrayList<Member_declarationContext>();
		public TerminalNode TYPE() { return getToken(BlinkParser.TYPE, 0); }
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(BlinkParser.ASSIGNMENT, 0); }
		public TerminalNode END() { return getToken(BlinkParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public InheritsContext inherits() {
			return getRuleContext(InheritsContext.class,0);
		}
		public List<Member_declarationContext> member_declaration() {
			return getRuleContexts(Member_declarationContext.class);
		}
		public Member_declarationContext member_declaration(int i) {
			return getRuleContext(Member_declarationContext.class,i);
		}
		public Blink_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blink_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterBlink_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitBlink_class(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitBlink_class(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Blink_classContext blink_class() throws RecognitionException {
		Blink_classContext _localctx = new Blink_classContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blink_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(TYPE);
			setState(52);
			((Blink_classContext)_localctx).id = match(IDENTIFIER);
			setState(53);
			match(L_PAREN);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(54);
				((Blink_classContext)_localctx).args = arguments();
				}
			}

			setState(57);
			match(R_PAREN);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(58);
				((Blink_classContext)_localctx).parent = inherits();
				}
			}

			setState(61);
			match(ASSIGNMENT);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				((Blink_classContext)_localctx).member_declaration = member_declaration();
				((Blink_classContext)_localctx).members.add(((Blink_classContext)_localctx).member_declaration);
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MEMBER );
			setState(67);
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

	public static class InheritsContext extends ParserRuleContext {
		public Token id;
		public ExpressionsContext args;
		public TerminalNode INHERITS() { return getToken(BlinkParser.INHERITS, 0); }
		public TerminalNode FROM() { return getToken(BlinkParser.FROM, 0); }
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public InheritsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inherits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterInherits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitInherits(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitInherits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritsContext inherits() throws RecognitionException {
		InheritsContext _localctx = new InheritsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inherits);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(INHERITS);
			setState(70);
			match(FROM);
			setState(71);
			((InheritsContext)_localctx).id = match(IDENTIFIER);
			setState(72);
			match(L_PAREN);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << NEGATE) | (1L << NOT))) != 0)) {
				{
				setState(73);
				((InheritsContext)_localctx).args = expressions();
				}
			}

			setState(76);
			match(R_PAREN);
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Method_declContext extends DeclarationContext {
		public TerminalNode LET() { return getToken(BlinkParser.LET, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public Method_declContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitMethod_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Var_declContext extends DeclarationContext {
		public TerminalNode LET() { return getToken(BlinkParser.LET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Var_declContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new Var_declContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(LET);
				setState(79);
				variable();
				}
				break;
			case 2:
				_localctx = new Method_declContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(LET);
				setState(81);
				method();
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

	public static class Member_declarationContext extends ParserRuleContext {
		public Member_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_declaration; }
	 
		public Member_declarationContext() { }
		public void copyFrom(Member_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Member_var_declContext extends Member_declarationContext {
		public TerminalNode MEMBER() { return getToken(BlinkParser.MEMBER, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Member_var_declContext(Member_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterMember_var_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitMember_var_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitMember_var_decl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Member_method_declContext extends Member_declarationContext {
		public TerminalNode MEMBER() { return getToken(BlinkParser.MEMBER, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public Member_method_declContext(Member_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterMember_method_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitMember_method_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitMember_method_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_declarationContext member_declaration() throws RecognitionException {
		Member_declarationContext _localctx = new Member_declarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_member_declaration);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new Member_var_declContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(MEMBER);
				setState(85);
				variable();
				}
				break;
			case 2:
				_localctx = new Member_method_declContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(MEMBER);
				setState(87);
				method();
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

	public static class VariableContext extends ParserRuleContext {
		public Token id;
		public Declared_typeContext typ;
		public StatementContext value;
		public TerminalNode ASSIGNMENT() { return getToken(BlinkParser.ASSIGNMENT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Declared_typeContext declared_type() {
			return getRuleContext(Declared_typeContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((VariableContext)_localctx).id = match(IDENTIFIER);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(91);
				((VariableContext)_localctx).typ = declared_type();
				}
			}

			setState(94);
			match(ASSIGNMENT);
			setState(95);
			((VariableContext)_localctx).value = statement();
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

	public static class MethodContext extends ParserRuleContext {
		public Token id;
		public ArgumentsContext args;
		public Declared_typeContext typ;
		public DeclarationContext declaration;
		public List<DeclarationContext> members = new ArrayList<DeclarationContext>();
		public StatementContext value;
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(BlinkParser.ASSIGNMENT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Declared_typeContext declared_type() {
			return getRuleContext(Declared_typeContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			((MethodContext)_localctx).id = match(IDENTIFIER);
			setState(98);
			match(L_PAREN);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(99);
				((MethodContext)_localctx).args = arguments();
				}
			}

			setState(102);
			match(R_PAREN);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(103);
				((MethodContext)_localctx).typ = declared_type();
				}
			}

			setState(106);
			match(ASSIGNMENT);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET) {
				{
				{
				setState(107);
				((MethodContext)_localctx).declaration = declaration();
				((MethodContext)_localctx).members.add(((MethodContext)_localctx).declaration);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			((MethodContext)_localctx).value = statement();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentContext first;
		public ArgumentContext argument;
		public List<ArgumentContext> last = new ArrayList<ArgumentContext>();
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BlinkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BlinkParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			((ArgumentsContext)_localctx).first = argument();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				((ArgumentsContext)_localctx).argument = argument();
				((ArgumentsContext)_localctx).last.add(((ArgumentsContext)_localctx).argument);
				}
				}
				setState(122);
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

	public static class ArgumentContext extends ParserRuleContext {
		public Token id;
		public Declared_typeContext typ;
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public Declared_typeContext declared_type() {
			return getRuleContext(Declared_typeContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			((ArgumentContext)_localctx).id = match(IDENTIFIER);
			setState(124);
			((ArgumentContext)_localctx).typ = declared_type();
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

	public static class Declared_typeContext extends ParserRuleContext {
		public TypeContext typ;
		public TerminalNode COLON() { return getToken(BlinkParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Declared_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declared_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterDeclared_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitDeclared_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitDeclared_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declared_typeContext declared_type() throws RecognitionException {
		Declared_typeContext _localctx = new Declared_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declared_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(COLON);
			setState(127);
			((Declared_typeContext)_localctx).typ = type();
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
		public TypesContext typ;
		public ExpressionContext expression;
		public List<ExpressionContext> sizes = new ArrayList<ExpressionContext>();
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public List<TerminalNode> L_SQUARE() { return getTokens(BlinkParser.L_SQUARE); }
		public TerminalNode L_SQUARE(int i) {
			return getToken(BlinkParser.L_SQUARE, i);
		}
		public List<TerminalNode> R_SQUARE() { return getTokens(BlinkParser.R_SQUARE); }
		public TerminalNode R_SQUARE(int i) {
			return getToken(BlinkParser.R_SQUARE, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((TypeContext)_localctx).typ = types();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==L_SQUARE) {
				{
				{
				setState(130);
				match(L_SQUARE);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << NEGATE) | (1L << NOT))) != 0)) {
					{
					setState(131);
					((TypeContext)_localctx).expression = expression(0);
					((TypeContext)_localctx).sizes.add(((TypeContext)_localctx).expression);
					}
				}

				setState(134);
				match(R_SQUARE);
				}
				}
				setState(139);
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

	public static class TypesContext extends ParserRuleContext {
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
	 
		public TypesContext() { }
		public void copyFrom(TypesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class String_typeContext extends TypesContext {
		public TerminalNode STRING_TYPE() { return getToken(BlinkParser.STRING_TYPE, 0); }
		public String_typeContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterString_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitString_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitString_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Custom_typeContext extends TypesContext {
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public Custom_typeContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterCustom_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitCustom_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitCustom_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Int_typeContext extends TypesContext {
		public TerminalNode INT_TYPE() { return getToken(BlinkParser.INT_TYPE, 0); }
		public Int_typeContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterInt_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitInt_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitInt_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_typeContext extends TypesContext {
		public TerminalNode BOOL_TYPE() { return getToken(BlinkParser.BOOL_TYPE, 0); }
		public Bool_typeContext(TypesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterBool_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitBool_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitBool_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_types);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_TYPE:
				_localctx = new Int_typeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(INT_TYPE);
				}
				break;
			case STRING_TYPE:
				_localctx = new String_typeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(STRING_TYPE);
				}
				break;
			case BOOL_TYPE:
				_localctx = new Bool_typeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(BOOL_TYPE);
				}
				break;
			case IDENTIFIER:
				_localctx = new Custom_typeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				((Custom_typeContext)_localctx).id = match(IDENTIFIER);
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

	public static class StatementContext extends ParserRuleContext {
		public Blink_ifContext blink_if() {
			return getRuleContext(Blink_ifContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				blink_if();
				}
				break;
			case LOOP:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				loop();
				}
				break;
			case INTEGER_LITERAL:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NIL:
			case ME:
			case NEW:
			case IDENTIFIER:
			case L_PAREN:
			case NEGATE:
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				expression(0);
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

	public static class Blink_ifContext extends ParserRuleContext {
		public ExpressionContext expr;
		public StatementContext true_value;
		public Blink_elseContext false_value;
		public TerminalNode IF() { return getToken(BlinkParser.IF, 0); }
		public TerminalNode THEN() { return getToken(BlinkParser.THEN, 0); }
		public TerminalNode END() { return getToken(BlinkParser.END, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Blink_elseContext blink_else() {
			return getRuleContext(Blink_elseContext.class,0);
		}
		public Blink_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blink_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterBlink_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitBlink_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitBlink_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Blink_ifContext blink_if() throws RecognitionException {
		Blink_ifContext _localctx = new Blink_ifContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blink_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(IF);
			setState(152);
			((Blink_ifContext)_localctx).expr = expression(0);
			setState(153);
			match(THEN);
			setState(154);
			((Blink_ifContext)_localctx).true_value = statement();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(155);
				((Blink_ifContext)_localctx).false_value = blink_else();
				}
			}

			setState(158);
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

	public static class Blink_elseContext extends ParserRuleContext {
		public StatementContext false_value;
		public TerminalNode ELSE() { return getToken(BlinkParser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Blink_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blink_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterBlink_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitBlink_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitBlink_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Blink_elseContext blink_else() throws RecognitionException {
		Blink_elseContext _localctx = new Blink_elseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blink_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(ELSE);
			setState(161);
			((Blink_elseContext)_localctx).false_value = statement();
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

	public static class LoopContext extends ParserRuleContext {
		public ExpressionContext expr;
		public StatementContext value;
		public TerminalNode LOOP() { return getToken(BlinkParser.LOOP, 0); }
		public TerminalNode WHILE() { return getToken(BlinkParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(BlinkParser.DO, 0); }
		public TerminalNode END() { return getToken(BlinkParser.END, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(LOOP);
			setState(164);
			match(WHILE);
			setState(165);
			((LoopContext)_localctx).expr = expression(0);
			setState(166);
			match(DO);
			setState(167);
			((LoopContext)_localctx).value = statement();
			setState(168);
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

	public static class ExpressionsContext extends ParserRuleContext {
		public ExpressionContext first;
		public ExpressionContext expression;
		public List<ExpressionContext> last = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BlinkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BlinkParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			((ExpressionsContext)_localctx).first = expression(0);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(171);
				match(COMMA);
				setState(172);
				((ExpressionsContext)_localctx).expression = expression(0);
				((ExpressionsContext)_localctx).last.add(((ExpressionsContext)_localctx).expression);
				}
				}
				setState(177);
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

	public static class Array_initContext extends ParserRuleContext {
		public Array_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_init; }
	 
		public Array_initContext() { }
		public void copyFrom(Array_initContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubexpressioninitContext extends Array_initContext {
		public Array_initContext init;
		public Array_initContext array_init;
		public List<Array_initContext> rest = new ArrayList<Array_initContext>();
		public List<TerminalNode> L_CURLY() { return getTokens(BlinkParser.L_CURLY); }
		public TerminalNode L_CURLY(int i) {
			return getToken(BlinkParser.L_CURLY, i);
		}
		public List<TerminalNode> R_CURLY() { return getTokens(BlinkParser.R_CURLY); }
		public TerminalNode R_CURLY(int i) {
			return getToken(BlinkParser.R_CURLY, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BlinkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BlinkParser.COMMA, i);
		}
		public List<Array_initContext> array_init() {
			return getRuleContexts(Array_initContext.class);
		}
		public Array_initContext array_init(int i) {
			return getRuleContext(Array_initContext.class,i);
		}
		public SubexpressioninitContext(Array_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterSubexpressioninit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitSubexpressioninit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitSubexpressioninit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressioninitContext extends Array_initContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public ExpressioninitContext(Array_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterExpressioninit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitExpressioninit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitExpressioninit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_initContext array_init() throws RecognitionException {
		Array_initContext _localctx = new Array_initContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_array_init);
		int _la;
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_LITERAL:
			case STRING_LITERAL:
			case TRUE:
			case FALSE:
			case NIL:
			case ME:
			case NEW:
			case IDENTIFIER:
			case L_PAREN:
			case NEGATE:
			case NOT:
				_localctx = new ExpressioninitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				expressions();
				}
				break;
			case L_CURLY:
				_localctx = new SubexpressioninitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(L_CURLY);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << L_CURLY) | (1L << NEGATE) | (1L << NOT))) != 0)) {
					{
					setState(180);
					((SubexpressioninitContext)_localctx).init = array_init();
					}
				}

				setState(183);
				match(R_CURLY);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(184);
					match(COMMA);
					setState(185);
					match(L_CURLY);
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << L_CURLY) | (1L << NEGATE) | (1L << NOT))) != 0)) {
						{
						setState(186);
						((SubexpressioninitContext)_localctx).array_init = array_init();
						((SubexpressioninitContext)_localctx).rest.add(((SubexpressioninitContext)_localctx).array_init);
						}
					}

					setState(189);
					match(R_CURLY);
					}
					}
					setState(194);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NnContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEGATE() { return getToken(BlinkParser.NEGATE, 0); }
		public TerminalNode NOT() { return getToken(BlinkParser.NOT, 0); }
		public NnContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterNn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitNn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitNn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Paren_exprContext extends ExpressionContext {
		public ExpressionContext expr;
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Paren_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterParen_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitParen_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitParen_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends ExpressionContext {
		public TypeContext typ;
		public ExpressionsContext value;
		public Array_initContext init;
		public TerminalNode NEW() { return getToken(BlinkParser.NEW, 0); }
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode L_CURLY() { return getToken(BlinkParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(BlinkParser.R_CURLY, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public Array_initContext array_init() {
			return getRuleContext(Array_initContext.class,0);
		}
		public NewContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayassignContext extends ExpressionContext {
		public ExpressionContext assignto;
		public ExpressionContext expression;
		public List<ExpressionContext> values = new ArrayList<ExpressionContext>();
		public ExpressionContext value;
		public TerminalNode ASSIGNMENT() { return getToken(BlinkParser.ASSIGNMENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> L_SQUARE() { return getTokens(BlinkParser.L_SQUARE); }
		public TerminalNode L_SQUARE(int i) {
			return getToken(BlinkParser.L_SQUARE, i);
		}
		public List<TerminalNode> R_SQUARE() { return getTokens(BlinkParser.R_SQUARE); }
		public TerminalNode R_SQUARE(int i) {
			return getToken(BlinkParser.R_SQUARE, i);
		}
		public ArrayassignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterArrayassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitArrayassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitArrayassign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public ExpressionContext first;
		public ExpressionContext rest;
		public TerminalNode OR() { return getToken(BlinkParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExpressionContext {
		public TerminalNode STRING_LITERAL() { return getToken(BlinkParser.STRING_LITERAL, 0); }
		public StringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Function2Context extends ExpressionContext {
		public Token id;
		public ExpressionsContext values;
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public Function2Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterFunction2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitFunction2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitFunction2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Function1Context extends ExpressionContext {
		public Token id;
		public ExpressionsContext values;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(BlinkParser.DOT, 0); }
		public TerminalNode L_PAREN() { return getToken(BlinkParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(BlinkParser.R_PAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public Function1Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterFunction1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitFunction1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitFunction1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(BlinkParser.FALSE, 0); }
		public FalseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatContext extends ExpressionContext {
		public ExpressionContext first;
		public ExpressionContext rest;
		public TerminalNode CONCAT() { return getToken(BlinkParser.CONCAT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConcatContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExpressionContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(BlinkParser.INTEGER_LITERAL, 0); }
		public IntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NilContext extends ExpressionContext {
		public TerminalNode NIL() { return getToken(BlinkParser.NIL, 0); }
		public NilContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterNil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitNil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitNil(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdassignContext extends ExpressionContext {
		public Token assignto;
		public ExpressionContext value;
		public TerminalNode ASSIGNMENT() { return getToken(BlinkParser.ASSIGNMENT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdassignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterIdassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitIdassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitIdassign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AsContext extends ExpressionContext {
		public ExpressionContext first;
		public Token op;
		public ExpressionContext rest;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(BlinkParser.PLUS, 0); }
		public TerminalNode SUBTRACT() { return getToken(BlinkParser.SUBTRACT, 0); }
		public AsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitAs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitAs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChecksContext extends ExpressionContext {
		public ExpressionContext first;
		public Token op;
		public ExpressionContext rest;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(BlinkParser.EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(BlinkParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(BlinkParser.GREATER_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(BlinkParser.LESS, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(BlinkParser.LESS_EQUAL, 0); }
		public ChecksContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterChecks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitChecks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitChecks(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public ExpressionContext first;
		public ExpressionContext rest;
		public TerminalNode AND() { return getToken(BlinkParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MdContext extends ExpressionContext {
		public ExpressionContext first;
		public Token op;
		public ExpressionContext rest;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(BlinkParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(BlinkParser.DIVIDE, 0); }
		public MdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterMd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitMd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitMd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(BlinkParser.TRUE, 0); }
		public TrueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MeContext extends ExpressionContext {
		public TerminalNode ME() { return getToken(BlinkParser.ME, 0); }
		public MeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterMe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitMe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitMe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExpressionContext {
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(BlinkParser.IDENTIFIER, 0); }
		public IdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BlinkListener ) ((BlinkListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BlinkVisitor ) return ((BlinkVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(198);
				match(INTEGER_LITERAL);
				}
				break;
			case 2:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(TRUE);
				}
				break;
			case 3:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(FALSE);
				}
				break;
			case 4:
				{
				_localctx = new NilContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(NIL);
				}
				break;
			case 5:
				{
				_localctx = new Function2Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				((Function2Context)_localctx).id = match(IDENTIFIER);
				setState(203);
				match(L_PAREN);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << NEGATE) | (1L << NOT))) != 0)) {
					{
					setState(204);
					((Function2Context)_localctx).values = expressions();
					}
				}

				setState(207);
				match(R_PAREN);
				}
				break;
			case 6:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				((IdContext)_localctx).id = match(IDENTIFIER);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(STRING_LITERAL);
				}
				break;
			case 8:
				{
				_localctx = new MeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(ME);
				}
				break;
			case 9:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(NEW);
				setState(212);
				((NewContext)_localctx).typ = type();
				setState(213);
				match(L_PAREN);
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << NEGATE) | (1L << NOT))) != 0)) {
					{
					setState(214);
					((NewContext)_localctx).value = expressions();
					}
				}

				setState(217);
				match(R_PAREN);
				setState(223);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(218);
					match(L_CURLY);
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << L_CURLY) | (1L << NEGATE) | (1L << NOT))) != 0)) {
						{
						setState(219);
						((NewContext)_localctx).init = array_init();
						}
					}

					setState(222);
					match(R_CURLY);
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new NnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				((NnContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NEGATE || _la==NOT) ) {
					((NnContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				expression(10);
				}
				break;
			case 11:
				{
				_localctx = new IdassignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				((IdassignContext)_localctx).assignto = match(IDENTIFIER);
				setState(228);
				match(ASSIGNMENT);
				setState(229);
				((IdassignContext)_localctx).value = expression(2);
				}
				break;
			case 12:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(L_PAREN);
				setState(231);
				((Paren_exprContext)_localctx).expr = expression(0);
				setState(232);
				match(R_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MdContext(new ExpressionContext(_parentctx, _parentState));
						((MdContext)_localctx).first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(237);
						((MdContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
							((MdContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(238);
						((MdContext)_localctx).rest = expression(10);
						}
						break;
					case 2:
						{
						_localctx = new AsContext(new ExpressionContext(_parentctx, _parentState));
						((AsContext)_localctx).first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(240);
						((AsContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==SUBTRACT) ) {
							((AsContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						((AsContext)_localctx).rest = expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ConcatContext(new ExpressionContext(_parentctx, _parentState));
						((ConcatContext)_localctx).first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(243);
						match(CONCAT);
						setState(244);
						((ConcatContext)_localctx).rest = expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ChecksContext(new ExpressionContext(_parentctx, _parentState));
						((ChecksContext)_localctx).first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(245);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(246);
						((ChecksContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER_EQUAL) | (1L << GREATER) | (1L << LESS_EQUAL) | (1L << LESS) | (1L << EQUAL))) != 0)) ) {
							((ChecksContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						((ChecksContext)_localctx).rest = expression(7);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						((AndContext)_localctx).first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(249);
						match(AND);
						setState(250);
						((AndContext)_localctx).rest = expression(6);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						((OrContext)_localctx).first = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(252);
						match(OR);
						setState(253);
						((OrContext)_localctx).rest = expression(5);
						}
						break;
					case 7:
						{
						_localctx = new ArrayassignContext(new ExpressionContext(_parentctx, _parentState));
						((ArrayassignContext)_localctx).assignto = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(259); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(255);
							match(L_SQUARE);
							setState(256);
							((ArrayassignContext)_localctx).expression = expression(0);
							((ArrayassignContext)_localctx).values.add(((ArrayassignContext)_localctx).expression);
							setState(257);
							match(R_SQUARE);
							}
							}
							setState(261); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==L_SQUARE );
						setState(263);
						match(ASSIGNMENT);
						setState(264);
						((ArrayassignContext)_localctx).value = expression(4);
						}
						break;
					case 8:
						{
						_localctx = new Function1Context(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(266);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(267);
						match(DOT);
						setState(268);
						((Function1Context)_localctx).id = match(IDENTIFIER);
						setState(269);
						match(L_PAREN);
						setState(271);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_LITERAL) | (1L << STRING_LITERAL) | (1L << TRUE) | (1L << FALSE) | (1L << NIL) | (1L << ME) | (1L << NEW) | (1L << IDENTIFIER) | (1L << L_PAREN) | (1L << NEGATE) | (1L << NOT))) != 0)) {
							{
							setState(270);
							((Function1Context)_localctx).values = expressions();
							}
						}

						setState(273);
						match(R_PAREN);
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u011a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\6\2,\n\2\r\2\16\2-\3\2\3\2\3\3\3\3"+
		"\5\3\64\n\3\3\4\3\4\3\4\3\4\5\4:\n\4\3\4\3\4\5\4>\n\4\3\4\3\4\6\4B\n\4"+
		"\r\4\16\4C\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\5\6U\n\6\3\7\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\5\b_\n\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\5\tg\n\t\3\t\3\t\5\tk\n\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\3\t"+
		"\3\t\3\n\3\n\3\n\7\ny\n\n\f\n\16\n|\13\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\5\r\u0087\n\r\3\r\7\r\u008a\n\r\f\r\16\r\u008d\13\r\3\16\3"+
		"\16\3\16\3\16\5\16\u0093\n\16\3\17\3\17\3\17\5\17\u0098\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u009f\n\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00b0\n\23\f\23\16\23\u00b3\13"+
		"\23\3\24\3\24\3\24\5\24\u00b8\n\24\3\24\3\24\3\24\3\24\5\24\u00be\n\24"+
		"\3\24\7\24\u00c1\n\24\f\24\16\24\u00c4\13\24\5\24\u00c6\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00d0\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00da\n\25\3\25\3\25\3\25\5\25\u00df\n\25\3\25\5"+
		"\25\u00e2\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ed"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\6\25\u0106\n\25\r\25"+
		"\16\25\u0107\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0112\n\25\3"+
		"\25\7\25\u0115\n\25\f\25\16\25\u0118\13\25\3\25\2\3(\26\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(\2\6\3\2\62\63\3\2\60\61\3\2./\3\2(,\2\u0138"+
		"\2+\3\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\bG\3\2\2\2\nT\3\2\2\2\fZ\3\2\2\2"+
		"\16\\\3\2\2\2\20c\3\2\2\2\22u\3\2\2\2\24}\3\2\2\2\26\u0080\3\2\2\2\30"+
		"\u0083\3\2\2\2\32\u0092\3\2\2\2\34\u0097\3\2\2\2\36\u0099\3\2\2\2 \u00a2"+
		"\3\2\2\2\"\u00a5\3\2\2\2$\u00ac\3\2\2\2&\u00c5\3\2\2\2(\u00ec\3\2\2\2"+
		"*,\5\4\3\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60\7\2\2"+
		"\3\60\3\3\2\2\2\61\64\5\6\4\2\62\64\5\n\6\2\63\61\3\2\2\2\63\62\3\2\2"+
		"\2\64\5\3\2\2\2\65\66\7\b\2\2\66\67\7\34\2\2\679\7 \2\28:\5\22\n\298\3"+
		"\2\2\29:\3\2\2\2:;\3\2\2\2;=\7!\2\2<>\5\b\5\2=<\3\2\2\2=>\3\2\2\2>?\3"+
		"\2\2\2?A\7\35\2\2@B\5\f\7\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE"+
		"\3\2\2\2EF\7\13\2\2F\7\3\2\2\2GH\7\t\2\2HI\7\n\2\2IJ\7\34\2\2JL\7 \2\2"+
		"KM\5$\23\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7!\2\2O\t\3\2\2\2PQ\7\f\2\2"+
		"QU\5\16\b\2RS\7\f\2\2SU\5\20\t\2TP\3\2\2\2TR\3\2\2\2U\13\3\2\2\2VW\7\r"+
		"\2\2W[\5\16\b\2XY\7\r\2\2Y[\5\20\t\2ZV\3\2\2\2ZX\3\2\2\2[\r\3\2\2\2\\"+
		"^\7\34\2\2]_\5\26\f\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\35\2\2ab\5\34"+
		"\17\2b\17\3\2\2\2cd\7\34\2\2df\7 \2\2eg\5\22\n\2fe\3\2\2\2fg\3\2\2\2g"+
		"h\3\2\2\2hj\7!\2\2ik\5\26\f\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lp\7\35\2\2"+
		"mo\5\n\6\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2"+
		"st\5\34\17\2t\21\3\2\2\2uz\5\24\13\2vw\7\36\2\2wy\5\24\13\2xv\3\2\2\2"+
		"y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\23\3\2\2\2|z\3\2\2\2}~\7\34\2\2~\177\5"+
		"\26\f\2\177\25\3\2\2\2\u0080\u0081\7\37\2\2\u0081\u0082\5\30\r\2\u0082"+
		"\27\3\2\2\2\u0083\u008b\5\32\16\2\u0084\u0086\7\"\2\2\u0085\u0087\5(\25"+
		"\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a"+
		"\7#\2\2\u0089\u0084\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\31\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0093\7\16\2"+
		"\2\u008f\u0093\7\17\2\2\u0090\u0093\7\20\2\2\u0091\u0093\7\34\2\2\u0092"+
		"\u008e\3\2\2\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\33\3\2\2\2\u0094\u0098\5\36\20\2\u0095\u0098\5\"\22\2\u0096"+
		"\u0098\5(\25\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2"+
		"\2\2\u0098\35\3\2\2\2\u0099\u009a\7\21\2\2\u009a\u009b\5(\25\2\u009b\u009c"+
		"\7\22\2\2\u009c\u009e\5\34\17\2\u009d\u009f\5 \21\2\u009e\u009d\3\2\2"+
		"\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\13\2\2\u00a1"+
		"\37\3\2\2\2\u00a2\u00a3\7\23\2\2\u00a3\u00a4\5\34\17\2\u00a4!\3\2\2\2"+
		"\u00a5\u00a6\7\24\2\2\u00a6\u00a7\7\25\2\2\u00a7\u00a8\5(\25\2\u00a8\u00a9"+
		"\7\26\2\2\u00a9\u00aa\5\34\17\2\u00aa\u00ab\7\13\2\2\u00ab#\3\2\2\2\u00ac"+
		"\u00b1\5(\25\2\u00ad\u00ae\7\36\2\2\u00ae\u00b0\5(\25\2\u00af\u00ad\3"+
		"\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"%\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00c6\5$\23\2\u00b5\u00b7\7$\2\2\u00b6"+
		"\u00b8\5&\24\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00c2\7%\2\2\u00ba\u00bb\7\36\2\2\u00bb\u00bd\7$\2\2\u00bc"+
		"\u00be\5&\24\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c1\7%\2\2\u00c0\u00ba\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u00b4\3\2\2\2\u00c5\u00b5\3\2\2\2\u00c6\'\3\2\2\2\u00c7\u00c8"+
		"\b\25\1\2\u00c8\u00ed\7\4\2\2\u00c9\u00ed\7\27\2\2\u00ca\u00ed\7\30\2"+
		"\2\u00cb\u00ed\7\31\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00cf\7 \2\2\u00ce"+
		"\u00d0\5$\23\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00ed\7!\2\2\u00d2\u00ed\7\34\2\2\u00d3\u00ed\7\5\2\2\u00d4"+
		"\u00ed\7\32\2\2\u00d5\u00d6\7\33\2\2\u00d6\u00d7\5\30\r\2\u00d7\u00d9"+
		"\7 \2\2\u00d8\u00da\5$\23\2\u00d9\u00d8\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00e1\7!\2\2\u00dc\u00de\7$\2\2\u00dd\u00df\5&\24"+
		"\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2"+
		"\7%\2\2\u00e1\u00dc\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00ed\3\2\2\2\u00e3"+
		"\u00e4\t\2\2\2\u00e4\u00ed\5(\25\f\u00e5\u00e6\7\34\2\2\u00e6\u00e7\7"+
		"\35\2\2\u00e7\u00ed\5(\25\4\u00e8\u00e9\7 \2\2\u00e9\u00ea\5(\25\2\u00ea"+
		"\u00eb\7!\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00c7\3\2\2\2\u00ec\u00c9\3\2"+
		"\2\2\u00ec\u00ca\3\2\2\2\u00ec\u00cb\3\2\2\2\u00ec\u00cc\3\2\2\2\u00ec"+
		"\u00d2\3\2\2\2\u00ec\u00d3\3\2\2\2\u00ec\u00d4\3\2\2\2\u00ec\u00d5\3\2"+
		"\2\2\u00ec\u00e3\3\2\2\2\u00ec\u00e5\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ed"+
		"\u0116\3\2\2\2\u00ee\u00ef\f\13\2\2\u00ef\u00f0\t\3\2\2\u00f0\u0115\5"+
		"(\25\f\u00f1\u00f2\f\n\2\2\u00f2\u00f3\t\4\2\2\u00f3\u0115\5(\25\13\u00f4"+
		"\u00f5\f\t\2\2\u00f5\u00f6\7-\2\2\u00f6\u0115\5(\25\n\u00f7\u00f8\f\b"+
		"\2\2\u00f8\u00f9\t\5\2\2\u00f9\u0115\5(\25\t\u00fa\u00fb\f\7\2\2\u00fb"+
		"\u00fc\7\'\2\2\u00fc\u0115\5(\25\b\u00fd\u00fe\f\6\2\2\u00fe\u00ff\7&"+
		"\2\2\u00ff\u0115\5(\25\7\u0100\u0105\f\5\2\2\u0101\u0102\7\"\2\2\u0102"+
		"\u0103\5(\25\2\u0103\u0104\7#\2\2\u0104\u0106\3\2\2\2\u0105\u0101\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010a\7\35\2\2\u010a\u010b\5(\25\6\u010b\u0115\3"+
		"\2\2\2\u010c\u010d\f\22\2\2\u010d\u010e\7\64\2\2\u010e\u010f\7\34\2\2"+
		"\u010f\u0111\7 \2\2\u0110\u0112\5$\23\2\u0111\u0110\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\7!\2\2\u0114\u00ee\3\2\2\2\u0114"+
		"\u00f1\3\2\2\2\u0114\u00f4\3\2\2\2\u0114\u00f7\3\2\2\2\u0114\u00fa\3\2"+
		"\2\2\u0114\u00fd\3\2\2\2\u0114\u0100\3\2\2\2\u0114\u010c\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117)\3\2\2\2"+
		"\u0118\u0116\3\2\2\2\"-\639=CLTZ^fjpz\u0086\u008b\u0092\u0097\u009e\u00b1"+
		"\u00b7\u00bd\u00c2\u00c5\u00cf\u00d9\u00de\u00e1\u00ec\u0107\u0111\u0114"+
		"\u0116";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}