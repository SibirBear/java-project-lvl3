package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        super.addPredicate(p -> p instanceof Integer);
        return this;
    }

    public final NumberSchema positive() {
        super.addPredicate(p -> p == null || (p instanceof Integer && (Integer) p > 0));
        return this;
    }

    public final NumberSchema range(int start, int end) {
        super.addPredicate(p -> p instanceof Integer
                && (Integer) p >= start && (Integer) p <= end);
        return this;
    }


}
