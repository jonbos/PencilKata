package model;

public class Pencil {
	private int pointDurability;
	private int initialDurability;
	private int length;

	public Pencil(){
		this.pointDurability=0;
		this.initialDurability=0;

		this.length=0;
	}
	public Pencil(int pointDurability, int length) {
		this.pointDurability=0;
		this.length=length;
		this.initialDurability=pointDurability;
	}
	public Pencil(int pointDurability) {
		this.pointDurability=pointDurability;
		this.initialDurability=pointDurability;
	}

	public int getPointDurability() {
		return this.pointDurability;
	}
	public void setPointDurability(int pointDurability) {
		this.pointDurability = pointDurability;
	}

	public void write(Paper paper, String text) {
		for (char c: text.toCharArray()){
			writeChar(paper, c);
		}
	}
	private void writeChar(Paper paper, char c){
		if (this.pointDurability<=0){
			paper.setText(paper.getText() + ' ');
		} else {
			paper.setText(paper.getText() + c);
		}

		pointDurability -= calculateWriteCost(c);
	}
	private int calculateWriteCost(char c){
		if (Character.isUpperCase(c) || Character.isDigit(c)){
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
		pointDurability=initialDurability;
	}
}
