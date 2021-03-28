package cz.educanet.arena.logic;

/**
 * Represents the arena.
 */
public class Arena {

    private Gladiator gladiator1;
    private Gladiator gladiator2;
    /**
     * Represents the current round. This property is incremented each round.
     */
    private int round;


    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }



    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    /**
     * Makes the gladiators fight one round.
     */
    public void fight() {
        getGladiator1().dealDamage(getGladiator2());
        getGladiator2().dealDamage(getGladiator1());
    }

    /**
     * @return the winner, null if none.
     */
    public Object getWinner() {
        // TODO:
        if (getGladiator1() != null && getGladiator1().isDead() ) { return getGladiator2().getName(); }
        if (getGladiator2() != null && getGladiator2().isDead()) { return getGladiator1().getName(); }
        return null;
    }


    public void setGladiator1(Gladiator gladiator1) {
        this.gladiator1 = gladiator1;
    }

    public void setGladiator2(Gladiator gladiator2) {
        this.gladiator2 = gladiator2;
    }
}
