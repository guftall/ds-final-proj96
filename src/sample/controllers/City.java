package sample.controllers;


import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

public class City {

    private List<Intersection> intersections;

    private Map<Intersection, List<Intersection>> adjacency_matrix;

    private static City that;

    public final double WEST;
    public final double NORTH;
    public final double EAST;
    public final double SOUTH;

    public final double WIDTH = 696;
    public final double HEIGHT = 440;

    private City(){

        adjacency_matrix = new HashMap<Intersection, List<Intersection>>();
        intersections = new MyArrayList<Intersection>();
        init();

        double minx = intersections.get(0).getLatitude();
        double maxx = intersections.get(0).getLatitude();
        double miny = intersections.get(0).getLongitude();
        double maxy = intersections.get(0).getLongitude();

        for(int i=1; i<intersections.size(); i++){
            if(intersections.get(i).getLatitude() > maxx)
                maxx = intersections.get(i).getLatitude();

            if(intersections.get(i).getLongitude() > maxy)
                maxy = intersections.get(i).getLongitude();


            if(intersections.get(i).getLatitude() < minx)
                minx = intersections.get(i).getLatitude();

            if(intersections.get(i).getLongitude() < miny)
                miny = intersections.get(i).getLongitude();
        }

        WEST = minx;
        SOUTH = miny;
        EAST = maxx;
        NORTH = maxy;

    }

    public static City getInstance(){
        if(that == null) that = new City();
        return that;
    }


    private void init(){

        Intersection i0 = new Intersection(28.957702, 50.837371, 0, "میدان امام");
        Intersection i1 = new Intersection(28.958820, 50.854620, 1, "میدان باغ زهرا");
        Intersection i2 = new Intersection(28.957412, 50.830583, 2, "سه راه عاشوری");
        Intersection i3 = new Intersection(28.957263, 50.827566, 3, "امام رضا");
        Intersection i4 = new Intersection(28.957999, 50.849510, 4, "سه راه بازرگانی");
        Intersection i5 = new Intersection(28.966765, 50.843704, 5, "میدان بهشت صادق");
        Intersection i6 = new Intersection(28.957553, 50.845635, 6, "سه راه هلالی");
        Intersection i7 = new Intersection(28.957662, 50.843134, 7, "سه راه باهنر");
        Intersection i8 = new Intersection(28.963824, 50.821801, 8, "میدان نیروی انتظامی");
        Intersection i9 = new Intersection(28.976539, 50.834811, 9, "میدان قدس");
        Intersection i10 = new Intersection(28.97524, 50.828373, 10, "میدان شهرداری");
        Intersection i11 = new Intersection(28.977419, 50.838696, 11, "چهارراه کشتی رانی");
        Intersection i12 = new Intersection(28.978424, 50.842349, 12, "چهارراه شیلات");
        Intersection i13 = new Intersection(28.974125, 50.840211, 13, "چهارراه فضیلت");
        Intersection i14 = new Intersection(28.969900, 50.841968, 14, "چهارراه توحید");
        Intersection i15 = new Intersection(28.968676, 50.836707, 15, "بسیج مرکزی");
        Intersection i16 = new Intersection(28.974773, 50.826413, 16, "میدان رئیس علی دلواری");
        Intersection i17 = new Intersection(28.984530, 50.829340, 17, "میدان معلم");
        Intersection i18 = new Intersection(28.988302, 50.833085, 18, "میدان انقلاب");
        Intersection i19 = new Intersection(28.993894, 50.832196, 19, "میدان گمرک");
        Intersection i20 = new Intersection(28.979859, 50.833594, 20, "علوم پزشکی");
        Intersection i21 = new Intersection(28.982650, 50.832574, 21, "پمپ بنزین شهر");
        Intersection i22 = new Intersection(28.982338, 50.831232, 22, "چهارراه دادگستری");
        Intersection i23 = new Intersection(28.993264, 50.828364, 23, "پارک TV");
        Intersection i24 = new Intersection(28.950829, 50.837874, 24, "چهارراه بیسیم");
        Intersection i25 = new Intersection(28.951129, 50.842605, 25, "میدان باهنر");
        Intersection i26 = new Intersection(28.962116, 50.836976, 26, "ملاصدرا (س)");
        Intersection i27 = new Intersection(28.967218, 50.836593, 27, "یادگار امام (س)");
        Intersection i28 = new Intersection(28.966939, 50.831068, 28, "یادگار امام (ع)");
        Intersection i29 = new Intersection(28.963250, 50.843355, 29, "ملاصدرا (ه)");
        Intersection i30 = new Intersection(28.968663, 50.848376, 30, "فتح المبین (ص)");
        Intersection i31 = new Intersection(28.983564, 50.835349, 31, "چهارراه ولی عصر");
        Intersection i32 = new Intersection(28.975562, 50.830437, 32, "سه راه عاشوری (د)");
        Intersection i33 = new Intersection(28.971372, 50.846068, 33, "صلح آباد");
        Intersection i34 = new Intersection(28.972248, 50.836073, 34, "سه راه اتکا");

        intersections.add(i0);
        intersections.add(i1);
        intersections.add(i2);
        intersections.add(i3);
        intersections.add(i4);
        intersections.add(i5);
        intersections.add(i6);
        intersections.add(i7);
        intersections.add(i8);
        intersections.add(i9);
        intersections.add(i10);
        intersections.add(i11);
        intersections.add(i12);
        intersections.add(i13);
        intersections.add(i14);
        intersections.add(i15);
        intersections.add(i16);
        intersections.add(i17);
        intersections.add(i18);
        intersections.add(i19);
        intersections.add(i20);
        intersections.add(i21);
        intersections.add(i22);
        intersections.add(i23);
        intersections.add(i24);
        intersections.add(i25);
        intersections.add(i26);
        intersections.add(i27);
        intersections.add(i28);
        intersections.add(i29);
        intersections.add(i30);
        intersections.add(i31);
        intersections.add(i32);
        intersections.add(i33);
        intersections.add(i34);


        addNeighbor(i0, i2, i7, i24, i26);
        addNeighbor(i1, i30, i4);
        addNeighbor(i2, i0, i3, i28);
        addNeighbor(i3, i2, i8, i24);
        addNeighbor(i4, i6, i1, i5);
        addNeighbor(i5, i30, i29, i14, i4);
        addNeighbor(i6, i7, i4, i29);
        addNeighbor(i7, i0, i6, i25);
        addNeighbor(i8, i3, i10);
        addNeighbor(i9, i32, i11, i20, i34);
        addNeighbor(i10, i16, i32, i8, i22);
        addNeighbor(i11, i31, i12, i9, i13);
        addNeighbor(i12, i19, i11, i33);
        addNeighbor(i13, i11, i14, i34);
        addNeighbor(i14, i15, i13, i33, i5);
        addNeighbor(i15, i34, i14, i27);
        addNeighbor(i16, i10, i17, i22);
        addNeighbor(i17, i23, i22, i16);
        addNeighbor(i18, i23, i21, i31);
        addNeighbor(i19, i31, i23, i12);
        addNeighbor(i20, i9, i21, i22);
        addNeighbor(i21, i18, i22, i31, i20);
        addNeighbor(i22, i21, i17, i16, i10, i20);
        addNeighbor(i23, i19, i18, i17);
        addNeighbor(i24, i3, i25, i0);
        addNeighbor(i25, i24, i7);
        addNeighbor(i26, i0, i27, i29);
        addNeighbor(i27, i15, i28, i26);
        addNeighbor(i28, i27,i2, i32);
        addNeighbor(i29, i6, i5, i26);
        addNeighbor(i30, i1, i33, i5);
        addNeighbor(i31, i18, i21, i19, i11);
        addNeighbor(i32, i9, i10, i28);
        addNeighbor(i33, i12, i30, i14);
        addNeighbor(i34, i13, i15, i9);
    }



    public List<Intersection> nearestWayFromTo(Intersection from, Intersection to){

        List<List<Intersection>> allWays = allWaysFromTo(from, to);

        if(allWays.size() == 0)
            throw new IllegalArgumentException("No way from source to destionation.");


        double min = calculatePriceOfWay(allWays.get(0));
        int minWayIndex = 0;

        for(int i=1; i<allWays.size() - 1; i++){

            double price = calculatePriceOfWay(allWays.get(i));

            if(price < min) {
                min = price;
                minWayIndex = i;
            }
        }

        System.out.println("price : "+ min);
        return allWays.get(minWayIndex);
    }

    public List<Intersection> nearestWayFromToWithTrafficLight(Intersection from, Intersection to){


        List<List<Intersection>> allWays = allWaysFromTo(from, to);

        if(allWays.size() == 0)
            throw new IllegalArgumentException("No way from source to destionation.");

        int minWayTime = calculatePriceOfWayWithTrafficLight(allWays.get(0));
        int minWayIndex = 0;

        for(int i=1; i<allWays.size() - 1; i++){

            int wayTime = calculatePriceOfWayWithTrafficLight(allWays.get(i));

            if(wayTime < minWayTime) {
                minWayTime = wayTime;
                minWayIndex = i;
            }
        }


        System.out.println("time (TL): "+ minWayTime);

        return allWays.get(minWayIndex);
    }

    public List<Intersection> nearestWayForBus(Intersection source, Intersection ...addresses){

        List<List<Intersection>> allWays = allWaysWithCircle(source);

        allWays = findWaysWithAddresses(allWays, addresses);

        return nearestWayInCircle(allWays);
    }

    public List<Intersection> nearestWayForBusWithTrafficLight(Intersection source, Intersection ...addresses){

        List<List<Intersection>> allWays = allWaysWithCircle(source);

        allWays = findWaysWithAddresses(allWays, addresses);

        return nearestWayInCircleWithTrafficLight(allWays);
    }

    private double calculatePriceOfWay(List<Intersection> way) {

        double total = 0;

        for(int i=0; i<way.size() - 1; i++){

            total += way.get(i).priceToNeighbor(way.get(i+1).getId());
        }

        return total;
    }

    private int calculatePriceOfWayWithTrafficLight(List<Intersection> way){

        int time = 0;

        for(int i=0; i<way.size() - 1; i++){

            double m = way.get(i).priceToNeighbor(way.get(i+1).getId());
            // 0.0xxxxxxxxxx
            m = (m*10000)/4;
            time += m;

            if(way.get(i+1).hasTrafficLight()){
                time += way.get(i+1).getTrafficLight().elapsedToGreen(time);
            }
        }

        return time;

    }

    private List<List<Intersection>> allWaysFromTo(Intersection from, Intersection to){

        List<List<Intersection>> result = new MyArrayList<List<Intersection>>();

        if(to == from){
            List<Intersection> tmp = new MyArrayList<Intersection>();
            tmp.add(from);
            result.add(tmp);
            return result;
        }

        boolean[] visited = new boolean[intersections.size()];
        Deque<Intersection> path = new ArrayDeque<Intersection>();
        getAllPath(from, to, visited, path, result);
        return result;
    }


    private List<List<Intersection>> allWaysWithCircle(Intersection source){

        List<List<Intersection>> allWays = new MyArrayList<>();
        for(Intersection neighbor : source.getNeighbors()){

            for(List<Intersection> way : allWaysFromTo(source, neighbor)){
//                if(way.size() == 2)
//                    continue;
                way.add(source);
                allWays.add(way);
            }
        }

        return allWays;
    }


    private List<List<Intersection>> findWaysWithAddresses(List<List<Intersection>> ways, Intersection ...addresses){

        List<List<Intersection>> result = new MyArrayList<>();
        for(List<Intersection> way : ways){
            int addressCounter = addresses.length;

            for(Intersection intersection : way){
                for(int k=0; k<addresses.length; k++){
                    if(addresses[k] == intersection)
                        --addressCounter;
                }
            }

            if(!(addressCounter > 0))
                result.add(way);


        }
        return result;
    }


    private List<Intersection> nearestWayInCircle(List<List<Intersection>> ways){

        double min = calculatePriceOfWay(ways.get(0));
        int minWayIndex = 0;

        for(int i=1; i<ways.size() - 1; i++){

            double price = calculatePriceOfWay(ways.get(i));

            if(price < min) {
                min = price;
                minWayIndex = i;
            }
        }

        System.out.println("price circle : "+ min);
        return ways.get(minWayIndex);
    }

    private List<Intersection> nearestWayInCircleWithTrafficLight(List<List<Intersection>> ways){

        int minTime = calculatePriceOfWayWithTrafficLight(ways.get(0));
        int minWayIndex = 0;

        for(int i=1; i<ways.size() - 1; i++){

            int price = calculatePriceOfWayWithTrafficLight(ways.get(i));

            if(price < minTime) {
                minTime = price;
                minWayIndex = i;
            }
        }

        System.out.println("price circle (TL): "+ minTime);

        return ways.get(minWayIndex);
    }


    private void getAllPath(Intersection from, Intersection to, boolean[] visited, Deque<Intersection> path, List<List<Intersection>> result) {

        visited[from.getId()] = true;
        path.add(from);
        if(from == to)
            result.add(new MyArrayList<Intersection>(path));
        else{
            if(adjacency_matrix.containsKey(from)){
                for(Intersection i : adjacency_matrix.get(from)){
                    if(!visited[i.getId()]){
                        getAllPath(i, to, visited, path, result);
                    }
                }
            }
        }
        path.removeLast();
        visited[from.getId()] = false;
    }


    private Intersection getIntersectionWithId(int id){
        for(Intersection i : intersections){
            if(i.getId() == id)
                return i;
        }
        throw new IllegalArgumentException();
    }

    public void addNeighbor(Intersection u, Intersection ...v){
        if(!adjacency_matrix.containsKey(u))
            adjacency_matrix.put(u, new MyArrayList<Intersection>());

        for(int i=0; i<v.length; i++) {
            adjacency_matrix.get(u).add(v[i]);
        }
        u.addNeighbor(v);
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

    public void enableTrafficLights(int ...interSectionsId){

        for(int i=0; i<interSectionsId.length; i++){

            getIntersectionWithId(interSectionsId[i]).setTrafficLight(TrafficLight.getTrafficLights()[interSectionsId[i]]);
        }
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
