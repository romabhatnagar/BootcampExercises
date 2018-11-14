$(document).ready(function () {
    $("#profileMenu").addClass('hide');
});


function showHideProfileMenu(event) {
    if ($("#profileMenu").hasClass('show')) {
        $("#profileMenu").removeClass('show');
        $("#profileMenu").addClass('hide');
        $("#badges").removeClass('hide');
        $("#badges").addClass('show');
    }
    else if ($("#profileMenu").hasClass('hide')) {
        $("#profileMenu").removeClass('hide');
        $("#profileMenu").addClass('show');
        $("#badges").removeClass('show');
        $("#badges").addClass('hide');
    }
}