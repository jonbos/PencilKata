package test;
import model.Paper;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPaperCreation {
	Paper paper = new Paper();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPaperIsCreatedWithBlankTextField() {
		assertEquals(paper.getText(), "");
	}

	@Test
	public void testPaperShouldSetTextField(){
		paper.setText("test");
		assertEquals(paper.getText(), "test");
	}
}
