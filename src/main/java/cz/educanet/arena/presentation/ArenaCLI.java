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
        System.out.println("Pick your fighter #1 (enter the path of the saved file):");
        String gladiator1File = sc.nextLine();
        System.out.println("Pick your fighter #2 (enter the path of the saved file):");
        String gladiator2File = sc.nextLine();

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
        while (logic.getWinner() == null) {
            logic.fight();
            System.out.println(gladiatorA.getName() + " " + gladiatorA.getHP());
            System.out.println(gladiatorB.getName() + " " + gladiatorB.getHP());
            System.out.println("--------------------");
        }
        System.out.println(logic.getWinner() + " is winner!!");
    }

}
