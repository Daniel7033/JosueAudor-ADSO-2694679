function saveCliente() { //SAVE para asociarlo a una persona existente y que se vuelva un cliente
    try {
        var documentPerson = parseInt($('#tags').val());
        if (isNaN(documentPerson) || documentPerson == null) {
            console.error("Documento inválido");
            return;
        }
        var namePerson = parseInt($('#selectedPerson').val());
        if (isNaN(namePerson) || namePerson == null) {
            console.error("Persona inexistente");
            return;
        }
        var data = {
            'tags': { 'id': documentPerson },
            'personId': { 'id': documentPerson },
        };
        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/cliente',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                console.log(response.data.id);
                console.log(response.data);
                alert('Persona asociada a cliente')
                loadData();
                clearData();
            },
            error: function (error) {
                console.error('Error: ', error);
            }
        });
    } catch (error) {
        console.error("Error: " + error);
    }
}
//SAVE para crear un nuevo cliente y persona a la ves
function save() {
    try {
        var selectedCityId = parseInt($("#selected_city_id").val());
        if (isNaN(selectedCityId) || selectedCityId === null) {
            console.error("ID de ciudad no válido");
            return;
        }

        var dataPerson = {
            'typeDocument': $('#typeDocumentPerson').val(),
            'document': $('#document').val(),
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'email': $('#email').val(),
            'phone': $('#phone').val(),
            'dateOfBirth': $('#dateOfBirth').val(),
            'gender': $('#gender').val(),
            "address": $("#address").val() + ' No ' + $("#numeral").val() + ' - ' + $("#numeral2").val() + ' - ' + $("#description").val(),
            'city': { 'id': selectedCityId },
            'state': parseInt($('#state').val() === true ? 1 : 0)
        };


        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/cliente/personCliente',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(dataPerson),
            success: function (response) {
                var id = response.data.id
                console.log(response.data.id);
                console.log(response.data);

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

function update() {
    // Construir el objeto data
    var selectedCityId = parseInt($("#selected_city_id").val());
    if (isNaN(selectedCityId) || selectedCityId === null) {
        console.error("ID de ciudad no válido");
        return;
    }
    try {
        var data = {
            'firstName': $("#firstName").val(),
            'lastName': $("#lastName").val(),
            'typeDocument': $("#typeDocumentPerson").val(),
            'document': $("#document").val(),
            'email': $("#email").val(),
            'phone': $("#phone").val(),
            'dateOfBirth': $("#dateOfBirth").val(),
            'gender': $("#gender").val(),
            'address': $("#address").val() + ' No. ' + $("#numeral").val() + ' - ' + $("#numeral2").val() + ' - ' + $("#description").val(),
            'city': {
                'id': selectedCityId
            },
            'state': parseInt($("#state").val())
        };

        var id = $('#id').val();
        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/cliente/personCliente/' + id,
            data: jsonData,
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
        }).done(function (result) {
            alert("Registro actualizado con éxito");
            loadData();
            clearData();
            //actualzar boton
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text("Agregar");
            btnAgregar.attr("onclick", "save()");
        });
    } catch (error) {
        alert("Error en actualizar user.");
        console.error("Error en la solicitud:", error);
        //actualzar boton
        loadData();
        clearData()
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
    }
}

function loadData() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/cliente/list',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;

            data.forEach(function (item) {
                if (!item.deletedAt) {
                    html += `<tr>
                        <td>${item.code}</td>
                        <td>${item.typeDocument}</td>
                        <td>${item.document}</td>
                        <td>${item.name}</td>
                        <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                        <td><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="findById(${item.id})">Editar</button></td>
                        <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
                        </tr>`;
                }
            });

            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error al cargar: ', error);
        }
    });
}

//Busqueda por Id
function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/cliente/list/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#firstName').val(data.data.personId.firstName);
            $('#lastName').val(data.data.personId.lastName);
            $('#typeDocument').val(data.data.personId.typeDocument);
            $('#document').val(data.data.personId.document);
            $('#email').val(data.data.personId.email);
            $('#phone').val(data.data.personId.phone);
            $('#dateOfBirth').val(data.data.personId.dateOfBirth);
            $('#gender').val(data.data.personId.gender);
            $('#address').val(data.data.personId.address);
            $('#city').val(data.data.personId.city.name);
            $('#state').val(data.data.state == true ? 1 : 0);
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');

        },
        error: function (error) {
            console.error('Error al encontrar: ', error);
        }
    });
}

//Borrado por id
function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/cliente/list' + id,
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

//Limpiar datos de formulario
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

//autocomplete
function autocomplete() {
    return loadCity(), loadPerson(), loadPersonDocumento();
}
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

function loadPerson() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var persons = response.data.map(function (person) {
                    return {
                        label: `${person.firstName} ${person.lastName}`,
                        value: person.id
                    };
                });

                $('#personId').autocomplete({
                    source: persons, // Provide the array of cities as the source
                    select: function (event, ui) {
                        $("#selectedPerson").val(ui.item.value);
                        $("#personId").val(ui.item.label);
                        console.log("ID de la persona seleccionada: " + ui.item.value);
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
function loadPersonDocumento() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/person',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var persons = response.data.map(function (person) {
                    return {
                        label: `${person.document} - ${person.typeDocument}`,
                        value: person.document,
                    };
                });

                $('#tags').autocomplete({
                    source: function (request, response) {
                        var term = request.term.toLowerCase();
                        var filtered = persons.filter(function (person) {
                            return person.value.toLowerCase().startsWith(term);
                        });
                        response(filtered);
                    },
                    select: function (event, ui) {
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
        error: function (error) {
            console.error("Error de la solicitud: ", error);
        }
    });
}

//Enums (datos quemados)
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
          $("#typeDocumentCliente").html(html);
          $("#typeDocumentPerson").html(html);
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
