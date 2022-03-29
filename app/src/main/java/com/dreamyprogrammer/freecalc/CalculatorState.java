package com.dreamyprogrammer.freecalc;

import java.io.Serializable;

public class CalculatorState implements Serializable {
    private String history;
    private String fullHistory;

    public CalculatorState(String history, String fullHistory) {
        this.history = history;
        this.fullHistory = fullHistory;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getFullHistory() {
        return fullHistory;
    }

    public void setFullHistory(String fullHistory) {
        this.fullHistory = fullHistory;
    }
}
