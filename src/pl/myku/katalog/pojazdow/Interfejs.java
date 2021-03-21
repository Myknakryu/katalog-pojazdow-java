package pl.myku.katalog.pojazdow;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfejs {

    static Scanner skaner = new Scanner(System.in);

    public static int uzyskajInt(){
        while(true){
            int x;
            try{
                x = skaner.nextInt();
                skaner.nextLine();
                return x;
            }
            catch(Exception e){
                skaner.nextLine();
            }
        }
    }

    public static void wypiszKatalog(List<Pojazd> katalog){
        for(var element: katalog){
            element.wypisz();
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

    public static int wyborElementu(List<Pojazd> katalog, String wiadomosc) {
        int opcja, rozmiar = katalog.size();
        while (true)
        {
            System.out.printf("%s\nPodaj wartosc od 1 do %d: ", wiadomosc, rozmiar);
            opcja = uzyskajInt();
            if(opcja > 0 && opcja <=rozmiar)
                return opcja-1;
        }
    }

    public static int wybierzPole(){
        int i = 0;
        var pola = Pojazd.class.getFields();
        for(Field pole : pola){
            System.out.printf("%d. %s\n",i++, pole.getName());
        }
        return uzyskajInt();
    }

    public static void wyborSortowanie(List<Pojazd> katalog){

        int opcja = wybierzPole();
        System.out.println("Rosnąco(dowolna liczba) czy malejąco(0): ");
        int rosnaca = uzyskajInt();
        Funkcje.sortuj(katalog, Pojazd.class.getFields(), opcja, rosnaca);
    }
    public static void wyborSzukania(List<Pojazd> katalog){
        int opcja = wybierzPole();
        switch(Funkcje.sprawdzTyp(opcja)){
            case 1:{
                System.out.println("Podaj czy ma być: \n(1) większe \n(2) mniejsze\n (3)równe\n");
                int operator = uzyskajInt();
                System.out.println("Wprowadź wartość: ");
                int wart = uzyskajInt();
                WyswietlanieWarunkowe.znajdzWartosc(katalog,wart,operator,opcja);
                break;
            }
            case 2:{
                System.out.println("podaj wzorzec: ");
                String wzorzec = skaner.nextLine();
                WyswietlanieWarunkowe.znajdzString(katalog, wzorzec, opcja);
                break;
            }
            case 3:{
                System.out.println("Podaj czy ma być: \n(0) automatyczna \n(dowolna) manualna\n");
                int wart = uzyskajInt();
                WyswietlanieWarunkowe.znajdzSkrzynia(katalog,
                        (wart!=0?typ_skrzyni.manualna:typ_skrzyni.automatyczna));
                break;
            }
            default:{
                System.out.println("Błędne pole!");
                break;
            }
        }
    }

    public static void obslugaMenu(){
        List<Pojazd> katalog = new ArrayList<>();
        while(true){
            generujMenu();
            int opcja = uzyskajInt();
            switch(opcja){
                case 1:{
                    katalog = OperacjePlikowe.wczytajPlik();
                    break;
                }
                case 2:{
                    OperacjePlikowe.zapisDoPliku(katalog);
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
                    wyborSzukania(katalog);
                    break;
                }
                case 6:{
                    katalog.get(wyborElementu(katalog, "Podaj element do wyświetlenia")).wypisz();
                    break;
                }
                case 7:{
                    wyborSortowanie(katalog);
                    break;
                }
                case 8:{
                    katalog.remove(wyborElementu(katalog, "Podaj element do usunięcia"));
                    break;
                }
                case 9:{
                    System.exit(0);
                }
            }
        }
    }
}
