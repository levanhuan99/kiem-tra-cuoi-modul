import java.io.IOException;
import java.util.ArrayList;

public interface IContactManager {

    void add(Contact contact);
    void edit(String number);
    void remove(String number);
    void update() throws IOException;
    String find(String number);
    boolean check(String number);
    void display();
}
