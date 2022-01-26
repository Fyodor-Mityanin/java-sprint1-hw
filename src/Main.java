import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        label:
        while (true) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
                    System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY.");
                    int currency = scanner.nextInt();
                    converter.convert(moneyBeforeSalary, currency);
                    break;
                case "2":
                    dinnerAdvisor.getAdvice(moneyBeforeSalary, daysBeforeSalary);
                    break;
                case "3": {
                    System.out.println("Введите размер траты:");
                    double expense = scanner.nextDouble();
                    System.out.println("К какой категории относится трата?");
                    String category = scanner.next();
                    moneyBeforeSalary = expensesManager.saveExpense(moneyBeforeSalary, category, expense);
                    break;
                }
                case "4":
                    expensesManager.printAllExpensesByCategories();
                    break;
                case "5": {
                    System.out.println("В какой категории искать?");
                    String category = scanner.next();
                    System.out.println("Самая большая трата в категории " + category + " составила "
                            + expensesManager.findMaxExpenseInCategory(category) + " руб.");
                    break;
                }
                case "6":
                    expensesManager.removeAllExpenses();
                    break;
                case "exit":
                    System.out.println("Выход");
                    break label;
                default:
                    System.out.println("Извините, такой команды нет.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?\n" +
                "1 - Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n" +
                "3 - Сверить отчёты\n" +
                "4 - Вывести информацию о всех месячных отчётах\n" +
                "5 - Вывести информацию о годовом отчёте\n" +
                "exit - Выход из программы");
    }
}

