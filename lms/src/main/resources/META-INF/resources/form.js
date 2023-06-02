function submitLeaveRequest(event) {
    event.preventDefault();

    const form = document.getElementById('leaveRequestForm');
    const localEmployeeId = form.elements.localEmployeeId.value;
    const leaveType = form.elements.leaveType.value;
    const startDate = form.elements.startDate.value;
    const endDate = form.elements.endDate.value;
    const startHours = form.elements.startHours.value;
    const endDateHours = form.elements.endDateHours.value;
    const totalHours = form.elements.totalHours.value;
    const reason = form.elements.reason.value;

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

    fetch('http://localhost:8080/leaves', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(leaveRequest),
    })
        .then(response => {
            if (response.ok) {

                console.log('Leave request submitted successfully.');
            } else {

                console.error('Failed to submit leave request:', response.status, response.statusText);
            }
        })
        .catch(error => {

            console.error('An error occurred while submitting the leave request:', error);
        });
}

const form = document.getElementById('leaveRequestForm');
form.addEventListener('submit', submitLeaveRequest);
