function addHideClass() {
    document.getElementById("profileMenu").classList.add("hide");
}

function showHideProfileMenu(event) {
    if (document.getElementById("profileMenu").classList.contains('show')) {
        document.getElementById("profileMenu").classList.remove('show');
        document.getElementById("profileMenu").classList.add('hide');
        document.getElementById("badges").classList.remove('hide');
        document.getElementById("badges").classList.add('show');
    }
    else if (document.getElementById("profileMenu").classList.contains('hide')) {
        document.getElementById("profileMenu").classList.remove('hide');
        document.getElementById("profileMenu").classList.add('show');
        document.getElementById("badges").classList.remove('show');
        document.getElementById("badges").classList.add('hide');
    }
}