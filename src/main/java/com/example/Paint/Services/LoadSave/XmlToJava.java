package com.example.Paint.Services.LoadSave;


import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Shape;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class XmlToJava
{


    public  Storage loadXml(String xmlString) throws  IOException {
        Storage storage=new Storage();

        XmlMapper xmlMap = new XmlMapper();

        //System.out.println(xmlString);
        ArrayList<Shape> shapes = xmlMap.readValue(xmlString, xmlMap.getTypeFactory().constructCollectionType(ArrayList.class, Shape.class));
        HashMap<String, IShape>hashMap=new HashMap<>();
        for(Shape shape:shapes)
        {
            hashMap.put( shape.getId(),shape);
        }
        storage.setHashMap(hashMap);
        return storage ;
    }
}
