package com.example.Paint.Services.LoadSave;

import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Shape;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.transform.sax.SAXResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JavaToJson {

    HashMap<String, IShape> save = new HashMap<>();
    public JavaToJson(HashMap<String, IShape> save)
    {

        this.save = save;

    }
        ObjectMapper objectMapper = new ObjectMapper();

        String Save() throws JsonProcessingException {

            List<Shape> l = new ArrayList<>();

            for (IShape ele : save.values()) {
                l.add((Shape) ele);
            }
            String json = objectMapper.writeValueAsString(l);

            return json;

        }
}

