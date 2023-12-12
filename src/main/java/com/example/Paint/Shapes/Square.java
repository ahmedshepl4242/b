package com.example.Paint.Shapes;

public class Square extends Shape {
    public Square(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures) {
        super(x, y, rotationangle, xscale, yscale, fillcolor, id, type, Morefeatures);
    }

    @Override
    public void draw(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures)
    {
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
    @Override
    public Shape MakeCopy()
    {
        Square square=null;
        try {
            square=(Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return square;

    }
}
