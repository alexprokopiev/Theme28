import java.util.Arrays;
import java.util.Scanner;

public class Utils {

    public static void printContacts() {
        //Печать списка контактов
        System.out.println("Ваш список контактов:");
        for (int i = 0; i < Main.contacts.length; i++) {
            if (Main.contacts[i] != null) {
                System.out.println((i+1)+"."+Main.contacts[i].getName()+" "+Main.contacts[i].getValue());
            } else {
                System.out.println((i+1)+"....");
            }
        }
        System.out.println();
    }

    public static void createNewContact() {
        //Проверка свободного места в списке контактов
        boolean isFreeContactCell = false;
        int i = 0;
        for (int j = 0;j < Main.contacts.length;j++) {
            if (Main.contacts[j] == null) {
                isFreeContactCell = true;
                i = j;
                break;
            }
        }
        if (!isFreeContactCell) {
            System.out.println("\u001B[31m" + "В списке контактов закончилось свободное место." + "\u001B[0m");
            Menu.directMainMenu();
        }
        //Создание нового контакта
        Contact contact = new Contact();
        contact.setName();
        contact.setValue();
        //Запись контакта в список контактов и печать списка
        Main.contacts[i] = contact;
        printContacts();
        //Возврат к главному меню
        Menu.directMainMenu();
    }

    public static void editContact() {
        System.out.println("Введите порядковый номер контакта");
        Scanner scanner = new Scanner(System.in);
        int contactNumber = findIndex(scanner,false,false);
        if (contactNumber < 0 || contactNumber > 9) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 10" + "\u001B[0m");
            editContact();
        }
        if (Main.contacts[contactNumber] == null) {
            System.out.println("\u001B[31m" + "Контакт пустой. Выберите существующий контакт" + "\u001B[0m");
            editContact();
        }
        System.out.println("Для редактирования выбран контакт: "
                +Main.contacts[contactNumber].getName()+" "+Main.contacts[contactNumber].getValue());
        Menu.directSecondEditMenu(contactNumber);
        printContacts();
        //Возврат к главному меню
        Menu.directMainMenu();
    }

    public static void swapContacts() {
        System.out.println("Введите порядковый номер первого контакта:");
        Scanner scanner = new Scanner(System.in);
        int firstToSwap = findIndex(scanner, true, true);
        if (firstToSwap < 0 || firstToSwap > 9) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 10" + "\u001B[0m");
            swapContacts();
        }
        System.out.println("Введите порядковый номер второго контакта:");
        int secondToSwap = findIndex(scanner, true, false);
        if (secondToSwap < 0 || secondToSwap > 9) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 10" + "\u001B[0m");
            swapContacts();
        }
        if (firstToSwap == secondToSwap) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Порядковые номера контактов совпадают" + "\u001B[0m");
            swapContacts();
        }
        if (Main.contacts[firstToSwap] == null && Main.contacts[secondToSwap] == null) {
            System.out.println("\u001B[31m" + "Оба контакта пустые" + "\u001B[0m");
            swapContacts();
        }
        Contact[] temp = Arrays.copyOf(Main.contacts,10);
        temp[firstToSwap] = Main.contacts[secondToSwap];
        temp[secondToSwap] = Main.contacts[firstToSwap];
        Main.contacts = temp;
        printContacts();
        //Возврат к главному меню
        Menu.directMainMenu();
    }

    public static void deleteContact() {
        System.out.println("Введите порядковый номер контакта");
        Scanner scanner = new Scanner(System.in);
        int contactNumber = findIndex(scanner, false, false);
        if (contactNumber < 0 || contactNumber > 9) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 10" + "\u001B[0m");
            deleteContact();
        }
        if (Main.contacts[contactNumber] == null) {
            System.out.println("\u001B[31m" + "Контакт пустой. Выберите существующий контакт" + "\u001B[0m");
            printContacts();
            deleteContact();
        }
        Main.contacts[contactNumber] = null;
        printContacts();
        //Возврат к главному меню
        Menu.directMainMenu();
    }

    public static int findIndex(Scanner scanner, boolean isSwap, boolean isFirstContact) {
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 10" + "\u001B[0m");
            System.out.println(isSwap ? isFirstContact ? "Введите порядковый номер первого контакта"
                    : "Введите порядковый номер второго контакта" : "Введите порядковый номер контакта");
            scanner.next();
        }
        return scanner.nextInt()-1;
    }

    public static void exit() {
        System.out.println("Завершение программы");
        System.exit(0);
    }
}
