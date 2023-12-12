package com.example.Paint.Shapes;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jdk.jfr.DataAmount;
import lombok.Builder;
import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Shape implements IShape {
    private double x, y, Rotationangle, Xscale, Yscale;
    private String fillcolor;
    private String id;
    private String type;
    private double[] Morefeatures = new double[2];

    public  Shape(Shape sh){
        this.x = sh.x;
        this.y = sh.y;
        Rotationangle = sh.Rotationangle;
        Xscale = sh.Xscale;
        Yscale = sh.Yscale;
        this.fillcolor = sh.fillcolor;

        this.id = sh.id;
        this.type = sh.type;
        this.Morefeatures = sh.Morefeatures;
    }

    public Shape(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures) {
        this.x = x;
        this.y = y;
        Rotationangle = rotationangle;
        Xscale = xscale;
        Yscale = yscale;
        this.fillcolor = fillcolor;

        this.id = id;
        this.type = type;
        this.Morefeatures = Morefeatures;
    }
    public  Shape()
    {

    }

    public double[] getMorefeatures() {
        return Morefeatures;
    }

    public void setMorefeatures(double[] morefeatures) {
        Morefeatures = morefeatures;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }


    public double getXscale() {
        return Xscale;
    }

    public void setXscale(double xscale) {
        Xscale = xscale;
    }

    public double getYscale() {
        return Yscale;
    }

    public void setYscale(double yscale) {
        Yscale = yscale;
    }


    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRotationangle() {
        return Rotationangle;
    }

    public void setRotationangle(double rotationangle) {
        Rotationangle = rotationangle;
    }

    public String getFillcolor() {
        return fillcolor;
    }

    public void setFillcolor(String fillcolor) {
        this.fillcolor = fillcolor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {

//            double[] m=this.getMorefeatures();
        return "{" +
                "\"" + "x" + "\":" + x + "," +
                "\"" + "y" + "\":" + y + "," +
                "\"" + "Rotationangle" + "\":" + Rotationangle + "," +
                "\"" + "xScale" + "\":" + Xscale + "," +
                "\"" + "yScale" + "\":" + Yscale + "," +
                "\"" + "fillColor" + "\":" + "\"" + fillcolor + "\"" + "," +
                "\"" + "id" + "\":" + id + "," +
                "\"" + "type" + "\":" + "\"" + type + "\"" + "," +
//                "\"" + "MoreF[0]" + "\":" + "\"" + m[0] + "\"" + ","+
//                "\"" + "MoreF[1]" + "\":" + "\"" + m[1] + "\"" + ","+
                '}';


    }

    @Override
    public Shape MakeCopy() {
        Shape shape = null;
        try {
            shape = (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return shape;
    }


    @Override
    public void draw(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures) {
        this.setX(x);
        this.setY(y);
        this.setRotationangle(rotationangle);
        this.setXscale(xscale);
        this.setYscale(yscale);
        this.setFillcolor(fillcolor);
        this.setId(id);
        this.setType(type);
        this.setMorefeatures(Morefeatures);
    }
}

