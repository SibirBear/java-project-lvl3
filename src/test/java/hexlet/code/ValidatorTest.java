package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    void testStringSchema() {
        final Validator v = new Validator();
        final StringSchema schema = v.string();
        final int length = 5;

        assertTrue(schema.isValid("")); // true
        assertTrue(schema.isValid(null)); // true

        schema.required();
        schema.minLength(length);

        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid("")); // false

        schema.contains("what");
        assertTrue(schema.isValid("what does the fox say")); // true

        schema.contains("whatthe");
        assertFalse(schema.isValid("what does the fox say")); // false

        assertFalse(schema.isValid("what does the fox say")); // false
    }
}
