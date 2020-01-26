package main.java.model;

public class Eraser {
    private int durability;

    public Eraser(int durability) {
        this.durability = durability;
    }

    public Eraser() {
        this.durability = 0;
    }

    public void erase(Paper paper, String string) {
        int index = paper.getText().lastIndexOf(string);

        if (index < 0) {
            return;
        }

        for (int i = string.length() - 1; i >= 0; i--) {
            eraseChar(paper, index + i);
        }
    }

    private void eraseChar(Paper paper, int index) {
        if (durability > 0) {
            String oldText = paper.getText();
            String newText = oldText.substring(0, index) + " " + oldText.substring(index + 1);
            durability -= 1;
            paper.setText(newText);
            paper.setIndexLastErased(index);
        }
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

}