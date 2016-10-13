package de.htwberlin.prog2.datamodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laura on 09.10.16.
 */
public class PolynomialTermTest {

    private PolynomialTerm polyTest;
    private PolynomialTerm polynomialTermToCalculateWith;

    @Before
    public void setup(){
        polyTest = new PolynomialTerm(1.0d, 2);
        polynomialTermToCalculateWith = new PolynomialTerm(1.0d, 2);
    }

    @Test
    public void add() throws Exception {
        PolynomialTerm expectedPolynomialTerm = new PolynomialTerm(2.0d, 2);

        PolynomialTerm newPolyTerm = polyTest.add(polynomialTermToCalculateWith);

        assertEquals(expectedPolynomialTerm, newPolyTerm);
    }

    @Test
    public void subtract() throws Exception {
        PolynomialTerm expectedPolynomialTerm = new PolynomialTerm(0.0d, 2);

        PolynomialTerm polySubtractedTerm = polyTest.subtract(polynomialTermToCalculateWith);

        assertEquals(expectedPolynomialTerm, polySubtractedTerm);
    }

}