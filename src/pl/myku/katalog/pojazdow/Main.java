package pl.myku.katalog.pojazdow;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        Pojazd jakisPojazd = new Pojazd();
        for(Field pole : jakisPojazd.getClass().getDeclaredFields()){
            System.out.println(pole.getName());
        }
	    Interfejs.obslugaMenu();
    }
}
