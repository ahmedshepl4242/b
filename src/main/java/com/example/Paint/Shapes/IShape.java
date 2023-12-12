package com.example.Paint.Shapes;


public interface IShape extends Cloneable {

    public Shape MakeCopy();
    public  void draw(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures);

}
