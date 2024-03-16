function save() {
    var data = {
        'firstName': $('#first_name').val(),
        'lastName': $('#last_name').val(),
        'email': $('#email').val(),
        'phone': $('#phone').val(),
        'dateOfBirth': $('#date_of_birth').val(),
        'gender': $('#gender').val(),
        'address': $('#address').val(),
        'state': parseInt($('#state').val()),
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
      'gender': $('#gender').val(),
      'address': $('#address').val(), 
      'state': parseInt($('#state').val()), 
  };
  var id = $("#id").val();
  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/person/' +id,
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
                              <td>${item.gender}</td>
                              <td>${item.address}</td>
                              <td>${item.state == true ? 'Activo' : 'Inactivo'}</td>
                              <td><button onclick="findById(${item.id})">Editar</button></td>
                              <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
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
            
            $('#id').val(data.data.id);
            $('#first_name').val(data.data.firstName);
            $('#last_name').val(data.data.lastName);
            $('#email').val(data.data.email);
            $('#phone').val(data.data.phone);
            $('#date_of_birth').val(data.data.dateOfBirth);
            $('#gender').val(data.data.gender);
            $('#address').val(data.data.address);
            $('#state').val(data.data.state == true ? 1 : 0); // Convertir booleano a valor de opción

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
      url: 'http://localhost:9000/service-security/v1/api/person/'+id,
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
    $('#state').val('');
}

