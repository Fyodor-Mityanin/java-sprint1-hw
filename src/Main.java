import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<MonthlyReport> monthlyReports = null;
        YearlyReport yearlyReport = null;
        label:
        while (true) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Считывание месячных отчетов");
                    monthlyReports = new ArrayList<>();
                    for (int i = 1; i <= 3; i++) {
                        String path = "./resources/m.20210" + i + ".csv";
                        String fileContents = readFileContentsOrNull(path);
                        if (fileContents != null) {
                            String[] lines = fileContents.split("\\r\\n");
                            ArrayList<MonthInvoice> monthInvoices = new ArrayList<>();
                            for (String line:lines) {
                                if ("item_name,is_expense,quantity,sum_of_one".equals(line)) {
                                    continue;
                                }
                                String[] items = line.split(",");
                                monthInvoices.add(new MonthInvoice(items));
                            }
                            Month month = Month.monthByNumber(String.valueOf(i));
                            monthlyReports.add(new MonthlyReport((short) 2021, month, monthInvoices));
                        } else {
                            System.out.println("Ошибка при чтении файла");
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.println("Считывание годового отчёта");
                    String path = "./resources/y.2021.csv";
                    String fileContents = readFileContentsOrNull(path);
                    if (fileContents != null) {
                        String[] lines = fileContents.split("\\r\\n");
                        ArrayList<YearInvoice> yearInvoices = new ArrayList<>();
                        for (String line:lines) {
                            if ("month,amount,is_expense".equals(line)) {
                                continue;
                            }
                            String[] items = line.split(",");
                            yearInvoices.add(new YearInvoice(items));
                        }
                        yearlyReport = new YearlyReport((short) 2021, yearInvoices);
                    } else {
                        System.out.println("Ошибка при чтении файла");
                        break;
                    }
                    break;
                case "3": {
                    if (monthlyReports != null && yearlyReport != null) {
                        System.out.println("Вывод информации о месячных отчётах");
                        for (MonthlyReport report: monthlyReports) {
                            report.showReport();
                        }
                    } else {
                        System.out.println("--------------------");
                        System.out.println("Отчет не сформирован");
                        System.out.println("--------------------");
                    } break;
                    break;
                }
                case "4":
                    if (monthlyReports != null) {
                        System.out.println("Вывод информации о месячных отчётах");
                        for (MonthlyReport report: monthlyReports) {
                            report.showReport();
                        }
                    } else {
                        System.out.println("--------------------");
                        System.out.println("Отчет не сформирован");
                        System.out.println("--------------------");
                    } break;
                case "5": {
                    if (yearlyReport != null) {
                        System.out.println("Вывод информации о годовом отчёте");
                        yearlyReport.showReport();

                    } else {
                        System.out.println("--------------------");
                        System.out.println("Отчет не сформирован");
                        System.out.println("--------------------");
                    } break;
                }
                case "exit":
                    System.out.println("Выход из программы");
                    break label;
                default:
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

    private static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}

