package test;

import model.Pencil;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPencilErasing {
	private Pencil pencil; 
	private Paper paper; 

	@Before
	public void setUp() throws Exception {
		 pencil = new Pencil();
		 paper = new Paper();
    }
    
    @Test
    public void pencilShouldReplaceTextWithSpaces() {
        pencil = new Pencil(10);
        paper.setText("ABC");
        pencil.erase(paper, "B");
        assertEquals("A C", paper.getText());
    }
}