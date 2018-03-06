package com.ender.twistedremix;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.ender.twistedremix.TwistedUtil.TransitionManager;

public class TwistedRemix extends Game {

    public BitmapFont font;

    public TwistedClient client;

    public TransitionManager transitionManager;

    @Override
    public void create() {
        font = new BitmapFont();

        client = new TwistedClient();

        client.startClient();

        setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        font.dispose();
    }
}
