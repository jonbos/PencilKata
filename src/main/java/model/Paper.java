package model;

public class Paper {
    private String text;
    private int indexLastErased;

    public Paper() {
        this.text = "";
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndexLastErased() {
        return this.indexLastErased;
    }

    public void setIndexLastErased(int indexLastErased) {
        this.indexLastErased = indexLastErased;
    }
}