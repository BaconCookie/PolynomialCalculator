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


    private int action;
    private Map<String, Polynomial> polynomialMap = new HashMap<>();

    public Controller() {
    }

    public void runPolynomials() //throws IOException
    {
        action = 1;
        while (action != 0) {
            switch (action) {
                case 1:
                    PolynomialTerm[] readTerms = new PolynomialTerm[Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE];
                    for (int exponent = 0; exponent < Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE; exponent++) {
                        readTerms[exponent] = readCoefficients(exponent);
                    }
                    Polynomial readPolynomial = new Polynomial(readTerms);
                    savePolynomial(readPolynomial);
                    break;

                case 2:
                    System.out.println(polynomialMap.entrySet());
                    break;

                case 3:
                    Polynomial polynomialToChange = userChoosePolynomial();
                    System.out.println(polynomialToChange);
                    int exponent = readInteger("Welchen Term möchten Sie ändern? : ");
                    Double newCoefficient = readDouble("Was soll der neue Wert werden? : ");
                    polynomialToChange.change(newCoefficient, exponent);
                    System.out.println(polynomialToChange);
                    break;

                case 4:
                    Polynomial polynomialToAddOne = userChoosePolynomial();
                    Polynomial polynomialToAddTwo = userChoosePolynomial();
                    Polynomial addedPolynomial = polynomialToAddOne.add(polynomialToAddTwo);
                    System.out.println("Ergebnis addition: " + addedPolynomial);
                    savePolynomial(addedPolynomial);
                    break;

                case 5:
                    Polynomial polynomialToSubtOne = userChoosePolynomial();
                    Polynomial polynomialToSubtTwo = userChoosePolynomial();
                    Polynomial subtractedPolynomial = polynomialToSubtOne.subtract(polynomialToSubtTwo);
                    System.out.println("Ergebnis subtraktion: " + subtractedPolynomial);
                    savePolynomial(subtractedPolynomial);
                    break;

                case 6:
                    Polynomial polynomialToMultiplyOne = userChoosePolynomial();
                    Polynomial polynomialToMultiplyTwo = userChoosePolynomial();
                    Polynomial multipliedPolynomial = polynomialToMultiplyOne.subtract(polynomialToMultiplyTwo);
                    System.out.println("Ergebnis multiplikation: " + multipliedPolynomial);
                    savePolynomial(multipliedPolynomial);
                    break;

                case 7:
                    Polynomial polynomialToDerive = userChoosePolynomial();
                    Polynomial derivedPolynomial = polynomialToDerive.firstDerivation();
                    System.out.println("Ergebnis der erste ableitung: " + derivedPolynomial);
                    savePolynomial(derivedPolynomial);
                    break;

                case 8:
                    Polynomial polynomialToCalcX = userChoosePolynomial();
                    double x = readDouble("Geben Sie den Wert für x ein: ");
                    double valueOfX = polynomialToCalcX.functionValueOfX(x);
                    System.out.println("Der Funktionswert von x ist: " + valueOfX);
                    break;

                case 9:
                    Polynomial polynomialToCalcA = userChoosePolynomial();
                    double a = readDouble("Berechnet wird die division des Polynoms durch (x - a). Geben Sie den Wert für a ein: ");
                    Map divisionByXMinusA = polynomialToCalcA.divideByXMinusA(a);
                    System.out.println("Ergebnis von x - a ist: " + divisionByXMinusA);
                    break;

                case 10:


                case 0: System.exit(0);
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
        System.out.println(" 10  Polynome aus gespeicherte Datei laden");
        System.out.println(" 0   Programm beenden");
        System.out.println("Ihre Eingabe: ");
        action = IOTools.readInteger();
    }

    private void savePolynomial(Polynomial polynomialToSave) {
        while (true) {
            String toSavePolynomialName = "";
            do {
                toSavePolynomialName = readString("Geben Sie den Namen des Polynoms ein:  ");
            }while (nameIsNullOrContainedInMapKeys(toSavePolynomialName));

            polynomialMap.put(toSavePolynomialName, polynomialToSave);

            char putInMap = readChar("Wollen Sie das Polynom speichern? j/n ");
            if (putInMap == 'j') {
                try {
                PolynomIo polynomIo = new PolynomIo();
                String filePath =
                        "./"+ toSavePolynomialName + ".poly";
                    polynomIo.save(polynomialToSave, filePath);
                } catch (IOException e) {
                    System.out.println("Error. Unerwarteter Fehler bei dem speichern. Die Antwort ist 42.");
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
            String toChange = readString("Welches Polynom möchten Sie auswählen? Geben Sie den Namen ein: ");
            choosenPolynomial = polynomialMap.get(toChange);
        }
        return choosenPolynomial;
    }

    private PolynomialTerm readCoefficients(int exponent) {
        double coeff = readDouble("Geben Sie den (double) Koeffizient für x^" + exponent + " ein: ");
        return new PolynomialTerm(coeff, exponent);
    }
}

