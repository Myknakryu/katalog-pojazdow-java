package pl.myku.katalog.pojazdow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfejs {

    static Scanner skaner = new Scanner(System.in);

    public static int uzyskajInt(){
        while(true){

            try{
                return skaner.nextInt();
            }
            catch(Exception e){
                skaner.nextLine();
            }
        }

    }

    public static void wypiszKatalog(List<Pojazd> katalog){
        for(var element: katalog){
            element.Wypisz();
        }
    }

    public static void generujMenu(){
        String[] elementy= {"Wczytanie z katalogu", "Zapis katalogu z pliku", "Wprowadzanie nowego samochodu",
                "Wyświetlenie listy pojazdów", "Wyświetlenie warunkowe", "Wyświetlenie pojedynczego samochodu", "Sortowanie",
                "Usuniecie z katalogu", "Wyjście"};
        int i = 1;
        for(String opcja: elementy){
            System.out.printf("%d. %s%n", i++, opcja);
        }
    }


    public static Pojazd wczytajPojazd(){
        String[] opcje = { "Podaj markę", "Podaj model", "Podaj rocznik", "Podaj pojemność (w cm³)", "Podaj przebieg (w km)", "Podaj typ skrzyni\n 1- automatyczna by ustawić automatyczna" };
        int i = 0;
        Pojazd samochod = new Pojazd();
        System.out.printf("%s: ", opcje[i++]);
        samochod.Marka = skaner.nextLine();
        System.out.printf("%s: ", opcje[i++]);
        samochod.Model = skaner.nextLine();
        System.out.printf("%s: ", opcje[i++]);
        samochod.Rocznik = uzyskajInt();
        System.out.printf("%s: ", opcje[i++]);
        samochod.Pojemnosc = uzyskajInt();
        System.out.printf("%s: ", opcje[i++]);
        samochod.Przebieg = uzyskajInt();
        System.out.printf("%s: ", opcje[i]);
        samochod.Skrzynia = (uzyskajInt()== 1?typ_skrzyni.automatyczna:typ_skrzyni.manualna);
        return samochod;
    }

    public static void obslugaMenu(){
        List<Pojazd> katalog = new ArrayList<>();
        while(true){
            generujMenu();
            int opcja = uzyskajInt();
            switch(opcja){
                case 1:{

                    break;
                }
                case 2:{

                    break;
                }
                case 3:{
                    katalog.add(wczytajPojazd());
                    break;
                }
                case 4:{
                    wypiszKatalog(katalog);
                    break;
                }
                case 5:{

                    break;
                }
                case 6:{

                    break;
                }
                case 7:{

                    break;
                }
                case 8:{

                    break;
                }
                case 9:{
                    System.exit(0);
                }
            }
        }
    }
}
