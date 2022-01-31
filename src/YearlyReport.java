import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    private final short year;
    private final HashMap<Month, Integer> expense;
    private final HashMap<Month, Integer> income;

    public YearlyReport(short year, ArrayList<YearInvoice> yearInvoices) {
        this.year = year;
        this.expense = new HashMap<>();
        this.income = new HashMap<>();
        for (YearInvoice invoice: yearInvoices) {
            if (invoice.isExpense()) {
                this.expense.put(invoice.getMonth(), invoice.getAmount());
            } else {
                this.income.put(invoice.getMonth(), invoice.getAmount());
            }
        }
    }

    public short getYear() {
        return year;
    }

    public HashMap<Month, Integer> getExpense() {
        return expense;
    }

    public HashMap<Month, Integer> getIncome() {
        return income;
    }

    public int getProfit(Month month) {
        return getIncome().get(month) - getExpense().get(month);
    }

}
