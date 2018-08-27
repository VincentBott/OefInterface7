package com.company;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainInterface {

    public static void main(String[] args) {

        ArrayList<Persoon> personen = new ArrayList<>();

        personen.add(new Persoon("Karen",LocalDate.of(1974, 10, 28)));
        personen.add(new Persoon("Kristel", LocalDate.of(1975, 12, 10)));
        personen.add(new Persoon("Kathleen", LocalDate.of(1978, 6, 18)));
        personen.add(new Persoon("Hanne", LocalDate.of(1994, 3, 3)));
        personen.add(new Persoon("Marthe", LocalDate.of(1996, 7, 16)));
        personen.add(new Persoon("Klaasje", LocalDate.of(1995, 3, 2)));



 //       Collections.sort(personen, new PersoonComparator());       Deze manier kan ook.


        personen.sort(new PersoonComparator());


        for(Persoon p: personen){

            System.out.println(p.getNaam());
        }
    }
}


class PersoonComparator implements Comparator<Persoon> {


    @Override
    public int compare(Persoon o1, Persoon o2) {

        return o1.getNaam().compareTo(o2.getNaam());

    }
}




class Persoon implements Comparable<Persoon> {

    private String naam;

    private LocalDate geboorteDatum;

    public Persoon(String naam, LocalDate geboorteDatum) {

        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
    }


    public String getNaam() {
        return naam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public int getLeeftijd() {

        LocalDate vandaag = LocalDate.now();

        int leeftijd = vandaag.getYear() - geboorteDatum.getYear();
        if (geboorteDatum.getDayOfYear() > vandaag.getDayOfYear()) leeftijd--;
        return leeftijd;
    }

    @Override
    public int compareTo(Persoon o) {
        return this.getLeeftijd() - o.getLeeftijd();
    }
}