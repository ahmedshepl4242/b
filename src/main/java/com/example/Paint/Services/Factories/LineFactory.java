package com.example.Paint.Services.Factories;

import com.example.Paint.Services.Factories.ShapeFactory;
import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Line;

public class LineFactory extends ShapeFactory {
    @Override
    public IShape CreateShape(double x, double y, double rotationangle, double xscale, double yscale,  String strokecolor, String id, String type, double[] Morefeatures) {
        return new Line(x,y,rotationangle,xscale,yscale,strokecolor,id,type,Morefeatures);
    }
}
