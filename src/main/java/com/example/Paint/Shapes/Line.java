package com.example.Paint.Shapes;

public class Line extends Shape {

    public Line(double x, double y, double rotationangle, double xscale, double yscale, String fillcolor, String id, String type, double[] Morefeatures) {
        super(x, y, rotationangle, xscale, yscale, fillcolor, id, "line", Morefeatures);
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
        Line line=null;
        try {
            line=(Line) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return line;

    }
}
