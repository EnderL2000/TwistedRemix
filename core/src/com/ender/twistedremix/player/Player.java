package com.ender.twistedremix.player;

import com.ender.twistedremix.cards.Deck;
import com.ender.twistedremix.TwistedUtil.Enums;

public class Player {
    private Enums.TeamColor teamColor;
    private Enums.ClassType classType;

    private Deck deck;
    private Stats stats;

    public Player(Enums.TeamColor teamColor, Enums.ClassType classType) {
        this.teamColor = teamColor;
        this.classType = classType;

        deck = new Deck(classType);
        stats = new Stats(classType);
    }

    public Deck getDeck() {
        return deck;
    }

    public Stats getStats() {
        return stats;
    }
}
