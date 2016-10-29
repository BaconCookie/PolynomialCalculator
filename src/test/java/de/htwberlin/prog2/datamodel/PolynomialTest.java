package de.htwberlin.prog2.datamodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laura on 17.10.16.
 */
public class PolynomialTest {

    private PolynomialTerm[] polyTermTest1;
    private PolynomialTerm[] polyTermTest2;
    private PolynomialTerm[] polyTermTest3;
    private Polynomial polyTest1;
    private Polynomial polyTest2;
    private Polynomial polyTest3;
    private Polynomial polyTest4;

    @Before
    public void setUp() throws Exception {

        polyTermTest1 = new PolynomialTerm[7];
        polyTermTest1[0] = new PolynomialTerm(5.0d, 0);
        polyTermTest1[1] = new PolynomialTerm(1.0d, 1);
        polyTermTest1[2] = new PolynomialTerm(3.0d, 2);
        polyTermTest1[3] = new PolynomialTerm(2.0d, 3);
        polyTermTest1[4] = new PolynomialTerm(0.0d, 4);
        polyTermTest1[5] = new PolynomialTerm(0.0d, 5);
        polyTermTest1[6] = new PolynomialTerm(0.0d, 6);
        polyTest1 = new Polynomial(polyTermTest1);

        polyTermTest2 = new PolynomialTerm[7];
        polyTermTest2[0] = new PolynomialTerm(5.0d, 0);
        polyTermTest2[1] = new PolynomialTerm(2.0d, 1);
        polyTermTest2[2] = new PolynomialTerm(0.0d, 2);
        polyTermTest2[3] = new PolynomialTerm(1.0d, 3);
        polyTermTest2[4] = new PolynomialTerm(2.0d, 4);
        polyTermTest2[5] = new PolynomialTerm(4.0d, 5);
        polyTermTest2[6] = new PolynomialTerm(5.0d, 6);
        polyTest2 = new Polynomial(polyTermTest2);

        polyTermTest3 = new PolynomialTerm[7];
        polyTermTest3[0] = new PolynomialTerm(4.0d, 0);
        polyTermTest3[1] = new PolynomialTerm(2.0d, 1);
        polyTermTest3[2] = new PolynomialTerm(2.0d, 2);
        polyTermTest3[3] = new PolynomialTerm(2.0d, 3);
        polyTermTest3[4] = new PolynomialTerm(0.0d, 4);
        polyTermTest3[5] = new PolynomialTerm(0.0d, 5);
        polyTermTest3[6] = new PolynomialTerm(0.0d, 6);
        polyTest3 = new Polynomial(polyTermTest3);

        polyTest4 = new Polynomial();
        Polynomial polySubtractedTerm = new Polynomial();
    }

    @Test
    public void add() throws Exception {
        PolynomialTerm[] expAddedTerms = new PolynomialTerm[7];
        expAddedTerms[0] = new PolynomialTerm(10.0d, 0);
        expAddedTerms[1] = new PolynomialTerm(3.0d, 1);
        expAddedTerms[2] = new PolynomialTerm(3.0d, 2);
        expAddedTerms[3] = new PolynomialTerm(3.0d, 3);
        expAddedTerms[4] = new PolynomialTerm(2.0d, 4);
        expAddedTerms[5] = new PolynomialTerm(4.0d, 5);
        expAddedTerms[6] = new PolynomialTerm(5.0d, 6);
        Polynomial expectedAddedPolynomial = new Polynomial(expAddedTerms);

        Polynomial actualPolynomial = polyTest1.add(polyTest2);

        assertEquals(expectedAddedPolynomial, actualPolynomial);

    }

    @Test
    public void multiply() throws Exception {
        PolynomialTerm[] expMultipliedTerms = new PolynomialTerm[7];
        expMultipliedTerms[0] = new PolynomialTerm(20.0d, 0);
        expMultipliedTerms[1] = new PolynomialTerm(14.0d, 1);
        expMultipliedTerms[2] = new PolynomialTerm(24.0d, 2);
        expMultipliedTerms[3] = new PolynomialTerm(26.0d, 3);
        expMultipliedTerms[4] = new PolynomialTerm(12.0d, 4);
        expMultipliedTerms[5] = new PolynomialTerm(10.0d, 5);
        expMultipliedTerms[6] = new PolynomialTerm(4.0d, 6);
        Polynomial expectedMultipliedPolynomial = new Polynomial(expMultipliedTerms);

        Polynomial actualPolynomial = polyTest1.multiply(polyTest3);

        assertEquals(expectedMultipliedPolynomial, actualPolynomial);
    }


}