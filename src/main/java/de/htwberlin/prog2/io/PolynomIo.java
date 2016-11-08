package de.htwberlin.prog2.io;

import de.htwberlin.prog2.datamodel.Polynomial;

import java.io.*;

/**
 * Created by laura on 07.11.16.
 */
public class PolynomIo {

    public void save(Polynomial polynomialToSave, String outputPath) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(outputPath);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(polynomialToSave);

    }

    public Polynomial load(String inputPath) throws IOException, ClassNotFoundException{
        FileInputStream fileInput = new FileInputStream(inputPath);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        Polynomial polynomialToLoad = null;
        Object readObject = objectInput.readObject();

        if (readObject instanceof Polynomial) {
            polynomialToLoad = (Polynomial) readObject;
        }else {
            throw new ClassNotFoundException("The read Value is not of type Polynomial.");
        }

        return polynomialToLoad;
    }

}
