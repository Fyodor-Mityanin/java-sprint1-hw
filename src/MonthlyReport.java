import java.util.ArrayList;

public class MonthlyReport {
    private final short year;
    private final Month month;
    private final ArrayList<MonthInvoice> invoices;

    public MonthlyReport(short year, Month month, ArrayList<MonthInvoice> invoices) {
        this.year = year;
        this.month = month;
        this.invoices = invoices;
    }

    public Month getMonth() {
        return month;
    }

    public ArrayList<MonthInvoice> getInvoices() {
        return invoices;
    }

    public short getYear() {
        return year;
    }

    public MonthInvoice getMostProfitableItem() {
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

    public MonthInvoice getMostExpensiveItem() {
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
