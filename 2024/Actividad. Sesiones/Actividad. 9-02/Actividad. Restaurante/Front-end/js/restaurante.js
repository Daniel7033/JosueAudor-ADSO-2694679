//Función para guardar los registros
function save() {
    // Construir el objeto data
    var data = {
      'nombre': $('#nombre').val(),
      'direccion': $('#direccion').val(),
      'tipo_cocina': $('#tipo_cocina').val(),
      'menu': ($('#menu').val()),
      'horario_atencion': parseInt($('#horario_atencion').val()),
      'capacidad': ($('#capacidad').val()),
      'estado': parseInt($('#estado').val()),
    };
  
    var jsonData = JSON.stringify(data);

    $.ajax({
      url: 'http://localhost:9000/v1/api/restaurante',
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
/*-----------------------------------------------------
Función de actualización de los registros guardados
-----------------------------------------------------*/
function update() {
    // Construir el objeto data
    var data = {
        'nombre': $('#nombre').val(),
        'direccion': $('#direccion').val(),
        'tipo_cocina': $('#tipo_cocina').val(),
        'menu': ($('#menu').val()),
        'horario_atencion': parseInt($('#horario_atencion').val()),
        'capacidad': ($('#capacidad').val()),
        'estado': parseInt($('#estado').val()),
    };
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: 'http://localhost:9000/v1/api/restaurante/' +id,
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
/*-----------------------------------------------------
Función de carga y vista de datos a tabla HTML
-----------------------------------------------------*/
function loadData() {
    $.ajax({
      url: 'http://localhost:9000/v1/api/restaurante',
      method: 'GET',
      dataType: 'json',
      success: function (data) {
        var html = '';
  
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          html += `<tr>
                  <td>`+ item.nombre + `</td>
                  <td>`+ item.direccion + `</td>
                  <td>`+ item.tipo_cocina + `</td>
                  <td>`+ item.menu + `</td>
                  <td>`+ item.horario_atencion + `</td>
                  <td>`+ item.capacidad + `</td>
                  <td>`+ (item.estado == true ? 'ACTIVO' : 'INACTIVO') + `</td>
                  <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(`+ item.id + `)"></th>
                  <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(`+ item.id + `)"></th>
              </tr>`;
        });
  
        $('#resultData').html(html);
      },
      error: function (error) {
        // Función que se ejecuta si hay un error en la solicitud
        console.error('Error en la solicitud:', error);
      }
    });
}
//Funciones "extras" 
/*-----------------------------------------------------------
findById para editar los datos en la tabla
------------------------------------------------------------*/
function findById(id) {
    $.ajax({
      url: 'http://localhost:9000/v1/api/restaurante/' + id,
      method: 'GET',
      dataType: 'json',
      success: function (data) {
        $('#id').val(data.id);
        $('#nombre').val(data.nombre);
        $('#direccion').val(data.direccion);
        $('#tipo_cocina').val(data.tipo_cocina);
        $('#menu').val(data.menu);
        $('#horario_atencion').val(data.horario_atencion);
        $('#capacidad').val(data.capacidad);
        $('#estado').val(data.estado == true ? 1 : 0);
  
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
/*---------------------------------------------------------------------
deleteById para borrar de manera permanente el registro seleccionado
-----------------------------------------------------------------------*/
//{
    function deleteById(id) {
        $.ajax({
        url: 'http://localhost:9000/v1/api/restaurante/' + id,
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
    //------------------------------
    function clearData() {
        $('#id').val('');
        $('#nombre').val('');
        $('#direccion').val('');
        $('#tipo_cocina').val('');
        $('#menu').val('');
        $('#horario_atencion').val('');
        $('#capacidad').val('');
        $('#estado').val('');
    }
//}