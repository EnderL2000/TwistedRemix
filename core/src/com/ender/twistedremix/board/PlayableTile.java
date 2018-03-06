package com.ender.twistedremix.board;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ender.twistedremix.cards.Entity;

public class PlayableTile extends BoardTile {

    public PlayableTile(int x, int y, Skin skin) {
        super(x, y, skin);
    }

    public void setOccupant(Entity occupant) {
        this.occupant = occupant;
    }
}
