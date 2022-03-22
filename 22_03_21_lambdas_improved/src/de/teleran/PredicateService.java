package de.teleran;
import java.util.List;
import java.util.function.Predicate;

public class PredicateService {

    public Predicate<Double> intersect(List<Predicate<Double>> predicates) {
        Predicate<Double> res = (Double x) -> true;

        for (Predicate<Double> predicate : predicates) {
            res = res.and(predicate);
        }

        return res;
    }
    public Predicate<Double> union(List<Predicate<Double>> predicates) {
        Predicate<Double> res1 = (Double x) -> true;

        for (Predicate<Double> predicate : predicates) {
            res1 = res1.or(predicate);
        }

        return res1;
    }
}