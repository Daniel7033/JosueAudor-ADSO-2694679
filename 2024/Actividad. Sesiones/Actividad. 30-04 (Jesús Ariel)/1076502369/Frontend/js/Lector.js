function save() {
    var selectedPersonaId = parseInt($("#selectedPersonaId").val());
    if (isNaN(selectedPersonaId) || selectedPersonaId === null) {
        console.error("ID de ciudad no válido");
        return;
    }
    var data = {
        'codigo': $('#codigo').val(),
        'personaId': { 'id': selectedPersonaId },
        'state': parseInt($('#state').val())
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/lector',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data) {
            alert("Registro exitoso");
            loadData();
            clearData();
        },
        error: function (error) {
            console.error('Error al registrar', error)
        }

    });
}

function update() {
    try {
        var selectedPersonaId = parseInt($("#selectedPersonaId").val());
        if (isNaN(selectedPersonaId) || selectedPersonaId === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {

            'codigo': $('#codigo').val(),
            'personaId': { 'id': selectedPersonaId },
            'state': parseInt($('#state').val()),

        };
        var id = $('#id').val();
        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/biblioteca-backend/v1/api/lector/' + id,
            method: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (result) {
                alert("Actualización exitosa");
                loadData();
                clearData();

                // actualizar botón
                var btnAgregar = $('button[name="btnAgregar"]');
                btnAgregar.text('Agregar');
                btnAgregar.attr('onclick', 'save()');
            },
            error: function (error) {
                console.error("Error al actualizar el registro:", error);
            }
        });
    } catch {

    }
}



function loadData() {
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/lector',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.codigo}</td>
                    <td>${item.personaId.nombre}</td>
                    <td>${item.personaId.telefono}</td>
                    <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                    <td><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="findById(${item.id})"><img src="../asset/icon/pencil-square.svg"></button></td>
                    <td><button class="btn btn-danger" onclick="deleteById(${item.id})"><img src="../asset/icon/trash3-fill.svg"></button></td>
                    </tr>`;
                });
            } else {
                console.error('el atributo "data" no es un arreglo: ', data);
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error al registrar', error)
        }

    });
}

function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/lector/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#codigo').val(data.data.codigo);
            $('#personaId').val(data.data.personaId.nombre);
            $('#state').val(data.data.state === true ? 1 : 0);

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error) {
            console.error('Error al registrar:', error)
        }
    });
}

function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/lector/' + id,
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function (xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}


function clearData() {
    $('#codigo').val('');
    $('#personaId').val('');
    $('#state').val('');
}

//autocomplete
function loadPersona() {

    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/persona',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function (persona) {
                    return {
                        label: persona.nombre,
                        value: persona.id
                    };
                });

                $('#personaId').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(cities, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        $("#selectedPersonaId").val(ui.item.value);
                        $("#personaId").val(ui.item.label);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });
            } else {
                console.error("No se obtuvo la lista de ciudades.");
            }
        },
        error: function (error) {
            console.error("Error en la solicitud: ", error);
        }
    });
}
