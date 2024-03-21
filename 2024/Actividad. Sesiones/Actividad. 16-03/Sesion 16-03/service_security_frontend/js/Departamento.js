function loadPais() {
  // Realizar la solicitud AJAX
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/pais',
    method: 'GET',
    dataType: 'json',
    success: function (data) {
      // Limpiar el selector antes de agregar nuevas opciones
      $('#pais').empty();

  //     // Crear opciones para el selector
      for (var i = 0; i < data.length; i++) {
        var option = document.createElement('option');
        option.value = data[i].id;
        option.text = data[i].id;
      }
    },
    error: function (error) {
      console.error('Error al obtener los datos:', error);
    }
  });
}

function save() {
  // Construir el objeto data
  var data = {
    'codigo': $('#codigo').val(),
    'nombre': $('#nombre').val(),
    'pais': {
      'id': parseInt($('#pais').val()),
    },
    'state': parseInt($('#state').val()),
  };

  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/departamento',
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
    'codigo': $('#codigo').val(),
    'nombre': $('#nombre').val(),
    'pais': {
      'id': parseInt($('#pais').val()),
    },
    'state': parseInt($('#state').val()),
  };
  var id = $("#id").val();
  var jsonData = JSON.stringify(data);
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/departamento/' + id,
    data: jsonData,
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    }
  }).done(function (result) {
    alert("Registro actualizado con éxito");
    loadPais();
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
    url: 'http://localhost:9000/service-security/v1/api/departamento',
    method: 'GET',
    dataType: 'json',
    success: function (response) {
      var html = '';
      var data = response.data;
      if (Array.isArray(data)) {
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          html += `<tr>
                  <td>${item.codigo}</td>
                  <td>${item.nombre}</td>
                  <td>${item.pais.nombre_pais}</td>
                  <td>${(item.state === true ? 'Activo' : 'Inactivo')}</td>
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
      // Función que se ejecuta si hay un error en la solicitud
      console.error('Error en la solicitud:', error);
    }
  });
}

function findById(id) {
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/departamento/' + id,
    method: 'GET',
    dataType: 'json',
    success: function (data) {
      $('#id').val(data.data.id);
      $('#codigo').val(data.data.codigo);
      $('#nombre').val(data.data.nombre);
      $('#pais').val(data.data.pais.id);
      $('#state').val(data.data.state === true ? 1 : 0);

      //Cambiar boton.
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text('Actualizar');
      btnAgregar.attr('onclick', 'update()');
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error('Error en la solicitud:', error);
    }
  });
}

function deleteById(id) {
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/departamento/' + id,
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
  $('#codigo').val('');
  $('#nombre').val('');
  $('#pais').val('');
  $('#state').val('');
}

