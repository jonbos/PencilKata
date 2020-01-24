package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Paper;
import model.Pencil;

public class TestPencilSharpening {
	private Pencil pencil; 
	private Paper paper; 

	@Before
	public void setUp() throws Exception {
		 pencil = new Pencil();
		 paper = new Paper();
	}

	@Test
	public void pencilCanBeCreatedWithLength() {
		pencil = new Pencil(100, 10);
		assertEquals(pencil.getLength(), 10);
    }
    @Test
	public void sharpeningAPencilRestoresItsPointDurability() {
        pencil = new Pencil(100, 10);
        pencil.setPointDurability(0);
        pencil.sharpen();
		assertEquals(pencil.getPointDurability(), 100);
	}
}