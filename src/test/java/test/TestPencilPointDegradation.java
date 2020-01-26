package test;

import model.Paper;
import model.Pencil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPencilPointDegradation {
    private Pencil pencil;
    private Paper paper;

    @Before
    public void setUp() {
        pencil = new Pencil();
        paper = new Paper();
    }

    @Test
    public void pencilCanBeCreatedWithPointDurability() {
        pencil = new Pencil(100);
        assertEquals(pencil.getPointDurability(), 100);
    }

    @Test
    public void pencilShouldWriteOnlyWhiteSpaceWhenDull() {
        pencil.setPointDurability(0);
        pencil.write(paper, "test");
        assertEquals(paper.getText(), "    ");
    }

    @Test
    public void pencilShouldDegradeByOneWhenWritingLowercaseCharacter() {
        pencil.setPointDurability(1);
        pencil.write(paper, "a");
        assertEquals(0, pencil.getPointDurability());
    }

    @Test
    public void pencilShouldDegradeByTwoWhenWritingUppercaseCharacter() {
        pencil.setPointDurability(2);
        pencil.write(paper, "A");
        assertEquals(0, pencil.getPointDurability());
    }

    @Test
    public void pencilShouldDegradeBySumOfCharsInString() {
        pencil.setPointDurability(5);
        pencil.write(paper, "Test");
        assertEquals(0, pencil.getPointDurability());
        pencil.setPointDurability(4);
        pencil.write(paper, "test");
        assertEquals(0, pencil.getPointDurability());
    }

    @Test
    public void pencilShouldNotDegradeWhenWritingWhitespace() {
        pencil.setPointDurability(1);
        pencil.write(paper, " 	");
        assertEquals(1, pencil.getPointDurability());
    }

    @Test
    public void pencilShouldWriteWhitespaceWhenDullInTheMiddleOfWriteOperation() {
        pencil.setPointDurability(4);
        pencil.write(paper, "Test");
        assertEquals("Tes ", paper.getText());
    }
}