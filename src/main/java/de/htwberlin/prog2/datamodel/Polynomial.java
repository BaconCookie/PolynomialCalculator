package de.htwberlin.prog2.datamodel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by laura on 09.10.16.
 * Class of Polynomials
 * Indices and Exponents have the same number and are sorted from 0 to 6
 */
public class Polynomial {

    public static final int MAX_POLYNOMIAL_GRADE_PLUS_ONE = 7; // plus one because we need the 0 too!

    private PolynomialTerm[] polynomialTerms;

    /**
     * Constructor of Polynomial which declares & constructs an array of polynomialTerms terms (length 7)
     * and calls a method to fill with default values
     */
    public Polynomial() {
        polynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        polynomialTerms = fillPolynomialTermsWithDefaultValues(polynomialTerms);
    }

    /**
     * Constructor of Polynomial which includes polynomial terms.
     * Checks if the grade of the polynomial term isn't too large.
     *
     * @param polynomialTerms which are included in this polynomial.
     *                        They are stored in an array. Indices hold one coefficient and exponent each.
     */
    public Polynomial(PolynomialTerm[] polynomialTerms) {
        this();
        for (PolynomialTerm currentTerm : polynomialTerms) {
            if (currentTerm != null) {
                Integer index = currentTerm.getExponent();
                if (index > MAX_POLYNOMIAL_GRADE_PLUS_ONE) {
                    throw new IllegalArgumentException("The grade of the polynomial term is too large. Max allowed: 6"
                            + MAX_POLYNOMIAL_GRADE_PLUS_ONE);
                }
                this.polynomialTerms[index] = this.polynomialTerms[index].add(currentTerm);
            }
        }
    }

    /**
     * Method which fills polynomial terms with default values
     * Default values are:  Coefficients 0.0d
     * Exponents have the same number as the Indices and are sorted from 0 to 6
     *
     * @param polynomialTerms polynomial terms which are being filled
     * @return polynomial terms with default values
     */
    private PolynomialTerm[] fillPolynomialTermsWithDefaultValues(PolynomialTerm[] polynomialTerms) {
        for (int i = 0; i < polynomialTerms.length; i++) {
            polynomialTerms[i] = new PolynomialTerm(0, i);
        }
        return polynomialTerms;
    }

    /**
     * Method which adds the terms of two polynomials with a matching exponent
     *
     * @param polynomialToAdd polynomial which is being added to the current polynomial
     * @return new polynomial object which includes PolynomialTerm Array called sumOfPolynomialTerms
     */
    public Polynomial add(Polynomial polynomialToAdd) {
        PolynomialTerm[] sumOfPolynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        PolynomialTerm[] polynomialTermsToAdd = polynomialToAdd.getPolynomialTerms();

        for (int i = 0; i < sumOfPolynomialTerms.length; i++) {
            PolynomialTerm currentTermToAdd = polynomialTermsToAdd[i];
            PolynomialTerm currentOwnTerm = polynomialTerms[i];
            if (hasSameExponent(currentTermToAdd, currentOwnTerm)) {
                sumOfPolynomialTerms[i] = currentOwnTerm.add(currentTermToAdd);
            } else {
                throw new IllegalArgumentException("You cannot add polynomial terms with unequal exponents.");
            }
        }
        return new Polynomial(sumOfPolynomialTerms);
    }

    /**
     * Method which subtracts the terms of two polynomials with a matching exponent
     *
     * @param polynomialToSubtract polynomial which is being subtracted from the current polynomial
     * @return new polynomial object which includes PolynomialTerm Array called subtractedPolynomialTerms
     */
    public Polynomial subtract(Polynomial polynomialToSubtract) {
        PolynomialTerm[] subtractedPolynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        PolynomialTerm[] polynomialTermsToSubtract = polynomialToSubtract.getPolynomialTerms();

        for (int i = 0; i < subtractedPolynomialTerms.length; i++) {
            PolynomialTerm currentTermToSubtract = polynomialTermsToSubtract[i];
            PolynomialTerm currentOwnTerm = polynomialTerms[i];
            if (hasSameExponent(currentTermToSubtract, currentOwnTerm)) {
                subtractedPolynomialTerms[i] = currentOwnTerm.subtract(currentTermToSubtract);
            } else {
                throw new IllegalArgumentException("You cannot subtract polynomial terms with unequal exponents.");
            }
        }
        return new Polynomial(subtractedPolynomialTerms);
    }

    /**
     * Method which multiplies two polynomials with a maximum final grade of six
     *
     * @param polynomialToMultiply polynomial which is being multiplied with the current polynomial
     * @return new polynomial object which includes the PolynomialTerm Array called multipliedPolynomialTerms
     */
    public Polynomial multiply(Polynomial polynomialToMultiply) {
        PolynomialTerm[] multipliedPolynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        multipliedPolynomialTerms = fillPolynomialTermsWithDefaultValues(multipliedPolynomialTerms);

        PolynomialTerm[] polynomialTermsToMultiply = polynomialToMultiply.getPolynomialTerms();

        for (int i = 0; i < polynomialTermsToMultiply.length; i++) {
            PolynomialTerm currentOwnTerm = polynomialTerms[i];

            for (int j = 0; j < polynomialTermsToMultiply.length; j++) {
                PolynomialTerm currentTermToMultiply = polynomialTermsToMultiply[j];
                PolynomialTerm multipliedTerm = currentOwnTerm.multiply(currentTermToMultiply);
                int placeInPolynomial = multipliedTerm.getExponent();
                switch (placeInPolynomial) {
                    case 0:
                        multipliedPolynomialTerms[0] = multipliedPolynomialTerms[0].add(multipliedTerm);
                        break;
                    case 1:
                        multipliedPolynomialTerms[1] = multipliedPolynomialTerms[1].add(multipliedTerm);
                        break;
                    case 2:
                        multipliedPolynomialTerms[2] = multipliedPolynomialTerms[2].add(multipliedTerm);
                        break;
                    case 3:
                        multipliedPolynomialTerms[3] = multipliedPolynomialTerms[3].add(multipliedTerm);
                        break;
                    case 4:
                        multipliedPolynomialTerms[4] = multipliedPolynomialTerms[4].add(multipliedTerm);
                        break;
                    case 5:
                        multipliedPolynomialTerms[5] = multipliedPolynomialTerms[5].add(multipliedTerm);
                        break;
                    case 6:
                        multipliedPolynomialTerms[6] = multipliedPolynomialTerms[6].add(multipliedTerm);
                        break;
                    default:
                        throw new IllegalArgumentException("This polynomial term could not be multiplied in this program: Error.");
                }
            }
        }
        return new Polynomial(multipliedPolynomialTerms);
    }

    /**
     * Method which calculates the first derivation of the current polynomial
     *
     * @return new polynomial object which includes the PolynomialTerm Array called derivedPolynomialTerms
     */
    public Polynomial firstDerivation() {
        PolynomialTerm[] derivedPolynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        derivedPolynomialTerms = fillPolynomialTermsWithDefaultValues(derivedPolynomialTerms);

        for (int i = 0; i < derivedPolynomialTerms.length; i++) {
            PolynomialTerm currentOwnTerm = polynomialTerms[i];
            derivedPolynomialTerms[i] = currentOwnTerm.derive();
        }
            return new Polynomial(derivedPolynomialTerms);
    }

    /**
     * Method to calculate the functionValueOfX using the HornerSchema
     *
     * @param valueOfX (double) value which is used instead of X, function of this value will be determined
     * @return (double) function value of x
     */
    public double functionValueOfX(double valueOfX) {
        double[] arrayToStoreValues = hornerSchema(valueOfX);
        return arrayToStoreValues[0];
    }

    /**
     * Method to divide the polynomial by (x - a)
     * In case "a" has the same value as valueOfX belonging to a functionValueOfX = 0,
     * then this division will be completed with a remainder of zero.
     *
     * @param valueOfA the value of a which is placed in divisor: (x - a)
     * @return Map with result of division with x - a
     */
    public Map divideByXMinusA(double valueOfA) {
        double[] arrayToStoreValues = hornerSchema(valueOfA);
        Map<String, Double> dividedByXMinusA = new HashMap();
        dividedByXMinusA.put("Remainder", 0 + arrayToStoreValues[0]);
        dividedByXMinusA.put("x^0", 0 + arrayToStoreValues[1]);
        dividedByXMinusA.put("x^1", 0 + arrayToStoreValues[2]);
        dividedByXMinusA.put("x^2", 0 + arrayToStoreValues[3]);
        dividedByXMinusA.put("x^3", 0 + arrayToStoreValues[4]);
        dividedByXMinusA.put("x^3", 0 + arrayToStoreValues[5]);
        dividedByXMinusA.put("x^5", 0 + arrayToStoreValues[6]);
        return dividedByXMinusA;
    }


    /**
     * Method using the principle of HornerSchema, to calculate the functionValueOfX and possibly division.
     * Only if the functionValueOfX = 0, this method can also be used to extract the outcome of a division.
     *
     * @param valueOfX (double) value which is used instead of X, function of this value will be determined
     * @return arrayToStoreValues which holds the value(s) for functionValueOfX and depending on the outcome also for the division
     */
    private double[] hornerSchema(double valueOfX) {
        PolynomialTerm[] polynomialTermsToDetermine = polynomialTerms;
        double[] arrayToStoreValues = new double[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        double[] arrayToHelpCalculate = new double[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        Arrays.fill(arrayToHelpCalculate, 0.0d);
        //final int NUM_ITERATIONS = MAX_POLYNOMIAL_GRADE_PLUS_ONE - 1;
        for (int i = MAX_POLYNOMIAL_GRADE_PLUS_ONE - 1; i >= 0; i--) {
            arrayToStoreValues[i] = polynomialTermsToDetermine[i].getCoefficient() + arrayToHelpCalculate[i];
            if (i != 0) {
                arrayToHelpCalculate[i - 1] = (arrayToStoreValues[i] * valueOfX);
            }
        }
        return arrayToStoreValues;
    }

    /**
     * Boolean to check if exponents of two terms to add are matching
     *
     * @param currentTermToCalculateWith term to add which is found in current index of polynomial to add
     * @param currentOwnTerm             term which is found in current index of own polynomial
     * @return true if exponents are the same number
     */
    private boolean hasSameExponent(PolynomialTerm currentTermToCalculateWith, PolynomialTerm currentOwnTerm) {
        return currentTermToCalculateWith.getExponent().equals(currentOwnTerm.getExponent());
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "polynomialTerms=" + Arrays.toString(polynomialTerms) + // calls toString method for each element of array
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Polynomial that = (Polynomial) other;
        return Arrays.equals(polynomialTerms, that.polynomialTerms);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(polynomialTerms);
    }

    public PolynomialTerm[] getPolynomialTerms() {
        return polynomialTerms;
    }
}
