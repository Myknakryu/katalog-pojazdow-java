package pl.myku.katalog.pojazdow;

import java.util.List;

public class WyswietlanieWarunkowe {
    public static void znajdzString(List<Pojazd> katalog, String wzorzec, int opcja) {
        var pola = Pojazd.class.getFields();
        for (var pojazd : katalog) {

            try {
                if (((String) pola[opcja].get(pojazd)).contains(wzorzec))
                    pojazd.wypisz();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void znajdzWartosc(List<Pojazd> katalog, int wartosc, int operator, int opcja) {
        var pola = Pojazd.class.getFields();

        for (var pojazd : katalog) {

            try {
                int wynik = pola[opcja].getInt(pojazd);

                if ((operator == 1 && wynik > wartosc) ||
                        (operator == 2 && wynik < wartosc) ||
                        (operator == 3 && wynik == wartosc))
                    pojazd.wypisz();

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void znajdzSkrzynia(List<Pojazd> katalog, typ_skrzyni opcja) {
        for (var pojazd : katalog) {
            if (pojazd.Skrzynia == opcja)
                pojazd.wypisz();
        }
    }
}
