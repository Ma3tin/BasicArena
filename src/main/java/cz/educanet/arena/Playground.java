package cz.educanet.arena;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Gladiator;
import cz.educanet.arena.presentation.ArenaCLI;

import java.util.Random;
import java.util.Scanner;

/**
 * This is just a playground class... You can create new gladiators and persist them ect.
 */
public class Playground {

    public static void main(String[] args) {
        Gladiator gl = new Gladiator();
        Gladiator jarda = new Gladiator();
        ArenaCLI cl = new ArenaCLI();
        cl.init();
        /*gl.setHP(80);
        jarda.setHP(1000);
        jarda.setMinDamage(10);
        jarda.setMaxDamage(20);
        gl.setMinDamage(20);
        gl.setMaxDamage(40);
        jarda.dealDamage(gl);
        System.out.println(gl.getHP());*/
        cl.renderEntireFight();
    }

}
