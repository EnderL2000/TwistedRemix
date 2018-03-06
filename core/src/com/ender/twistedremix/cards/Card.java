package com.ender.twistedremix.cards;

import com.ender.twistedremix.TwistedUtil.Enums;

/**
 * @author Ender
 */
public abstract class Card {
    protected Enums.TeamColor teamColor;
    protected String name, description;

    /**
     * A card is the most basic object in the game. A card is anything from a
     * troop to a spell to an amplifier. Every card has a name, a description,
     * and a color for the "Team" it is on
     *
     * @param name The name of the card
     * @param description The card's description
     */
    public Card(String name, String description) {
        this.name = name;
        this.description = description;
        //TODO assign the card a teamColor from Player that placed it
    }

    /**
     * Special call for <code> Troop.java </code>
     */
    public Card() {
        return;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract void updateDescription();

    public Enums.TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(Enums.TeamColor color) {
        teamColor = color;
    }
}
