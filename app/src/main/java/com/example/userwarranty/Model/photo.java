package com.example.userwarranty.Model;

import java.io.Serializable;

public class photo  implements Serializable {
    private int resourceID; // laays anhr tuwf drawable

    public photo(int resourceID) {
        this.resourceID = resourceID;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }
}
