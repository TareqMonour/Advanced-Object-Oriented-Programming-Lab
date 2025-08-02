package com.example.class4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML

    private TextArea ta;

    @FXML
   public void initialize(){
        String filepath="records.txt";
        ArrayList<String> rec=new ArrayList<>();

        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))) {
            String line;


            while((line=reader.readLine())!=null)
            {
                String[] parts=line.split(",");
                if(parts.length==3)
                {
                    String outputData="id= "+parts[0]+"\n"+
                                      "name= "+parts[1]+"\n"+
                                      "email= "+parts[2]+"\n";

                    rec.add(outputData);
                }
            }


        }
        catch (Exception e){
            rec.add("Error Reading File "+e.getMessage());
        }

        ta.setText(String.join("\n\n",rec));

    }


    @FXML

    private void switchScene() {
        try {
            HelloApplication.switchScene("scene2.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}