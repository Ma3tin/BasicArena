package cz.educanet.arena.data;

import cz.educanet.arena.logic.Gladiator;

import java.io.*;

/**
 * Utils class that saves and loads gladiators.
 */
public class GladiatorDatabase {

    /**
     * @param filename path to the gladiator file.
     * @return loaded Gladiator
     */
    public static Gladiator loadGladiator(String filename) {
        Gladiator gl = new Gladiator();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            gl.setName(br.readLine());
            gl.setHP(Integer.parseInt(br.readLine()));
            gl.setMinDamage(Integer.parseInt(br.readLine()));
            gl.setMaxDamage(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gl;
    }

    /**
     * Saves the gladiator.
     * @param filename path to save too.
     * @param gladiator Gladiator to save.
     */
    public static void saveGladiator(String filename, Gladiator gladiator) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(gladiator.getName());
            bw.newLine();
            bw.write(gladiator.getHP() + "");
            bw.newLine();
            bw.write(gladiator.getMinDamage() + "");
            bw.newLine();
            bw.write(gladiator.getMaxDamage() + "");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
