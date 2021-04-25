package com.qof;

import java.util.HashSet;
import java.util.Set;

public class Baby extends Persoon implements Patiënt {
    private final Leeftijdcategory leeftijdCategory;
    private final Set<Aandoeningen> aandoeningen = new HashSet<>();

    public Baby(String naam, String geslacht, int leeftijd, Leeftijdcategory leeftijdCategory) {
        super(naam, geslacht, leeftijd);
        this.leeftijdCategory = leeftijdCategory;
    }

    public void setAandoening(Aandoeningen aandoeningen){
        this.aandoeningen.add(aandoeningen);
    }

    public String babyCry(){
        return getNaam() + ": Mweeehhh";
    }

    private boolean babyExtreemHuilen(){
        boolean cry = false;
        if (getKwaliteitVanLeven() < 3){
            if (Math.random() < 0.5){
                cry = true;
            }
        }
        return cry;
    }

    private boolean oudersMerkenOp(){
        boolean notice = false;
        if (babyExtreemHuilen()){
            if (Math.random() < 0.5){
                notice = true;
            }
        }
        return notice;
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
            Aandoeningen += "\nHeeft geen aandoeningen\n";
            return Aandoeningen;
        }
        Aandoeningen +=  "\nTotaal aantal aandoeningen: " + aandoeningen.size() + "\nHeeft de volgende aandoeningen:";
        for ( Aandoeningen aandoeningen : aandoeningen){
            Aandoeningen += "\n" + aandoeningen.toString();
        }
        return Aandoeningen;
    }

    @Override
    public boolean heeftAandoenigen() {
        if (aandoeningen.isEmpty() || !this.getLevend()){
            return false;
        }
        return true;
    }


    @Override
    public double getLeeftijdsverwachting() {
        double levensVerwachting = 85;
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
                if (babyExtreemHuilen()){
                    if (oudersMerkenOp()){
                        return getNaam() + ": is naar het ziekenhuis gebracht.";
                    }
                }

                if (getZichtbaarheid() > 5){
                    return getNaam() + ": is naar het ziekenhuis gebracht.";
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

    public String equals(Baby baby) {
        if (this == baby){
            return getNaam() +  " is het zelfde baby als " + baby.getNaam() ;
        }
        return getNaam() +  " is het zelfde baby als " + baby.getNaam() ;

    }


}
