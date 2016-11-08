package de.htwberlin.prog2.datamodel;

import Prog1Tools.IOTools;
import de.htwberlin.prog2.io.PolynomIo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Prog1Tools.IOTools.readChar;
import static Prog1Tools.IOTools.readDouble;
import static Prog1Tools.IOTools.readString;

/**
 * Created by laura on 03.11.16.
 */
public class Controller {


    private int action = 10;
    private Map polynomialMap = new HashMap();

    public Controller() {
    }

    public void runPolynomials() //throws IOException
     {

        while (action != 0) {
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

            switch (action) {
                case '1':
                    PolynomialTerm[] readTerms = new PolynomialTerm[Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE];
                    for (int exponent = 0; exponent < Polynomial.MAX_POLYNOMIAL_GRADE_PLUS_ONE; exponent++) {
                        readTerms[exponent] = readCoefficients(exponent);
                    }
                    Polynomial readPolynomial = new Polynomial(readTerms);
                    String polynomialName = readString("Geben Sie ein unter welchen Namen das Polynoms gespeichert werden soll: ");
                    polynomialMap.put(polynomialName, readPolynomial);

                    /*
                    //POLYNOM SPEICHERN?
                    PolynomIo polynomIo = new PolynomIo();
                    String filePath = "./test.poly";
                    try {
                        polynomIo.save(readPolynomial, filePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    File file = new File(filePath); //hier wird immer n neues file geschrieben --> klassenebene
                    */
                    break;

                case '2':
                    System.out.println(polynomialMap.entrySet());
                    /*
                    for (int i = 0; i < polynomialMap.size(); i++) {
                        System.out.println(polynomialMap.entrySet());
                    }
                    */
                    //gespeicherte Polynome printen
                    break;

                case '3': //eins von den gespeicherten Polynome auswählen, ändern (ganz neu eingeben?), wieder speichern
                    break;

                case '4':
                    String polynomialOne = readString("Geben Sie ein zu welches Polynom Sie addieren wollen: ");
                    String polynomialTwo = readString("Geben Sie ein welches Polynom Sie dazu addieren wollen: ");
                    Polynomial polynomialToAddOne = (Polynomial) polynomialMap.get(polynomialOne);
                    Polynomial polynomialToAddTwo = (Polynomial) polynomialMap.get(polynomialTwo);
                    Polynomial addedPolynomial = polynomialToAddOne.add(polynomialToAddTwo);
                    System.out.println("Ergebnis addition: " + addedPolynomial);

                    char save = readChar("Wollen Sie das addierte Polynom speichern? j/n ");
                    if (save == 'j') {
                        String addedPolynomialName = readString("Geben Sie ein unter welchen Namen das Polynoms gespeichert werden soll: ");
                        polynomialMap.put(addedPolynomialName, addedPolynomial);
                    }
                    if (save == 'n') {
                        break;
                    }
                    else {
                        //nochmal eingabe??
                    }


                    //zwei Polynome auswählen mit add methode addieren, das addierte polynom printen& speichern
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

                case '0':
                    break;

                default:
                    System.out.println("Nein!!!Doch???Oh!!!");
                    System.out.println("Die Eingabe konnte nicht verarbeitet werden - probieren Sie was anderes: ");
            }
        }
    }

    private PolynomialTerm readCoefficients(int exponent) {
        double coeff = readDouble("Geben Sie den (double) Koeffizient für x^" + exponent + " ein: ");
        return new PolynomialTerm(coeff, exponent);
    }
}

