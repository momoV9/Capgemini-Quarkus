package com.capgemini.sync.controller;

import com.capgemini.sync.model.MetricsEntry;
import com.capgemini.sync.repository.MetricsRepository;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/metrics")
public class MetricsController {

    private static final int DEFAULT_PAGE_SIZE = 999;

    @Inject
    MetricsRepository metricsRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MetricsEntry> getMetrics(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("pageSize") @DefaultValue("" + DEFAULT_PAGE_SIZE) int pageSize) {
        int offset = (page - 1) * pageSize;
        return metricsRepository.getEntriesWithPagination(offset, pageSize);
    }
}
