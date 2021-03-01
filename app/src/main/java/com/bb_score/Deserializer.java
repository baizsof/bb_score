package com.bb_score;

import java.util.Set;

public interface Deserializer<T> {
    Set<T> get();
}
