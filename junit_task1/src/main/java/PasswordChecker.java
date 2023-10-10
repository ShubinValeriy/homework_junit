

public class PasswordChecker {
    private int minLength;
    private int maxRepeats;
    private boolean checkMinLength = false;
    private boolean checkMaxRepeats = false;


    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Значение должно быть больше нуля или равно нулю, " +
                    "а Вы указали: " + minLength);
        }
        this.minLength = minLength;
        checkMinLength = true;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Значение должно быть больше нуля, " +
                    "а Вы указали: " + maxRepeats);
        }
        this.maxRepeats = maxRepeats;
        checkMaxRepeats = true;
    }

    public boolean verify(String password) {
        if (!checkMaxRepeats || !checkMinLength) {
            String error = checkMinLength ? "Не задано количество повторений одного символа" :
                    checkMaxRepeats ? "Не задана минимальная длина пароля" : "Не заданы оба параметра";
            throw new IllegalStateException(error);
        }
        return password.length() >= minLength && verifyMaxRepeats(password, maxRepeats);
    }


    private boolean verifyMaxRepeats(String text, int maxRepeats) {
        char checkChar = text.charAt(0);
        int countRepeats = 0;
        for (int i = 0; i < text.length() - 1; i++) {
            if (checkChar == text.charAt(i + 1)) {
                countRepeats += 1;
            } else {
                checkChar = text.charAt(i + 1);
                countRepeats = 0;
            }
            if (countRepeats + 1 > maxRepeats) {
                return false;
            }
        }
        return true;
    }
}
