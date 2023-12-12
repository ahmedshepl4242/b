package com.example.Paint.Services.Factories;

import com.example.Paint.Shapes.IShape;

public class Factories implements IFactories {
    private CircleFactory circleFactory = new CircleFactory();
    private RectangleFactory rectangleFactory = new RectangleFactory();
    private LineFactory lineFactory = new LineFactory();
    private EllipseFactory ellipseFactory = new EllipseFactory();
    private SquareFactory squareFactory = new SquareFactory();
    private TriangleFactory triangleFactory = new TriangleFactory();

    @Override
    public IShape CreateShape(String typeOfFactory, double x, double y, double rotationangle, double xscale, double yscale, String fillcolor,  String id, String type, double[] Morefeatures) {
        System.out.println(typeOfFactory);

        switch (typeOfFactory) {
            case "circle":
                return circleFactory.CreateShape(x, y, rotationangle, xscale, yscale, fillcolor,  id, type, Morefeatures);

            case "rectangle":

                return rectangleFactory.CreateShape(x, y, rotationangle, xscale, yscale, fillcolor,  id, type, Morefeatures);

            case "square":

                return squareFactory.CreateShape(x, y, rotationangle, xscale, yscale, fillcolor,  id, type, Morefeatures);

            case "line":

                return lineFactory.CreateShape(x, y, rotationangle, xscale, yscale, fillcolor,  id, type, Morefeatures);

            case "triangle":

                return triangleFactory.CreateShape(x, y, rotationangle, xscale, yscale, fillcolor,  id, type, Morefeatures);

            case "ellipse":

                return ellipseFactory.CreateShape(x, y, rotationangle, xscale, yscale, fillcolor,  id, type, Morefeatures);

        }

        System.out.println("not correct factory");
        return null;
    }
}
