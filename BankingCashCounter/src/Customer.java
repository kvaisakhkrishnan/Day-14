class Customer {
    private String name;
    private String transactionType;
    private int amount;

    public Customer(String name, String transactionType, int amount) {
        this.name = name;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }
}
