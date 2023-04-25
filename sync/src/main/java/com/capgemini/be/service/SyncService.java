package com.capgemini.be.service;
import com.capgemini.be.lms.model.LeaveRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class SyncService {

    private final HttpClient httpClient;

    public SyncService() {
        this.httpClient = HttpClientBuilder.create().build();
    }

    public void syncLeaveRequest(String syncUrl, LeaveRequest leaveRequest) throws IOException {
        HttpPost post = new HttpPost(syncUrl);

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
    }
}