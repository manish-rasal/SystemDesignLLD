package main.java.LLD.SplitWise;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplit(double amount, List<User> users, List<Double> metadata);
}
