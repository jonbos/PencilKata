package model;

public class Pencil {
	private int pointDurability;

	public Pencil() {
		this.pointDurability=0;
	}
	public Pencil(int pointDurability) {
		this.pointDurability=pointDurability;
	}

	public int getPointDurability() {
		return this.pointDurability;
	}

	public void write(Paper paper, String text) {
		paper.setText(paper.getText() + text);
	}

}
