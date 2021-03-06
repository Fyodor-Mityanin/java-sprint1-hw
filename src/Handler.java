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
                    System.out.println("??????-???? ???? ?????? ?? ?????????????? ???? " + Month.toString(month));
                    isCorrect = false;
                }
            }
            if (isCorrect) {
                System.out.println("?????????? ?? ???????????????? ????????????????");
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
            System.out.println("?????????? ???? " + yearlyReport.getYear() + " ??????");
            System.out.println("?????????????? ???? ?????????????? ????????????");
            for (Month month : Month.values()) {
                if (yearlyReport.getExpense().containsKey(month) && yearlyReport.getIncome().containsKey(month)) {
                    System.out.println("???? " + Month.toString(month) + " ?????????????? ???????????????????? " + yearlyReport.getProfit(month));
                } else {
                    System.out.println("???? " + Month.toString(month) + " ?????? ????????????");
                }
            }
            Printer.longLine();
        } else {
            Printer.reportNotReady();
        }
    }

    public void showOneMonthReport(MonthlyReport report) {
        Printer.longLine();
        System.out.println("?????????? ???? " + Month.toString(report.getMonth()) + " " + report.getYear() + " ??????");
        MonthInvoice mostProfitableItem = report.getMostProfitableItem();
        System.out.println("?????????? ???????????????????? ??????????: " + mostProfitableItem.getItemName());
        System.out.println("?????? ?????????????? ???? " + mostProfitableItem.profit() + " ??????????");
        MonthInvoice mostExpensiveItem = report.getMostExpensiveItem();
        System.out.println("?????????? ?????????????? ??????????: " + mostExpensiveItem.getItemName());
        System.out.println("?????????????????? " + mostExpensiveItem.profit() + " ??????????");
        Printer.longLine();
    }
}
