package com.sda.pid;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BarsApp {

    public static void main(String[] args) {
        JAXBContext jaxbContext = null;

        try {
            jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File xmlFile = new File(ClassLoader.getSystemClassLoader().getResource("bar.xml").getFile());
            Products products = (Products) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(products.getBars().size());
        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }
}
