### Hexlet tests and linter status:
[![Actions Status](https://github.com/SibirBear/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/SibirBear/java-project-lvl3/actions)
![Java CI](https://github.com/SibirBear/java-project-lvl3/workflows/Java%20CI/badge.svg)

### Code Climate
[![Maintainability](https://api.codeclimate.com/v1/badges/395b7ec010d3b137b7e9/maintainability)](https://codeclimate.com/github/SibirBear/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/395b7ec010d3b137b7e9/test_coverage)](https://codeclimate.com/github/SibirBear/java-project-lvl3/test_coverage)


## Data Validator

A data validator is a library with which you can check the correctness of any data. There are many similar libraries in every language, since almost all programs work with external data that needs to be checked for correctness. First of all, we are talking about the data of forms filled in by users.

The library interface for validation is a vivid example of DSL, a specialized language that allows you to declaratively (descriptively) describe what you want from the code. Code written in this style is much easier to read than working with direct object creation. In many ways, this approach is based on the fluent interface pattern.

### Usage example:
```
Validator v = new Validator();

// strings
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Map with structure verification support
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human2); // false
```
