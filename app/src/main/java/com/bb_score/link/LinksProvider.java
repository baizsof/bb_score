package com.bb_score.link;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.Provider;
import com.bb_score.deserializer.JacksonDeserializer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinksProvider extends Provider<Link> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LinksProvider(File file) {
        super(new JacksonDeserializer<>(file, Link.class));
    }

    @Override
    protected Map<String, Link> loadData() {
        Map<String, Link> map = new HashMap<>();
        List<Link> elements = deserializer.get();
        for (Link element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
