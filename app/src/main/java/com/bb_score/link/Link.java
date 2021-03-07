package com.bb_score.link;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.Element;
import com.bb_score.Player;

import java.util.Optional;

public class Link implements Element {
    private final String id;
    private Optional<Player> owner;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Link(String id) {
        this.id = id;
        this.owner = Optional.empty();
    }

    public String getId() {
        return id;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Player> getOwner() {
        if(owner.isPresent())
            return owner;
        else
            return Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setOwner(Player owner) {
        this.owner = Optional.of(owner);
    }

    @Override
    public String getID() {
        return id;
    }
}
