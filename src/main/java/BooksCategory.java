import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor

public class BooksCategory {

    private int categoryID;
    private String name;
    private int priority;

    @Override
    public String toString() {
        return "BooksCategory{" +
                "categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
