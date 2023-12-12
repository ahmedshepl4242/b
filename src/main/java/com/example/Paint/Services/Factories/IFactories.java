package com.example.Paint.Services.Factories;

import com.example.Paint.Shapes.IShape;

public interface IFactories {
    public IShape CreateShape(String typeOfFactory,double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures);

}
