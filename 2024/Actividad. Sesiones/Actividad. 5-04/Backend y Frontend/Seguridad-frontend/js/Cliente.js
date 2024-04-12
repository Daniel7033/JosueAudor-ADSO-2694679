function save() {
    try {
        var dataPerson = {
            'typeDocument': $('#typeDocument').val(),
            'document': $('#document').val(),
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'email': $('#email').val(),
            'phone': $('#phone').val(),
            'dateOfBirth': $('#dateOfBirth').val(),
            'gender': $('#gender').val(),
            'address': $('#address').val(),
            'city': { 'id': parseInt($('#city_id')) },
            'state': parseInt($('#state').val())
        };

        var jsonDataPerson = JSON.stringify(dataPerson);

        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/person',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: jsonDataPerson,
            success: function (dataPerson) {
                var id = data.id
                console.log(data.data);
                alert("Registro guardado.");
                loadData();
                clearData();
            },
            error: function (error) {
                console.error('Error al guardar: ', error);
            }
        });

    } catch (error) {
        console.error('Error al guardar: ', error);
    }
}


function loadPerson() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person',
        method: "GET",
        dataType: 'json',
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var persons = response.data.map(function(person) {
                    return {
                        label: `${person.firstName} ${person.lastName}`,
                        value: person.id
                    };
                });

                $('#personId').autocomplete({
                    source: persons, // Provide the array of cities as the source
                    select: function(event, ui) {
                        console.log("ejecutadnod");
                        $("#personId").val(ui.item.value);
                        $("#personId").val(ui.item.label);
                        console.log("ID de la persona seleccionada: " + ui.item.value);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });
            } else {
                console.error("No se obtuvo la lista de ciudades.");
            }
        },
        error: function(error) {
            console.error("Error en la solicitud: ", error);
        }
    });
}


function loadData() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/cliente',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;

            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.code}</td>
                    <td>${item.personId.document}</td>
                    <td>${item.personId.firstName} ${item.personId.lastName}</td>
                    <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                    <td><button onclick="findById(${item.id})">Editar</button></td>
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


function loadPersonDocumento() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person',
        method: "GET",
        dataType: 'json',
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var persons = response.data.map(function(person) {
                    return {
                        label: `${person.firstName} ${person.lastName} - ${person.document}`,
                        value: person.document,
                        id: person.id,
                        nombre: person.firstName
                    };
                });

                $('#tags').autocomplete({
                    source: function(request, response) {
                        var term = request.term.toLowerCase();
                        var filtered = persons.filter(function(person) {
                            return person.value.toLowerCase().startsWith(term);
                        });
                        response(filtered);
                    },
                    select: function(event, ui) {
                        $('#tags').val(ui.item.value); // Llena el número de documento
                        $('#name').val(ui.item.nombre); // Llena el nombre de la persona
                        $("#personId").val(ui.item.id);
                        return false;
                    }
                });
                
            } else {
                console.error("No se obtuvo la lista de personas.");
            }
        },
        error: function(error) {
            console.error("Error de la solicitud: ", error);
        }
    });
}
function Enum() {
    return loadTypeDocument(), loadGender();
}

function loadTypeDocument() {
    // Realizar una llamada AJAX para obtener los tipos de documento desde el backend
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/enum/tipo_documento',
        type: 'GET',
        dataType: 'json',
        success: function (response) {
            // Iterar sobre los tipos de documento y agregarlos al select
            response.forEach(function (item) {
                $('#typeDocument').append($('<option>', {
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

function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/cliente/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#personId').val(data.data.personId.id);
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

//autocomplete
function loadCity() {
    console.log("Ejecutando loadCity");

    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/city',
        method: "GET",
        dataType: 'json',
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function(city) {
                    return {
                        label: city.name,
                        value: city.id
                    };
                });

                $('#city').autocomplete({
                    source: cities, // Provide the array of cities as the source
                    select: function(event, ui) {
                        console.log("ejecutadnod");
                        $("#city_id").val(ui.item.value);
                        $("#city").val(ui.item.label);
                        console.log("ID de la ciudad seleccionada: " + ui.item.value);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });
            } else {
                console.error("No se obtuvo la lista de ciudades.");
            }
        },
        error: function(error) {
            console.error("Error en la solicitud: ", error);
        }
    });
}


function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/cliente/' + id,
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
    $('#typeDocument').val('');
    $('#document').val('');
    $('#state').val('');
}
