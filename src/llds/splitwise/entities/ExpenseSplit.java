package llds.splitwise.entities;

public class ExpenseSplit {
    public String getUserId() {
        return userId;
    }

    public Double getAmount() {
        return amount;
    }

    public boolean isPayer() {
        return isPayer;
    }

    String userId;
    Double amount;
    boolean isPayer;

    public ExpenseSplit(String userId, Double amount, boolean iaPayer) {
        this.userId = userId;
        this.amount = amount;
        this.isPayer = iaPayer;
    }
}
