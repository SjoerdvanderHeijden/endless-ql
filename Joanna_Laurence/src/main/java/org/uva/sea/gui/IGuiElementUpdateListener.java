package org.uva.sea.gui;

import org.uva.sea.languages.ql.interpreter.evaluate.valueTypes.Value;

public interface IGuiElementUpdateListener {
    void updateGuiVariable(String identifier, Value value);
}