package main.java.LLD.SplitWise;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSplit(double amount, List<User> users, List<Double> percetages) {
        List<Split> splits = new ArrayList<>();
        int n = users.size();
        for(int i = 0; i < n; i++) {
            User user = users.get(i);
            double percent = percetages.get(i);
            splits.add(new Split(user, amount * percent / 100 ));
        }
        return splits;
    }
}
