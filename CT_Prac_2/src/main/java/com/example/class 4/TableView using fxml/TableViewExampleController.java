package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class TableViewExampleController {
    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, Integer> ageColumn;

    private final ObservableList<Person> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        data.add(new Person("Alice", 25));
        data.add(new Person("Bob", 30));

        tableView.setItems(data);
    }

    @FXML
    public void handleAddRow() {
        TextInputDialog nameDialog = new TextInputDialog();
        nameDialog.setTitle("Add Row");
        nameDialog.setHeaderText("Enter Name:");
        Optional<String> nameResult = nameDialog.showAndWait();

        TextInputDialog ageDialog = new TextInputDialog();
        ageDialog.setTitle("Add Row");
        ageDialog.setHeaderText("Enter Age:");
        Optional<String> ageResult = ageDialog.showAndWait();

        if (nameResult.isPresent() && ageResult.isPresent()) {
            try {
                String name = nameResult.get();
                int age = Integer.parseInt(ageResult.get());
                data.add(new Person(name, age));
            } catch (NumberFormatException e) {
                System.err.println("Invalid age input. Please enter a number.");
            }
        }
    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

