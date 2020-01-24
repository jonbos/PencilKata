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
}