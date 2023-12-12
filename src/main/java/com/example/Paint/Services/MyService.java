package com.example.Paint.Services;

import com.example.Paint.Services.Factories.Factories;
import com.example.Paint.Services.Factories.IFactories;
import com.example.Paint.Services.LoadSave.LoadSave;
import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Shape;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class MyService {

    public static HashMap<String, IShape> mp = new HashMap<>();

    public static IFactories factry = new Factories();

    private IUndoRedo undeRedo = new UndoRedo();

    private Action action;


    private LoadSave loadSave = new LoadSave();

    public List<String> getData() {
        List<String> l = new ArrayList<>();

        for (IShape ele : mp.values()) {
            l.add(ele.toString());
        }
        return l;
    }


    public String getShape(String id) {

        //we get shape from hashmap by id


        Shape shape = (Shape) mp.get(id);

        System.out.println(shape);
        if (shape == null) {
            return "NOTFOUND";
        }

        return shape.toString();

    }

    public String copy(copyid ID) {
        String old_id = ID.getOldID();
        String new_id = ID.getNewID();

        System.out.println(old_id + "    " + new_id);

        Shape shape = (Shape) mp.get(old_id);

        if (shape == null) {
            return "not found";
        }


        mp.put(new_id, factry.CreateShape(shape.getType(), shape.getX(), shape.getY(), shape.getRotationangle(), shape.getXscale(), shape.getYscale(), shape.getFillcolor(), new_id, shape.getType(), shape.getMorefeatures()));


        Action act = new Action("create", new_id, (Shape) (mp.get(new_id)));
        this.undeRedo.storeAction(act);


        return "good";
    }

    public String CreateShape(Shape shape) {
//        System.out.println("i am here i hear you");


        double x = shape.getX();
        double y = shape.getY();
        double rotationAngle = shape.getRotationangle();
        double xScale = shape.getXscale();
        double yScale = shape.getYscale();
        String fillColor = shape.getFillcolor();
        String id = shape.getId();
        String type = shape.getType();
        double m[] = shape.getMorefeatures();


        mp.put(id, factry.CreateShape(shape.getType(), x, y, rotationAngle, xScale, yScale, fillColor, id, type, m));


        // undo and redo part
        Action act = new Action("create", id, (Shape) (mp.get(id)));
        this.undeRedo.storeAction(act);

        return "CreatingShapes...";
    }

    public String updateShape(Shape shape) {


        double x = shape.getX();
        double y = shape.getY();
        double rotationAngle = shape.getRotationangle();
        double xScale = shape.getXscale();
        double yScale = shape.getYscale();
        String fillColor = shape.getFillcolor();
        String id = shape.getId();
        String type = shape.getType();
        double m[] = shape.getMorefeatures();


        // undo and redo part
        Action act = new Action("ShapeAttributes", id, new Shape((Shape) mp.get(id)));
        this.undeRedo.storeAction(act);


        System.out.println(act.shape.toString());

        shape = (Shape) mp.get(id);
        if (shape == null) {
            return "NOTFOUND";
        }

        shape.draw(x, y, rotationAngle, xScale, yScale, fillColor, id, type, m);


        System.out.println(act.shape.toString());


        mp.put(id, shape);


        return "MODIFIED";
    }

    public void refresh() {
        mp.clear();
        this.undeRedo.refresh();
    }

    public String DeleteShape(uuid id_string) {

//        System.out.println(id_string.getId());

        String id = id_string.getId();

//        System.out.println(id + "  deleteeeeeee");


        IShape shape = mp.get(id);
        if (shape == null) {
            return "NOTFOUND";
        }

        // undo and redo part
        Action act = new Action("delete", id, (Shape) (mp.get(id)));
        this.undeRedo.storeAction(act);


        mp.remove(id);
        return "DELETED";

    }

    public void undo() {
        this.action = this.undeRedo.undo();
    }

    public void redo() {
        this.action = this.undeRedo.redo();
    }

    public Action getAction() {
        return this.action;
    }


    public String savexml() throws JsonProcessingException {
        return loadSave.Savexml(mp);
    }

    public String savejson() throws JsonProcessingException {
        return loadSave.Savejson(mp);

    }

    public List<Shape> loadjson(String jsonString) throws IOException {
        this.refresh();

        HashMap<String,IShape> m = loadSave.loadjson(jsonString).getHashMap();
        for (HashMap.Entry<String, IShape> entry : m.entrySet()) {
            mp.put(entry.getKey(), entry.getValue());
        }


        List<Shape> l = new ArrayList<>();

        for (IShape ele : mp.values()) {
            l.add((Shape) ele);
        }
        return l;

    }

    public List<Shape> loadxml(String xmlString) throws IOException {
        this.refresh();
//        mp =new HashMap<>(loadSave.loadXml(xmlString).getHashMap()) ;

        HashMap<String,IShape> m = loadSave.loadXml(xmlString).getHashMap();

        for (HashMap.Entry<String, IShape> entry : m.entrySet()) {
            mp.put(entry.getKey(), entry.getValue());
        }


        List<Shape> l = new ArrayList<>();

        for (IShape ele : mp.values()) {
            l.add((Shape) ele);
        }
        return l;
    }

}
