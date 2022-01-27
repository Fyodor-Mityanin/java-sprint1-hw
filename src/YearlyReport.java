import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    private short year;
    private HashMap<Month, Integer> expense;
    private HashMap<Month, Integer> income;

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

    public void showReport() {
        System.out.println("-------------------------");
        System.out.println("Отчёт за " + getYear() + " год");
        System.out.println("Прибыль по каждому месяцу");
        for (Month month: Month.values()) {
            if (getExpense().containsKey(month) && getIncome().containsKey(month)) {
                System.out.println("За "+ Month.toString(month) + " прибыль составляет " + getProfit(month));
            } else {
                System.out.println("За "+ Month.toString(month) + " нет данных");
            }
        }
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public HashMap<Month, Integer> getExpense() {
        return expense;
    }

    public void setExpense(HashMap<Month, Integer> expense) {
        this.expense = expense;
    }

    public HashMap<Month, Integer> getIncome() {
        return income;
    }

    public int getProfit(Month month) {
        return getIncome().get(month) - getExpense().get(month);
    }

    public void setIncome(HashMap<Month, Integer> profit) {
        this.income = profit;
    }
}
