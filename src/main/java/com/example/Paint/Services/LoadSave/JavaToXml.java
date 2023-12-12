package com.example.Paint.Services.LoadSave;

import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Shape;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaToXml {

    HashMap<String, IShape> save = new HashMap<>();
    XmlMapper xmlMap = new XmlMapper();

    public JavaToXml(HashMap<String, IShape> save) {
        this.save = save;
    }

    public String saveXml() {
        String xmlString = null;

        List<Shape> l = new ArrayList<>();

        for (IShape ele : save.values()) {
            l.add((Shape) ele);
        }
        try {
            xmlString = xmlMap.writeValueAsString(l);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return xmlString;
    }

}
