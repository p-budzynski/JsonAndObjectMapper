package pl.kurs.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isMarried;
    private List<String> hobbies;
    private List<Kid> kids;

}
