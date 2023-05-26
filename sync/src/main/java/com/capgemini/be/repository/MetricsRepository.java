package com.capgemini.be.repository;

import com.capgemini.be.lms.model.LeaveType;
import com.capgemini.be.model.MetricsEntry;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MetricsRepository {
    private final List<MetricsEntry> metricsCollection;

    public MetricsRepository() {
        metricsCollection = new ArrayList<>();
        metricsCollection.add(new MetricsEntry("John Doe", LocalDate.parse("2023-05-10"), LocalDate.parse("2023-05-12"), LeaveType.VACATION, 24));
        metricsCollection.add(new MetricsEntry("Marc Doe", LocalDate.parse("2023-05-10"), LocalDate.parse("2023-05-12"), LeaveType.VACATION, 24));
        metricsCollection.add(new MetricsEntry("Alice Johnson", LocalDate.parse("2023-05-14"), LocalDate.parse("2023-05-15"), LeaveType.PARENTAL, 8));
        metricsCollection.add(new MetricsEntry("Bob Anderson", LocalDate.parse("2023-05-15"), LocalDate.parse("2023-05-16"), LeaveType.VACATION, 16));
        metricsCollection.add(new MetricsEntry("Eva Thompson", LocalDate.parse("2023-05-16"), LocalDate.parse("2023-05-17"), LeaveType.PARENTAL, 24));
        metricsCollection.add(new MetricsEntry("Michael Davis", LocalDate.parse("2023-05-17"), LocalDate.parse("2023-05-18"), LeaveType.SICK, 8));
        metricsCollection.add(new MetricsEntry("Sophia Wilson", LocalDate.parse("2023-05-18"), LocalDate.parse("2023-05-19"), LeaveType.VACATION, 16));
        metricsCollection.add(new MetricsEntry("David Clark", LocalDate.parse("2023-05-19"), LocalDate.parse("2023-05-20"), LeaveType.PARENTAL, 24));
        metricsCollection.add(new MetricsEntry("Olivia Turner", LocalDate.parse("2023-05-20"), LocalDate.parse("2023-05-21"), LeaveType.SICK, 8));
        metricsCollection.add(new MetricsEntry("Jacob Rodriguez", LocalDate.parse("2023-05-21"), LocalDate.parse("2023-05-22"), LeaveType.VACATION, 16));
        metricsCollection.add(new MetricsEntry("Emily Young", LocalDate.parse("2023-07-22"), LocalDate.parse("2023-07-25"), LeaveType.PARENTAL, 24));
        metricsCollection.add(new MetricsEntry("Emily Smith", LocalDate.parse("2023-08-28"), LocalDate.parse("2023-08-28"), LeaveType.PARENTAL, 24));
        metricsCollection.add(new MetricsEntry("William Johnson", LocalDate.parse("2023-09-23"), LocalDate.parse("2023-05-24"), LeaveType.SICK, 8));
        metricsCollection.add(new MetricsEntry("Sophie Anderson", LocalDate.parse("2023-05-24"), LocalDate.parse("2023-05-25"), LeaveType.VACATION, 16));
        metricsCollection.add(new MetricsEntry("Alexander Davis", LocalDate.parse("2023-05-25"), LocalDate.parse("2023-05-26"), LeaveType.PARENTAL, 24));
        metricsCollection.add(new MetricsEntry("Emma Wilson", LocalDate.parse("2023-05-26"), LocalDate.parse("2023-05-27"), LeaveType.SICK, 8));
        metricsCollection.add(new MetricsEntry("Noah Clark", LocalDate.parse("2023-05-27"), LocalDate.parse("2023-05-28"), LeaveType.VACATION, 16));
        metricsCollection.add(new MetricsEntry("Oliver Turner", LocalDate.parse("2023-05-28"), LocalDate.parse("2023-05-29"), LeaveType.PARENTAL, 24));
        metricsCollection.add(new MetricsEntry("Isabella Rodriguez", LocalDate.parse("2023-05-29"), LocalDate.parse("2023-05-30"), LeaveType.SICK, 8));
        metricsCollection.add(new MetricsEntry("Mia Young", LocalDate.parse("2023-05-30"), LocalDate.parse("2023-05-31"), LeaveType.VACATION, 16));
        metricsCollection.add(new MetricsEntry("James Thompson", LocalDate.parse("2023-05-31"), LocalDate.parse("2023-06-01"), LeaveType.PARENTAL, 24));

    }
    public List<MetricsEntry> getEntriesWithPagination(int offset, int pageSize) {
        int endIndex = Math.min(offset + pageSize, metricsCollection.size());

        if (offset >= metricsCollection.size()) {
            return new ArrayList<>();
        }

        return metricsCollection.subList(offset, endIndex);
    }
}
