$(document).ready(function () {
    $.ajax({
        type: 'GET',
        cache: false,
        url: location.href,
        complete: function (req, textStatus) {
            var date = new Date(dateString);
            $('#serverTime').text(date);
        }
    });
});