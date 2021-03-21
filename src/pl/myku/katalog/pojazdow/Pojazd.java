package pl.myku.katalog.pojazdow;

import java.io.Serializable;

enum typ_skrzyni {manualna, automatyczna}

public class Pojazd implements Serializable {

    public String Marka;
    public String Model;
    public int Rocznik;
    public int Pojemnosc;
    public int Przebieg;
    public typ_skrzyni Skrzynia;

    public Pojazd() {}

    public Pojazd(String Marka, String Model, int Rocznik, int Pojemnosc, int Przebieg, typ_skrzyni Skrzynia) {
        this.Marka = Marka;
        this.Model = Model;
        this.Rocznik = Rocznik;
        this.Pojemnosc = Pojemnosc;
        this.Przebieg = Przebieg;
        this.Skrzynia = Skrzynia;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %d - %d cm³ - %dkm - %s", Marka, Model, Rocznik, Pojemnosc, Przebieg, (Skrzynia == typ_skrzyni.automatyczna ? "Automatyczna" : "Manualna"));
    }

    public void wypisz() {
        System.out.println(toString());
    }
}
