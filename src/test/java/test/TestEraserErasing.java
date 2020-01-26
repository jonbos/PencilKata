package test;

import model.Eraser;
import model.Paper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEraserErasing {
    private Paper paper;
    private Eraser eraser;

    @Before
    public void setUp() {
        paper = new Paper();
        eraser = new Eraser();
    }

    @Test
    public void eraserShouldReplaceTextWithSpaces() {
        eraser.setDurability(1);
        paper.setText("ABC");
        eraser.erase(paper, "B");
        assertEquals("A C", paper.getText());
    }

    @Test
    public void eraserShouldEraseOnlyLastOccurenceOfWord() {
        eraser.setDurability(100);
        paper.setText("How much wood would a woodchuck chuck if a woodchuck would chuck wood");
        eraser.erase(paper, "chuck");
        assertEquals("How much wood would a woodchuck chuck if a woodchuck would       wood", paper.getText());
        eraser.erase(paper, "chuck");
        assertEquals("How much wood would a woodchuck chuck if a wood      would       wood", paper.getText());
    }

    @Test
    public void eraserShouldSetLastErasedPropertyOnPaper() {
        paper.setText("ABC");
        eraser.erase(paper, "B");
        assertEquals(1, paper.getIndexLastErased());
    }

}