public class YearInvoice {
    private final Month month;
    private final int amount;
    private final boolean isExpense;

    YearInvoice(String[] items) {
        this.month = Month.monthByNumber(items[0]);
        this.amount = Integer.parseInt(items[1]);
        this.isExpense = Boolean.parseBoolean(items[2]);
    }

    public Month getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isExpense() {
        return isExpense;
    }
}
