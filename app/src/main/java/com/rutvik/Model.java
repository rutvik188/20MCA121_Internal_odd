package com.rutvik;

public class Model {
    String fName;
    int image;

    public Model(String fName, int image) {
        this.fName = fName;
        this.image = image;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
