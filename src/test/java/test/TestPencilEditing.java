package test.java.test;

import main.java.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPencilEditing {
	private Pencil pencil;
	private Paper paper;

	@Before
	public void setUp() {
		pencil = new Pencil(100, 100, new Eraser(100));
		paper = new Paper();
	}

	@Test
	public void pencilShouldEditTextIntoLastErasedIndex() {
		paper.setText("An apple a day keeps the doctor away");
		pencil.erase(paper, "apple");
		pencil.edit(paper, "onion");
		assertEquals("An onion a day keeps the doctor away", paper.getText());
	}

	@Test
	public void pencilShouldWriteSpecialCharWhenCollisionHappensInEdit() {
		paper.setText("An apple a day keeps the doctor away");
		pencil.erase(paper, "apple");
		pencil.edit(paper, "artichoke");
		assertEquals("An artich@k@ay keeps the doctor away", paper.getText());

	}
}

