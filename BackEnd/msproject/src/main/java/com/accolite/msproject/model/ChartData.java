package com.accolite.msproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ChartData implements Serializable {
    String label;
    List<BigDecimal> data;

    public ChartData() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<BigDecimal> getData() {
        return data;
    }

    public void setData(List<BigDecimal> data) {
        this.data = data;
    }
}
