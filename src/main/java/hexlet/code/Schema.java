package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Schema {

    private final List<Predicate<String>> predicates = new ArrayList<>();

    /**
     * Adds predicate to list.
     * @param predicate - predicate to added in list of predicates
     */
    public void addPredicate(Predicate<String> predicate) {
        predicates.add(predicate);
    }

    /**
     * Returns false if received String as param, contains in list of predicates.
     * @param s - some string
     * @return boolean
     */
    public boolean isValid(String s) {
        for (Predicate<String> p : predicates) {
            if (!p.test(s)) {
                return false;
            }
        }
        return true;
    }

}
