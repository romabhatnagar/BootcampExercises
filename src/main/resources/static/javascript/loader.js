function showLoader() {
    //document.getElementById('image').show();
    $(".load").show();
}

function hideLoader() {
    $(".load").hide();
}

$('#test').click(function (e) {
    showLoader();
    $.ajax({
        type: "post",
        url: "/employeesubmit",

        success: function (data) {
            console.log("Response came from server", data);
        },
        error: function (err) {
            console.log("Something went wrong!");
        },
        complete: function () {
            hideLoader();

        }
    });
});

