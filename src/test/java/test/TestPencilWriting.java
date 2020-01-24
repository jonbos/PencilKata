package test;

import model.Pencil;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPencilWriting {
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

	@Test
	public void pencilShouldAppendTextToPaper() {
		paper.setText("existing text ");
		pencil.write(paper, "new text");
		assertEquals(paper.getText(), "existing text new text");
	}
}

