function editSaladSubmit(id) {
    $.ajax({
        type: 'POST',
        url: '/editSalad',
        data: $("#editSaladForm" + id).serialize(),
        success: function (data) {
            location.reload();
        }
    });
}

function cancelEditSalad(){
    location.reload();
}

