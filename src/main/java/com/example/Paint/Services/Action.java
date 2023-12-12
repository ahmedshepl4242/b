package com.example.Paint.Services;


import com.example.Paint.Shapes.Shape;

public class Action {
     String type;

    public Action(Action action) {
        this.type=action.type;
        this.id=action.id;
        this.shape=action.shape;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;
    Shape shape;

    public Action(){

    }

    public String getType() {
        return type;
    }



    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Action(String type, String id, Shape shape) {
        this.type = type;
        this.id = id;
        this.shape = shape;
    }


    public Action(String type, String id) {
        this.type = type;
        this.id = id;
    }



}
