package com.ender.twistedremix.TwistedUtil;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public interface TwistedScreen extends Screen{

    public Stage getStage();

    public int getHeight();

    public int getWidth();
}
