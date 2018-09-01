package bookstore.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor

public class Author {
    private int authorID;
    private String name;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "ID: " + authorID + ", name: " + name +", lastName: " + lastName + ", age: " + age;
    }
}
