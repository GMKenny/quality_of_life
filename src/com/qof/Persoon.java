package com.qof;

public class Persoon {
    private final String naam;
    private final String geslacht;
    private final int leeftijd;


    public Persoon(String naam, String geslacht, int leeftijd){
        this.naam = naam;
        this.geslacht = geslacht;
        this.leeftijd = leeftijd;
    }

    public String getNaam() {
        return naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public int getLeeftijd() { return leeftijd; }
}


