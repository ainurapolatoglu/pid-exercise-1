package com.sda.pid;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
public class Bar implements  Comparable<Bar> {
    private String SN; //attribute
    private Double fat; // the rest down are elements
    private Double energy;
    private Double carbs;
    private Double protein;
    private Double fiber;
    private List<Reviewer> reviewers;

    public String getSN() {
        return SN;
    }

    @XmlAttribute ( name = "SN")   // if we put attribute it by default thinks it is ID, so we show that it is not ID but SN from XML
    public void setSN(String SN) {
        this.SN = SN;
    }

    public double getFat() {
        return fat;
    }

    @XmlElement (name = "fett") // showing how element in xml maps to element in Bar class
    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getEnergy() {
        return energy;
    }

    @XmlElement
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getCarbs() {
        return carbs;
    }

    @XmlElement (name = "kolhydrat")
    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProtein() {
        return protein;
    }

    @XmlElement
    public void setProtein(double protein) {
        this.protein = protein;
    }

    public Double getFiber() {
        return fiber;
    }

    @XmlElement
    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public List<Reviewer> getReviewers() {
        return reviewers;
    }

    @XmlElementWrapper ( name = "review")
    @XmlElement ( name = "reviewer")
    public void setReviewers(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    @Override
    public int compareTo(Bar protein) {
        return this.protein.compareTo(protein.getProtein());
    }


}