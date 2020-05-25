package com.sda.pid;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@XmlRootElement
public class Products {
    private List<Bar> bars;
    Scanner in = new Scanner(System.in);

    public List<Bar> getBars() {
        return bars;
    }

    @XmlElement(name = "bar")
    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public void printBars() {
        int numberOfBars = bars.size();
        IntStream.range(0, numberOfBars).mapToObj(i -> (i + 1) + " " + bars.get(i).getSN()).forEachOrdered(System.out::println);
    }

    public void filterBarsByFiberAndPrint(Double fiberAmount) {
        for (Bar bar : bars) {
            if (bar.getFiber() < fiberAmount)
                System.out.println(bar.getSN());
        }
    }

    public List<Bar> filterBarsByProtein(Double proteinAmount) {
        List<Bar> filteredList = new ArrayList<>();
        for (Bar bar : bars) {
            if (bar.getProtein() > proteinAmount) {
                filteredList.add(bar);
            }
        }
        return filteredList;
    }

    public void filterReviewersAndPrint(List<Bar> barList, String user) {
        for (Bar bar : barList) {
            for (Reviewer reviewer : bar.getReviewers()) {
                if (user.equals(reviewer.getPersonId())) {
                    System.out.println(bar.getSN());
                    break;
                }
            }
        }

    }
}
