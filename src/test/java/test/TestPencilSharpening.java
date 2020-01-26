package test.java.test;

import main.java.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPencilSharpening {
    private main.java.model.Pencil pencil;

    @Before
    public void setUp() {
        pencil = new Pencil();
    }

    @Test
    public void pencilCanBeCreatedWithLength() {
        pencil = new Pencil(100, 10);
        assertEquals(pencil.getLength(), 10);
    }

    @Test
    public void sharpeningAPencilRestoresItsPointDurability() {
        pencil = new Pencil(100, 10);
        pencil.setPointDurability(0);
        pencil.sharpen();
        assertEquals(pencil.getPointDurability(), 100);
    }

    @Test
    public void pencilShouldDegradeInLengthByOneWhenSharpened() {
        pencil = new Pencil(100, 10);
        pencil.sharpen();
        assertEquals(9, pencil.getLength());

    }

    @Test
    public void pencilShouldNotRegainDurabilityWhenSharpeningAtLengthZero() {
        pencil.setPointDurability(0);
        pencil.setLength(0);
        pencil.sharpen();
        assertEquals(0, pencil.getPointDurability());
    }
}