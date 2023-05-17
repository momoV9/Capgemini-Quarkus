package com.capgemini.be.controller;

import com.capgemini.be.lms.model.LeaveRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/metrics")
public class MetricsController {

    @GET
    public List<LeaveRequest> getMetrics() {
        return null;
    }
}
