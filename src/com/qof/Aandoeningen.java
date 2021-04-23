package com.qof;

public class Aandoeningen {
    private final String naam;
    private final double verkortingLevensverwachting;
    private final double levensKwaliteit;

    public Aandoeningen(String naam, double verkortingLevensverwachting, double levensKwaliteit){
        this.naam = naam;
        this.verkortingLevensverwachting = verkortingLevensverwachting;
        this.levensKwaliteit = levensKwaliteit;
    }

    public double getLevensKwaliteit() {
        return levensKwaliteit;
    }

    public double getVerkortingLevensverwachting() {
        return verkortingLevensverwachting;
    }

    public String getNaam() { return naam; }

    public String toString(){
        return "Aandoening: " + naam + "\nVerkorte levensverwachting: " + verkortingLevensverwachting + " Jaar \nKwaliteit van leven: " + levensKwaliteit +"\n";
    }
}
