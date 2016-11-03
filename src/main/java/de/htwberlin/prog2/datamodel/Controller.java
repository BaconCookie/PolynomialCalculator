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


    public void foobar() {

        while (action != 'e') {
            System.out.println();
            System.out.println("--> Bitte entscheiden Sie sich für eine Aktion: <--");
            System.out.println(" p   Polynom eingeben");
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
        double coeff = readDouble("Geben Sie hier den Koeffizient für x^" + exponent + " ein (Bsp. 0.0)");
        return new PolynomialTerm(coeff, exponent);
    }
}

