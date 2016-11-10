package de.htwberlin.prog2.io;

import de.htwberlin.prog2.datamodel.Polynomial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laura on 07.11.16.
 * @author Laura Hartgers, HTW-Berlin Matrikelnummer 556238
 * @version 1.0
 */
public class PolynomIo {

    /**
     * Method to save polynomials in a file
     * <p>
     * @param polynomialToSave polynomial which is being saved
     * @param outputPath path where the polynomial is saved
     * @throws IOException to a higher level because the Exception can't be handled here
     */
    public void save(Polynomial polynomialToSave, String outputPath) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(outputPath);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(polynomialToSave);
    }

    /**
     * Method to load polynomials from a file
     * <p>
     * @param inputPath location where the file can be found
     * @return polynomialToLoad if successful
     * @throws IOException            to a higher level because the Exception can't be handled here
     * @throws ClassNotFoundException in case he read Value is not of type Polynomial
     */
    public Polynomial load(String inputPath) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(inputPath);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        Polynomial polynomialToLoad = null;
        Object readObject = objectInput.readObject();

        if (readObject instanceof Polynomial) {
            polynomialToLoad = (Polynomial) readObject;
        } else {
            throw new ClassNotFoundException("The read Value is not of type Polynomial.");
        }

        return polynomialToLoad;
    }

    /**
     * Method which shows which polynomials are saved as files
     * <p>
     * @param path path of file
     * @return List of polynomial files
     */
    public List<String> showFiles(String path) {
        File dir = new File(path);
        List<String> polyFiles = new ArrayList<>();
        for (File currentFile : dir.listFiles()) {
            if (currentFile.getName().contains(".poly")) ;
            {
                polyFiles.add(currentFile.getName());
            }
        }
        return polyFiles;
    }

}
