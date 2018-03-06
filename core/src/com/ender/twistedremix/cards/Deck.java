package com.ender.twistedremix.cards;

import com.badlogic.gdx.Gdx;
import com.ender.twistedremix.TwistedUtil.Enums.ClassType;

import java.util.List;

public class Deck {

    private List<Card> deck;
    private ClassType classType;
    private int cp, ap, tp, territory;

    public Deck(ClassType classType) {
        this.classType = classType;
        switch (classType) {
            case DJ:
                break;
            case SWARM:
                break;
            case RAVAGER:
                break;
            default:
                Gdx.app.error("classType was never defined", "A classType was never defined for Deck");
                break;
        }
    }
}
