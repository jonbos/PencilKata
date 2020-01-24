package test;

import model.Pencil;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPencilPointDegradation {
	private Pencil pencil; 
	private Paper paper; 

	@Before
	public void setUp() throws Exception {
		 pencil = new Pencil();
		 paper = new Paper();
	}

	@Test
	public void pencilCanBeCreatedWithPointDurability() {
		pencil = new Pencil(100);
		assertEquals(pencil.getPointDurability(), 100);
	}
	@Test
	public void pencilShouldWriteOnlyWhiteSpaceWhenDull(){
		pencil.setPointDurability(0);
		pencil.write(paper, "test");
		assertEquals(paper.getText(), "    ");
	}
}

