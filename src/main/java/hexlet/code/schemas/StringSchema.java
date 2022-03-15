package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        super.addPredicate(p -> p instanceof String && !String.valueOf(p).isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        super.addPredicate(p -> p instanceof String && String.valueOf(p).length() >= length);
        return this;
    }

    public final StringSchema contains(String s) {
        super.addPredicate(p -> p instanceof String && String.valueOf(p).contains(s));
        return this;
    }

}
