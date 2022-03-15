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

}
