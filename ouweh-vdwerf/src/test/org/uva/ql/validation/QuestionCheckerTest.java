package org.uva.ql.validation;

import org.junit.Before;
import org.junit.Test;
import org.uva.app.LogHandler;
import org.uva.ql.ast.Question;
import org.uva.ql.ast.type.BooleanType;
import org.uva.ql.ast.type.IntegerType;
import org.uva.ql.ast.type.StringType;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuestionCheckerTest {

    private LogHandler logHandler;

    @Before
    public void setUp() {
        Logger logger = Logger.getGlobal();
        LogManager.getLogManager().reset();
        this.logHandler = new LogHandler();
        logger.addHandler(logHandler);
    }

    @Test
    public void runCheck() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1", "v1", new BooleanType()));
        questions.add(new Question("Q2", "v2", new IntegerType()));
        questions.add(new Question("Q3", "v3", new StringType()));
        QuestionChecker questionChecker = new QuestionChecker(questions);
        questionChecker.runCheck();

        assertFalse(this.logHandler.hasWarnings());
    }

    @Test
    public void runCheckDuplicateName() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1", "v1", new BooleanType()));
        questions.add(new Question("Q1", "v2", new IntegerType()));
        QuestionChecker questionChecker = new QuestionChecker(questions);
        questionChecker.runCheck();

        assertTrue(this.logHandler.hasWarnings());
    }

    @Test
    public void runCheckDuplicateContent() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1", "v1", new BooleanType()));
        questions.add(new Question("Q2", "v1", new IntegerType()));
        QuestionChecker questionChecker = new QuestionChecker(questions);
        questionChecker.runCheck();

        assertTrue(this.logHandler.hasWarnings());
    }
}