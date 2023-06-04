window.addEventListener("DOMContentLoaded", function() {
    searchTimesheet();
});

function searchTimesheet() {
    // Clear previous search results
    let table = document.getElementById("timesheetTable");
    table.innerHTML = '<tr><th>Date</th><th>Investment</th><th>Investment ID</th><th>Hours</th></tr>';

    // Make an AJAX request to the server to fetch timesheet entries
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/clarity", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            let response = JSON.parse(xhr.responseText);
            displayTimesheetEntries(response);
        }
    };

    // Send an empty JSON object as the request body
    xhr.send(JSON.stringify({}));
}

function displayTimesheetEntries(response) {
    let table = document.getElementById("timesheetTable");
    let entries = response.entries;

    if (entries.length === 0) {
        let row = table.insertRow();
        let cell = row.insertCell();
        cell.colSpan = 4;
        cell.textContent = "No timesheet entries found.";
    } else {
        for (let i = 0; i < entries.length; i++) {
            let entry = entries[i];
            let row = table.insertRow();
            row.insertCell().textContent = entry.date;
            row.insertCell().textContent = entry.investment;
            row.insertCell().textContent = entry.investmentId;
            row.insertCell().textContent = entry.hours;
        }
    }
}
