package com.sda.pid;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
public class Products {
    private List<Bar> bars;
    Products products = null;

    public List<Bar> getBars() {
        return bars;
    }

    @XmlElement ( name = "bar")
    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public void PrintBars () {
        int numberOfBars = products.getBars().size();
        for (int i = 0; i < numberOfBars; i++) {
            String s = (i + 1) + " " + products.getBars().get(i).getSN();
            System.out.println(s);
        }
    }

}
