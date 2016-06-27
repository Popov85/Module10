package com.goit.g2popov.module10;

import java.io.*;
import java.util.Scanner;

/**
 * Class {@code FileCipher} codes/decodes a file by means of Caesar algorithm
 * Class is able to create encrypted files and decrypt the content
 * Limitations of the encryption algorithm:
 * It works only with English alphabet
 * Shift range lies within [3-25]
 * @author  Andrii Popov
 */

public class FileCipher {

        private static final int SHIFT = 3;
        private static CipherEngine encryptionEngine = new CipherEngine("",SHIFT);

        private String pathway;

        public FileCipher (String pathway) {
                this.pathway = pathway;
        }

        public void writeByLineCoded() {
                PrintWriter writer = null;
                try {
                        writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.pathway)));
                } catch (FileNotFoundException e) {
                        System.out.println("Filed to create a file according to the pathway given!");
                }
                Scanner scanner = new Scanner(System.in);
                String nextLine;
                do {
                        System.out.println("Enter a line: ");
                        nextLine = scanner.nextLine();
                        if (!nextLine.equals("enough")) {
                                writer.print(encodeLine(nextLine));
                                writer.println();
                        }
                } while (!nextLine.equals("enough"));

                writer.flush();
                writer.close();
        }

        private String encodeLine(String line) {
                encryptionEngine.setStatement(line);
                return encryptionEngine.cipher(true);
        }

        public void readByLineDecoded() {
                Scanner scanner = null;
                try {
                        scanner = new Scanner(new BufferedReader(new FileReader(this.pathway)));
                        while (scanner.hasNextLine()) {
                                System.out.println(decodeLine(scanner.nextLine()));
                        }
                } catch (FileNotFoundException e) {
                        System.out.println("Filed to open a file according to the pathway given!");
                } finally {
                        if (scanner != null) scanner.close();
                }
        }

        private String decodeLine(String line) {
                encryptionEngine.setStatement(line);
                return encryptionEngine.cipher(false);
        }
}
