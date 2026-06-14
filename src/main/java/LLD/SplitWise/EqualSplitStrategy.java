package main.java.LLD.SplitWise;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSplit(double amount, List<User> users, List<Double> ignore) {
        List<Split> splits = new ArrayList<>();
        double share = amount / users.size();
        for(User user: users) {
            splits.add(new Split(user, share));
        }
        return splits;
    }
}
