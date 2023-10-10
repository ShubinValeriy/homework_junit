public class TaxesChoice {
    public static void taxesChoice(int earnings, int spendings) {
        int taxEarnings = taxEarnings(earnings);
        int taxEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);
        if (taxEarnings > taxEarningsMinusSpendings) {
            printInfo("доходы минус расходы", taxEarningsMinusSpendings, taxEarnings);
        } else if (taxEarningsMinusSpendings > taxEarnings) {
            printInfo("доходы", taxEarnings, taxEarningsMinusSpendings);
        } else {
            System.out.println("Можете выбрать любую систему налогообложения");
            System.out.println("Ваш налог составит: " + taxEarnings + " рублей \n");
        }

    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    private static void printInfo(String taxSystem, int taxWin, int taxLose) {
        System.out.println("\nМы советуем вам УСН " + taxSystem);
        System.out.println("Ваш налог составит: " + taxWin + " рублей");
        System.out.println("Налог на другой системе: " + taxLose + " рублей");
        System.out.println("Экономия: " + (taxLose - taxWin) + " рублей \n");

    }
}
