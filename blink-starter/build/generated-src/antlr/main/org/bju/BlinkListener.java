// Generated from org\bju\Blink.g4 by ANTLR 4.7.2

	package org.bju;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BlinkParser}.
 */
public interface BlinkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BlinkParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(BlinkParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(BlinkParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(BlinkParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(BlinkParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#blink_class}.
	 * @param ctx the parse tree
	 */
	void enterBlink_class(BlinkParser.Blink_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#blink_class}.
	 * @param ctx the parse tree
	 */
	void exitBlink_class(BlinkParser.Blink_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#inherits}.
	 * @param ctx the parse tree
	 */
	void enterInherits(BlinkParser.InheritsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#inherits}.
	 * @param ctx the parse tree
	 */
	void exitInherits(BlinkParser.InheritsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_decl}
	 * labeled alternative in {@link BlinkParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(BlinkParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_decl}
	 * labeled alternative in {@link BlinkParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(BlinkParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method_decl}
	 * labeled alternative in {@link BlinkParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(BlinkParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method_decl}
	 * labeled alternative in {@link BlinkParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(BlinkParser.Method_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code member_var_decl}
	 * labeled alternative in {@link BlinkParser#member_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMember_var_decl(BlinkParser.Member_var_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code member_var_decl}
	 * labeled alternative in {@link BlinkParser#member_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMember_var_decl(BlinkParser.Member_var_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code member_method_decl}
	 * labeled alternative in {@link BlinkParser#member_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMember_method_decl(BlinkParser.Member_method_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code member_method_decl}
	 * labeled alternative in {@link BlinkParser#member_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMember_method_decl(BlinkParser.Member_method_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(BlinkParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(BlinkParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(BlinkParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(BlinkParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(BlinkParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(BlinkParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(BlinkParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(BlinkParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#declared_type}.
	 * @param ctx the parse tree
	 */
	void enterDeclared_type(BlinkParser.Declared_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#declared_type}.
	 * @param ctx the parse tree
	 */
	void exitDeclared_type(BlinkParser.Declared_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BlinkParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BlinkParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void enterInt_type(BlinkParser.Int_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void exitInt_type(BlinkParser.Int_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void enterString_type(BlinkParser.String_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void exitString_type(BlinkParser.String_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void enterBool_type(BlinkParser.Bool_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void exitBool_type(BlinkParser.Bool_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code custom_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void enterCustom_type(BlinkParser.Custom_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code custom_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 */
	void exitCustom_type(BlinkParser.Custom_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BlinkParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BlinkParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#blink_if}.
	 * @param ctx the parse tree
	 */
	void enterBlink_if(BlinkParser.Blink_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#blink_if}.
	 * @param ctx the parse tree
	 */
	void exitBlink_if(BlinkParser.Blink_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#blink_else}.
	 * @param ctx the parse tree
	 */
	void enterBlink_else(BlinkParser.Blink_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#blink_else}.
	 * @param ctx the parse tree
	 */
	void exitBlink_else(BlinkParser.Blink_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(BlinkParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(BlinkParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BlinkParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(BlinkParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BlinkParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(BlinkParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressioninit}
	 * labeled alternative in {@link BlinkParser#array_init}.
	 * @param ctx the parse tree
	 */
	void enterExpressioninit(BlinkParser.ExpressioninitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressioninit}
	 * labeled alternative in {@link BlinkParser#array_init}.
	 * @param ctx the parse tree
	 */
	void exitExpressioninit(BlinkParser.ExpressioninitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subexpressioninit}
	 * labeled alternative in {@link BlinkParser#array_init}.
	 * @param ctx the parse tree
	 */
	void enterSubexpressioninit(BlinkParser.SubexpressioninitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subexpressioninit}
	 * labeled alternative in {@link BlinkParser#array_init}.
	 * @param ctx the parse tree
	 */
	void exitSubexpressioninit(BlinkParser.SubexpressioninitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nn}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNn(BlinkParser.NnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nn}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNn(BlinkParser.NnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen_expr(BlinkParser.Paren_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen_expr(BlinkParser.Paren_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNew(BlinkParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNew(BlinkParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayassign}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayassign(BlinkParser.ArrayassignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayassign}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayassign(BlinkParser.ArrayassignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(BlinkParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(BlinkParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(BlinkParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(BlinkParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code function2}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction2(BlinkParser.Function2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code function2}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction2(BlinkParser.Function2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code function1}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction1(BlinkParser.Function1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code function1}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction1(BlinkParser.Function1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code false}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalse(BlinkParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code false}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalse(BlinkParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concat}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConcat(BlinkParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConcat(BlinkParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInt(BlinkParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInt(BlinkParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nil}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNil(BlinkParser.NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nil}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNil(BlinkParser.NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idassign}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdassign(BlinkParser.IdassignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idassign}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdassign(BlinkParser.IdassignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code as}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAs(BlinkParser.AsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code as}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAs(BlinkParser.AsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code checks}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterChecks(BlinkParser.ChecksContext ctx);
	/**
	 * Exit a parse tree produced by the {@code checks}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitChecks(BlinkParser.ChecksContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(BlinkParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(BlinkParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code md}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMd(BlinkParser.MdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code md}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMd(BlinkParser.MdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code true}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrue(BlinkParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code true}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrue(BlinkParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code me}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMe(BlinkParser.MeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code me}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMe(BlinkParser.MeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(BlinkParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(BlinkParser.IdContext ctx);
}