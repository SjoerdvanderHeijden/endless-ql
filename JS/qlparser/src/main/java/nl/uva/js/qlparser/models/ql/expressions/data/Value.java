package nl.uva.js.qlparser.models.ql.expressions.data;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import nl.uva.js.qlparser.models.ql.enums.DataType;
import nl.uva.js.qlparser.wrappers.logic.ValueChangeListener;

@Data
@Builder
public class Value<T> implements DataExpression<T> {
    @NonNull private DataType dataType;
    @NonNull private T value;

    @Override
    public DataType returnCheckedType() {
        return dataType;
    }

    @Override
    public T value() {
        return this.getValue();
    }

    @Override
    public void addChangeListener(ValueChangeListener ignored) {}
}
