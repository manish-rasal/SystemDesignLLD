package main.java.LLD.SplitWise;

import java.util.List;

public class Expense {
    private int expenseId;
    private User paidBy;
    private double totalAmount;
    private List<Split> splits;

    public Expense(int expenseId, User paidBy, double totalAmount, List<Split> splits) {
        this.expenseId = expenseId;
        this.paidBy = paidBy;
        this.totalAmount = totalAmount;
        this.splits = splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
