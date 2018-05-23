function loadIngredients(id) {
    $.ajax({
        type: 'POST',
        url: '/loadingredients',
        data: $("#saladForm" + id).serialize(),
        success: function (data, textstatus) {
            if (data !== '') {
                $("#ingredients").html("").append(data);
            }

        }
    });
}

function createSalad(id) {
    $.ajax({
        type: 'GET',
        url: '/createSalad',
        success: function (data, textstatus) {
            if (data !== '') {
                $("#newSalad").html("").append(data);
            }

        }
    });
}

function editSalad(id) {
    $.ajax({
        type: 'GET',
        url: '/editSalad',
        data: $("#saladForm" + id).serialize(),
        success: function (data, textstatus) {
            if (data !== '') {
                $("#th" + id).html("").append(data);
            }

        }
    });
}

function removeSaladSubmit(id) {
    if(confirm('Sure?')) {
        $.ajax({
            type: 'POST',
            url: '/removeSalad',
            data: $("#saladForm" + id).serialize(),
            success: function (data, textstatus) {
                location.reload();
            }
        });
    }
}
