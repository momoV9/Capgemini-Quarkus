document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8081/metrics')
        .then(response => response.json())
        .then(data => {
            const dashboardDataElement = document.getElementById('dashboard-data');
            data.forEach(entry => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${entry.user}</td>
                    <td>${entry.startDate} - ${entry.endDate}</td>
                    <td>${entry.leaveType}</td>
                    <td>${entry.hours}</td>
                `;
                dashboardDataElement.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
});
