import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<MonthlyReport> monthlyReports = null;
        YearlyReport yearlyReport = null;
        label:
        while (true) {
            Printer.menu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    monthlyReports = new ArrayList<>();
                    for (int i = 1; i <= 3; i++) {
                        String path = "./resources/m.20210" + i + ".csv";
                        String fileContents = FileReader.readFileContentsOrNull(path);
                        if (fileContents != null) {
                            ArrayList<MonthInvoice> monthInvoices = FileReader.getMonthInvoices(fileContents);
                            Month month = Month.monthByNumber(String.valueOf(i));
                            monthlyReports.add(new MonthlyReport((short) 2021, month, monthInvoices));
                        } else {
                            Printer.errorReadingFile();
                            break;
                        }
                    }
                    Printer.readingSuccess();
                    break;
                case "2":
                    String path = "./resources/y.2021.csv";
                    String fileContents = FileReader.readFileContentsOrNull(path);
                    if (fileContents != null) {
                        yearlyReport = FileReader.getYearlyReport(fileContents);
                    } else {
                        Printer.errorReadingFile();
                        break;
                    }
                    Printer.readingSuccess();
                    break;
                case "3": {
                    if (monthlyReports != null && yearlyReport != null) {
                        yearlyReport.checkReports(monthlyReports);
                    } else {
                        Printer.reportNotReady();
                    } break;
                }
                case "4":
                    if (monthlyReports != null) {
                        MonthlyReport.showReports(monthlyReports);
                    } else {
                        Printer.reportNotReady();
                    } break;
                case "5": {
                    if (yearlyReport != null) {
                        yearlyReport.showReport();
                    } else {
                        Printer.reportNotReady();
                    } break;
                }
                case "exit":
                    Printer.exit();
                    break label;
                default:
                    break;
            }
        }
    }
}

