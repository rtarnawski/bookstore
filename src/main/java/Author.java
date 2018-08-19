import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Author {
    private int authorID;
    private String name;
    private String lastName;
    private int age;
}
