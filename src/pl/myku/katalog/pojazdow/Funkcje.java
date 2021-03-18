package pl.myku.katalog.pojazdow;

import java.lang.reflect.Field;
import java.util.List;

public class Funkcje {
    public static <T> T swap(T a, T b) {
        return a;
    }

    public static void sortuj(List<Pojazd> katalog, Field[] pola, int opcja, int rosnaca){
        katalog.sort((o1, o2) -> {
            try {
                if(rosnaca==0)
                    o2 = swap(o1, o1 = o2);
                var typ = pola[opcja].getType();
                if(typ.equals(int.class)){
                    return (pola[opcja].getInt(o1) -
                            pola[opcja].getInt(o2));
                }
                else if(typ.equals(String.class)){
                    return ((String) pola[opcja].get(o1)).compareTo(
                            (String) pola[opcja].get(o2));
                }
                else if(typ.equals(typ_skrzyni.class)){
                    return (((typ_skrzyni) pola[opcja].get(o1)).name().compareTo(
                            ((typ_skrzyni) pola[opcja].get(o2)).name()));
                }
                return 0;

            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return 0;
            }
        });
        Interfejs.wypiszKatalog(katalog);
    }
}
