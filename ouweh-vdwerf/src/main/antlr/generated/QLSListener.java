// Generated from QLS.g4 by ANTLR 4.7.1

package antlr.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSParser}.
 */
public interface QLSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(QLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(QLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QLSParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QLSParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(QLSParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(QLSParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#defaultStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStatement(QLSParser.DefaultStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#defaultStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStatement(QLSParser.DefaultStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterWidget(QLSParser.WidgetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitWidget(QLSParser.WidgetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code radio}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterRadio(QLSParser.RadioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code radio}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitRadio(QLSParser.RadioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code checkbox}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterCheckbox(QLSParser.CheckboxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code checkbox}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitCheckbox(QLSParser.CheckboxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dropdown}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterDropdown(QLSParser.DropdownContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dropdown}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitDropdown(QLSParser.DropdownContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slider}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterSlider(QLSParser.SliderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slider}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitSlider(QLSParser.SliderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void enterText(QLSParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link QLSParser#widgetType}.
	 * @param ctx the parse tree
	 */
	void exitText(QLSParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(QLSParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(QLSParser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntegerType(QLSParser.IntegerTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntegerType(QLSParser.IntegerTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moneyType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMoneyType(QLSParser.MoneyTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moneyType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMoneyType(QLSParser.MoneyTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringType(QLSParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link QLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringType(QLSParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(QLSParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(QLSParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#styleProperty}.
	 * @param ctx the parse tree
	 */
	void enterStyleProperty(QLSParser.StylePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#styleProperty}.
	 * @param ctx the parse tree
	 */
	void exitStyleProperty(QLSParser.StylePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(QLSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(QLSParser.ValueContext ctx);
}