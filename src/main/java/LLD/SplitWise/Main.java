package main.java.LLD.SplitWise;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User a = new User(1,"Manish");

        User b = new User(2,"John");

        User c = new User(3,"Mary");

        ExpenseService service =
                new ExpenseService(
                        new BalanceSheet());

        service.createExpense(
                a,
                List.of(a,b,c),
                300.0,
                new EqualSplitStrategy(),
                Collections.emptyList());
    }
}
