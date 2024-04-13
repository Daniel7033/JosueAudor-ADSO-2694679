function save() {
    try {
        var selectedCityId = parseInt($("#selected_city_id").val());
        if (isNaN(selectedCityId) || selectedCityId === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'email': $('#email').val(),
            'phone': $('#phone').val(),
            'dateOfBirth': $('#dateOfBirth').val(),
            'gender': $('#gender').val(),
            "address": $("#address").val() + ' No ' + $("#numeral").val() + ' - ' + $("#numeral2").val() + ' - ' + $("#description").val(),
            'city': { 'id': selectedCityId },
            'typeDocument': $('#typeDocument').val(),
            'document': $('#document').val(),
            'state': $('#state').val() == 1 ? true : false
        };

        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/person',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (data) {
                alert("Registro guardado.");
                loadData();
                clearData();
            },
            error: function (error) {
                console.error('Error al guardar: ', error);
            }
        });
    } catch (error) {

    }
}

function update() {
    try {

        var selectedCityId = parseInt($("#selected_city_id").val());
        if (isNaN(selectedCityId) || selectedCityId === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'email': $('#email').val(),
            'phone': $('#phone').val(),
            'dateOfBirth': $('#dateOfBirth').val(),
            'gender': $('#gender').val(),
            "address": $("#address").val() + ' No ' + $("#numeral").val() + ' - ' + $("#numeral2").val() + ' - ' + $("#description").val(),
            'city': { 'id': selectedCityId },
            'typeDocument': $('#typeDocument').val(),
            'document': $('#document').val(),
            'state': parseInt($('#state').val())
        };

        var id = $('#id').val();
        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/person/' + id,
            method: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (result) {
                alert("Actualizado.");
                loadData();
                clearData();

                var btnAgregar = $('button[name="btnAgregar"]');
                btnAgregar.text('Agregar');
                btnAgregar.attr('onclick', 'save()');
            },
            error: function (error) {
                console.error('Error al actualizar: ', error);
            }
        });
    } catch (error) {

    }
}

function loadData() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;

            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.email}</td>
                    <td>${item.phone}</td>
                    <td>${item.dateOfBirth}</td>
                    <td>${item.gender}</td>
                    <td>${item.address}</td>
                    <td>${item.typeDocument}</td>
                    <td>${item.document}</td>
                    <td>${item.city.name}</td>
                    <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                    <td><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
                    </tr>`;
                });
            } else {
                console.error('El atributo "data" no es un arreglo: ', data);
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error al cargar: ', error);
        }
    });
}

//autocomplete
function loadCity() {
    console.log("Ejecutando loadCity");

    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/city',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function (city) {
                    return {
                        label: city.name,
                        value: city.id
                    };
                });

                $('#city_id').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(cities, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        console.log("ejecutadnod");
                        $("#selected_city_id").val(ui.item.value);
                        $("#city_id").val(ui.item.label);
                        console.log("ID de la ciudad seleccionada: " + ui.item.value);
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

function Enum() {
    cargarTiposDocumento();
}
function cargarTiposDocumento() {

    var tiposDocumento = ['DNI', 'CC', 'TI', 'PS', 'RC'];

    var tipoDocumentoOptions = '';
    tiposDocumento.forEach(function (tipoDocumento) {
        tipoDocumentoOptions += `<option value="${tipoDocumento}">${tipoDocumento}</option>`;
    });


    $('#typeDocument').html(tipoDocumentoOptions);
}

function cargarNomeclaturas() {
    var nomeclaturas = {
        "calle": "Calle",
        "carrera": "Carrera",
        "transversal": "Transversal",
        "bis": "Bis"
    };

    var addressInput = '';

    for (var key in nomeclaturas) {
        if (nomeclaturas.hasOwnProperty(key)) {
            addressInput += `<div class="form-group row">
                                <label class="col-sm-2 col-form-label">${nomeclaturas[key]}</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="${key}" id="${key}" placeholder="${nomeclaturas[key]}">
                                </div>
                            </div>`;
        }
    }

    $("#inputs").append(addressInput);
}


function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.id);
            $('#firstName').val(data.firstName);
            $('#lastName').val(data.lastName);
            $('#email').val(data.email);
            $('#phone').val(data.phone);
            $('#dateOfBirth').val(data.dateOfBirth);
            $('#gender').val(data.gender);
            $('#address').val(data.address);
            $('#city').val(data.city.id);
            $('#typeDocument').val(data.typeDocument);
            $('#document').val(data.document);
            $('#calle').val(data.address.calle);
            $('#carrera').val(data.address.carrera);
            $('#transversal').val(data.address.transversal);
            $('#bis').val(data.address.bis);
            $('#state').val(data.state === true ? 1 : 0);

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');

        },
        error: function (error) {
            console.error('Error al encontrar: ', error);
        }
    });
}


function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person/' + id,
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
    $('#firstName').val('');
    $('#lastName').val('');
    $('#email').val('');
    $('#phone').val('');
    $('#dateOfBirth').val('');
    $('#gender').val('');
    $('#address').val('');
    $('#city').val('');
    $('#typeDocument').val('');
    $('#document').val('');
    $('#state').val('');
}
