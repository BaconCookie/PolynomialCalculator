package de.htwberlin.prog2.datamodel;

import java.util.Objects;

/**
 * Created by laura on 09.10.16.
 */
public class PolynomialTerm {

    private Double coefficient;
    private Integer exponent;

    public PolynomialTerm(double coefficient, Integer exponent) {
        //coefficient from PolynomialTerm Class = coefficient with value from outside
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /**
     * Adds termToAdd to current term
     * @param termToAdd term which is added
     * @return sum of current term and termToAdd
     */
    public PolynomialTerm add(PolynomialTerm termToAdd){
        if (exponent.equals(termToAdd.getExponent())) {
            double newCoefficient = this.coefficient + termToAdd.getCoefficient();
            return new PolynomialTerm(newCoefficient, exponent);
            } else {
            throw new IllegalArgumentException("You cannot add polynomial terms with unequal exponents.");
        }
    }

    /**
     * Subtracts termToSubtract from current term
     * @param termToSubtract term which is subtracted
     * @return difference between current term and termToSubtract
     */
    public  PolynomialTerm subtract(PolynomialTerm termToSubtract){
        if (exponent.equals(termToSubtract.getExponent())){
            double newCoefficient = this.coefficient - termToSubtract.getCoefficient();
            return new PolynomialTerm(newCoefficient, exponent);
        } else {
            throw new IllegalArgumentException("You cannot subtract polynomial terms with unequal exponents.");
        }
    }

    /**
     * Multplies termToMultiply with current term
     * @param termToMultiply term which is multiplied
     * @return new term which is the result of the multiplication of the two terms
     */
    public PolynomialTerm multiply(PolynomialTerm termToMultiply){
        double newCoefficient = this.coefficient * termToMultiply.getCoefficient();
        int newExponent = this.exponent + termToMultiply.getExponent();
        if (newExponent < 7) {                                              //Hard coded 7, still ok?
            return new PolynomialTerm(newCoefficient, newExponent);
        } else {
            throw new IllegalArgumentException("The maximum grade of polynomials calculated in this program is six.");
        }
    }

    public Double getCoefficient() {
        return coefficient;
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
        return "PolynomialTerm{" +  coefficient +
                "x^" + exponent +
                '}';
    }
}
