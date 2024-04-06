function save() {
    var data = {
        'firstName': $('#firstName').val(),
        'lastName': $('#lastName').val(),
        'email': $('#email').val(),
        'phone': $('#phone').val(),
        'dateOfBirth': $('#dateOfBirth').val(),
        'gender': $('#gender').val(),
        'address': $('#address').val(),
        'city': { 'id': $('#city').val() },
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
}

function update() {
    var data = {
        'firstName': $('#firstName').val(),
        'lastName': $('#lastName').val(),
        'email': $('#email').val(),
        'phone': $('#phone').val(),
        'dateOfBirth': $('#dateOfBirth').val(),
        'gender': $('#gender').val(),
        'address': $('#address').val(),
        'city': { 'id': $('#city').val() },
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
                    <td>${item.city.name}</td>
                    <td>${item.typeDocument}</td>
                    <td>${item.document}</td>
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

function loadCity() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/city',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            var options = '';

            if (response.status && Array.isArray(response.data)) {
                response.data.forEach(function (city) {
                    options += `<option value="${city.id}">${city.name}</option>`;
                });
                $('#city').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error: function (error) {
            console.error('Error al cargar las ciudades: ', error);
        }
    });
}

function loadTypeDocumentEnum(){
fetch('http://localhost:9000/seguridad/v1/api/enum/tipo_documento')
.then(response => response.json())
.then(data => {
  // Obtener el elemento select del formulario
  const selectElement = document.getElementById('typeDocument');
  
  // Agregar opciones al elemento select
  data.document.forEach(typeDocument => {
    const option = document.createElement('option');
    option.textContent = typeDocument;
    option.value = typeDocument;
    selectElement.appendChild(option);
  });
})
.catch(error => {
  console.error('Error al obtener los valores enum:', error);
});
}
//{
//     $.ajax({
//         url: 'http://localhost:9000/seguridad/v1/api/enum/tipo_documento',
//         method: 'GET',
//         dataType: 'json',
//         success: function (response) {
//             var options = '';

//             if (response.status && Array.isArray(response.data)) {
//                 response.data.forEach(function (item) {
//                     options += `<option value="">${item.value()}</option>`;
//                 });
//                 $('#typeDocument').html(options);
//             } else {
//                 console.error('La estructura no es la esperada: ', response);
//             }
//         },
//         error: function (error) {
//             console.error('Error al cargar las ciudades: ', error);
//         }
//     });
// }

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
            $('#city').val(data.data.city.id);
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
