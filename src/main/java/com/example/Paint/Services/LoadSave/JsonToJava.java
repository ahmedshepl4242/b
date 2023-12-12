package com.example.Paint.Services.LoadSave;


import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Shape;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class JsonToJava
{
    ObjectMapper objectMapper = new ObjectMapper();
   Storage loadjson(String jsonString) throws IOException
    {

            Storage storage=new Storage();

        List<Shape> shapes = objectMapper.readValue(jsonString, new TypeReference<List<Shape>>() {});

        HashMap<String, IShape> hashMap=new HashMap<>();
        for(Shape shape:shapes)
        {
            hashMap.put( shape.getId(),shape);
        }
        storage.setHashMap(hashMap);
        return storage ;
    }


}
