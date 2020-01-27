package test;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPencilWriting {
	private Pencil pencil;
	private Paper paper;

	@Before
	public void setUp() {
		pencil = new Pencil(100);
		paper = new Paper();
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

