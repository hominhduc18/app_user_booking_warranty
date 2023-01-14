package com.example.userwarranty.models.Image;

public class Photo {
    private int resourceID; // laays anhr tuwf drawable

    public Photo(int resourceID) {
        this.resourceID = resourceID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }
}
