package test.java.test;

import main.java.model.Paper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPaperCreation {
    Paper paper;

    @Before
    public void setUp() {
        paper = new Paper();
    }

    @Test
    public void testPaperIsCreatedWithBlankTextField() {
        assertEquals(paper.getText(), "");
    }

    @Test
    public void testPaperShouldSetTextField() {
        paper.setText("test");
        assertEquals(paper.getText(), "test");
    }
}
