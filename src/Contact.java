import java.util.Scanner;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String value;

    public static void demo() {
        //Добавление в список нескольких записей для удобной демонстрации функционала
        Main.contacts[0] = new Contact();
        Main.contacts[0].name = "Начальник";
        Main.contacts[0].value = "89658547548";
        Main.contacts[1] = new Contact();
        Main.contacts[1].name = "Отец";
        Main.contacts[1].value = "89623492843";
        Main.contacts[2] = new Contact();
        Main.contacts[2].name = "Жена";
        Main.contacts[2].value = "89099749966";
    }

    public String getName() {
        return name;
    }

    public  String getValue() {
        return value;
    }

    public void setName() {
        //Проверка условий и запись имени абонента
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя абонента");
        String name = scanner.nextLine();
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите имя абонента" + "\u001B[0m");
            setName();
        }
    }

    public void setValue() {
        //Проверка условий и запись номера абонента
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер абонента");
        String value = scanner.nextLine();
        if (value != null && Pattern.matches("89[0-9]{9}",value)) {
            this.value = value;
        } else {
            System.out.println("\u001B[31m" + "Ошибка ввода. Введите номер абонента в формате 89*********" + "\u001B[0m");
            setValue();
        }
    }
}
