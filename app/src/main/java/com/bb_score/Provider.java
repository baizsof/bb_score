package java.com.bb_score;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Provider<T> {
    private final Deserializer<T> deserializer;
    private final Map<String, T> list;

    public Provider(Deserializer<T> deserializer) {
        this.deserializer = deserializer;
        list = loadData();
    }

    private Map<String, T> loadData() {
        Map<String, T> map = new HashMap<>();
        Set<T> elements = deserializer.get();
        for (T element : elements) {
            map.put(createUniqueID(element), element);
        }
        return map;
    }

    protected abstract String createUniqueID(T element);


}
