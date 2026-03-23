package mainfx.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    public int id;
    public String name;
    public int age;
    private double rating;
}
