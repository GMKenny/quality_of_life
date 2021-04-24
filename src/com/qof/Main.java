package com.qof;

public class Main {

    public static void main(String[] args) {
        Baby babyEen = new Baby("Asta","Man", 1, Leeftijdcategory.Baby);
        Baby babyTwee = new Baby("Amber","Vrouw", 1, Leeftijdcategory.Baby);
        Kind kindEen = new Kind( "Kees", "Man", 1, Leeftijdcategory.Kind);
        Puber puberEen = new Puber("Clara", "vrouw", 17, Leeftijdcategory.Puber);
        Puber puberTwee = new Puber("Jan", "Man", 18, Leeftijdcategory.Puber);


        Aandoeningen autisme = new Aandoeningen("Autisme", 16, 7.5, 7, false, false);
        Aandoeningen hazenlip = new Aandoeningen("Hazenlip", 0, 9.99, 10, false, false);
        Aandoeningen hersenvliesontsteking = new Aandoeningen("Hersenvliesontsteking", 90, 2, 4, true, false);
        Aandoeningen rinovirus = new Aandoeningen("Rinovirus", 0, 8, 8, false, false);
        Aandoeningen chlamydia = new Aandoeningen("Chlamyda", 0, 7, 7, false, true);
        Aandoeningen trichomonas = new Aandoeningen( "Trichomonas", 0,7, 6, false, true);

        System.out.println(autisme.equals(hazenlip));
        System.out.println(autisme.equals(autisme));

        babyEen.setAandoening(hersenvliesontsteking);
        babyTwee.setAandoening(autisme);
        babyTwee.setAandoening(hazenlip);
        puberEen.setAandoening(rinovirus);


        System.out.println(babyEen.toString());
        System.out.println(babyTwee.toString());

        System.out.println(babyEen.babyCry());
        System.out.println(babyEen.Yearpassed());
        System.out.println(babyTwee.Yearpassed());
        System.out.println(kindEen.Yearpassed());
        System.out.println(kindEen.buitenSpelen(rinovirus));

        System.out.println(puberEen.gaatNaarFestival());
        System.out.println(puberTwee.gaatNaarFestival());



//        Aandoeningen Alzheimer = new Aandoeningen("Alzheimer", 10, 4);
//        System.out.println(Alzheimer.toString());

    }
}
