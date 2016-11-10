package de.htwberlin.prog2.datamodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by laura on 09.10.16.
 * @author Laura Hartgers, HTW-Berlin Matrikelnummer 556238
 * @version 1.0
 */
public class PolynomialTermTest {

    private PolynomialTerm polyTermTest;
    private PolynomialTerm polynomialTermToCalculateWith;
    private PolynomialTerm polynomialTermToCalculateWithTwo;

    @Before
    public void setup() {
        polyTermTest = new PolynomialTerm(1.0d, 2);
        polynomialTermToCalculateWith = new PolynomialTerm(1.0d, 2);
        polynomialTermToCalculateWithTwo = new PolynomialTerm(4.0d, 3);
    }

    @Test
    public void add() throws Exception {
        PolynomialTerm expectedPolynomialTerm = new PolynomialTerm(2.0d, 2);

        PolynomialTerm newPolyTerm = polyTermTest.add(polynomialTermToCalculateWith);

        assertEquals(expectedPolynomialTerm, newPolyTerm);
    }

    @Test
    public void subtract() throws Exception {
        PolynomialTerm expectedPolynomialTerm = new PolynomialTerm(0.0d, 2);

        PolynomialTerm polySubtractedTerm = polyTermTest.subtract(polynomialTermToCalculateWith);

        assertEquals(expectedPolynomialTerm, polySubtractedTerm);
    }

    @Test
    public void multiply() throws Exception {
        PolynomialTerm expectedPolynomialTerm = new PolynomialTerm(4.0d, 5);

        PolynomialTerm newMultipliedTerm = polyTermTest.multiply(polynomialTermToCalculateWithTwo);

        assertEquals(expectedPolynomialTerm, newMultipliedTerm);
    }

    @Test
    public void derive() throws Exception {
        PolynomialTerm expectedPolynomialTerm = new PolynomialTerm(12.0, 2);

        PolynomialTerm actualPolynomialTerm = polynomialTermToCalculateWithTwo.derive();

        assertEquals(expectedPolynomialTerm, actualPolynomialTerm);
    }
}