package com.qof;

public class Main {

    public static void main(String[] args) {
        Baby een = new Baby("Asta","Man", 1, Leeftijdcategory.Baby);
        Baby twee = new Baby("Amber","Vrouw", 1, Leeftijdcategory.Baby);

        System.out.println(een.toString());

        Aandoeningen Autisme = new Aandoeningen("Autisme", 16, 7.5, 7, false);
        Aandoeningen Hazenlip = new Aandoeningen("Hazenlip", 0, 9.99, 10, false);
        Aandoeningen Hersenvliesontsteking = new Aandoeningen("Hersenvliesontsteking", 90, 2, 4, true);

        een.setAandoening(Hersenvliesontsteking);
        twee.setAandoening(Autisme);
        twee.setAandoening(Hazenlip);
        System.out.println(een.toString());
        System.out.println(twee.toString());

        System.out.println(twee.getLeeftijdsverwachting());
        System.out.println(een.getLeeftijdsverwachting());
        System.out.println(twee.getKwaliteitVanLeven());
        System.out.println(een.getKwaliteitVanLeven());


//        Aandoeningen Alzheimer = new Aandoeningen("Alzheimer", 10, 4);
//        System.out.println(Alzheimer.toString());

    }
}
