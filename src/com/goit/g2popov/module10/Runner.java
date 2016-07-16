package com.goit.g2popov.module10;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class {@code Runner} Module 10
 * Task. Encrypt/decrypt text files
 *  Writes into a file line by line
 *  You enter lines from keyboard line by line
 **/
public class Runner {

        private static final Path PATH = Paths.get("src/SampleFile.txt");

        public static void main(String[] args) {
                FileCipher fileCipher = new FileCipher(PATH);
                fileCipher.writeByLineCoded();
                fileCipher.readByLineDecoded();
        }
}
