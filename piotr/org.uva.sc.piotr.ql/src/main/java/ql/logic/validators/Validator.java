package ql.logic.validators;

import ql.error.Error;

public abstract class Validator {

    private Error error;

    public abstract boolean validate();

    public void setError(Error error) {
        this.error = error;
    }

    public String getMessage() {
        return this.error.getMessage();
    }

    public Boolean criticalErrorOccurred() {
        return this.error.getLevel() == Error.Level.CRITICAL;
    }
}
