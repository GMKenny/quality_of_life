package com.qof;

import java.util.HashSet;
import java.util.Set;

public class Kind extends Persoon implements KwaliteitVanLeven{
    private final Leeftijdcategory leeftijdCategory;
    private Set<Aandoeningen> aandoeningen = new HashSet<>();

    public Kind(String naam, String geslacht, int leeftijd, Leeftijdcategory leeftijdCategory) {
        super(naam, geslacht, leeftijd);
        this.leeftijdCategory = leeftijdCategory;
    }

    public void setAandoening(Aandoeningen aandoeningen){
        this.aandoeningen.add(aandoeningen);
    }

    public String buitenSpelen(Aandoeningen aandoeningen){
        if (Math.random() < 0.5){
            setAandoening(aandoeningen);
            return getNaam() + ": Heeft tijdens buiten spelen een aandoening opgelopen: " + aandoeningen.getNaam();
        }
        return getNaam() + ": is buiten wezen spelen.";
    }

    private boolean praatOverProbleem(){
        boolean praat = false;
        if (getKwaliteitVanLeven() < 5){
            if (Math.random() < 0.5){
                praat = true;
            }
        }
        return praat;
    }

    private boolean oudersMerkenOp(){
        boolean oudersMerkenop = false;

        if (Math.random() < 0.5){
            return true;
        }

        if(praatOverProbleem()){
            oudersMerkenop = true;
        }
        return oudersMerkenop;
    }


    @Override
    public String toString() {
        String samenvatting;
        samenvatting = "Naam: " + getNaam() + "\nGeslacht: " + getGeslacht() + "\nlevend: " +  getLevend() + "\nLeeftijd: "+ getLeeftijd()  +  "\nLeeftijds Category: " +
                leeftijdCategory.toString() + "\nVerwachte Levensverwachting: " +  getLeeftijdsverwachting() + " jaar."+ "\n"+
                "Verwachte Levens kwaliteit: " + getKwaliteitVanLeven() + getAandoeningen();
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
    public double getLeeftijdsverwachting() {
        double levensVerwachting = 80;
        double leeftijdsverwachting = levensVerwachting;
        for ( Aandoeningen aandoeningen : aandoeningen){
            leeftijdsverwachting -= aandoeningen.getVerkortingLevensverwachting();
        }
        if (leeftijdsverwachting < 0){
            return 0;
        }
        return (int)leeftijdsverwachting;
    }

    @Override
    public double getKwaliteitVanLeven() {
        double levensKwaliteit = 10;
        for ( Aandoeningen aandoeningen : aandoeningen){
            levensKwaliteit = (levensKwaliteit - (levensKwaliteit - aandoeningen.getLevensKwaliteit()));
        }

        return Math.round(levensKwaliteit * 100.0) / 100.0;
    }

    @Override
    public double getZichtbaarheid() {
        double zichtbaar = 0;
        for ( Aandoeningen aandoeningen : aandoeningen){
            zichtbaar += aandoeningen.getZichtbaarheid();
        }
        return zichtbaar;
    }

    @Override
    public boolean getErnst() {
        boolean Ernst = false ;
        for ( Aandoeningen aandoeningen : aandoeningen){
            if (aandoeningen.getDoodelijkheid()) {
                Ernst = true;
                break;
            }
        }
        return Ernst;
    }


    @Override
    public String Yearpassed() {
        if (getLevend()){
            setLeeftijd(getLeeftijd() + 1);
            if (getErnst()){

                if (oudersMerkenOp()){
                    return getNaam() + ": is naar het ziekenhuis gebracht.";
                }

                if (getZichtbaarheid() > 5){
                    return getNaam() + ": is naar het ziekenhuis gebracht.";
                }
                setLevend(false);
                return getNaam() + ": Is helaas overleden";
            }

            if (getLeeftijdsverwachting() == getLeeftijd()){
                return  getNaam() + ": Is overleden op een" + getLeeftijd() + "jarige leeftijd.";
            }

            return getNaam() + ": Heeft het 1 jaar langer overleefd.";
        }
        return "";

    }

    public String equals(Kind kind) {
        if (this == kind){
            return "Dit is het zelfde kind";
        }
        return "Dit is niet het zelfde kind";
    }


}
