package mainfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mainfx.data.Student;
import mainfx.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;
    @FXML
    private TableColumn<Student, Double> ratingColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField ratingField;

    private StudentService studentService;

    public void initialize() {
        studentService = new StudentService();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        updateTable();
    }

    public void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About this application");
        alert.setContentText("This is a simple application to manage students.");
        alert.show();
    }

    public void addStudent() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double rating = Double.parseDouble(ratingField.getText());

        studentService.addStudent(id, name, age, rating);

        updateTable();
    }

    public void deleteStudent() {
        Student student = studentTable.getSelectionModel().getSelectedItem();
        if (student != null) {
            studentService.removeStudent(student);
            updateTable();
        }
    }

    private void updateTable() {
        studentTable.setItems(FXCollections.observableArrayList(studentService.getStudents()));
    }
}
