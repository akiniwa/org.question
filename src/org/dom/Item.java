package org.dom;

public class Item {
    private String text;
    private boolean checked;

    public Item(String text) {
        super();
        this.text = text;
        this.checked = false;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    public boolean getChecked() {
        return this.checked;
    }
}
