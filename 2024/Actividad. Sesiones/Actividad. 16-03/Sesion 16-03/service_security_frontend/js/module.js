function loadView() {
    // Realizar la solicitud AJAX
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/view',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // Limpiar el selector antes de agregar nuevas opciones
            $('#view').empty();

            //     // Crear opciones para el selector
            for (var i = 0; i < data.length; i++) {
                var option = document.createElement('option');
                option.value = data[i].id;
                option.text = data[i].id;
                $('#view').append(option);
            }
        },
        error: function (error) {
            console.error('Error al obtener los datos:', error);
        }
    });
}
//Funcion para guardar datos de la entidad "Module"
function save() {
    var data = {
        'name': $('#name').val(),
        'route': $('#route').val(),
        'description': $('#description').val(),
        'view': {
            'id': parseInt($('#view').val()),
        },
        'state': parseInt($('#state').val()),
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/module',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success: function (data) {
            alert("Registro agregado con éxito");
            loadData();
            clearData();
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}
/* -------------------------------------------------------------------------
Funcion para actualizar los datos ya guardados en la entidad "Module"
*/
function update() {
    // Construir el objeto data
    var data = {
        'name': $('#name').val(),
        'route': $('#route').val(),
        'description': $('#description').val(),
        'view': {
            'id': parseInt($('#view').val()),
        },
        'state': parseInt($('#state').val()),
    };
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/module/' + id,
        data: jsonData,
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro actualizado con éxito");
        loadData();
        clearData();

        //actualzar boton
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text('Agregar');
        btnAgregar.attr('onclick', 'save()');
    })
}

function loadData() {
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/module',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;
            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                              <td>${item.name}</td>
                              <td>${item.route}</td>
                              <td>${item.description}</td>
                              <td>${item.view.name}</td>
                              <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                              <th><button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="findById(${item.id})"><img src="../asset/icon/pencil-square.svg"></button></th>
                              <th><button class="btn btn-danger" onclick="deleteById(${item.id})"><img src="../asset/icon/trash-fill.svg"></button></th>
                          </tr>`;
                });
            } else {
                console.error('El atributo "data" recibido no es un arreglo:', data);
            }
            $('#resultData').html(html);
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}




function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/module/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {

            $('#id').val(data.data.id);
            $('#name').val(data.data.name);
            $('#route').val(data.data.route);
            $('#description').val(data.data.description);
            $('#description').val(data.data.view);
            $('#state').val(data.data.state === true ? 1 : 0); // Convertir booleano a valor de opción

            // Cambiar el texto y el evento onclick del botón "Agregar" a "Actualizar"
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
        }
    });
}




function deleteById(id) {
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/module/' + id,
        method: "delete",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        alert("Registro eliminado con éxito");
        loadData();
        clearData();
    })
}


function clearData() {
    $('#id').val('');
    $('#name').val('');
    $('#route').val('');
    $('#description').val('');
    $('#state').val('');
}

