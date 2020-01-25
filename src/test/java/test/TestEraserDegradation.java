package test;

import model.Pencil;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEraserDegradation {
	private Pencil pencil; 
	private Paper paper; 

	@Before
	public void setUp() throws Exception {
		 pencil = new Pencil();
		 paper = new Paper();
    }
    
    @Test
    public void pencilShouldBeCreatedWithValueForEraserDurability() {
        pencil = new Pencil(100, 100, 100);
        assertEquals(100, pencil.getEraserDurability());
    }
    @Test
    public void pencilEraserShouldDegradeByOneWhenErasingCharacter() {
        pencil = new Pencil(100, 100, 100);
        pencil.setEraserDurability(1);
        paper.setText("ABC");
        pencil.erase(paper, "C");
        assertEquals(0, pencil.getEraserDurability());
    }
    @Test
    public void pencilShouldNotEraseIfDurabilityIsZero() {
        pencil = new Pencil(100, 100, 100);
        pencil.setEraserDurability(0);
        paper.setText("ABC");
        pencil.erase(paper, "C");
        assertEquals("ABC", paper.getText());
    }
    @Test
    public void pencilShouldStopErasingRightToLeftWhenDurabilityIsZero() {
        pencil = new Pencil(100, 100, 100);
        pencil.setEraserDurability(3);
        paper.setText("Buffalo Bill");
        pencil.erase(paper, "Bill");
        assertEquals("Buffalo B   ", paper.getText());
    }
}