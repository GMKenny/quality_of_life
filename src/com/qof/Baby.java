package com.qof;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class Baby extends Persoon implements KwaliteitVanLeven{
    private final Leeftijdcategory leeftijdCategory;
    private final double levensVerwachting = 85;
    private final double levensKwaliteit = 10;
    private final Set<Aandoeningen> aandoeningen = new HashSet<>();

    public Baby(String naam, String geslacht, int leeftijd, Leeftijdcategory leeftijdCategory) {
        super(naam, geslacht, leeftijd);
        this.leeftijdCategory = leeftijdCategory;
    }

    public void setAandoening(Aandoeningen newAandoeningen){
        this.aandoeningen.add(newAandoeningen);
    }


    @Override
    public String toString() {
        String samenvatting;
        samenvatting = "Naam: " + getNaam() + "\nGeslacht: " + getGeslacht() + "\nLeeftijds Category: " +
                leeftijdCategory.toString() + "\n" +  getLeeftijdsverwachting() + "\n"+  getKwaliteitVanLeven() + getAandoeningen();
        return samenvatting;
    }

    @Override
    public String getAandoeningen() {
        String Aandoeningen = "";
        if (aandoeningen.isEmpty()){
            Aandoeningen += "\nHeeft de geen aandoeningen\n";
            return Aandoeningen;
        }
        Aandoeningen +=  "\nTotaal aantal aandoeningen: " + aandoeningen.size() + "\nHeeft de volgende aandoeningen:\n";
        for ( Aandoeningen aandoeningen : aandoeningen){
            Aandoeningen += aandoeningen.toString() + "\n";
        }
        return Aandoeningen;
    }

    @Override
    public String getLeeftijdsverwachting() {
        double leeftijdsverwachting = this.levensVerwachting - getLeeftijd();
        for ( Aandoeningen aandoeningen : aandoeningen){
            leeftijdsverwachting -= aandoeningen.getVerkortingLevensverwachting();
        }
        return "Verwachte Leeftijdverwachting: " + (int)leeftijdsverwachting;
    }

    @Override
    public String getKwaliteitVanLeven() {
        double levensKwaliteit = this.levensKwaliteit;
        for ( Aandoeningen aandoeningen : aandoeningen){
            levensKwaliteit = (levensKwaliteit - (levensKwaliteit - aandoeningen.getLevensKwaliteit()));
        }

        return "Verwachte Levens kwaliteit: " + Math.round(levensKwaliteit * 100.0) / 100.0;
    }

    @Override
    public String Yearpassed() {
        return null;
    }


}
