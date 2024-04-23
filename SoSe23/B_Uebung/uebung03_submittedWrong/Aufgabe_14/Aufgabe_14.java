package SoSe23.B_Uebung.uebung03_submittedWrong.Aufgabe_14;

import java.util.Random;

public class Aufgabe_14 {

    // --------------------------------------

    public static int[] wuerfeln() {
        int[] wurf = new int[5];
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            wurf[i] = random.nextInt(6) + 1;
        }

        return wurf;
    }

    // --------------------------------------

    public static int halbeChance(int[] wurf) {
        int summe = 0;

        for (int zahl : wurf) {
            summe += zahl;
        }

        return summe / 2;
    }

    // --------------------------------------

    public static int augenSumme(int[] wurf, int x) {
        int summe = 0;

        for (int zahl : wurf) {
            if (zahl == x) {
                summe += x;
            }
        }

        return summe;
    }

    // --------------------------------------
    
    public static int fullHouse(int[] wurf) {
        int[] zaehler = new int[6];

        for (int zahl : wurf) {
            zaehler[zahl - 1]++;
        }

        boolean dreiGleiche = false;
        boolean zweiGleiche = false;

        for (int anzahl : zaehler) {
            if (anzahl == 3) {
                dreiGleiche = true;
            } else if (anzahl == 2) {
                zweiGleiche = true;
            }
        }

        if (dreiGleiche && zweiGleiche) {
            return 25;
        } else {
            return 0;
        }
    }

    // --------------------------------------

    public static void main(String[] args) {
        int gesamtpunktzahl = 0;

        for (int runde = 1; runde <= 5; runde++) {
            int[] wurf = Aufgabe_14.wuerfeln();
            int chance = Aufgabe_14.halbeChance(wurf);
            int fullHouse = Aufgabe_14.fullHouse(wurf);

            int maxAugenSumme = 0;
            int maxAugenZahl = 0;
            for (int i = 1; i <= 6; i++) {
                int augenSumme = Aufgabe_14.augenSumme(wurf, i);
                if (augenSumme > maxAugenSumme) {
                    maxAugenSumme = augenSumme;
                    maxAugenZahl = i;
                }
            }

            int punkte;
            String auswahl;

            if (chance >= maxAugenSumme && chance >= fullHouse) {
                punkte = chance;
                auswahl = "Chance";
            } else if (maxAugenSumme >= fullHouse) {
                punkte = maxAugenSumme;
                auswahl = "Augensumme für " + maxAugenZahl;
            } else {
                punkte = fullHouse;
                auswahl = "Full House";
            }

            gesamtpunktzahl += punkte;
            System.out.printf("Runde %d: Auswahl: %s, Punkte: %d\n", runde, auswahl, punkte);
        }

        System.out.printf("Gesamtpunktzahl: %d\n", gesamtpunktzahl);
    }

    // --------------------------------------

}
