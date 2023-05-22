document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8081/metrics')
        .then(response => response.json())
        .then(data => {
            const dashboardContainer = document.getElementById('dashboard-container');
            const table = document.createElement('table');
            table.classList.add('datagrid'); // Voeg een CSS-klasse toe voor opmaak

            const thead = document.createElement('thead');
            const trHead = document.createElement('tr');

            // Voeg de kolomkoppen toe in de gewenste volgorde
            const headers = ['User', 'Leave Type', 'Start Date', 'End Date', 'Hours'];
            headers.forEach(headerText => {
                const th = document.createElement('th');
                th.textContent = headerText;
                trHead.appendChild(th);
            });

            thead.appendChild(trHead);
            table.appendChild(thead);

            const tbody = document.createElement('tbody');

            // Voeg de gegevensrijen toe
            data.forEach(entry => {
                const tr = document.createElement('tr');

                const userTd = document.createElement('td');
                userTd.textContent = entry.user;
                tr.appendChild(userTd);

                const leaveTypeTd = document.createElement('td');
                leaveTypeTd.textContent = entry.leaveType;
                tr.appendChild(leaveTypeTd);

                const startDateTd = document.createElement('td');
                startDateTd.textContent = entry.startDate;
                tr.appendChild(startDateTd);

                const endDateTd = document.createElement('td');
                endDateTd.textContent = entry.endDate;
                tr.appendChild(endDateTd);

                const hoursTd = document.createElement('td');
                hoursTd.textContent = entry.hours;
                tr.appendChild(hoursTd);

                tbody.appendChild(tr);
            });

            table.appendChild(tbody);
            dashboardContainer.appendChild(table);
        })
        .catch(error => console.error('Error:', error));
});
