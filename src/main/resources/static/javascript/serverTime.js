$(document).ready(function () {
    $.ajax({
        type: 'GET',
        cache: false,
        url: location.href, //it returns the URL of the current page
        complete: function (req, textStatus) {
            var date = new Date(dateString);
            $('#serverTime').text(date);
        }
    });
});