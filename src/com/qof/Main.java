package com.qof;

public class Main {

    public static void main(String[] args) {
        Baby babyEen = new Baby("Asta","Man", 1, Leeftijdcategory.Baby);
        Baby babyTwee = new Baby("Amber","Vrouw", 1, Leeftijdcategory.Baby);
        Kind kindEen = new Kind( "Kees", "Man", 1, Leeftijdcategory.Kind);
        Puber puberEen = new Puber("Clara", "vrouw", 17, Leeftijdcategory.Puber);
        Puber puberTwee = new Puber("Jan", "Man", 18, Leeftijdcategory.Puber);
        Volwassen volwassenEen = new Volwassen("Johan", "Man", 27, Leeftijdcategory.Volwassen);
        Volwassen volwassenTwee = new Volwassen("Sara", "Vrouw", 34, Leeftijdcategory.Volwassen);
        Volwassen volwassenDrie = new Volwassen("Mitchel", "Man", 31, Leeftijdcategory.Volwassen);
        Volwassen volwassenVier = new Volwassen("Lieke", "Vrouw", 29, Leeftijdcategory.Volwassen);
        Senior seniorEen = new Senior("Henk", "Man", 61, Leeftijdcategory.Senior);
        Senior seniorTwee = new Senior("Bianca", "Vrouw", 61, Leeftijdcategory.Senior);

        Aandoeningen autisme = new Aandoeningen("Autisme", 16, 7.5, 7, false, false);
        Aandoeningen hazenlip = new Aandoeningen("Hazenlip", 0, 9.99, 10, false, false);
        Aandoeningen hersenvliesontsteking = new Aandoeningen("Hersenvliesontsteking", 90, 2, 4, true, false);
        Aandoeningen rinovirus = new Aandoeningen("Rinovirus", 0, 8, 8, false, false);
        Aandoeningen chlamydia = new Aandoeningen("Chlamyda", 0, 7, 7, false, true);
        Aandoeningen trichomonas = new Aandoeningen( "Trichomonas", 0,7, 6, false, true);

        System.out.println(autisme.equals(hazenlip));
        System.out.println(autisme.equals(autisme));
        System.out.println(seniorTwee.equals(seniorEen));
        System.out.println(kindEen.equals(kindEen));
        System.out.println(puberTwee.equals(puberEen));

        babyEen.setAandoening(hersenvliesontsteking);
        babyTwee.setAandoening(autisme);
        babyTwee.setAandoening(hazenlip);
        puberEen.setAandoening(rinovirus);
        volwassenEen.setAandoening(chlamydia);
        volwassenTwee.setAandoening(trichomonas);
        volwassenDrie.setAandoening(hersenvliesontsteking);
        seniorEen.setAandoening(hersenvliesontsteking);

        System.out.println(babyEen.toString());
        System.out.println(babyTwee.toString());

        System.out.println(babyEen.babyCry());
        System.out.println(babyEen.yearPassed());
        System.out.println(babyTwee.yearPassed());
        System.out.println(kindEen.yearPassed());
        System.out.println(kindEen.buitenSpelen(rinovirus));
        System.out.println(puberEen.gaatNaarFestival());
        System.out.println(puberTwee.gaatNaarFestival());
        System.out.println(seniorEen.kennisGeven(volwassenVier));
        System.out.println(seniorEen.yearPassed());
        System.out.println(volwassenEen.relaatsiesMetElkaar(volwassenTwee));
        System.out.println(volwassenDrie.relaatsiesMetElkaar(volwassenVier));
        System.out.println(volwassenTwee.relaatsiesMetElkaar(volwassenVier));
        System.out.println(volwassenVier.toString());
        System.out.println(volwassenDrie.toString());

        Behandeling behandelingEen = new Behandeling(kindEen);
        System.out.println(behandelingEen.addPatiënt(kindEen));
        System.out.println(behandelingEen.addPatiënt(babyEen));
        System.out.println(behandelingEen.addPatiënt(volwassenVier));
        System.out.println(behandelingEen.addPatiënt(volwassenDrie));
        System.out.println(behandelingEen.PatientenInformatie());
    }
}
