package de.htwberlin.prog2.datamodel;

import de.htwberlin.prog2.io.PolynomIo;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by laura on 17.10.16.
 * @author Laura Hartgers, HTW-Berlin Matrikelnummer 556238
 * @version 1.0
 */
public class PolynomialTest {

    private PolynomialTerm[] polyTermTest1;
    private PolynomialTerm[] polyTermTest2;
    private PolynomialTerm[] polyTermTest3;
    private PolynomialTerm[] polyTermTest4;
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


        polyTermTest4 = new PolynomialTerm[7];
        polyTermTest4[0] = new PolynomialTerm(4.0d, 0);
        polyTermTest4[1] = new PolynomialTerm(-3.0d, 1);
        polyTermTest4[2] = new PolynomialTerm(2.5d, 2);
        polyTermTest4[3] = new PolynomialTerm(0.0d, 3);
        polyTermTest4[4] = new PolynomialTerm(6.0d, 4);
        polyTermTest4[5] = new PolynomialTerm(2.0d, 5);
        polyTermTest4[6] = new PolynomialTerm(7.3d, 6);
        polyTest4 = new Polynomial(polyTermTest4);


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

        Polynomial actualAddedPolynomial = polyTest1.add(polyTest2);

        assertEquals(expectedAddedPolynomial, actualAddedPolynomial);

    }

    @Test
    public void subtract() throws Exception {
        PolynomialTerm[] expSubTerms = new PolynomialTerm[7];
        expSubTerms[0] = new PolynomialTerm(0.0, 0);
        expSubTerms[1] = new PolynomialTerm(-1.0, 1);
        expSubTerms[2] = new PolynomialTerm(3.0, 2);
        expSubTerms[3] = new PolynomialTerm(1.0, 3);
        expSubTerms[4] = new PolynomialTerm(-2.0, 4);
        expSubTerms[5] = new PolynomialTerm(-4.0, 5);
        expSubTerms[6] = new PolynomialTerm(-5.0, 6);
        Polynomial expectedSubtractedPolynomial = new Polynomial(expSubTerms);

        Polynomial actualSubtractedPolynomial = polyTest1.subtract(polyTest2);

        assertEquals(expectedSubtractedPolynomial, actualSubtractedPolynomial);
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

    @Test
    public void functionValueOfX() throws Exception {

        double expectedValueOfX = 89.0;

        double actualValueOfX = polyTest1.functionValueOfX(3.0);

        assertEquals(expectedValueOfX, actualValueOfX, 0.05d);
    }

    @Test
    public void divideByXMinusA() throws Exception {
        Map expectedDivisionResult = new HashMap();
        expectedDivisionResult.put("Remainder", 89.0);
        expectedDivisionResult.put("x^0", 28.0);
        expectedDivisionResult.put("x^1", 9.0);
        expectedDivisionResult.put("x^2", 2.0);
        expectedDivisionResult.put("x^3", 0.0);
        expectedDivisionResult.put("x^3", 0.0);
        expectedDivisionResult.put("x^5", 0.0);

        Map actualDivisionResult = polyTest1.divideByXMinusA(3.0);

        assertEquals(expectedDivisionResult, actualDivisionResult);
    }

    @Test
    public void firstDerivation() throws Exception {
        PolynomialTerm[] expectedDerivedTerms = new PolynomialTerm[7];
        expectedDerivedTerms[0] = new PolynomialTerm(2.0d, 0);
        expectedDerivedTerms[1] = new PolynomialTerm(0.0d, 1);
        expectedDerivedTerms[2] = new PolynomialTerm(3.0d, 2);
        expectedDerivedTerms[3] = new PolynomialTerm(8.0d, 3);
        expectedDerivedTerms[4] = new PolynomialTerm(20.0d, 4);
        expectedDerivedTerms[5] = new PolynomialTerm(30.0d, 5);
        expectedDerivedTerms[6] = new PolynomialTerm(0.0d, 6);
        Polynomial expectedDerivedPolynomial = new Polynomial(expectedDerivedTerms);

        Polynomial actualPolynomial = polyTest2.firstDerivation();

        assertEquals(expectedDerivedPolynomial, actualPolynomial);
    }

    @Test
    public void saveAndLoad() throws Exception {
        PolynomIo polynomIo = new PolynomIo();
        String filePath = "./test.poly";
        polynomIo.save(polyTest2, filePath);
        Polynomial actualLoadedPolynomial = polynomIo.load(filePath);

        assertEquals(polyTest2, actualLoadedPolynomial);
        File file = new File(filePath);
        file.deleteOnExit();
    }
}