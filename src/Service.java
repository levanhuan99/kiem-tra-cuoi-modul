import java.io.IOException;
import java.util.Scanner;

public class Service {
    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.check contact");
        System.out.println("2.add contact");
        System.out.println("3.edit contact");
        System.out.println("4.remove contact");
        System.out.println("5.update contact");
        System.out.println("6.display contact");
        System.out.println("7.find contact");
        System.out.println("0.exit");
        System.out.println("==================");
        System.out.println("enter your choice!");
        int choice = scanner.nextInt();
        ContactManagerImpl contactManager = new ContactManagerImpl();

        switch (choice) {
            case 1:
                System.out.println("enter your number:");
                String numberCheck = scanner.next();
                if (contactManager.check(numberCheck)) {
                    System.out.println(numberCheck + " in contact!");
                } else System.out.println(numberCheck + " is not in contact!");
                run();
                break;
            case 2:
                System.out.println("enter new number:");
                String number1 = scanner.next();

                System.out.println("enter new group:");
                String group = scanner.next();

                System.out.println("enter new name:");
                String name = scanner.next();

                System.out.println("enter new gender:");
                String gender = scanner.next();

                System.out.println("enter new address:");
                String address = scanner.next();

                System.out.println("enter new dateOfBirth:");
                String dateOfBirth = scanner.next();

                System.out.println("enter new email:");
                String email = scanner.next();

                Contact newContact = new Contact(number1, group, name, gender, address, dateOfBirth, email);
                contactManager.add(newContact);

                contactManager.update();
                run();
                break;
            case 3:
                System.out.println("enter your number you want to edit:");
                String numberEdit = scanner.next();
                contactManager.edit(numberEdit);

                contactManager.update();
                break;
            case 4:
                System.out.println("enter your number you want to remove:");
                String numberRemove = scanner.next();
                contactManager.remove(numberRemove);
                contactManager.update();
                run();
                break;
            case 5:
                contactManager.update();

                break;
            case 6:
                contactManager.display();
                run();
                break;
            case 7:
                System.out.println("enter your number you want to find:");
                String numberFind = scanner.next();
                System.out.println(contactManager.find(numberFind));
                run();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("out of choice!");
                run();
                break;
        }
    }
}
