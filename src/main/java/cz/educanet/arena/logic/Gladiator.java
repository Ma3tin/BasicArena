package cz.educanet.arena.logic;

import java.util.Random;

public class Gladiator {
    /**
     * Name, health, minimal damage and maximal damage of the gladiator
     */
    private String name;
    private int HP;
    private int minDamage;
    private int maxDamage;

    /**
     * @return true if hp is <= 0, else false
     */
    public boolean isDead() {
        return (getHP() <= 0);
    }

    /**
     * Generates a random value between min. damage and max. damage and deals it to the enemy.
     * @param enemy Enemy gladiator
     */
    public void dealDamage(Gladiator enemy) {
        Random rd = new Random();
        int damage = (rd.nextInt((getMaxDamage() - getMinDamage()) + 1) + getMinDamage());
        enemy.setHP(enemy.getHP() - damage);
    }


    /**
     * getter and setter for name
     * @return
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter and setter for HP
     * @return
     */

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * getter and setter for minimal damage
     * @param minDamage
     */

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    /**
     * getter and setter for maximal damage
     * @return
     */

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
}
