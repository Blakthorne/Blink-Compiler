// Generated from org\bju\Blink.g4 by ANTLR 4.7.2

	package org.bju;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BlinkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BlinkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BlinkParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(BlinkParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(BlinkParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#blink_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlink_class(BlinkParser.Blink_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#inherits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInherits(BlinkParser.InheritsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_decl}
	 * labeled alternative in {@link BlinkParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(BlinkParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method_decl}
	 * labeled alternative in {@link BlinkParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(BlinkParser.Method_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code member_var_decl}
	 * labeled alternative in {@link BlinkParser#member_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_var_decl(BlinkParser.Member_var_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code member_method_decl}
	 * labeled alternative in {@link BlinkParser#member_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_method_decl(BlinkParser.Member_method_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(BlinkParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(BlinkParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(BlinkParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(BlinkParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#declared_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclared_type(BlinkParser.Declared_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BlinkParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_type(BlinkParser.Int_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_type(BlinkParser.String_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_type(BlinkParser.Bool_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code custom_type}
	 * labeled alternative in {@link BlinkParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustom_type(BlinkParser.Custom_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BlinkParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#blink_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlink_if(BlinkParser.Blink_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#blink_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlink_else(BlinkParser.Blink_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(BlinkParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BlinkParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(BlinkParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressioninit}
	 * labeled alternative in {@link BlinkParser#array_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressioninit(BlinkParser.ExpressioninitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subexpressioninit}
	 * labeled alternative in {@link BlinkParser#array_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpressioninit(BlinkParser.SubexpressioninitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nn}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNn(BlinkParser.NnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_expr(BlinkParser.Paren_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code new}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew(BlinkParser.NewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayassign}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayassign(BlinkParser.ArrayassignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(BlinkParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(BlinkParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function2}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction2(BlinkParser.Function2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code function1}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction1(BlinkParser.Function1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(BlinkParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(BlinkParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(BlinkParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nil}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil(BlinkParser.NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idassign}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdassign(BlinkParser.IdassignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code as}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAs(BlinkParser.AsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code checks}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChecks(BlinkParser.ChecksContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(BlinkParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code md}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMd(BlinkParser.MdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(BlinkParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code me}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMe(BlinkParser.MeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link BlinkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(BlinkParser.IdContext ctx);
}