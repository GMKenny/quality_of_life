package com.qof;

import java.util.HashSet;
import java.util.Set;

public class Volwassen extends Persoon implements Patiënt {
    private final Leeftijdcategory leeftijdCategory;
    private Set<Aandoeningen> aandoeningen = new HashSet<>();

    public Volwassen(String naam, String geslacht, int leeftijd, Leeftijdcategory leeftijdCategory) {
        super(naam, geslacht, leeftijd);
        this.leeftijdCategory = leeftijdCategory;
    }

    public void setAandoening(Aandoeningen aandoeningen){
        this.aandoeningen.add(aandoeningen);

    }

    public String relaatsiesMetElkaar(Volwassen volwassen){
        Set<Aandoeningen> soa = new HashSet<>();
        for (Aandoeningen aandoeningen : aandoeningen){
            if (aandoeningen.getSoa()){
                soa.add(aandoeningen);
            }
        }
        for (Aandoeningen aandoeningen : volwassen.aandoeningen){
            if (aandoeningen.getSoa()){
                soa.add(aandoeningen);
            }
        }
        if (!soa.isEmpty()){
            for (Aandoeningen aandoeningen : soa){
                this.setAandoening(aandoeningen);
                volwassen.setAandoening(aandoeningen);
            }
            return getNaam() + " en " + volwassen.getNaam() + " hebben de liefdesdaad verricht en hebben soa op gelopen";
        }
        return getNaam() + " en " + volwassen.getNaam() + " hebben de liefdesdaad verricht";
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
            Aandoeningen += "\nHeeft de geen aandoeningen";
            return Aandoeningen;
        }
        Aandoeningen +=  "\nTotaal aantal aandoeningen: " + aandoeningen.size() + "\nHeeft de volgende aandoeningen:\n";
        for ( Aandoeningen aandoeningen : aandoeningen){
            Aandoeningen += aandoeningen.toString() + "\n";
        }
        return Aandoeningen;
    }

    @Override
    public boolean heeftAandoenigen() {
        return !aandoeningen.isEmpty();
    }


    @Override
    public double getLeeftijdsverwachting() {
        double levensVerwachting = 40;
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
                if (getKwaliteitVanLeven() < 5 || getZichtbaarheid() > 5){
                    return getNaam() + ": is naar het ziekenhuis gegaan.";
                }
                setLevend(false);
                return getNaam() + ": Is helaas overleden";
            }

            if (getLeeftijdsverwachting() == getLeeftijd()){
                setLevend(false);
                return  getNaam() + ": Is overleden op een" + getLeeftijd() + "jarige leeftijd.";
            }

            return getNaam() + ": Heeft het 1 jaar langer overleefd.";
        }
        return "";
    }


    public String equals(Volwassen volwassen) {
        if (this == volwassen){
            return getNaam() +  " is het dezelfde volwassen als " + volwassen.getNaam() ;
        }
        return getNaam() +  " is niet dezelfde volwassen als " + volwassen.getNaam() ;
    }

}
