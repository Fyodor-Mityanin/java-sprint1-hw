public class MonthInvoice {
    private String itemName;
    private int quantity;
    private int sumOfOne;
    private boolean isExpense;

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

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSumOfOne() {
        return sumOfOne;
    }

    public void setSumOfOne(int sumOfOne) {
        this.sumOfOne = sumOfOne;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }


}
