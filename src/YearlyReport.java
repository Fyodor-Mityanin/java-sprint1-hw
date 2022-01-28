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
        System.out.println("-------------------------");
    }

    public void checkReports(ArrayList<MonthlyReport> monthlyReports) {
        boolean isCorrect = true;
        System.out.println("-------------------------");
        for (MonthlyReport monthlyReport: monthlyReports) {
            Month month = monthlyReport.getMonth();
            int monthExpense = getExpense().get(month);
            int monthIncome = getIncome().get(month);
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
        System.out.println("-------------------------");
    }
}
