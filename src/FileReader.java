import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader {
    static final String monthReportFirstLine = "item_name,is_expense,quantity,sum_of_one";
    static final String yearReportFirstLine = "month,amount,is_expense";


    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                    "Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static ArrayList<MonthInvoice> getMonthInvoices(String fileContents) {
        ArrayList<MonthInvoice> monthInvoices = new ArrayList<>();
        String[] lines = fileContents.split("\\R");
        for (String line:lines) {
            if (monthReportFirstLine.equals(line)) {
                continue;
            }
            String[] items = line.split(",");
            monthInvoices.add(new MonthInvoice(items));
        }
        return monthInvoices;
    }

    public static YearlyReport getYearlyReport(String fileContents) {
        String[] lines = fileContents.split("\\R");
        ArrayList<YearInvoice> yearInvoices = new ArrayList<>();
        for (String line:lines) {
            if (yearReportFirstLine.equals(line)) {
                continue;
            }
            String[] items = line.split(",");
            yearInvoices.add(new YearInvoice(items));
        }
        return new YearlyReport((short) 2021, yearInvoices);
    }
}
