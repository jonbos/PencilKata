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
		if (pointDurability<=0){
			paper.setText(StringUtils.repeat(" ", text.length()));
		}
		else{
			paper.setText(paper.getText() + text);
		}
	}
}
