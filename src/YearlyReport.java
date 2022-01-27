import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    private short year;
    private HashMap<Month, YearInvoice[]> invoices;

    public YearlyReport(short year, ArrayList<YearInvoice> yearInvoices) {
        this.year = year;
        this.invoices = yearInvoices;
    }

    public void showReport() {
        System.out.println("-------------------------");
        System.out.println("Отчёт за " + getYear() + " год");
        System.out.println("Прибыль по каждому месяцу");
        for (Month month: Month.values()) {

        }

        MonthInvoice mostProfitableItem = getMostProfitableItem();
        System.out.println("Самый прибыльный товар: " + mostProfitableItem.getItemName());
        System.out.println("его продано на " + mostProfitableItem.profit() + " денег");
        MonthInvoice mostExpensiveItem = getMostExpensiveItem();
        System.out.println("Самая большая трата: " + mostExpensiveItem.getItemName());
        System.out.println("потрачено " + mostExpensiveItem.profit() + " денег");
        System.out.println("-------------------------");
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public ArrayList<YearInvoice> getYearInvoices() {
        return yearInvoices;
    }

    public void setYearInvoices(ArrayList<YearInvoice> yearInvoices) {
        this.yearInvoices = yearInvoices;
    }

}
