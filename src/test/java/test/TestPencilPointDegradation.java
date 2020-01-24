package test;

import model.Pencil;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPencilPointDegradation {
	Pencil pencil = new Pencil();
	Paper paper = new Paper();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void pencilCanBeCreatedWithPointDurability() {
		pencil = new Pencil(100);
		assertEquals(pencil.getPointDurability(), 100);
	}
}

