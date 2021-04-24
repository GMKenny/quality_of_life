package com.qof;

public class Aandoeningen {
    private final String naam;
    private final double verkortingLevensverwachting;
    private final double levensKwaliteit;
    private final double zichtbaarheid;
    private final boolean doodelijk;

    public Aandoeningen(String naam, double verkortingLevensverwachting, double levensKwaliteit, double zichtbaarheid, boolean doodelijk){
        this.naam = naam;
        this.verkortingLevensverwachting = verkortingLevensverwachting;
        this.levensKwaliteit = levensKwaliteit;
        this.zichtbaarheid = zichtbaarheid;
        this.doodelijk = doodelijk;
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
