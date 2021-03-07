package com.bb_score.deserializer;


import java.util.List;


public interface Deserializer<T> {
    List<T> get();
}
