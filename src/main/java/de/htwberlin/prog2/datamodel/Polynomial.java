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
    }

    public Polynomial(PolynomialTerm[] polynomialTerms) {
        this();
        for (PolynomialTerm currentTerm : polynomialTerms) {
            Integer index = currentTerm.getExponent();
            if (index > MAX_POLYNOMIAL_GRADE_PLUS_ONE) {
                throw new IllegalArgumentException("The grade of the polynomial term is to large. Max allowed: "
                        + MAX_POLYNOMIAL_GRADE_PLUS_ONE);
            }
            polynomialTerms[index] = polynomialTerms[index].add(currentTerm);
        }
        this.polynomialTerms = polynomialTerms;
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

    /**
     * Boolean to check if exponents of two terms to add are matching
     * @param currentTermToAdd term to add which is found in current index of polynomial to add
     * @param currentOwnTerm term which is found in current index of own polynomial
     * @return true if exponents are the same number
     */
    private boolean hasSameExponent(PolynomialTerm currentTermToAdd, PolynomialTerm currentOwnTerm) {
        return currentTermToAdd.getExponent().equals(currentOwnTerm.getExponent());
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
