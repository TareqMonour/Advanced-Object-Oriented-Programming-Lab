package com.example.class4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableComparatorExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        class Person implements Comparable<Person> {
            String name;
            int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person other) {
                return this.age - other.age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 22));
        people.add(new Person("Charlie", 30));

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(people.stream().map(Person::toString).toList());

        Collections.sort(people, Comparator.comparing(p -> p.name));

        listView.getItems().setAll(people.stream().map(Person::toString).toList());

        VBox root = new VBox(listView);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Comparable & Comparator Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

