package com.qof;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class Baby extends Persoon implements KwaliteitVanLeven{
    private final Leeftijdcategory leeftijdCategory;
    private double levensVerwachting = 81;
    private final Set<Aandoeningen> aandoeningen = new HashSet<>();

    public Baby(String naam, String geslacht, int leeftijd, Leeftijdcategory leeftijdCategory) {
        super(naam, geslacht, leeftijd);
        this.leeftijdCategory = leeftijdCategory;
    }

    public void setAandoening(Aandoeningen newAandoeningen){
        this.aandoeningen.add(newAandoeningen);
    }

    @Override
    public String getAllString() {
        String samenvatting;
        samenvatting = "Naam: " + getNaam() + "\nGeslacht: " + getGeslacht() + "\nLeeftijds Category: " + leeftijdCategory.toString() + "\n";
        return samenvatting;
    }

    @Override
    public String getAandoeningenString() {
        String Aandoeningen = "Naam: " + getNaam()  + "\nLeeftijd: " + getLeeftijd();
        if (aandoeningen.isEmpty()){
            Aandoeningen += "\nHeeft de geen aandoeningen\n";
            return Aandoeningen;
        }
        Aandoeningen +=  "\nHeeft de volgende aandoeningen:\n";
        for ( Aandoeningen aandoeningen : aandoeningen){
            Aandoeningen += aandoeningen.toString();
        }
        return Aandoeningen;
    }

    @Override
    public String getLeeftijdsverwachtingString() {
        String Aandoeningen = "Naam: " + getNaam();


        return null;
    }
}
