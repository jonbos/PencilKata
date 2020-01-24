package model;
import org.apache.commons.lang.StringUtils;

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
		if (Character.isUpperCase(c)){
			pointDurability-=2;
		} else if (Character.isWhitespace(c)) {
			return;
		} else {
			pointDurability -= 1;
		}
	}
}
