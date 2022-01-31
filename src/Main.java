import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Handler handler = new Handler();
        label:
        while (true) {
            Printer.menu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    handler.readMonthReports();
                    break;
                case "2":
                    handler.readYearReports();
                    break;
                case "3": {
                    handler.checkReports();
                    break;
                }
                case "4":
                    handler.showAllMonthlyReports();
                    break;
                case "5": {
                    handler.showYearlyReport();
                    break;
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

