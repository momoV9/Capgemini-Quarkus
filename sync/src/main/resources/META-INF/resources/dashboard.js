document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8081/metrics')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('dashboard-container');

            const gridOptions = {
                dataSource: data,
                columns: [
                    { dataField: 'user', caption: 'User' },
                    { dataField: 'leaveType', caption: 'Leave Type' },
                    { dataField: 'startDate', caption: 'Start Date' },
                    { dataField: 'endDate', caption: 'End Date' },
                    { dataField: 'hours', caption: 'Hours' }
                ],
                columnAutoWidth: true,
                showBorders: true,
                editing: {
                    allowDeleting: true
                }
            };

            const dashboardContainer = document.getElementById('dashboard-container');
            const dataGrid = new DevExpress.ui.dxDataGrid(dashboardContainer, gridOptions);
            dataGrid.on('cellValueChanged', function(e) {
                console.log('Data is gewijzigd:', e);
            });
        })
        .catch(error => console.error('Error:', error));
});
