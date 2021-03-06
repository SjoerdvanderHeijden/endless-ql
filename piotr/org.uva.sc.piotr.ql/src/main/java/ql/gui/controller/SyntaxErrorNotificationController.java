package ql.gui.controller;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import ql.gui.view.ErrorMessageView;
import ql.gui.view.WindowView;

public class SyntaxErrorNotificationController extends BaseErrorListener {

    private final WindowView windowView;
    private Boolean foundSyntaxError = false;

    public SyntaxErrorNotificationController(WindowView windowView) {
        this.windowView = windowView;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        this.foundSyntaxError = true;
        ErrorMessageView.showErrorDialog(this.windowView, "Parse error", msg + ". Line " + line + ", column " + charPositionInLine + ".");
    }

    public Boolean getFoundSyntaxError() {
        return foundSyntaxError;
    }
}