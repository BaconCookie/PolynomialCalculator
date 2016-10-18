package de.htwberlin.prog2.datamodel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by laura on 17.10.16.
 */
public class PolynomialTest {

    private PolynomialTerm[] polyTermTest1;
    private PolynomialTerm polyTermTest2;
    private Polynomial polyTestA;
    private Polynomial polyTestB;
    private Polynomial polyTestC;
    private Polynomial polyTestD;

    @Before
    public void setUp() throws Exception {

        for (PolynomialTerm polynomialTerm : polyTermTest1 = new PolynomialTerm[3]) {

        }
        polyTermTest2 = new PolynomialTerm(5.0d, 2);


        Polynomial polySubtractedTerm = new Polynomial();
        polyTestA = new Polynomial(polyTermTest1);
        polyTestB = new Polynomial();
        polyTestC = new Polynomial();
        polyTestD = new Polynomial();

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void multiply() throws Exception {

    }


}