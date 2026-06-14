package main.java.LLD.SplitWise;

import java.util.List;

public class ExpenseService {
    private BalanceSheet balanceSheet;
    public ExpenseService(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public Expense createExpense(User paidBy, List<User> users, Double totalAmount, SplitStrategy strategy, List<Double> metadata) {
        List<Split> splits = strategy.calculateSplit(totalAmount, users, metadata);
        balanceSheet.updateBalance(paidBy, splits);
        balanceSheet.diplayBalance();
        return new Expense((int)System.currentTimeMillis(), paidBy, totalAmount, splits);
    }
}
