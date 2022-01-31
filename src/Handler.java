import java.util.ArrayList;

public class Handler {
    FileReader fileReader = new FileReader();
    ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
    YearlyReport yearlyReport;
    static final String yearFilePath = "./resources/y.2021.csv";
    static final String monthFilePath1 = "./resources/m.20210";
    static final String monthFilePath2 = ".csv";

    public void readMonthReports() {
        for (int i = 1; i <= 3; i++) {
            String path = monthFilePath1 + i + monthFilePath2;
            String fileContents = fileReader.readFileContentsOrNull(path);
            if (fileContents != null) {
                ArrayList<MonthInvoice> monthInvoices = fileReader.getMonthInvoices(fileContents);
                Month month = Month.monthByNumber(String.valueOf(i));
                monthlyReports.add(new MonthlyReport((short) 2021, month, monthInvoices));
                Printer.readingMonthSuccess(month);
            } else {
                Printer.errorReadingFile();
                break;
            }
        }
    }

    public void readYearReports() {
        String fileContents = fileReader.readFileContentsOrNull(yearFilePath);
        if (fileContents != null) {
            yearlyReport = fileReader.getYearlyReport(fileContents);
            Printer.readingSuccess();
        } else {
            Printer.errorReadingFile();
        }
    }

    public void checkReports() {
        if (monthlyReports != null && yearlyReport != null) {
            boolean isCorrect = true;
            Printer.longLine();
            for (MonthlyReport monthlyReport : monthlyReports) {
                Month month = monthlyReport.getMonth();
                int monthExpense = yearlyReport.getExpense().get(month);
                int monthIncome = yearlyReport.getIncome().get(month);
                for (MonthInvoice invoice : monthlyReport.getInvoices()) {
                    if (invoice.isExpense()) {
                        monthExpense -= invoice.profit();
                    } else {
                        monthIncome -= invoice.profit();
                    }
                }
                if (monthExpense != 0 || monthIncome != 0) {
                    System.out.println("Что-то не так с отчётом за " + Month.toString(month));
                    isCorrect = false;
                }
            }
            if (isCorrect) {
                System.out.println("Дебет с кредитом сходятся");
            }
            Printer.longLine();
        } else {
            Printer.reportNotReady();
        }
    }

    public void showAllMonthlyReports() {
        if (!monthlyReports.isEmpty()) {
            for (MonthlyReport report: monthlyReports) {
                showOneMonthReport(report);
            }
        } else {
            Printer.reportNotReady();
        }
    }

    public void showYearlyReport() {
        if (yearlyReport != null) {
            Printer.longLine();
            System.out.println("Отчёт за " + yearlyReport.getYear() + " год");
            System.out.println("Прибыль по каждому месяцу");
            for (Month month : Month.values()) {
                if (yearlyReport.getExpense().containsKey(month) && yearlyReport.getIncome().containsKey(month)) {
                    System.out.println("За " + Month.toString(month) + " прибыль составляет " + yearlyReport.getProfit(month));
                } else {
                    System.out.println("За " + Month.toString(month) + " нет данных");
                }
            }
            Printer.longLine();
        } else {
            Printer.reportNotReady();
        }
    }

    public void showOneMonthReport(MonthlyReport report) {
        Printer.longLine();
        System.out.println("Отчёт за " + Month.toString(report.getMonth()) + " " + report.getYear() + " год");
        MonthInvoice mostProfitableItem = report.getMostProfitableItem();
        System.out.println("Самый прибыльный товар: " + mostProfitableItem.getItemName());
        System.out.println("его продано на " + mostProfitableItem.profit() + " денег");
        MonthInvoice mostExpensiveItem = report.getMostExpensiveItem();
        System.out.println("Самая большая трата: " + mostExpensiveItem.getItemName());
        System.out.println("потрачено " + mostExpensiveItem.profit() + " денег");
        Printer.longLine();
    }
}
