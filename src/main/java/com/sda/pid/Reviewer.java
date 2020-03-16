package com.sda.pid;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class Reviewer {
    private String personId;
    private LocalDate reviewDate;
    private int reviewScore;

    public String getPersonId() {
        return personId;
    }

    @XmlAttribute ( name = "personID")
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    @XmlElement ( name = "date")
    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    @XmlElement ( name = "score")
    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }
}
