package de.htwberlin.prog2;

/**
 * Created by laura on 10.10.16.
 */
public class Example {

    public void example() {

        System.out.println("Klassenvariable: " + Integer.MAX_VALUE);
        Integer integerObjektAkaInstanz = new Integer(5);

        System.out.println("Instanzvariable: " + integerObjektAkaInstanz.intValue());
        System.out.println("Klassenvariable an einer Instanz: " + integerObjektAkaInstanz.MAX_VALUE);
    }
}
