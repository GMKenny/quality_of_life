package com.qof;

public class Aandoeningen {
    private final String naam;
    private final double verkortingLevensverwachting;
    private final double levensKwaliteit;
    private final double zichtbaarheid;
    private final boolean ernst;
    private final boolean soa;

    public Aandoeningen(String naam, double verkortingLevensverwachting, double levensKwaliteit, double zichtbaarheid, boolean ernst, boolean soa){
        this.naam = naam;
        this.verkortingLevensverwachting = verkortingLevensverwachting;
        this.levensKwaliteit = levensKwaliteit;
        this.zichtbaarheid = zichtbaarheid;
        this.ernst = ernst;
        this.soa = soa;

    }

    public double getLevensKwaliteit() {
        return levensKwaliteit;
    }

    public double getVerkortingLevensverwachting() {
        return verkortingLevensverwachting;
    }

    public double getZichtbaarheid(){ return zichtbaarheid; }

    public boolean getDoodelijkheid(){ return ernst; }

    public boolean getSoa(){ return soa;}

    public String equals(Aandoeningen aandoeningen){
        if (this == aandoeningen){
            return this.naam + " is gelijk aan " + aandoeningen.naam;
        }
        return this.naam + " is niet gelijk aan " + aandoeningen.naam;
    }

    public String getNaam() { return naam; }

    public String toString(){
        return "Aandoening: " + naam  + "\nKwaliteit van leven: " + levensKwaliteit +"\n";
    }
}
