package com.ender.twistedremix.cards;

import com.ender.twistedremix.TwistedUtil.Enums.TroopAbilities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ender
 */
public abstract class Entity extends Card
{
    protected int apCost, cpCost, attack, health, currentAttack, currentHealth, xCoord, yCoord;
    protected List<TroopAbilities> abilities;

    /**
     * An Entity is a troop. An entity can be placed on the game
     * board and thus moved and can attack other units on the game board, only from the
     * game board (Not the hand)
     * @param name The Entity's name
     * @param description The Entity's description
     * @param ap The amount of Action points it costs to move this Entity
     * @param cp The amount of Creature points it costs to play this Entity
     * @param attack The Attack value this Entity has
     * @param hp The number of Health Points this Entity has
     * @param startPosX The starting x position on the board for this Entity
     * @param startPosY The starting y position on the board for this Entity
     */
    public Entity(String name, String description, int ap, int cp, int attack, int hp, int startPosX, int startPosY)
    {
        super(name, description);
        this.apCost = ap;
        this.cpCost = cp;
        this.attack = attack;
        this.health = hp;
        this.currentHealth = hp;
        this.xCoord = startPosX;
        this.yCoord = startPosY;

        abilities = new ArrayList<TroopAbilities>();
    }

    public abstract boolean[] getAbilities();

    public abstract boolean hasAbility(int num);

    public abstract boolean canDeflect();

    public abstract boolean canMirror();

    public abstract void kill(Entity killed);

    /**
     * Change an Entity's Health Points and Attack Value
     * @param hp - The amount to change the Entity's current Health points by
     * @param atk - The amount to change the Entity's current Attack value by
     */
    public void modifyEntity(int hp, int atk)
    {
        currentHealth += hp;
        currentAttack += atk;
        if(currentHealth <= 0)
            kill(this);
    }

    public void heal(int hp)
    {
        if(currentHealth + hp > health)
            currentHealth = health;
        else
            modifyEntity(hp, 0);
    }

    /**
     * <code> dealDamage(defender) </code> is the method that allows one Entity to attack another.
     * The method takes in the opposing Entity to be attacked and plays the correct sound
     * corresponding to the attack, checks if the defender has deflect or mirror and handles
     * that accordingly, and, if possible, deals damage.
     * @param defender - The Entity to attack
     */
    /*public void dealDamage(Entity defender) TODO
    {
        if(this instanceof Troop)
        {
            if(((Troop)this).hasAbility(3))
            {
                fx = new Audio("FX", "Range");
            }
            else if(((Troop)this).hasAbility(2))
            {
                fx = new Audio("FX", "Blast");
            }
            else
            {
                fx = new Audio("FX", "Melee");
            }
        }
        else
        {
            fx = new Audio("FX", "Melee");
        }

        if(defender.getAbilities() != null)
        {
            if(defender.canMirror())
            {
                fx = new Audio("FX", "Mirror");
                currentHealth -= currentAttack / 2;
            }
            if(defender.canDeflect())
            {
                fx = new Audio("FX", "Deflect");
                return;
            }
        }
        defender.currentHealth -= this.currentAttack;
        if(defender.currentHealth <= 0)
            kill(defender);
    }*/

    public abstract void attack(Entity defender);

    public int getCurrentAttack() {
        return currentAttack;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getCpCost() {
        return cpCost;
    }

    public int getApCost() {
        return apCost;
    }

    public int getXPos() {
        return xCoord;
    }

    public int getYPos() {
        return yCoord;
    }

    public boolean hasAbility(TroopAbilities ability) {
        return abilities.contains(ability);
    }

    /**
     * Sets a Entity's internal coordinates to a specified point
     * @param movePoint The point to which the troop should move
     */
    /*public void setCoords(MovePoint movePoint) { TODO
        xCoord = movePoint.getX();
        yCoord = movePoint.getY();
    }*/

    /**
     * <code> move() </code> is the method used to move an Entity. The methods checks to see if a move is valid
     * by first making sure the player has enough Action Points and then making sure the move is only one tile
     * in any direction
     * @param placed - The Entity to move
     * @param ap - The Action Points possessed by the Player
     * @param posX - The x position to move the Entity to
     * @param posY - The x position to move the Entity to
     * @return int - The remaining amount of Action Points possessed by the Player
     */
    /*public static int move(Entity placed, int ap, int posX, int posY) TODO
    {
        if (ap >= placed.getApCost() && Math.abs(posX - placed.getPosX()) <= 1 && Math.abs(posY - placed.getPosY()) <= 1
                && Game.game.getBoard()[posX][posY] == null) {
            Game.game.getBoard()[placed.getPosX()][placed.getPosY()] = null;
            Game.game.getBoard()[posX][posY] = placed;
            placed.setCoords(new MovePoint(posX, posY));
            return ap - placed.getApCost();
        }
        return ap;
    }*/
}
