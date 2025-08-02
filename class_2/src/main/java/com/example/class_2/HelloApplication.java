package com.example.class_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Group root=new Group();

        Scene scene1 = new Scene(root, Color.CYAN);

        stage.setX(100);
        stage.setY(100);
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setTitle("JavaFx Class 2");

        stage.setScene(scene1);

        //Text
        Text txt=new Text();
        txt.setText("Ajke Chutti Diye dilam");
        txt.setX(100);
        txt.setY(100);
        txt.setFont(Font.font("Impact",25));
        txt.setFill(Color.valueOf("#277b10"));

        root.getChildren().add(txt);

        //Button

        Button btn= new Button();
        btn.setText("Understandable");
        btn.setLayoutX(100);
        btn.setLayoutY(150);
        btn.setPrefSize(150,50);
        btn.setFont(Font.font("Impact",15));

        btn.setOnAction(e->{
            Text txt2=new Text();
            txt2.setText("Why Not");
            txt2.setX(100);
            txt2.setY(250);
            txt2.setFont(Font.font("Impact",20));
            txt2.setFill(Color.valueOf("#277b10"));

            root.getChildren().add(txt2);
        });

        root.getChildren().add(btn);

        //Rectangle

        Rectangle rt= new Rectangle();
        rt.setX(100);
        rt.setY(300);
        rt.setWidth(100);
        rt.setHeight(50);
        rt.setFill(Color.DARKGREEN);
        rt.setStrokeWidth(3);
        rt.setStroke(Color.WHITE);

        root.getChildren().add(rt);

        //Circle

        Circle circ= new Circle();
        circ.setCenterX(300);
        circ.setCenterY(325);
        circ.setRadius(40);
        circ.setFill(Color.DARKGREEN);
        circ.setStrokeWidth(3);
        circ.setStroke(Color.WHITE);

        root.getChildren().add(circ);

        //Icon
        Image icon=new Image(new FileInputStream("D:\\SYH\\Class_2\\src\\icon.png"));
        stage.getIcons().add(icon);

        //Image
        Image pic=new Image(new FileInputStream("D:\\SYH\\Class_2\\src\\pic.png"));
        ImageView imageV=new ImageView(pic);

        imageV.setX(350);
        imageV.setY(150);
        imageV.setFitHeight(150);
        imageV.setFitWidth(300);

        root.getChildren().add(imageV);

        //Scene Switching

        Group root2 = new Group();
        Scene scene2=new Scene(root2,Color.DARKORANGE);

        //next button in scene 1
        Button nxt= new Button();
        nxt.setText("Next");
        nxt.setLayoutX(350);
        nxt.setLayoutY(350);
        nxt.setPrefSize(150,50);
        nxt.setFont(Font.font("Impact",15));

        nxt.setOnAction(e->{
            stage.setScene(scene2);
        });

        root.getChildren().add(nxt);

        //Back button in scene 2
        Button bck= new Button();
        bck.setText("Back");
        bck.setLayoutX(350);
        bck.setLayoutY(350);
        bck.setPrefSize(150,50);
        bck.setFont(Font.font("Impact",15));

        bck.setOnAction(e->{
            stage.setScene(scene1);
        });

        root2.getChildren().add(bck);

        TextField tf1=new TextField("Enter email");
        Label l1=new Label("Email: ");

        HBox hb=new HBox(5);
        hb.setTranslateX(100);
        hb.setTranslateY(100);

        hb.getChildren().addAll(l1,tf1);

        root2.getChildren().add(hb);

        TextField tf2=new TextField("Enter Pass");
        Label l2=new Label("Pass: ");

        VBox vb=new VBox(5);
        vb.setTranslateX(100);
        vb.setTranslateY(200);

        vb.getChildren().addAll(l2,tf2);

        root2.getChildren().add(vb);



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
