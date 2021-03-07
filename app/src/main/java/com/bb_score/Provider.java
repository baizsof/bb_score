package com.bb_score;

import com.bb_score.deserializer.Deserializer;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public abstract class Provider<T> {
    protected final Deserializer<T> deserializer;
    private final Map<String, T> map;

    public Provider(Deserializer<T> deserializer) {
        this.deserializer = deserializer;
        map = loadData();
    }

    protected abstract Map<String, T> loadData();

    public T get(@NotNull String id) {
        return map.get(id);
    }
}
