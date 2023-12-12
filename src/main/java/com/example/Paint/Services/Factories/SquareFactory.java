package com.example.Paint.Services.Factories;

import com.example.Paint.Services.Factories.ShapeFactory;
import com.example.Paint.Shapes.IShape;
import com.example.Paint.Shapes.Square;

public class SquareFactory extends ShapeFactory {

    @Override
    public IShape CreateShape(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor,  String id, String type, double[] Morefeatures) {
        return new Square(x,y,rotationangle,xscale,yscale,fillcolor,id,type,Morefeatures);
    }
}
