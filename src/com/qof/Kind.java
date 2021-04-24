package com.qof;

import java.util.HashSet;
import java.util.Set;

public class Kind extends Persoon implements KwaliteitVanLeven{
    private final Leeftijdcategory leeftijdCategory;
    private final double levensVerwachting = 51;
    private final double levensKwaliteit = 10;
    private Set<Aandoeningen> aandoeningen = new HashSet<>();

    public Kind(String naam, String geslacht, int leeftijd, Leeftijdcategory leeftijdCategory) {
        super(naam, geslacht, leeftijd);
        this.leeftijdCategory = leeftijdCategory;
    }

    public void setAandoening(Aandoeningen aandoeningen){
        this.aandoeningen.add(aandoeningen);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String getAandoeningen() {
        return null;
    }

    @Override
    public String getLeeftijdsverwachting() {
        return null;
    }

    @Override
    public String getKwaliteitVanLeven() {
        return null;
    }

    @Override
    public String Yearpassed() {
        return null;
    }


}
