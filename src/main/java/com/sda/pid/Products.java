package com.sda.pid;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Products {
    private List<Bar> bars;

    public List<Bar> getBars() {
        return bars;
    }

    @XmlElement ( name = "bar")
    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }
}
