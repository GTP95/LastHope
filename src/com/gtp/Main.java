package com.gtp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    printMainMenu();

    }

    public static void calcolaIndici(){
        ArrayList<Float> voti=new ArrayList<>();
        float media;
        double mediaDegliScostamenti;
        int numeroSufficienze;
        float percentualeSufficienze;
        float varianza;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Inserire qualsiasi lettera per terminare l'inserimento dei voti");
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
        varianza=varianza(voti, media);

        System.out.println("La media dei voti è " + media);
        System.out.println();
        System.out.println("INDICI FARLOCCHI:");
        System.out.println("La media degli scostamenti è " + mediaDegliScostamenti);
        System.out.println("I voti maggiori o uguali a 6 sono " + numeroSufficienze + "/" + voti.size() + " cioè il " + percentualeSufficienze*100+"%");
        System.out.println();
        System.out.println("INDICI DI DISPERSIONE:");
        System.out.println("Varianza: " + varianza);
        System.out.println();
        System.out.println();
        System.out.print("Eseguire il calcolo per una nuova lista di voti? [S/n] ");
       // while (!scanner.hasNextLine()); //aspetta che l'utente iserisca qualcosa
        if(scanner.next().equals("s") || scanner.next().equals("S") || scanner.next().isEmpty()) calcolaIndici();
    }

    public static float media(ArrayList<Float> voti){
        int somma=0;
        for (int index=0; index<voti.size(); index++) somma+=voti.get(index);
        return (float)somma/voti.size();
    }

    public static double mediaDegliScostamenti(ArrayList<Float> voti, float media){
        double scostamento;
        double sommaDegliScostamenti=0f;
        for(float voto : voti){
            scostamento=voto-media;
            sommaDegliScostamenti+=scostamento;
        }

        return sommaDegliScostamenti/voti.size();
    }

    public static float varianza(ArrayList<Float> voti, float media){
        float somma=0;
        for(float voto : voti){
            somma+=Math.pow(voto-media, 2);
        }
        return somma/(voti.size()-1);
    }

   public static int contaSufficienze(ArrayList<Float> voti){
        int counter=0;
        for(float voto : voti) if(voto>=6) counter++;
        return counter;
    }

    public static void printMainMenu(){
        System.out.println("Software rilasciato sotto licenza GPLv3");
        System.out.println("Il testo completo della licenza è disponibile al seguente indirizzo: https://www.gnu.org/licenses/gpl-3.0.en.html");
        System.out.println("Il codice sorgente di questo programma è disponibile al seguente indirizzo: https://github.com/GTP95/LastHope");
        System.out.println();
        System.out.println("MENÙ PRINCIPALE");
        System.out.println("1. Calcola media e indici di dispersione");
        System.out.println("2. Note sull'utilizzo del programma");
        System.out.println("3. Esci");
        selezione();
    }

    private static void selezione(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Inserire selezione: ");
        switch(scanner.nextInt()){
            case 1:
                calcolaIndici();
                break;
            case 2:
                stampaNote();
                printMainMenu();
                break;
            case 3:
                break;
            default:
                System.err.println("Inserire un numero nell'intervallo [1,3]");
                selezione();
        }
    }

    public static void stampaNote(){
        System.out.println("Il separatore per le cifre decimali può essere il punto o la virgola, in base alle impostazioni del computer.");
        System.out.println("La \"media degli scostamenti\" viene calcolata sottraendo a ciascun voto la media dei voti e facendo la media dei valori così ottenuti.");
        System.out.println("Un valore positivo, per esempio 0.5, indica che i voti sono mediamente più alti della media. In questo esempio in media sono più alti di mezzo voto.");
        System.out.println("Viceversa un valore negativo indica che sono mediamente più bassi della media");
        System.out.println("Nel caso il risultato sia 0 ignorare questo indice ed affidarsi alla varianza");
        System.out.println("ATTENZIONE: questo indice non viene utilizzato in Statistica, usarlo con precauzione!");
    }

}
