package com.lab2_5.sligamer.renaissancepaintings;

/**
 * Created by Justin Freres on 2/4/2018.
 * Data Model for a single painting
 */

public class Painting {

    private String mDescription;
    private int mId;

    public Painting(String description, int id){
        mDescription = description;
        mId = id;
    }

    public String getDescription(){
        return mDescription;
    }

    public void setDescription(String description){
        mDescription = description;
    }

    public int getId(){
        return mId;
    }

    public void setId(int id){
        mId = id;
    }
}
