function save() {
    try {
        var selectedPersonaId = parseInt($("#selectedPersona").val());
        if (isNaN(selectedPersonaId) || selectedPersonaId === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'personaId': { 'id': selectedPersonaId },
            'fechaNacimiento': parseInt($('#fechaNacimiento').val()),
            'fechaMuerte': parseInt($('#fechaMuerte').val()),
            'state': parseInt($('#state').val())
        };

        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9000/biblioteca-backend/v1/api/autor',
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
    } catch {

    }
}

function update() {
    try {
        var selectedPersonaId = parseInt($("#selectedPersona").val());
        if (isNaN(selectedPersonaId) || selectedPersonaId === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'personaId': { 'id': selectedPersonaId },
            'fechaNacimiento': $('#fechaNacimiento').val(),
            'fechaMuerte': $('#fechaMuerte').val(),
            'state': parseInt($('#state').val()),

        };
        var id = $('#id').val();
        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/biblioteca-backend/v1/api/autor/' + id,
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
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.personaId.nombre}</td>
                    <td>${item.fechaNacimiento}</td>
                    <td>${item.fechaMuerte}</td>
                    <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                    <td><button type="button" class="btn btn-secondary modal-button" data-bs-dismiss="modal"  data-bs-target="#exampleModal" onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
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
    var selectedPersonaId = personaId.nombre;
    $.ajax({
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#personaId').val(data.data.selectedPersonaId);
            $('#fechaNacimiento').val(data.data.fechaNacimiento);
            $('#fechaMuerte').val(data.data.fechaMuerte);
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
        url: 'http://localhost:9000/biblioteca-backend/v1/api/autor/' + id,
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
    $('#personaId').val('');
    $('#fechaNacimiento').val('');
    $('#fechaMuerte').val('');
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
                        $("#selectedPersona").val(ui.item.value);
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
