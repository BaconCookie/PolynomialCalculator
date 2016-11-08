package de.htwberlin.prog2.datamodel;

import Prog1Tools.IOTools;

import static Prog1Tools.IOTools.readDouble;

/**
 * Created by laura on 03.11.16.
 */
public class Controller {


    char action = 'r';

    public Controller() {
    }

    public void runPolynomials() {

        while (action != 'e') {
            System.out.println();
            System.out.println("--> Bitte entscheiden Sie sich für eine Aktion: <--");
            System.out.println(" p   Polynom eingeben");
            System.out.println(" w   gespeichtere Polynome anzeigen");
            System.out.println(" v   Polynom verändern");
            System.out.println(" a   zwei Polynome addieren");
            System.out.println(" s   zwei Polynome subtrahieren");
            System.out.println(" m   zwei Polynome multiplizieren");
            System.out.println(" f   erste Ableitung des Polynoms");
            System.out.println(" x   Funktionswert von x");
            System.out.println(" d   Polynom dividieren durch (x - a)");
            System.out.println(" e   Programm beenden");
            System.out.println("Ihre Eingabe: ");
            action = IOTools.readChar();

            switch (action) {
                case 'p':
                    PolynomialTerm[] readTerms = new PolynomialTerm[Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE];
                    for (int exponent = 0; exponent < Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE; exponent++) {
                        readTerms[exponent] = readCoefficients(exponent);
                    }
                    Polynomial readPolynomial = new Polynomial(readTerms);


                    //POLYNOM SPEICHERN?
                    break;

                case 'w': //gespeicherte Polynome printen
                    break;

                case 'v': //eins von den gespeicherten Polynome auswählen, ändern (ganz neu eingeben?), wieder speichern
                    break;

                case 'a': //zwei Polynome auswählen mit add methode addieren, das addierte polynom printen& speichern
                    break;

                case 's': //zwei Polynome auswählen mit subtract methode addieren, das subtrahierte polynom printen& speichern
                    break;

                case 'm': //zwei Polynome auswählen mit multiply methode addieren, das multiplizierte polynom printen& speichern
                    break;

                case 'f': //ein Polynom auswählen mit firstDerivation methode ableiten, das abgeleitete polynom printen& speichern
                    break;

                case 'x': //ein Polynom auswählen, double Wert für x eingeben lassen,
                        // X mit functionValueOfX methode berechnen, double x printen
                    break;

                case 'd': //ein Polynom auswählen, double Wert für a eingeben lassen,
                    // und mit divideByXMinusA methode berechnen, Werte aus Hashmap printen
                    break;

                case 'e':
                    break;

                default:
                    System.out.println("Nein!!!Doch???Oh!!!");
                    System.out.println("Die Eingabe konnte nicht verarbeitet werden - probieren Sie was anderes: ");
            }
        }
    }

    private PolynomialTerm readCoefficients(int exponent) {
        double coeff = readDouble("Geben Sie hier den (double) Koeffizient für x^" + exponent + " ein: ");
        return new PolynomialTerm(coeff, exponent);
    }
}

