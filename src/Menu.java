import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private HashMap<Integer, String> menuValue = new HashMap<>();

    private Menu(String... strings) {
        int i = 1;
        for (String string : strings) {
            menuValue.put(i++,string);
        }
    }

    public HashMap<Integer, String> getMenuValue() {
        return menuValue;
    }

    public void viewMenu(HashMap<Integer, String> menuValue) {
        System.out.println("Введите номер пункта меню:");
        for (Map.Entry entry : menuValue.entrySet()) {
            System.out.println(entry.getKey()+". "+entry.getValue());
        }
    }

    public static Menu mainMenu = new Menu("Новый контакт","Редактировать контакт",
            "Удалить контакт","Выйти");
    public static Menu firstEditMenu = new Menu("Редактировать контакт", "Поменять два контакта местами");
    public static Menu secondEditMenu = new Menu("Редактировать имя абонента",
            "Редактировать номер абонента", "Редактировать имя и номер абонента");

    public static void directMainMenu() {
        mainMenu.viewMenu(mainMenu.getMenuValue());
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 4" + "\u001B[0m");
            mainMenu.viewMenu(mainMenu.getMenuValue());
            scanner.next();
        }
        switch (scanner.nextInt()) {
            case 1:
                Utils.createNewContact();
                break;
            case 2:
                directFirstEditMenu();
                break;
            case 3:
                Utils.deleteContact();
                break;
            case 4:
                Utils.exit();
            default:
                System.out.println("\u001B[31m" + "Ошибка ввода. Введите число от 1 до 4" + "\u001B[0m");
                directMainMenu();
        }
    }

    public static void directFirstEditMenu() {
        firstEditMenu.viewMenu(firstEditMenu.getMenuValue());
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите числа 1 или 2" + "\u001B[0m");
            firstEditMenu.viewMenu(firstEditMenu.getMenuValue());
            scanner.next();
        }
        switch (scanner.nextInt()) {
            case 1:
                //Редактирование контакта
                Utils.editContact();
                break;
            case 2:
                //Обмен двух контактов местами
                Utils.swapContacts();
                break;
            default:
                System.out.println("\u001B[31m" + "Ошибка ввода. Введите числа 1 или 2" + "\u001B[0m");
                directFirstEditMenu();
        }
    }

    public static void directSecondEditMenu(int contactNumber) {
        secondEditMenu.viewMenu(secondEditMenu.getMenuValue());
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите числа от 1 до 3" + "\u001B[0m");
            secondEditMenu.viewMenu(secondEditMenu.getMenuValue());
            scanner.next();
        }
        switch (scanner.nextInt()) {
            case 1:
                //Редактирование имени контакта
                Main.contacts[contactNumber].setName();
                break;
            case 2:
                //Редактирование номера контакта
                Main.contacts[contactNumber].setValue();
                break;
            case 3:
                //Редактирование имени и номера контакта
                Main.contacts[contactNumber].setName();
                Main.contacts[contactNumber].setValue();
                break;
            default:
                System.out.println("\u001B[31m" + "Ошибка ввода. Введите числа от 1 до 3" + "\u001B[0m");
                directSecondEditMenu(contactNumber);
        }
    }
}

