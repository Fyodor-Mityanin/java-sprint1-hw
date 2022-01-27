import java.util.ArrayList;

public class MonthlyReport {
    private short year;
    private Month month;
    private ArrayList<MonthInvoice> invoices;

    public MonthlyReport(short year, Month month, ArrayList<MonthInvoice> invoices) {
        this.year = year;
        this.month = month;
        this.invoices = invoices;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public ArrayList<MonthInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<MonthInvoice> invoices) {
        this.invoices = invoices;
    }

    public void showReport() {
        System.out.println("-------------------------");
        System.out.println("Отчёт за " + Month.toString(getMonth()));
        MonthInvoice mostProfitableItem = getMostProfitableItem();
        System.out.println("Самый прибыльный товар: " + mostProfitableItem.getItemName());
        System.out.println("его продано на " + mostProfitableItem.profit() + " денег");
        MonthInvoice mostExpensiveItem = getMostExpensiveItem();
        System.out.println("Самая большая трата: " + mostExpensiveItem.getItemName());
        System.out.println("потрачено " + mostExpensiveItem.profit() + " денег");
        System.out.println("-------------------------");
    }

    private MonthInvoice getMostProfitableItem() {
        int max = 0;
        MonthInvoice mostProfitableItem = null;
        for(MonthInvoice invoice: getInvoices()) {
            if (!invoice.isExpense()) {
                int profit = invoice.profit();
                if (profit > max) {
                    max = profit;
                    mostProfitableItem = invoice;
                }
            }
        }
        return mostProfitableItem;
    }

    private MonthInvoice getMostExpensiveItem() {
        int max = 0;
        MonthInvoice mostExpensiveItem = null;
        for(MonthInvoice invoice: getInvoices()) {
            if (invoice.isExpense()) {
                int expense = invoice.profit();
                if (expense > max) {
                    max = expense;
                    mostExpensiveItem = invoice;
                }
            }
        }
        return mostExpensiveItem;
    }

}
