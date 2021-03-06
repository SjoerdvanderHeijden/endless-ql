package nl.uva.js.qlparser.models.ql.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.uva.js.qlparser.models.ql.expressions.data.Variable;
import nl.uva.js.qlparser.ui.components.form.ComponentBuilder;
import nl.uva.js.qlparser.wrappers.arithmetic.CalculatableDouble;
import nl.uva.js.qlparser.wrappers.arithmetic.CalculatableInteger;
import nl.uva.js.qlparser.wrappers.arithmetic.CalculatableMoney;

import javax.swing.*;
import java.time.LocalDate;
import java.util.function.Function;

@RequiredArgsConstructor
public enum DataType {
    DATE(LocalDate::parse, "2000-01-01", ComponentBuilder::buildDateField),
    MONEY(CalculatableMoney::new, "EUR 0", ComponentBuilder::buildMoneyField),
//    Remove the starting and trailing quotes, doing it here enables the visitor to handle all values
    STRING(value -> String.valueOf(value).replaceAll("^\"|\"$", ""), "", ComponentBuilder::buildTextField),
    DECIMAL(CalculatableDouble::new, "0.0", ComponentBuilder::buildTextField),
    BOOLEAN(Boolean::parseBoolean, "false", ComponentBuilder::buildCheckBox),
    INTEGER(CalculatableInteger::new, "0", ComponentBuilder::buildTextField);

    @NonNull @Getter private Function<String, ?> valueOf;
    @NonNull @Getter private String emptyValue;
    @NonNull @Getter private Function<Variable, ? extends JComponent> component;
}