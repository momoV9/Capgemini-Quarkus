package com.capgemini.be.repository;

import com.capgemini.be.model.MetricsEntry;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

  class MetricsRepositoryTest {

    @Test
     void testPaginationReturnsCorrectData() {
        MetricsRepository repository = new MetricsRepository();

        int offset = 0;
        int pageSize = 5;

        List<MetricsEntry> result = repository.getEntriesWithPagination(offset, pageSize);

        assertEquals(pageSize, result.size());

        MetricsEntry firstEntry = result.get(0);
        assertEquals("John Doe", firstEntry.getUser());
        assertEquals(LocalDate.parse("2023-05-10"), firstEntry.getStartDate());
        assertEquals(LocalDate.parse("2023-05-12"), firstEntry.getEndDate());

        MetricsEntry lastEntry = result.get(result.size() - 1);
        assertEquals("Eva Thompson", lastEntry.getUser());
        assertEquals(LocalDate.parse("2023-05-16"), lastEntry.getStartDate());
        assertEquals(LocalDate.parse("2023-05-17"), lastEntry.getEndDate());
    }

    @Test
     void testPaginationReturnsEmptyListWhenOffsetOutOfRange() {
        MetricsRepository repository = new MetricsRepository();

        int offset = 100;
        int pageSize = 5;

        List<MetricsEntry> result = repository.getEntriesWithPagination(offset, pageSize);

        assertTrue(result.isEmpty());
    }
}
