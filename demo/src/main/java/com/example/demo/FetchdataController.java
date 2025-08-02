package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FetchdataController {

    public Label label;
    public ImageView image;

    public void initialize() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/example/demo/demo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("title:")) {
                    label.setText(line.substring(6).trim());
                }
                if (line.startsWith("image:")) {
                    String imagePath = line.substring(6).trim();
                    image.setImage(new javafx.scene.image.Image(imagePath));
                }
            }
        } catch (IOException e) {
            label.setText("Error reading file");
            e.printStackTrace();
        }
    }
}
