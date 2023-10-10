import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printInfo();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    moneyStr = scanner.nextLine();
                    money = Integer.parseInt(moneyStr);
                    spendings += money;
                    break;
                case 3:
                    TaxesChoice.taxesChoice(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }


    public static void printInfo() {
        System.out.println("\nВыберите операцию и введите её номер:");
        System.out.println("   1   - Добавить новый доход");
        System.out.println("   2   - Добавить новый расход");
        System.out.println("   3   - Выбрать систему налогообложения");
        System.out.println("   end - Выход\n");
    }

}
