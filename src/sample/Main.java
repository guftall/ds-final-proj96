package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controllers.City;
import sample.controllers.Intersection;
import sample.controllers.LatLong;
import sample.controllers.MyArrayList;

import java.util.List;
import java.util.Optional;

public class Main extends Application {

    private City city = City.getInstance();
    private List<Intersection> intersections;
    private Text txtSourceNumber;
    private Text txtDestinationNumber;

    private List<Line> drawedLine = new MyArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{

        txtSourceNumber = new Text();
        txtDestinationNumber = new Text();

        txtSourceNumber.setLayoutX(790);
        txtDestinationNumber.setLayoutX(790);
        txtDestinationNumber.setLayoutY(20);

        primaryStage.setTitle("Show Image");

        LatLong.init();
        Group root = new Group();

        Scene scene = new Scene(root, 1024, 720, Color.WHITE);

        Pane pane = new Pane();
        pane.setBackground(Background.EMPTY);

        final ImageView imageView = new ImageView();
        final Image image2 = new Image(Main.class.getResourceAsStream("img1.png"));
        imageView.setImage(image2);
        imageView.setFitHeight(840);
        imageView.setFitWidth(580);

        final HBox pictureRegion = new HBox();
        pictureRegion.setLayoutX(88);
        pictureRegion.setLayoutY(16 - 190);

        pictureRegion.getChildren().add(imageView);
        pictureRegion.setRotate(-90);
        pane.getChildren().add(pictureRegion);

        intersections = city.getIntersections();

        for(int i=0; i<intersections.size(); i++){

            Circle circle = new Circle(8);
            circle.setCenterX(intersections.get(i).getScreenX());
            circle.setCenterY(intersections.get(i).getScreenY());
            pane.getChildren().add(circle);

            Label label = new Label(intersections.get(i).getName());
            label.setLayoutX(intersections.get(i).getScreenX());
            label.setLayoutY(intersections.get(i).getScreenY() + 3);
            label.setFont(new Font(10));
            pane.getChildren().add(label);
        }

        drawStreets(pane);


        root.getChildren().add(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String msg =
                        "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
                                "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
                                "(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")";

                primaryStage.setTitle(msg);
            }
        });

        while(true){
            askForInput(pane);
        }
    }

    private void circleWithoutTL(Pane pane) {


        TextInputDialog source = new TextInputDialog();
        source.setX(960);
        source.setY(220);
        source.setTitle("مسیر مورد نظر");
        source.setHeaderText("Look, a Text Input Dialog");
        source.setContentText("شماره ی مبدا را وارد کنید:");


        Optional<String> sourceNumber = source.showAndWait();

        removeDrawedWays(pane);

        if(sourceNumber.isPresent()) {
            int src = Integer.valueOf(sourceNumber.get());

            List<Integer> visitId = new MyArrayList();

            visitId.add(10);
            visitId.add(17);
            visitId.add(33);
            visitId.add(4);
            visitId.add(12);
            visitId.add(23);

            if(visitId.contains(src)){
                visitId.remove(visitId.indexOf(src));
            }

            Intersection[] toVisit = new Intersection[visitId.size()];
            for(int k=0; k<visitId.size(); k++)
                toVisit[k] = intersections.get(visitId.get(k));

            List<Intersection> busWay = city.nearestWayForBus(intersections.get(src),
                    toVisit);

            drawNearestWay(pane, busWay, false);

            circleWithTL(pane, src);
        }


    }

    private void circleWithTL(Pane pane, int src) {


            city.enableTrafficLights(5, 15, 32);

            List<Integer> visitId = new MyArrayList();

            visitId.add(10);
            visitId.add(17);
            visitId.add(33);
            visitId.add(4);
            visitId.add(12);
            visitId.add(23);

            if(visitId.contains(src)){
                visitId.remove(visitId.indexOf(src));
            }

            Intersection[] toVisit = new Intersection[visitId.size()];
            for(int k=0; k<visitId.size(); k++)
                toVisit[k] = intersections.get(visitId.get(k));

            List<Intersection> busWay = city.nearestWayForBusWithTrafficLight(intersections.get(src),
                    toVisit);


        for(int i=0; i<intersections.size(); i++){

            if(intersections.get(i).hasTrafficLight()) {
                Circle circle = new Circle(13);
                circle.setCenterX(intersections.get(i).getScreenX());
                circle.setCenterY(intersections.get(i).getScreenY());
                circle.setFill(Color.YELLOW);
                pane.getChildren().add(circle);
            }

            if(i ==10 || i == 17 || i ==33 || i == 4 || i==12 || i == 23){

                Circle circle = new Circle(10);
                circle.setCenterX(intersections.get(i).getScreenX());
                circle.setCenterY(intersections.get(i).getScreenY());
                circle.setFill(Color.BLUE);
                pane.getChildren().add(circle);
            }
        }

        drawNearestWay(pane, busWay, true);
    }


    public void wayWithTL(Pane pane, int src, int dst){


        city.enableTrafficLights(14);

        List<Intersection> way = city.nearestWayFromToWithTrafficLight(
                intersections.get(src), intersections.get(dst));

        for(int i=0; i<intersections.size(); i++){

            if(intersections.get(i).hasTrafficLight()) {
                Circle circle = new Circle(8);
                circle.setCenterX(intersections.get(i).getScreenX());
                circle.setCenterY(intersections.get(i).getScreenY());
                circle.setFill(Color.YELLOW);
                pane.getChildren().add(circle);
            }
        }
        drawNearestWay(pane, way, true);


    }

    public void wayWithoutTL(Pane pane){

        TextInputDialog source = new TextInputDialog();
        source.setTitle("مسیر مورد نظر");
        source.setHeaderText("Look, a Text Input Dialog");
        source.setContentText("شماره ی مبدا را وارد کنید:");

        TextInputDialog dest = new TextInputDialog();
        dest.setTitle("مسیر مورد نظر");
        dest.setHeaderText("Look, a Text Input Dialog");
        dest.setContentText("شماره ی مقصد را وارد کنید:");

        source.setX(960);
        source.setY(220);
        dest.setX(960);
        dest.setY(220);
        Optional<String> sourceNumber = source.showAndWait();


        if(sourceNumber.isPresent()) {
            int src = Integer.valueOf(sourceNumber.get());

            Optional<String> destNumber = dest.showAndWait();
            removeDrawedWays(pane);

            if (destNumber.isPresent()) {
                int dst = Integer.valueOf(destNumber.get());

                List<Intersection> way = city.nearestWayFromTo(
                        intersections.get(src), intersections.get(dst));

                drawNearestWay(pane, way, false);

                wayWithTL(pane, src, dst);
            }
        }

    }

    private void askForInput(Pane pane) {

        //wayWithTL(pane);
        wayWithoutTL(pane);

        //circleWithoutTL(pane);
    }

    private void removeDrawedWays(Pane pane) {

        Line[] lines = new Line[drawedLine.size()];

        for(int k=0; k<drawedLine.size(); k++){
            lines[k] = drawedLine.get(k);
        }

        pane.getChildren().removeAll(lines);
    }

    private void drawNearestWay(Pane pane, List<Intersection> way, boolean withTL) {

        for(int i=0; i<way.size() - 1; i++){

            Line line = new Line(way.get(i).getScreenX(), way.get(i).getScreenY(),
                    way.get(i+1).getScreenX(), way.get(i+1).getScreenY());
            line.setStrokeWidth(4);
            if(withTL)
                line.setStroke(Paint.valueOf("#b92121"));
            else {
                line.setStroke(Paint.valueOf("#31b400"));
                line.setStrokeWidth(9);
            }

            drawedLine.add(line);
            pane.getChildren().add(line);
        }
    }

    private void drawStreets(Pane pane){


        for(int k=0; k < City.getInstance().getIntersections().size(); k++){

            for(int i=0; i<City.getInstance().getIntersections().get(k).getNeighbors().size(); i++){
                Intersection neighbor = City.getInstance().getIntersections().get(k).getNeighbors().get(i);

                Line line = new Line(City.getInstance().getIntersections().get(k).getScreenX(), City.getInstance().getIntersections().get(k).getScreenY(),
                        neighbor.getScreenX(), neighbor.getScreenY());
                line.setStrokeWidth(2);
                pane.getChildren().add(line);

            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
