public class YearInvoice {
    private Month month;
    private int amount;
    private boolean isExpense;

    YearInvoice(String[] items) {
        this.month = Month.monthByNumber(items[0]);
        this.amount = Integer.parseInt(items[1]);
        this.isExpense = Boolean.parseBoolean(items[2]);
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }
}
