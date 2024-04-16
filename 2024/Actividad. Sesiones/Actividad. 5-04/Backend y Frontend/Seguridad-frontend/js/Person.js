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
            'state': parseInt($('#state').val())
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
            url: 'http://localhost:9000/seguridad/v1/api/person/personCliente/' + id,
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

//Enums
function Enum() {
    return loadTypeDocumentCliente(), loadGender(), loadNomenclaturas();
}
function loadTypeDocumentCliente() {
    // Realizar una llamada AJAX para obtener los tipos de documento desde el backend
    $.ajax({
        url: "http://localhost:9000/seguridad/v1/api/enum/tipo_documento",
        method: "GET",
        dataType: "json",
        success: function (response) {
          console.log(response);
          var html = "";
          response.forEach(function (item) {
            // Construir el HTML para cada objeto
            html += `<option value="${item}">${item}</option>`;
          });
          $("#typeDocument").html(html);
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
        },
      });
};
function loadGender() {
    // Realizar una llamada AJAX para obtener los tipos de documento desde el backend
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/enum/genero',
        type: 'GET',
        dataType: 'json',
        success: function (response) {
            // Iterar sobre los tipos de documento y agregarlos al select
            response.forEach(function (item) {
                $('#gender').append($('<option>', {
                    value: item,
                    text: item
                }));
            });
        },
        error: function (xhr, status, error) {
            console.error('Error al obtener los tipos de documento:', error);
        }
    });
};
function loadNomenclaturas() {
    // Realizar una llamada AJAX para obtener los tipos de documento desde el backend
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/enum/nomenclatura',
        type: 'GET',
        dataType: 'json',
        success: function (response) {
            // Iterar sobre los tipos de documento y agregarlos al select
            response.forEach(function (item) {
                $('#address').append($('<option>', {
                    value: item,
                    text: item
                }));
            });
        },
        error: function (xhr, status, error) {
            console.error('Error al obtener los tipos de documento:', error);
        }
    });
};


function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#firstName').val(data.data.firstName);
            $('#lastName').val(data.data.lastName);
            $('#email').val(data.data.email);
            $('#phone').val(data.data.phone);
            $('#dateOfBirth').val(data.data.dateOfBirth);
            $('#gender').val(data.data.gender);
            $('#address').val(data.data.address);
            $('#city').val(data.data.selectedCityId);
            $('#typeDocument').val(data.data.typeDocument);
            $('#document').val(data.data.document);
            $('#state').val(data.data.state === true ? 1 : 0);

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
