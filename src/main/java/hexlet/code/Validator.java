package hexlet.code;

public class Validator {

    /**
     * Returns instance of StringSchema.
     * @return instance of StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Returns instance of NumberSchema.
     * @return instance of NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Returns instance of MapSchema.
     * @return instance of MapSchema
     */
    public MapSchema map() {
        return new MapSchema();
    }

}
