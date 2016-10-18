package de.htwberlin.prog2;

import de.htwberlin.prog2.datamodel.Polynomial;
import de.htwberlin.prog2.datamodel.PolynomialTerm;

public class Main {

    public static void main(String[] args) {

       // PolynomialTerm polyTest0 = new PolynomialTerm(9.0d, 0);
       // PolynomialTerm polyTest1 = new PolynomialTerm(3.0d, 1);
        PolynomialTerm polyTest2 = new PolynomialTerm(3.0d, 2);
       // PolynomialTerm polyTest3 = new PolynomialTerm(2.0d, 3);
       // PolynomialTerm polyTest4 = new PolynomialTerm(4.0d, 4);
       // PolynomialTerm polyTest5 = new PolynomialTerm(1.0d, 5);
        PolynomialTerm polynomialTermToCalculateWith = new PolynomialTerm(1.0d, 2);

        PolynomialTerm productOfTwoTerms = polyTest2.add(polynomialTermToCalculateWith);
        System.out.println(productOfTwoTerms);

        PolynomialTerm polySubtractedTerm = polyTest2.subtract(polynomialTermToCalculateWith);
        System.out.println(polySubtractedTerm);

        PolynomialTerm[] polyTestX = new PolynomialTerm[7];

        polyTestX[0] = new PolynomialTerm(9.0d, 0);
        //polyTestX[1] = polyTest1;
        //polyTestX[2] = polyTest2;
        //polyTestX[3] = polyTest3;
        //polyTestX[4] = polyTest4;
        //polyTestX[5] = polyTest5;

        Polynomial polyAddTest = new Polynomial(polyTestX); //throws Exception in thread "main" java.lang.NullPointerException
        System.out.println(polyAddTest);
        System.out.println(polyTestX); //Sieht aus wie Adresse in Speicher --> brauche ich eine toString Override in der Main?
                                    // Komisch weil es bei add schon funktioniert, aber da ohne Array[]

        PolynomialTerm[] polyTestY = {new PolynomialTerm(9.0d, 0), new PolynomialTerm(3.0d, 1)}; //Gleicher Fehler wie bei polyTestX
        System.out.println(polyTestY);

        //Example exampleBanane = new Example();
        //exampleBanane.example();

        //Polynomial polynomial1 = new Polynomial();

    }
}