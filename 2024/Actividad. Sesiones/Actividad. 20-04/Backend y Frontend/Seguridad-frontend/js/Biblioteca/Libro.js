function save() {
    try {
        var selectedAutor = parseInt($("#selectedAutor").val());
        if (isNaN(selectedAutor) || selectedAutor === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'titulo': $('#titulo').val(),
            'codigo': $('#codigo').val(),
            'ejemplares': $('#ejemplares').val(),
            'autorId': { 'id': selectedAutor },
            'state': parseInt($('#state').val())
        };

        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/libro',
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
        var selectedAutor = parseInt($("#selectedAutor").val());
        if (isNaN(selectedAutor) || selectedAutor === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'titulo': $('#titulo').val(),
            'codigo': $('#codigo').val(),
            'ejemplares': $('#ejemplares').val(),
            'autorId': { 'id': selectedAutor },
            'state': parseInt($('#state').val())
        };
        var id = $('#id').val();
        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/libro/' + id,
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
        url: 'http://localhost:9000/seguridad/v1/api/libro',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.titulo}</td>
                    <td>${item.codigo}</td>
                    <td>${item.ejemplares}</td>
                    <td>${item.autorId.personId.nombre}</td>
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
        url: 'http://localhost:9000/seguridad/v1/api/libro/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#titulo').val(data.data.titulo);
            $('#codigo').val(data.data.codigo);
            $('#ejemplares').val(data.data.ejemplares);
            $('#autorId').val(data.data.autorId.personId.nombre);
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
        url: 'http://localhost:9000/seguridad/v1/api/libro/' + id,
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
    $('#titulo').val('');
    $('#codigo').val('');
    $('#ejemplares').val('');
    $('#autorId').val('');
    $('#state').val('');
}

//autocomplete
function loadAutor() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/autor',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function (autor) {
                    return {
                        label: autor.personId.nombre,
                        value: autor.id
                    };
                });

                $('#autorId').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(cities, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        $("#selectedAutor").val(ui.item.value);
                        $("#autorId").val(ui.item.label);
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
