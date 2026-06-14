package main.java.LLD.SplitWise;

import java.util.HashMap;
import java.util.List;

public class BalanceSheet {
    HashMap<User, HashMap<User, Double>> balanceSheet = new HashMap<>();

    public void updateBalance(User paidBy, List<Split> splits) {
        for(Split split: splits) {
            if(paidBy.equals(split.getUser())) continue;

            balanceSheet.computeIfAbsent(split.getUser(), f -> new HashMap<>()).merge(paidBy, split.getAmount(), Double::sum);
        }
    }

    public void diplayBalance() {
        for(User user: balanceSheet.keySet()) {
            for(User paidBy: balanceSheet.get(user).keySet()) {
                System.out.println(user.getName() + " ows " + paidBy.getName() + " $" + balanceSheet.get(user).get(paidBy));
            }
        }
    }
}
