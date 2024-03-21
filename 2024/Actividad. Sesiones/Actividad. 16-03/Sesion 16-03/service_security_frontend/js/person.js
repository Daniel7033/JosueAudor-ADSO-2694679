function loadCiudad() {
    // Realizar la solicitud AJAX
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/ciudad',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // Limpiar el selector antes de agregar nuevas opciones
            $('#ciudad').empty();

            //     // Crear opciones para el selector
            for (var i = 0; i < data.length; i++) {
                var option = document.createElement('option');
                option.value = data[i].id;
                option.text = data[i].id;
                $('#ciudad').append(option);
            }
        },
        error: function (error) {
            console.error('Error al obtener los datos:', error);
        }
    });
}

function save() {
    var data = {
        'firstName': $('#first_name').val(),
        'lastName': $('#last_name').val(),
        'email': $('#email').val(),
        'phone': $('#phone').val(),
        'dateOfBirth': $('#date_of_birth').val(),
        'gender': parseInt($('#gender').val()),
        'address': $('#address').val(),
        'ciudad': {
            'id': parseInt($('#ciudad').val()),
        },
        'state': parseInt($('#state').val())  // Convertir el valor a booleano
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/person',
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

function update() {
    // Construir el objeto data
    var data = {
        'firstName': $('#first_name').val(),
        'lastName': $('#last_name').val(),
        'email': $('#email').val(),
        'phone': $('#phone').val(),
        'dateOfBirth': $('#date_of_birth').val(),
        'gender': parseInt($('#gender').val()),
        'address': $('#address').val(),
        'ciudad':{
            'id': parseInt($('#address').val()),
        },
        'state': parseInt($('#state').val())
    };
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);
    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/person/' + id,
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
        url: 'http://localhost:9000/service-security/v1/api/person',
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
                    <td>${item.gender === true ? 'Masculino' : 'Femenino'}</td>
                    <td>${item.address}</td>
                    <td>${item.ciudad.nombre}</td>
                    <td>${item.state === true ? 'Activo' : 'Inactivo'}</td>
                    <td><button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="findById(${item.id})"><img src="../asset/icon/pencil-square.svg"></button>
                    <td><button class="btn btn-danger" onclick="deleteById(${item.id})"><img src="../asset/icon/trash-fill.svg"></button>
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
        url: 'http://localhost:9000/service-security/v1/api/person/' + id,
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            console.log("data findById", data);
            $('#id').val(data.data.id);
            $('#first_name').val(data.data.firstName);
            $('#last_name').val(data.data.lastName);
            $('#email').val(data.data.email);
            $('#phone').val(data.data.phone);
            $('#date_of_birth').val(data.data.dateOfBirth);
            $('#gender').val(data.data.gender === true ? 1 : 0);
            $('#address').val(data.data.address);
            $('#address').val(data.data.ciudad.id);
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
        url: 'http://localhost:9000/service-security/v1/api/person/' + id,
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
    $('#first_name').val('');
    $('#last_name').val('');
    $('#email').val('');
    $('#phone').val('');
    $('#date_of_birth').val('');
    $('#gender').val('');
    $('#address').val('');
    $('#ciudad').val('');
    $('#state').val('');
}