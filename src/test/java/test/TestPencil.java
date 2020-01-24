package test;
import model.Pencil;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPencil {
	Pencil pencil = new Pencil();
	Paper paper = new Paper();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void pencilShouldWriteTextToPaper() {
		pencil.write(paper, "test");
		assertEquals(paper.getText(), "test");
	}
}
