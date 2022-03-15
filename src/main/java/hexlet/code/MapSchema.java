package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {

    //required – требуется тип данных Map
    public final MapSchema required() {
        super.addPredicate(p -> p instanceof Map);
        return this;
    }

    //sizeof – количество пар ключ-значений в объекте Map должно быть равно заданному
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
