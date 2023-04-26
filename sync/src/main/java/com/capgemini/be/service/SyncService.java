package com.capgemini.be.service;

import com.capgemini.be.lms.model.LeaveRequest;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.IOException;

@ApplicationScoped
public class SyncService {

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        // create the leave request in the local database
        // ...

        // send the leave request to the sync application
        String syncUrl = "http://localhost:8080/sync/leaves"; // replace with the actual URL of the sync application
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(syncUrl);

        try {
            StringEntity requestBody = new StringEntity(
                    "{\n" +
                            "    \"localEmployeeId\": " + leaveRequest.getLocalEmployeeId() + ",\n" +
                            "    \"leaveType\": \"" + leaveRequest.getLeaveType() + "\",\n" +
                            "    \"startDate\": \"" + leaveRequest.getStartDate() + "\",\n" +
                            "    \"endDate\": \"" + leaveRequest.getEndDate() + "\",\n" +
                            "    \"startHours\": \"" + leaveRequest.getStartHours() + "\",\n" +
                            "    \"endDateHours\": \"" + leaveRequest.getEndDateHours() + "\",\n" +
                            "    \"totalHours\": \"" + leaveRequest.getTotalHours() + "\",\n" +
                            "    \"reason\": \"" + leaveRequest.getReason() + "\",\n" +
                            "    \"status\": \"" + leaveRequest.getStatus() + "\"\n" +
                            "}"
            );
            post.setEntity(requestBody);
            post.setHeader("Content-type", "application/json");

            HttpResponse response = httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed to sync leave request. Response code: " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to sync leave request: " + e.getMessage(), e);
        }

        return leaveRequest;
    }
}
