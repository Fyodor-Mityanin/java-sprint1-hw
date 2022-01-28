public class MonthInvoice {
    private final String itemName;
    private final int quantity;
    private final int sumOfOne;
    private final boolean isExpense;

    MonthInvoice(String[] items) {
        this.itemName = items[0];
        this.isExpense = Boolean.parseBoolean(items[1]);
        this.quantity = Integer.parseInt(items[2]);
        this.sumOfOne = Integer.parseInt(items[3]);
    }

    public int profit() {
        return this.sumOfOne * this.quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isExpense() {
        return isExpense;
    }

}
