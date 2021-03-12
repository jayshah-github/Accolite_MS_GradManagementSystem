package com.accolite.msproject.model;

import java.io.Serializable;
import java.util.List;

public class Chart implements Serializable {
    List<String> labels;
    ChartData chartData;

    public Chart() {
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public ChartData getChartData() {
        return chartData;
    }

    public void setChartData(ChartData chartData) {
        this.chartData = chartData;
    }
}
