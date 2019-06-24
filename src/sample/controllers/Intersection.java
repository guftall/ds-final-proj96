package sample.controllers;

import java.util.List;

public class Intersection {

    private List<Intersection> neighbors;

    private TrafficLight trafficLight;
    private boolean hasTrafficLight;

    private double latitude;
    private double longitude;

    private double screenX;
    private double screenY;

    private int id;
    private String name;

    public Intersection(double latitude, double longitude, int id, String name){
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
        this.name = name;
        this.neighbors = new MyArrayList<Intersection>();
    }

    public Intersection(Intersection[] neighbors, double x, double y, int id, String name){
        this(x, y, id, name);
    }


    public void addNeighbor(Intersection ...neighbor){

        for(int i = 0; i<neighbor.length; i++)
            neighbors.add(neighbor[i]);
    }

    public double priceToNeighbor(int neighborId){

        Intersection neighbor = null;

        for(Intersection i : neighbors)
            if(i.getId() == neighborId)
                neighbor = i;
        if(neighbor == null) throw new IllegalArgumentException("no neighbor with this id");

        double x2 = neighbor.getLatitude();
        double y2 = neighbor.getLongitude();

        double x1 = this.latitude;
        double y1 = this.longitude;

        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    public void setTrafficLight(TrafficLight trafficLight){
        hasTrafficLight = true;
        this.trafficLight = trafficLight;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public boolean hasTrafficLight(){
        return hasTrafficLight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setScreenX(double screenX){
        this.screenX = screenX;
    }

    public double getScreenX(){
//        int xx =(int) (latitude *1000000);
//        xx = xx % 100000;
//
//        // map to 0, 1024
//
//        return (xx-City.getInstance().WEST)*((City.getInstance().WIDTH)/(City.getInstance().EAST -City.getInstance().WEST));

        return screenX;
    }

    public void setScreenY(double screenY){
        this.screenY = screenY;
    }

    public double getScreenY(){
//        int yy =(int) (longitude *1000000);
//        yy = yy % 1000000;
//
//        // map to 0, 1024
//        return (yy-City.getInstance().SOUTH)*((City.getInstance().HEIGHT)/(City.getInstance().NORTH -City.getInstance().SOUTH));
        return screenY;
    }

    public List<Intersection> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
