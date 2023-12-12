package com.example.Paint.Services.LoadSave;

import com.example.Paint.Shapes.IShape;
import com.fasterxml.jackson.core.JsonProcessingException;


import java.io.IOException;
import java.util.HashMap;

public class LoadSave {




    public Storage loadXml(String xmlString) throws IOException
    {
        XmlToJava xmlToJava=new XmlToJava();
        return xmlToJava.loadXml(xmlString);

    }
    public Storage loadjson(String jsonString) throws IOException {
        JsonToJava jsonToJava=new JsonToJava();

        return  jsonToJava.loadjson(jsonString);
    }

    public String Savexml(HashMap<String, IShape> save)throws JsonProcessingException {

        JavaToXml javaToXml=new JavaToXml(save);

        return javaToXml.saveXml();


    }
    public String Savejson(HashMap<String, IShape> save)throws JsonProcessingException {

        JavaToJson javaToJson=new JavaToJson(save);

        return javaToJson.Save();


    }

}
