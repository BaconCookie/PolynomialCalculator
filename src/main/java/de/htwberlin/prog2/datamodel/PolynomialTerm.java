package de.htwberlin.prog2.datamodel;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by laura on 09.10.16.
 * @author Laura Hartgers, HTW-Berlin Matrikelnummer 556238
 * @version 1.0
 */
public class PolynomialTerm implements Serializable {

    private Double coefficient;
    private Integer exponent;

    public PolynomialTerm(double coefficient, Integer exponent) {
        //coefficient from PolynomialTerm Class = coefficient with value from outside
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public PolynomialTerm() {
        //default constructor to avoid null pointer exception ????????
    }

    /**
     * Adds termToAdd to current term
     * <p>
     * @param termToAdd term which is added
     * @return sum of current term and termToAdd
     */
    public PolynomialTerm add(PolynomialTerm termToAdd) {
        if (exponent.equals(termToAdd.getExponent())) {
            double newCoefficient = this.coefficient + termToAdd.getCoefficient();
            return new PolynomialTerm(newCoefficient, exponent);
        } else {
            throw new IllegalArgumentException("You cannot add polynomial terms with unequal exponents.");
        }
    }

    /**
     * Subtracts termToSubtract from current term
     * <p>
     * @param termToSubtract term which is subtracted
     * @return difference between current term and termToSubtract
     */
    public PolynomialTerm subtract(PolynomialTerm termToSubtract) {
        if (exponent.equals(termToSubtract.getExponent())) {
            double newCoefficient = this.coefficient - termToSubtract.getCoefficient();
            return new PolynomialTerm(newCoefficient, exponent);
        } else {
            throw new IllegalArgumentException("You cannot subtract polynomial terms with unequal exponents.");
        }
    }

    /**
     * Multiplies termToMultiply with current term, with a max. newExponent of 6
     * If the new Exponent is 7 or more and the newCoefficient also is bigger then 0, this method throws an new IllegalArgumentException
     * <p>
     * @param termToMultiply term which is multiplied
     * @return new term which is the result of the multiplication of the two terms (newCoefficient, max. newExponent of 6)
     */
    public PolynomialTerm multiply(PolynomialTerm termToMultiply) {
        double newCoefficient = this.coefficient * termToMultiply.getCoefficient();
        int newExponent = this.exponent + termToMultiply.getExponent();
        if (newExponent < 7) {                                              //Hard coded 7, still ok?
            return new PolynomialTerm(newCoefficient, newExponent); //Bis hier wird noch richtig gerechnet, aber es scheint nicht rchtig zurückgegeben zu werden
        }
        if (newCoefficient == 0) {
            return new PolynomialTerm(0.0d, 0);
        } else {
            throw new IllegalArgumentException("The maximum grade of polynomials calculated in this program is six.");
        }
    }

    /**
     * Method which derives polynomial term with a exponent bigger then 0
     * This method is used for the first derivation of polynomials
     * <p>
     * @return new term which is the result of the derivation (newCoefficient, newExponent)
     */
    public PolynomialTerm derive() {
        if (exponent > 0) {
            double newCoefficient = this.coefficient * this.exponent;
            int newExponent = this.exponent - 1;
            return new PolynomialTerm(newCoefficient, newExponent);
        } else {
            return new PolynomialTerm(0.0d, 0);
        }
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double newCoefficient) {
        this.coefficient = newCoefficient;
    }

    public Integer getExponent() {
        return exponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolynomialTerm that = (PolynomialTerm) o;
        return Double.compare(that.getCoefficient(), getCoefficient()) == 0 &&
                Double.compare(that.getExponent(), getExponent()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoefficient(), getExponent());
    }

    @Override
    public String toString() {
        return coefficient +
                "x^" + exponent;
    }
}
