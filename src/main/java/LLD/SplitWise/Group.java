package main.java.LLD.SplitWise;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private List<User> members;
    private List<Expense> expenses;

    public Group(int groupId) {
        this.groupId = groupId;
        members = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
