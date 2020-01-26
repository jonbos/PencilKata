package test;

import model.Eraser;
import model.Paper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEraserDegradation {
    private Paper paper;
    private Eraser eraser;

    @Before
    public void setUp() {
        eraser = new Eraser();
        paper = new Paper();
    }

    @Test
    public void eraserShouldBeCreatedWithValueForEraserDurability() {
        Eraser eraser = new Eraser(100);
        assertEquals(100, eraser.getDurability());
    }

    @Test
    public void pencilEraserShouldDegradeByOneWhenErasingCharacter() {
        eraser.setDurability(1);
        paper.setText("ABC");
        eraser.erase(paper, "C");
        assertEquals(0, eraser.getDurability());
    }

    @Test
    public void pencilShouldNotEraseIfDurabilityIsZero() {
        eraser.setDurability(0);
        paper.setText("ABC");
        eraser.erase(paper, "C");
        assertEquals("ABC", paper.getText());
    }

    @Test
    public void pencilShouldStopErasingRightToLeftWhenDurabilityIsZero() {
        eraser.setDurability(3);
        paper.setText("Buffalo Bill");
        eraser.erase(paper, "Bill");
        assertEquals("Buffalo B   ", paper.getText());
    }
}