package sample.controllers;

import java.awt.geom.*;
import java.util.List;

public class LatLong {

    private  int  imageW,  imageH;
    private final double west;
    private final double north,
            east,      south;



    public LatLong(int w, int h) {
        west = City.getInstance().WEST;
        north = City.getInstance().NORTH;
        east = City.getInstance().EAST;
        south = City.getInstance().SOUTH;
        imageW = (int) City.getInstance().WIDTH;
        imageH = (int) City.getInstance().HEIGHT;
    }

    public List<Point2D> convertLatLongToCoord (List<Point2D> coordinate) {
        List<Point2D> latLong = new MyArrayList<Point2D>();
        for (int k=0; k<coordinate.size(); k++) {
            double  x = coordinate.get(k).getY();
            double  px = imageW * (x-east) / (west-east);
            double y = coordinate.get(k).getX();
            double py = imageH * (y-north)/(south-north);
            latLong.add (new Point2D.Double(px,py));
        }
        return latLong;
    }

    public static void init () {

        int latlongCount = City.getInstance().getIntersections().size();

        double[] latit = new double[latlongCount],
                longit = new double[latlongCount];

        for(int i=0; i<latlongCount; i++){
            latit[i] = City.getInstance().getIntersections().get(i).getLatitude();
            longit[i] = City.getInstance().getIntersections().get(i).getLongitude();
        }

        List<Point2D> pointList = new MyArrayList<Point2D>();
        for (int i = 0 ; i < latit.length ; i++)
            pointList.add (new Point2D.Double(longit[i], latit[i]));

        List<Point2D> pixels = new LatLong (1024,720).convertLatLongToCoord (pointList);

        for (int i = 0 ; i < latit.length ; i++) {
            City.getInstance().getIntersections().get(i).setScreenX(pixels.get(i).getX());
            City.getInstance().getIntersections().get(i).setScreenY(pixels.get(i).getY());
        }
    }}