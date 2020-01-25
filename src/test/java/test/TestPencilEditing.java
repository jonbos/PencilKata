package test;

import model.Pencil;
import model.Paper;
import model.Eraser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPencilEditing {
	private Pencil pencil;
	private Paper paper;

	@Before
	public void setUp() throws Exception {
		pencil = new Pencil(100, 100, new Eraser(100));
		paper = new Paper();
	}

	@Test
	public void eraserShouldSetLastErasedPropertyOnPaper() {
        paper.setText("ABC");
        pencil.erase(paper, "B");
		assertEquals(1, paper.getIndexLastErased());
	}
}

