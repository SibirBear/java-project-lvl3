package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    void testStringSchema() {
        final Validator v = new Validator();
        final StringSchema schema = v.string();
        final int length = 5;
        final String testString = "what does the fox say";

        assertTrue(schema.isValid("")); // true
        assertTrue(schema.isValid(null)); // true

        schema.required();
        schema.minLength(length);

        assertTrue(schema.isValid(testString)); // true
        assertTrue(schema.isValid("hexlet")); // true
        assertFalse(schema.isValid(null)); // false
        assertFalse(schema.isValid("")); // false

        schema.contains("what");
        assertTrue(schema.isValid(testString)); // true

        schema.contains("whatthe");
        assertFalse(schema.isValid(testString)); // false

        assertFalse(schema.isValid(testString)); // false
    }

    @Test
    void testNumberSchema() {
        final Validator v = new Validator();
        NumberSchema schema = v.number();
        final int ten = 10;
        final int five = 5;

        assertTrue(schema.isValid(null)); // true

        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(ten)); // true
        assertFalse(schema.isValid("5")); // false

        schema.positive();
        assertTrue(schema.isValid(ten)); // true
        assertFalse(schema.isValid(-ten)); // false

        schema.range(five, ten);

        assertTrue(schema.isValid(five)); // true
        assertTrue(schema.isValid(ten)); // true
        assertFalse(schema.isValid(five - 1)); // false
        assertFalse(schema.isValid(ten + 1)); // false
    }

    @Test
    void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, String> data = new HashMap<>();

        assertTrue(schema.isValid(null)); // true

        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap())); // true

        data.put("key1", "value1");

        assertTrue(schema.isValid(data)); // true

        schema.sizeof(2);
        assertFalse(schema.isValid(data));  // false

        data.put("key2", "value2");

        assertTrue(schema.isValid(data)); // true
    }
}
