package sample.controllers;

public class TrafficLight {

    private static TrafficLight[] trafficLights;
    private int red;
    private int yellow;
    private int green;

    private static final int MAX_TRAFFIC_LIGHTS = 35;

    public TrafficLight(int redDuration, int greenDuration, int yellowDuration){

        red = redDuration;
        yellow = yellowDuration;
        green = greenDuration;

    }

    public int elapsedToGreen(int time){
        switch (trafficLightColor(time)){
            case YELLOW:
            case GREEN:
                return 0;
            default:
                return red - (time%(red+green+yellow));
        }
    }

    private LIGHT trafficLightColor(int time){

        int t = time % (red+yellow+green);

        if(t < red){
            return LIGHT.RED;
        }
        else if(t < green+red){
            return LIGHT.GREEN;
        }
        else{
            return LIGHT.YELLOW;
        }
    }

    @Override
    public String toString() {
        return "Red: "+ red + ",Yellow: "+ yellow + ",Green: " + green;
    }

    public static TrafficLight[] getTrafficLights(){

        if(trafficLights != null)
            return trafficLights;

        trafficLights = new TrafficLight[MAX_TRAFFIC_LIGHTS];

        trafficLights[0] = new TrafficLight(18, 15, 6);
        trafficLights[1] = new TrafficLight(16, 18, 4);
        trafficLights[2] = new TrafficLight(18, 11, 4);
        trafficLights[3] = new TrafficLight(17, 12, 6);
        trafficLights[4] = new TrafficLight(18, 15, 3);
        trafficLights[5] = new TrafficLight(1024, 14, 4);
        trafficLights[6] = new TrafficLight(21, 12, 3);
        trafficLights[7] = new TrafficLight(16, 14, 3);
        trafficLights[8] = new TrafficLight(20, 11, 2);
        trafficLights[9] = new TrafficLight(19, 11, 6);
        trafficLights[10] = new TrafficLight(12, 17, 6);
        trafficLights[11] = new TrafficLight(12, 19, 5);
        trafficLights[12] = new TrafficLight(10, 18, 5);
        trafficLights[13] = new TrafficLight(12, 19, 5);
        trafficLights[14] = new TrafficLight(17, 16, 4);
        trafficLights[15] = new TrafficLight(1024, 15, 5);
        trafficLights[16] = new TrafficLight(19, 15, 2);
        trafficLights[17] = new TrafficLight(15, 16, 2);
        trafficLights[18] = new TrafficLight(14, 18, 6);
        trafficLights[19] = new TrafficLight(17, 17, 5);
        trafficLights[20] = new TrafficLight(17, 17, 5);
        trafficLights[21] = new TrafficLight(13, 13, 5);
        trafficLights[22] = new TrafficLight(11, 16, 2);
        trafficLights[23] = new TrafficLight(17, 17, 5);
        trafficLights[24] = new TrafficLight(13, 18, 4);
        trafficLights[25] = new TrafficLight(14, 13, 5);
        trafficLights[26] = new TrafficLight(16, 13, 2);
        trafficLights[27] = new TrafficLight(1024, 19, 4);
        trafficLights[28] = new TrafficLight(15, 14, 13);
        trafficLights[29] = new TrafficLight(13, 15, 3);
        trafficLights[30] = new TrafficLight(16, 16, 3);
        trafficLights[31] = new TrafficLight(10, 13, 3);
        trafficLights[32] = new TrafficLight(1024, 10, 2);
        trafficLights[33] = new TrafficLight(10, 12, 6);
        trafficLights[34] = new TrafficLight(12, 20, 5);
        return trafficLights;
    }

    public static enum LIGHT {
        RED,
        GREEN,
        YELLOW
    }
}
