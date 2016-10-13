package de.htwberlin.prog2;

import de.htwberlin.prog2.datamodel.Polynomial;
import de.htwberlin.prog2.datamodel.PolynomialTerm;

public class Main {

    public static void main(String[] args) {

        PolynomialTerm polyTest2 = new PolynomialTerm(3.0d, 2);
        PolynomialTerm polynomialTermToAdd2 = new PolynomialTerm(1.0d, 2);
        System.out.println(polyTest2.add(polynomialTermToAdd2));

        //PolynomialTerm polySubtractedTerm = new PolynomialTerm(3.0d, 2);
        //PolynomialTerm polynomialTermToAdd2 = new PolynomialTerm(1.0d, 2);
        Polynomial polySubtractedTerm = new Polynomial();
        System.out.println(polySubtractedTerm);

        //Example exampleBanane = new Example();
        //exampleBanane.example();

        //Polynomial polynomial1 = new Polynomial();

    }
}