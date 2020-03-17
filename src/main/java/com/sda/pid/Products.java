package com.sda.pid;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@XmlRootElement
public class Products {
    private List<Bar> bars;
    Scanner in = new Scanner(System.in);

    public List<Bar> getBars() {
        return bars;
    }

    @XmlElement ( name = "bar")
    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public void printBars() {
        int numberOfBars = bars.size();
        for (int i = 0; i < numberOfBars; i++) {
            String s = (i + 1) + " " + bars.get(i).getSN();
            System.out.println(s);
        }
    }

    public void filterBarsByFiberAndPrint(Double fiberAmount){

        // List<Bar> filteredBars= bars.stream().filter(bars -> bars.getFiber().contains(fiberAmount)).collect(Collectors.toList());

        for (Bar bar : bars) {
            if (bar.getFiber().compareTo(fiberAmount) == -1)
                System.out.println(bar.getSN());
        }
    }
}
