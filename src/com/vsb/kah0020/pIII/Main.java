package com.vsb.kah0020.pIII;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int pocet = 4;
        //System.out.println(pocet);
        int cislo[] = new int[pocet];
        for(int i=0; i < pocet; i++){
            cislo[i]=(int)(random()*6);}
        //System.out.println(Arrays.toString(cislo));
        String vstup;
        int presne = 0;
        int priblizne = 0;
        Scanner sc = new Scanner(System.in,"UTF-8");
        System.out.println("Vítej u hry Logik. \nCílem této hry je uhádnout kombinaci čtyř čísel. Hra tě vždy požádá o zadání kombinace čísel (0-5). \nNásledně uvidíš, kolik čísel jsi měl na správné pozici (správně) a kolik čísel jsi trefil, ale mimo svou pozici (skoro). \nDej si bacha na správné zadání kombinace!");
        for(int a=0; a<10; a++){
            System.out.printf("Zadej kombinaci čtyř čísel od 0 do 5: ");
            vstup = sc.nextLine();
            presne = priblizne = 0;
            //System.out.println(vstup.length());
            //reseni toho, kdy uzivatel zada jiny pocet cislic - ukonceni hry.
            if (vstup.length()!=pocet){
                System.out.println("Zadal jsi jiný počet čísel! Díky své nepozornosti jsi prohrál! #sorryJako");
                return;
            }
            //reseni toho, kdy uzivatel zada cislice mimo rozsah - ukonceni hry.
            if (vstup.contains("6") || vstup.contains("7") || vstup.contains("8") || vstup.contains("9"))
            {
                System.out.println("Zadal jsi číslo mimo možný výběr! Díky své nepozornosti jsi prohrál! #sorryJako");
                return;
            }
            //cyklus prochazejici jednotlive zadane cislice a porovnavajici s generovanymi cisly, pri splnenem kriteriu navyseni hodnot
            for(int i=0; i < pocet; i++){
                    if(cislo[i] == vstup.charAt(i) - 48) //48 kvuli prevedeni z ASCII (48 = 0)
                        presne ++;
                    else
                        for(int j=0; j < pocet; j++){
                            if(cislo[i] == vstup.charAt(j) - 48){
                                priblizne++;
                                j = 10;
                            }
                        }
                     }
            if (presne == pocet){
                System.out.println("Jsi BOSS!");
                a = 10;
                }
            else
                System.out.printf("Správně: %d, skoro: %d\n\n",presne, priblizne);

            }
            if(presne!=pocet){
                    System.out.printf("LŮZR! Hledaná kombinace byla: ");
                    for (int i:cislo)
                        System.out.printf("%d", i);
                }
    }
}
