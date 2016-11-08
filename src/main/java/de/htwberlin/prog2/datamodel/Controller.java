package de.htwberlin.prog2.datamodel;

import Prog1Tools.IOTools;
import de.htwberlin.prog2.io.PolynomIo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Prog1Tools.IOTools.*;

/**
 * Created by laura on 03.11.16.
 */
public class Controller {


    private int action = 10;
    private Map<String, Polynomial> polynomialMap = new HashMap<>();

    public Controller() {
    }

    public void runPolynomials() //throws IOException
    {
        action = '1';
        while (action != 0) {
            switch (action) {
                case '1':
                    PolynomialTerm[] readTerms = new PolynomialTerm[Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE];
                    for (int exponent = 0; exponent < Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE; exponent++) {
                        readTerms[exponent] = readCoefficients(exponent);
                    }
                    Polynomial readPolynomial = new Polynomial(readTerms);
                    savePolynomial(readPolynomial);
                    break;

                case '2':
                    System.out.println(polynomialMap.entrySet());
                    break;

                case '3':
                    Polynomial polynomialToChange = userChoosePolynomial();
                    System.out.println(polynomialToChange);
                    int exponent = readInteger("Welchen Term möchten Sie ändern? : ");
                    Double newCoefficient = readDouble("Was soll der neue Wert werden? : ");
                    polynomialToChange.change(newCoefficient, exponent);
                    System.out.println(polynomialToChange);
                    break;

                case '4': //zwei Polynome auswählen mit add methode addieren, das addierte polynom printen& speichern
                    Polynomial polynomialToAddOne = userChoosePolynomial();
                    Polynomial polynomialToAddTwo = userChoosePolynomial();
                    Polynomial addedPolynomial = polynomialToAddOne.add(polynomialToAddTwo);
                    System.out.println("Ergebnis addition: " + addedPolynomial);

                    savePolynomial(addedPolynomial);
                    break;

                case '5': //zwei Polynome auswählen mit subtract methode addieren, das subtrahierte polynom printen& speichern
                    break;

                case '6': //zwei Polynome auswählen mit multiply methode addieren, das multiplizierte polynom printen& speichern
                    break;

                case '7': //ein Polynom auswählen mit firstDerivation methode ableiten, das abgeleitete polynom printen& speichern
                    break;

                case '8': //ein Polynom auswählen, double Wert für x eingeben lassen,
                    // X mit functionValueOfX methode berechnen, double x printen
                    break;

                case '9': //ein Polynom auswählen, double Wert für a eingeben lassen,
                    // und mit divideByXMinusA methode berechnen, Werte aus Hashmap printen
                    break;

                case '0': System.exit(0);
                    break;

                default:
                    System.out.println("Nein!!!Doch???Oh!!!");
                    System.out.println("Die Eingabe konnte nicht verarbeitet werden - probieren Sie was anderes: ");
            }
            showMenu();
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("--> Bitte entscheiden Sie sich für eine Aktion: <--");
        System.out.println(" 1   Polynom eingeben");
        System.out.println(" 2   gespeichtere Polynome anzeigen");
        System.out.println(" 3   Polynom verändern");
        System.out.println(" 4   zwei Polynome addieren");
        System.out.println(" 5   zwei Polynome subtrahieren");
        System.out.println(" 6   zwei Polynome multiplizieren");
        System.out.println(" 7   erste Ableitung des Polynoms");
        System.out.println(" 8   Funktionswert von x");
        System.out.println(" 9   Polynom dividieren durch (x - a)");
        System.out.println(" 0   Programm beenden");
        System.out.println("Ihre Eingabe: ");
        action = IOTools.readChar();
    }

    private void savePolynomial(Polynomial addedPolynomial) {
        while (true) {
            String addedPolynomialName = "";
            do {
                addedPolynomialName = readString("Geben Sie den Namen des Polynoms eins:  ");
            }while (nameIsNullOrContainedInMapKeys(addedPolynomialName));
            polynomialMap.put(addedPolynomialName, addedPolynomial);

            char putInMap = readChar("Wollen Sie das addierte Polynom speichern? j/n ");
            if (putInMap == 'j') {
                try {
                //POLYNOM SPEICHERN?
                PolynomIo polynomIo = new PolynomIo();
                String filePath =
                        "./"+ addedPolynomialName + ".poly";
                    polynomIo.save(addedPolynomial, filePath);
                } catch (IOException e) {
                    System.out.println("Unerwartete Fehler beim speichern. Suchen Sie deckung.");;
                }
                return;
            } else if (putInMap == 'n') {
                return;
            }
        }
    }

    private boolean nameIsNullOrContainedInMapKeys(String addedPolynomialName) {
        return polynomialMap.containsKey(addedPolynomialName) || addedPolynomialName.equals("");
    }

    private Polynomial userChoosePolynomial() {
        Polynomial choosenPolynomial = null;
        while (choosenPolynomial == null) {
            System.out.println(polynomialMap);
            String toChange = readString("Welches Polynom möchten Sie auswählen? : ");
            choosenPolynomial = polynomialMap.get(toChange);
        }
        return choosenPolynomial;
    }

    private PolynomialTerm readCoefficients(int exponent) {
        double coeff = readDouble("Geben Sie den (double) Koeffizient für x^" + exponent + " ein: ");
        return new PolynomialTerm(coeff, exponent);
    }
}

