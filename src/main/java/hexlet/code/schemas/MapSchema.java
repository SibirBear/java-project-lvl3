package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        super.addPredicate(p -> p instanceof Map);
        return this;
    }

    public final MapSchema sizeof(int count) {
        super.addPredicate(p -> p instanceof Map && ((Map<?, ?>) p).size() == count);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        super.addPredicate(p -> {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) p).entrySet()) {
                if (!schemas.get(entry.getKey()).isValid(entry.getValue())) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
