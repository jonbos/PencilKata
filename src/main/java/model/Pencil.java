package model;

public class Pencil {
	private int pointDurability;
	private int initialDurability;
	private int length;
	private Eraser eraser;

	public Pencil() {
		this.pointDurability = 0;
		this.initialDurability = 0;
		this.length = 0;
		this.eraser = null;
	}

	public Pencil(int pointDurability, int length, Eraser eraser) {
		this.pointDurability = pointDurability;
		this.length = length;
		this.initialDurability = pointDurability;
		this.eraser = eraser;
	}

	public Pencil(int pointDurability, int length) {
		this.pointDurability = 0;
		this.length = length;
		this.initialDurability = pointDurability;
	}

	public Pencil(int pointDurability) {
		this.pointDurability = pointDurability;
		this.initialDurability = pointDurability;
	}

	public int getPointDurability() {
		return this.pointDurability;
	}

	public void setPointDurability(int pointDurability) {
		this.pointDurability = pointDurability;
	}

	public void write(Paper paper, String text) {
		for (char c : text.toCharArray()) {
			writeChar(paper, c, paper.getText().length());
		}
	}

	private void writeChar(Paper paper, char c, int index) {
		String text = paper.getText();
		StringBuilder sb = new StringBuilder(text);
		if (isCollision(paper, index)) c = '@';
		if (this.pointDurability <= 0 || calculateWriteCost(c) > this.pointDurability) c = ' ';

		if (index >= text.length()) {
			sb.append(c);
		} else {
			sb.setCharAt(index, c);
		}

		paper.setText(sb.toString());
		pointDurability -= calculateWriteCost(c);
	}

	private int calculateWriteCost(char c) {
		if (Character.isUpperCase(c) || Character.isDigit(c)) {
			return 2;
		} else if (Character.isWhitespace(c)) {
			return 0;
		} else {
			return 1;
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void sharpen() {
		if (getLength() == 0) {
			return;
		}
		pointDurability = initialDurability;
		length -= 1;
	}

	public void erase(Paper paper, String string) {
		this.eraser.erase(paper, string);
	}

	public void edit(Paper paper, String text) {
		int index = paper.getIndexLastErased();
		if (index < 0) {
			write(paper, text);
			return;
		}
		for (char c : text.toCharArray()) {
			writeChar(paper, c, index);
			index += 1;
		}
	}

	private boolean isCollision(Paper paper, int index) {
		try {
			return !(index > paper.getText().length()) && !(Character.isWhitespace(paper.getText().charAt(index)));
		} catch (StringIndexOutOfBoundsException e){
			return false;
		}
	}
}
