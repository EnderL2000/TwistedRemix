package com.ender.twistedremix.board;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.ender.twistedremix.cards.Entity;

public class BoardTile extends Button{
    protected Entity occupant;
    public final int X, Y;

    public BoardTile(int x, int y, Skin skin) {
        super(skin);
        this.X = x;
        this.Y = y;
        occupant = null;
    }

    public Entity getOccupant() {
        return occupant;
    }
}
