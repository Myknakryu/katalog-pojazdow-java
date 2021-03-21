package pl.myku.katalog.pojazdow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OperacjePlikowe {
    public static void zapisDoPliku(List<Pojazd> katalog) {
        try {
            FileOutputStream fos = new FileOutputStream("katalog.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(katalog);
            oos.close();
        } catch (Exception e) {
            System.out.printf("Program napotkał problem podczas zapisu:\n%s\n", e.toString());
        }
    }

    public static List<Pojazd> wczytajPlik() {
        List<Pojazd> katalog;
        try {
            FileInputStream fis = new FileInputStream("katalog.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            katalog = (List<Pojazd>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.printf("Program napotkał problem podczas wczytywania:\n%s\n", e.toString());
            katalog = new ArrayList<Pojazd>();
        }
        return katalog;
    }
}
