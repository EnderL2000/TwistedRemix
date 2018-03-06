package com.ender.twistedremix.player;

import com.badlogic.gdx.Gdx;
import com.ender.twistedremix.TwistedUtil.Enums;

public class Stats {
    private int ap, cp, tp, territory;

    public Stats(Enums.ClassType classType) {
        switch(classType) {
            case RAVAGER:
                ap = 20;
                cp = 16;
                tp = 4;
                territory = 1;
                break;
            case SWARM:
                ap = 12;
                cp = 12;
                tp = 4;
                territory = 1;
                break;
            case DJ:
                ap = 16;
                cp = 8;
                tp = 12;
                territory = 1;
                break;
            default:
                Gdx.app.error("classType was never defined", "A classType was never defined for Deck");
                break;
        }
    }

    public boolean useAP(int ap) {
        if (this.ap >= ap) {
            this.ap -= ap;
            return true;
        }
        return false;
    }

    public boolean useCP(int cp) {
        if (this.cp >= cp) {
            this.cp -= cp;
            return true;
        }
        return false;
    }

    public boolean useTP(int tp) {
        if (this.tp >= tp) {
            this.tp -= tp;
            return true;
        }
        return false;
    }

    public int getTerritory() {
        return territory;
    }
}
