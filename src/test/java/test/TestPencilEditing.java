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
	public void setUp()  {
		pencil = new Pencil(100, 100, new Eraser(100));
		paper = new Paper();
	}

}

