package com.example.Paint.Shapes;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class sh
{
    private double  x, y, rotationangle, xscale, yscale;
    private String fillcolor;
    private String id;
    private String type;
//    private double[] morefeatures = new double[2];

    public double getX() {
        return x;
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
        return rotationangle;
    }

    public void setRotationangle(double rotationangle) {
        this.rotationangle = rotationangle;
    }

    public double getXscale() {
        return xscale;
    }

    public void setXscale(double xscale) {
        this.xscale = xscale;
    }

    public double getYscale() {
        return yscale;
    }

    public void setYscale(double yscale) {
        this.yscale = yscale;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public double[] getMorefeatures() {
//        return morefeatures;
//    }
//
//    public void setMorefeatures(double[] morefeatures) {
//        this.morefeatures = morefeatures;
//    }
}
