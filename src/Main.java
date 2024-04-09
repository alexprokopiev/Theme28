import java.util.Scanner;

public class Main {

    public static Contact[] contacts = new Contact[10];

    public static void main(String[] args) {
        Contact.demo();
        Utils.printContacts();
        Menu.directMainMenu();
    }
}


