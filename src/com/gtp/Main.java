package com.gtp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    ArrayList<Float> voti=new ArrayList<>();
	    float media;
	    float mediaDegliScostamenti;
	    int numeroSufficienze;
	    float percentualeSufficienze;
        Scanner scanner=new Scanner(System.in);
        int numeroVoto=1;
        while (true){
            System.out.print("Inserire voto " + numeroVoto + ":");
            if(scanner.hasNextFloat()) voti.add(scanner.nextFloat());
            else break;
            numeroVoto++;
        }

        media=media(voti);
        mediaDegliScostamenti=mediaDegliScostamenti(voti, media);
        numeroSufficienze=contaSufficienze(voti);
        percentualeSufficienze=(float)numeroSufficienze/voti.size();

        System.out.println("La media dei voti è " + media);
        System.out.println();
        System.out.println("INDICI FARLOCCHI:");
        System.out.println("La media degli scostamenti è " + mediaDegliScostamenti);
        System.out.println("I voti maggiori o uguali a 6 sono " + numeroSufficienze + "/" + voti.size() + "cioè lo " + percentualeSufficienze*100+"%");
        System.out.println();
        System.out.println("INDICI DI DISPERSIONE:");


    }

    public static float media(ArrayList<Float> voti){
        int somma=0;
        for (int index=0; index<voti.size(); index++) somma+=voti.get(index);
        return somma/voti.size();
    }

    public static float mediaDegliScostamenti(ArrayList<Float> voti, float media){
        float scostamento;
        float sommaDegliScostamenti=0;
        for(int index=0; index<voti.size(); index++){
            scostamento=voti.get(index)-media;
            sommaDegliScostamenti+=scostamento;
        }

        return sommaDegliScostamenti/voti.size();
    }

   public static int contaSufficienze(ArrayList<Float> voti){
        int counter=0;
        for(float voto : voti) if(voto>=6) counter++;
        return counter;
    }

    public static void printMainMenu(){
        System.out.println("Software rilasciato sotto licenza GPLv3");
        System.out.println("Il testo completo della licenza è disponibile al seguente indirizzo: https://www.gnu.org/licenses/gpl-3.0.en.html");
        System.out.println("Il codice sorgente di questo programma è disponibile al seguente indirizzo: ");
        System.out.println();
        System.out.println("MENÙ PRINCIPALE");
        System.out.println("1) Calcola media e indici di dispersione");
        System.out.println("2. Note sull'utilizzo del programma");
        System.out.println("3. Esci");
        
    }
}
