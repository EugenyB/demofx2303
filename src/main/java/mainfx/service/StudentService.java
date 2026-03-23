package mainfx.service;

import lombok.Data;
import mainfx.data.Student;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentService {
    private List<Student> students;

    public StudentService() {
        students = new ArrayList<>(List.of(
                new Student(1, "John", 20, 75),
                new Student(2, "Kate", 21, 81),
                new Student(3, "Mike", 22, 78),
                new Student(4, "Jane", 19, 82),
                new Student(5, "Bob", 23, 67)
        ));
    }

    public void addStudent(int id, String name, int age, double rating) {
        Student student = new Student(id, name, age, rating);
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
