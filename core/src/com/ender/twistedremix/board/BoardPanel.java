package com.ender.twistedremix.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.ender.twistedremix.TwistedUtil.TwistedScreen;
import com.ender.twistedremix.TwistedUtil.Enums;

public class BoardPanel extends Table {
    private Enums.BoardLayout layout;

    public TwistedScreen screen;

    public Skin skin;

    public BoardPanel(Enums.BoardLayout layout) {
        super();

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        this.layout = layout;

        //TODO Gen board
        init(layout);
    }

    private void init(Enums.BoardLayout layout) {
        switch(layout) {
            case CLASSIC:
                //TODO change below to read XML to place void or playable tiles in the correct places
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        this.add( new PlayableTile(i, j, skin)).size(100f, 100f);
                    }
                    this.row();
                }
                break;
            default:
                Gdx.app.error("layout was never defined", "A BoardLayout was never defined for BoardPanel");
                break;
        }
    }
}
