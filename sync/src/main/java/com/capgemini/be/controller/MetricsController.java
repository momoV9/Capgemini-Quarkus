package com.capgemini.be.controller;

import com.capgemini.be.model.MetricsEntry;
import com.capgemini.be.repository.MetricsRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/metrics")
public class MetricsController {

    @Inject
    MetricsRepository metricsRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MetricsEntry> getMetrics() {
        return metricsRepository.getAllEntries();
    }
}
