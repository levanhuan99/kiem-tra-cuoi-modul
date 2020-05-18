import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagerImpl implements IContactManager {
    private ArrayList<Contact> list = new ArrayList<>();
    private File file= new File();

    public ContactManagerImpl() throws IOException {

        list = file.readFromFile();
    }

    @Override
    public void add(Contact contact) {
        list.add(contact);
    }

    @Override
    public void edit(String number) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++) {
            if (isContact(number, i)) {
                System.out.println("enter new number:");
                String newNumber = scanner.next();
                list.get(i).setNumber(newNumber);

                System.out.println("enter new group:");
                String newGroup = scanner.next();
                list.get(i).setGroup(newGroup);

                System.out.println("enter new name:");
                String newName = scanner.next();
                list.get(i).setName(newName);

                System.out.println("enter new gender:");
                String newGender = scanner.next();
                list.get(i).setGender(newGender);

                System.out.println("enter new address:");
                String newAddress = scanner.next();
                list.get(i).setAddress(newAddress);
            }
        }
    }

    @Override
    public void remove(String number) {
        for (int i = 0; i < list.size(); i++) {
            if (isContact(number, i)) {
                list.remove(i);
            }
        }
    }

    @Override
    public void update() throws IOException {
        File file = new File();
        file.writeToFile(list);
    }

    @Override
    public String find(String number) {
        for (int i = 0; i < list.size(); i++) {
            if ( list.get(i).getNumber().equals(number)) {
                return list.get(i).toString();
            }
        }
        return number;
    }

    @Override
    public boolean check(String number) {
        for (int i = 0; i < list.size(); i++) {
            if (isContact(number, i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }


    private boolean isContact(String number, int i) {
        return list.get(i).getNumber().equals(number);
    }


}
