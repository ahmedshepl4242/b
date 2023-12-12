package com.example.Paint.Services.Factories;

import com.example.Paint.Shapes.IShape;

public abstract class ShapeFactory
{
    public abstract IShape CreateShape(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double []Morefeatures);

}
