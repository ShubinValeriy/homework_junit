import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите мин. длину пароля: ");
        int minLength = Integer.parseInt(scanner.nextLine());
        passwordChecker.setMinLength(minLength);
        System.out.print("\nВведите макс. допустимое количество повторений символа подряд: ");
        int maxRepeats = Integer.parseInt(scanner.nextLine());
        passwordChecker.setMaxRepeats(maxRepeats);
        while (true) {
            System.out.print("\nВведите пароль или end для выхода: ");
            System.out.println();
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Программа завершена");
                break;
            }
            boolean checkPassword = passwordChecker.verify(input);
            System.out.println(checkPassword ? "Подходит!" : "Не подходит!");
        }
    }
}
