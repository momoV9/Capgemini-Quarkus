document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8081/metrics')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('dashboard-container');

            const hotInstance = new Handsontable(container, {
                data: data,
                columns: [
                    { data: 'user' },
                    { data: 'leaveType' },
                    { data: 'startDate' },
                    { data: 'endDate' },
                    { data: 'hours' }
                ],
                columnSorting: true,
                manualRowMove: true,
                pagination: true,
                maxRows: 120,
                rowHeaders: true,
                colHeaders: ['User', 'Leave Type', 'Start Date', 'End Date', 'Hours'],
                contextMenu: true,
                licenseKey: 'non-commercial-and-evaluation'
            });

            hotInstance.addHook('afterChange', function(changes) {
                console.log('Data is gewijzigd:', changes);
            });

        })
        .catch(error => console.error('Error:', error));
});
