package com.example.Paint.Services.LoadSave;

import com.example.Paint.Shapes.IShape;

import java.util.HashMap;

public class Storage {

  public static HashMap<String, IShape> hashMap=new HashMap<>();

    public  HashMap<String, IShape> getHashMap() {
        return hashMap;
    }

    public  void setHashMap(HashMap<String, IShape> hashMap) {
        Storage.hashMap = hashMap;

    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}
