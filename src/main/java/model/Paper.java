package model;

public class Paper {
	private String text;
	public Paper() {
		this.text="";
	}

	public String getText() {
		return this.text;
	}
	public void setText(String text){
		this.text=text;
	}
}