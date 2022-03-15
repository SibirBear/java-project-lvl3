package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> predicates = new ArrayList<>();

    /**
     * Adds predicate to list.
     * @param predicate - predicate to added in list of predicates
     */
    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    /**
     * Returns false if received String as param, contains in list of predicates.
     * @param o - some string
     * @return boolean
     */
    public boolean isValid(Object o) {
        for (Predicate<Object> p : predicates) {
            if (!p.test(o)) {
                return false;
            }
        }
        return true;
    }

}
