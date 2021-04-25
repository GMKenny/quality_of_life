package com.qof;

import java.util.HashSet;
import java.util.Set;

public class Behandeling {
    private final Set<Patiënt> Patiënten = new HashSet<>();
    private final int MaxPatients = 10;

    public Behandeling(Patiënt patiënt){
        if (patiënt.heeftAandoenigen()){
            Patiënten.add(patiënt);
        }
    }

    public String addPatiënt(Patiënt patiënt){
        if (patiënt.heeftAandoenigen()){
            if (!Patiënten.contains(patiënt)){
                Patiënten.add(patiënt);
                return "De Volgende patiënt begint nu aan zijn behandeling:\n" + patiënt.toString();
            }
            return "De Volgende patiënt word al behandeld:\n" + patiënt.toString();
        }
        return "De Volgende Patient heeft geen aandoeningen:\n" + patiënt.toString();
    }

    public String PatientenInformatie(){
        String informatie = "De volgende patienten zijn nu onder behandeling:\n";
        int counter = 1;
        for (Patiënt patiënt : Patiënten){
            informatie += "Patiënt: " + counter + ".\n" + patiënt.toString();
            counter += 1;
        }
        if (Patiënten.isEmpty()){
            informatie = "Er zijn op het moment geen patiënten in behandeling:";
        }
        return  informatie;
    }

}
