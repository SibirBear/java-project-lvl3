package hexlet.code;

public class StringSchema extends Schema {

    public final StringSchema required() {
        super.addPredicate(p -> p != null && !p.isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        super.addPredicate(p -> p != null && p.length() >= length);
        return this;
    }

    public final StringSchema contains(String s) {
        super.addPredicate(p -> p != null && p.contains(s));
        return this;
    }

}
