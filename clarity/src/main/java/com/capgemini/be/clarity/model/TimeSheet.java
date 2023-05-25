package com.capgemini.be.clarity.model;

import java.time.LocalDate;
import java.util.List;

public class TimeSheet {

    private long user;
    private List<TimesheetEntry> entries;

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public List<TimesheetEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<TimesheetEntry> entries) {
        this.entries = entries;
    }

    public static class TimesheetEntry {
        private LocalDate date;
        private int hours;
        private String investmentId;

        private String Investment;

        public String getInvestment() {
            return Investment;
        }

        public void setInvestment(String investment) {
            Investment = investment;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public String getInvestmentId() {
            return investmentId;
        }

        public void setInvestmentId(String investmentId) {
            this.investmentId = investmentId;
        }
    }
}


