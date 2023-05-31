function submitLeaveRequest(event) {
    event.preventDefault(); // Prevent form submission

    // Get form values
    const form = document.getElementById('leaveRequestForm');
    const localEmployeeId = form.elements.localEmployeeId.value;
    const leaveType = form.elements.leaveType.value;
    const startDate = form.elements.startDate.value;
    const endDate = form.elements.endDate.value;
    const startHours = form.elements.startHours.value;
    const endDateHours = form.elements.endDateHours.value;
    const totalHours = form.elements.totalHours.value;
    const reason = form.elements.reason.value;

    // Create the leave request object
    const leaveRequest = {
        localEmployeeId: parseInt(localEmployeeId),
        leaveType,
        startDate,
        endDate,
        startHours: parseInt(startHours),
        endDateHours: parseInt(endDateHours),
        totalHours: parseInt(totalHours),
        reason,
    };

    // Send the leave request to the server
    fetch('http://localhost:8081/sync', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(leaveRequest),
    })
        .then(response => {
            if (response.ok) {
                // Success! Handle the response accordingly
                console.log('Leave request submitted successfully.');
            } else {
                // Handle the error response
                console.error('Failed to submit leave request:', response.status, response.statusText);
            }
        })
        .catch(error => {
            // Handle any network or server errors
            console.error('An error occurred while submitting the leave request:', error);
        });
}

// Attach the submitLeaveRequest function to the form's submit event
const form = document.getElementById('leaveRequestForm');
form.addEventListener('submit', submitLeaveRequest);
