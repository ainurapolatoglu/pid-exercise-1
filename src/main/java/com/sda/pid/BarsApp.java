package com.sda.pid;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BarsApp {

    public static void main(String[] args) {

        JAXBContext jaxbContext = null;
        Scanner in = new Scanner(System.in);
        int option = 0;
        System.out.println("Welcome to our amazing PROTEIN BARS list!");
        do {
            System.out.println("Pick an option:");
            System.out.println("(1) Show the name of all bars.");
            System.out.println("(2) Sort bars based on highest protein content.");
            System.out.println("(3) Sort bars based on highest fat content.");
            System.out.println("(4) Filter bars which has less than \"some number from the user\" fiber and sort them from highest to lowest.");
            System.out.println("(5) Find all protein bars with more than X protein reviewed by Y (X and Y should be entered from the user).");
            System.out.println("(6) Quit.");
            option = Integer.parseInt(in.nextLine()); //input from user
            Products products = null;

            try {
                jaxbContext = JAXBContext.newInstance(Products.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                File xmlFile = new File(ClassLoader.getSystemClassLoader().getResource("bar.xml").getFile());
                products = (Products) jaxbUnmarshaller.unmarshal(xmlFile);
                System.out.println(products.getBars().size());
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            // Printing unsorted initial list of Bar names
            if (option == 1) {
                int numberOfBars = products.getBars().size();
                for (int i = 0; i < numberOfBars; i++) {
                    String s = (i + 1) + " " + products.getBars().get(i).getSN();
                    System.out.println(s);
                }

                // Printing sorted list of Bar names by highest protein content
            } else if (option == 2) {
                // Sorting by protein in reverse order
                Collections.sort(products.getBars(), Collections.reverseOrder());
                {
                    int numberOfBars = products.getBars().size();
                    for (int i = 0; i < numberOfBars; i++) {
                        String s = (i + 1) + " " + products.getBars().get(i).getSN();
                        System.out.println(s);
                    }
                }

                // Printing sorted list of Bar names by highest fat content
            } else if (option == 3) {

                products.getBars().sort(Comparator.comparingDouble(Bar::getFat)
                        .reversed());
                {
                    int numberOfBars = products.getBars().size();
                    for (int i = 0; i < numberOfBars; i++) {
                        String s = (i + 1) + " " + products.getBars().get(i).getSN();
                        System.out.println(s);
                    }
                }

                // Printing filtered Bar names
            } else if (option == 4) {


            } else if (option == 5) {

            } else if (option == 6) {
                System.out.println(" Thank you! Come again!");
                System.out.println(" Have a proteiny day! :D ");
                break;
            } else {
                System.out.println("Entered option doesn't exist. Please enter correct option!");
            }
        } while (option > 0);
        in.close();
    }
}
