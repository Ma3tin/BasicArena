package cz.educanet.arena.presentation;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.util.Scanner;

public class ArenaCLI {

    private Arena logic;
    private Scanner sc;

    /**
     * Initialize all variables that are needed.
     */
    public void init() {
        logic = new Arena();
        sc = new Scanner(System.in);
    }

    public void renderLandingPage() {
        System.out.println("     /\\                         \n" +
                "    /  \\   _ __ ___ _ __   __ _ \n" +
                "   / /\\ \\ | '__/ _ \\ '_ \\ / _` |\n" +
                "  / ____ \\| | |  __/ | | | (_| |\n" +
                " /_/    \\_\\_|  \\___|_| |_|\\__,_|");
        System.out.println("---------------------------------");
    }

    public void renderGladiatorPicker() {
        System.out.println("Enter name of your first gladiator");
        String gladiator1File = sc.nextLine();
        gladiator1File += ".txt";
        System.out.println("Enter name of your second gladiator");
        String gladiator2File = sc.nextLine();
        gladiator2File += ".txt";

        Gladiator gladiator1 = GladiatorDatabase.loadGladiator(gladiator1File);
        Gladiator gladiator2 = GladiatorDatabase.loadGladiator(gladiator2File);

        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);
    }

    public void newGladiator() {
        Gladiator gladiator1 = new Gladiator();
        Gladiator gladiator2 = new Gladiator();

        System.out.println("Set his/her name for gladiator A" + ".");
        gladiator1.setName(sc.nextLine());
        System.out.println("------------------------------------------------------");
        System.out.println("Set his/her health points for gladiator " + gladiator1.getName() + ".");
        gladiator1.setHP(Integer.parseInt(sc.nextLine()));
        System.out.println("------------------------------------------------------");
        System.out.println("Set his/her minimal and maximal damage for gladiator " + gladiator1.getName() + ".");
        gladiator1.setMinDamage(Integer.parseInt(sc.nextLine()));
        gladiator1.setMaxDamage(Integer.parseInt(sc.nextLine()));
        System.out.println("------------------------------------------------------");

        System.out.println("Set his/her name for gladiator B" + ".");
        gladiator2.setName(sc.nextLine());
        System.out.println("------------------------------------------------------");
        System.out.println("Set his/her health points for gladiator " + gladiator2.getName() + ".");
        gladiator2.setHP(Integer.parseInt(sc.nextLine()));
        System.out.println("------------------------------------------------------");
        System.out.println("Set his/her minimal and maximal damage for gladiator " + gladiator2.getName() + ".");
        gladiator2.setMinDamage(Integer.parseInt(sc.nextLine()));
        gladiator2.setMaxDamage(Integer.parseInt(sc.nextLine()));
        System.out.println("------------------------------------------------------");
        GladiatorDatabase.saveGladiator(gladiator1.getName() + ".txt", gladiator1);
        GladiatorDatabase.saveGladiator(gladiator2.getName() + ".txt", gladiator2);

    }

    public void chooseGladiator() {
        System.out.println("Do you want to make a new gladiator.");
        String input = sc.nextLine();
        if (input.toLowerCase().equals("yes")) {
            newGladiator();
        } else {
            renderGladiatorPicker();
        }
    }

    /**
     * Fight until one gladiator dies, or surrenders.
     */

    public void renderEntireFight() {
        // TODO:
        Scanner sc = new Scanner(System.in);
        chooseGladiator();
        Gladiator gladiatorA = logic.getGladiator1();
        Gladiator gladiatorB = logic.getGladiator2();
        int round = 0;
        logic.setRound(round);
        float oneHealthBarA = (float) gladiatorA.getHP() / 20;
        float oneHealthBarB = (float) gladiatorB.getHP() / 20;
        String healthBarA = "";
        String healthBarB = "";
        while (logic.getWinner() == null) {
            float a = gladiatorA.getHP() / oneHealthBarA;
            float b = gladiatorB.getHP() / oneHealthBarB;
            round = logic.getRound();
            round++;
            logic.setRound(round);
            int hpA = gladiatorA.getHP();
            int hpB = gladiatorB.getHP();

            logic.fight();

            System.out.println("-------- " + logic.getRound() + ". kolo ---------");
            System.out.println();
            System.out.println("Fighter's health:");
            for (int i = 0; i < a; i++) healthBarA += "#";
            for (int i = 0; i < b; i++) healthBarB += "#";
            System.out.print(gladiatorA.getName() + " [");
            if (gladiatorA.isDead()) System.out.print("]");
            else System.out.print(healthBarA + "]");
            System.out.println();
            System.out.print(gladiatorB.getName() + " [");
            if (gladiatorB.isDead()) System.out.print("]");
            else System.out.println(healthBarB + "]");
            System.out.println();
            if (!gladiatorB.isDead()) System.out.println(gladiatorA.getName() + " attack and deal " + (hpB - gladiatorB.getHP()) +
                    " damage. And " + gladiatorB.getName() + " has " + gladiatorB.getHP() + " health points.");

            else System.out.println(gladiatorA.getName() + " attack and deal " + (hpB - gladiatorB.getHP()) +
                    " damage. And " + gladiatorB.getName() + " has " + gladiatorB.getHP() + " health points and died.");

            if (!gladiatorA.isDead()) System.out.println(gladiatorB.getName() + " attack and deal " + (hpA - gladiatorA.getHP()) +
                    " damage. And " + gladiatorA.getName() + " has " + gladiatorA.getHP() + " health points.");

            else System.out.println(gladiatorB.getName() + " attack and deal " + (hpA - gladiatorA.getHP()) +
                    " damage. And " + gladiatorA.getName() + " has " + gladiatorA.getHP() + " health points and died.");

            System.out.println();

            healthBarA = "";
            healthBarB = "";

        }
        System.out.println(logic.getWinner() + " is winner!!");
    }
}