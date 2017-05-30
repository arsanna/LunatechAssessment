function queryResultClick() {
    var countryCode = document.getElementById('inputCode').value;
    var countryName = document.getElementById('inputName').value;

    $.ajax({
        type: 'POST',
        url: 'query/',
        dataType: "JSON",
        data: {
            code: countryCode,
            name: countryName
        },
        success: function (data) {
            if ($.trim(data)) {
                var airoportsHtml = '<table border = 1>' +
                    '<thead>' +
                    '<tr>' +
                    '<th>Ident</th>' +
                    '<th>Type</th>' +
                    '<th>Name</th>' +
                    '<th>latitude_deg</th>' +
                    '<th>longitude_deg</th>' +
                    '<th>elevation_ft</th>' +
                    '<th>runway</th>' +
                    '</tr>' +
                    '</thead>' +
                    '<tbody>';

                $.each(data, function (index, value) {
                    airoportsHtml +=
                        '<tr>' +
                        '<td>' + value.ident + '</td>' +
                        '<td>' + value.type + '</td>' +
                        '<td>' + value.name + '</td>' +
                        '<td>' + value.latitude_deg + '</td>' +
                        '<td>' + value.longitude_deg + '</td>' +
                        '<td>' + value.elevation_ft + '</td>' +
                        '<td>' +
                        '<table>' +
                        '<tbody>';
                    $.each(value.runways, function (ind, val) {
                        airoportsHtml +=
                            '<tr>' +
                            '<td>' + val.length_ft + '</td>' +
                            '<td>' + val.width_ft + '</td>' +
                            '<td>' + val.surface + '</td>' +
                            '<td>' + val.lighted + '</td>' +
                            '<td>' + val.closed + '</td>' +
                            '<td>' + val.le_ident + '</td>' +
                            '<td>' + val.le_latitude_deg + '</td>' +
                            '<td>' + val.le_longitude_deg + '</td>' +
                            '<td>' + val.le_elevation_ft + '</td>' +
                            '<td>' + val.le_heading_degT + '</td>' +
                            '<td>' + val.le_displaced_threshold_ft + '</td>' +
                            '<td>' + val.he_ident + '</td>' +
                            '<td>' + val.he_latitude_deg + '</td>' +
                            '<td>' + val.he_longitude_deg + '</td>' +
                            '<td>' + val.he_elevation_ft + '</td>' +
                            '<td>' + val.he_heading_degT + '</td>' +
                            '<td>' + val.he_displaced_threshold_ft + '</td>' +
                            '</tr>';
                    });
                    airoportsHtml += '</tbody>' +
                        '</table>' +
                        '</td>' +
                        '</tr>';
                });
                airoportsHtml +=
                    '</tbody>' +
                    '</table>';

                $('#divAirports').html(airoportsHtml);
            }
            else {
                $('#divAirports').html("No data found");
            }
        },
        error: function (data) {
            window.alert("error: " + data);
        }
    });
};