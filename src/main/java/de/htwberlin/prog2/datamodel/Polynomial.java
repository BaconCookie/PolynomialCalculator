package de.htwberlin.prog2.datamodel;

import java.util.Arrays;

/**
 * Created by laura on 09.10.16.
 * Class of Polynomials
 * Indices and Exponents have the same number and are sorted from 0 to 6
 */
public class Polynomial {



    public static final int MAX_POLYNOMIAL_GRADE_PLUS_ONE = 7; // plus one because we need the 0 too!

    private PolynomialTerm[] polynomialTerms;

    public Polynomial() {
        polynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE]; //constructs an array of polynomialTerms terms, length 7
        for (int i = 0; i < polynomialTerms.length; i++){
            polynomialTerms[i] = new PolynomialTerm(0, 0);
        }
    }
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
     * Method which adds the terms of two polynomials with a matching exponent
     * @param polynomialToAdd polynomial which is being added to the current polynomial
     * @return new polynomial object called sumOfPolynomialTerms
     */
    public Polynomial add(Polynomial polynomialToAdd) {
        PolynomialTerm[] sumOfPolynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        PolynomialTerm[] polynomialTermsToAdd = polynomialToAdd.getPolynomialTerms();

        for (int i = 0; i < polynomialTermsToAdd.length; i++) {
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

    /**Method which multiplies two polynomials with a maximum final grade of six
     * @param polynomialToMultiply polynomial which is being multiplied with the current polynomial
     * @return new polynomial object called multipliedPolynomialTerms
     */
    public Polynomial multiply(Polynomial polynomialToMultiply) {
        PolynomialTerm[] multipliedPolynomialTerms = new PolynomialTerm[MAX_POLYNOMIAL_GRADE_PLUS_ONE];
        PolynomialTerm[] polynomialTermsToMultiply = polynomialToMultiply.getPolynomialTerms();

        for (int i = 0; i < polynomialTermsToMultiply.length; i++)  {
            PolynomialTerm currentOwnTerm = polynomialTerms[i];

            for (int j = 0; j < polynomialTermsToMultiply.length; j++){
                PolynomialTerm currentTermToMultiply = polynomialTermsToMultiply[j];
                PolynomialTerm multipliedTerm = currentOwnTerm.multiply(currentTermToMultiply);
                int placeInPolynomial = multipliedTerm.getExponent();
                switch (placeInPolynomial) {
                    case 0: multipliedPolynomialTerms[0] = multipliedPolynomialTerms[0].add(multipliedTerm);
                        break;
                    case 1: multipliedPolynomialTerms[1] = multipliedPolynomialTerms[1].add(multipliedTerm);
                        break;
                    case 2: multipliedPolynomialTerms[2] = multipliedPolynomialTerms[2].add(multipliedTerm);
                        break;
                    case 3: multipliedPolynomialTerms[3] = multipliedPolynomialTerms[3].add(multipliedTerm);
                        break;
                    case 4: multipliedPolynomialTerms[4] = multipliedPolynomialTerms[4].add(multipliedTerm);
                        break;
                    case 5: multipliedPolynomialTerms[5] = multipliedPolynomialTerms[5].add(multipliedTerm);
                        break;
                    case 6: multipliedPolynomialTerms[6] = multipliedPolynomialTerms[6].add(multipliedTerm);
                        break;
                    default: throw new IllegalArgumentException("This polynomial term could not be multiplied in this program: Error.");
                }
            }
        }
       return new Polynomial(multipliedPolynomialTerms);
    }
    /**
     * Boolean to check if exponents of two terms to add are matching
     * @param currentTermToCalculateWith term to add which is found in current index of polynomial to add
     * @param currentOwnTerm term which is found in current index of own polynomial
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
