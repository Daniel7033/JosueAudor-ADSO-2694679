function save() {
    // Construir el objeto data
    var data = {
      'cantidad': parseInt($('#cantidad').val()),
      'valor_pagar': parseFloat($('#valor_pagar').val()),
      //'factura_id': parseInt($('#factura_id').val()),
      //'producto_id': parseInt($('#producto_id').val()),
      'estado': parseInt($('#estado').val()),
    };
  
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: 'http://localhost:9000/v1/api/factura_detalle',
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
        'cantidad': parseInt($('#cantidad').val()),
        'valor_pagar': parseFloat($('#valor_pagar').val()),
      //'factura_id': parseInt($('#factura_id').val()),
      //'producto_id': parseInt($('#producto_id').val()),
      'estado': parseInt($('#estado').val()),
    };
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: 'http://localhost:9000/v1/api/factura_detalle/' +id,
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
      url: 'http://localhost:9000/v1/api/factura_detalle',
      method: 'GET',
      dataType: 'json',
      success: function (data) {
        var html = '';
  
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          html += `<tr>
                  <td>`+ item.factura_id + `</td>
                  <td>`+ item.producto_id + `</td>
                  <!-- <td>`+ item.valor_pagar + `</td> -->
                  <!-- <td>`+ item.cantidad + `</td> -->
                  <td>`+ (item.estado == true ? 'Activio' : 'Inactivo') + `</td>
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
  
  function findById(id) {
    $.ajax({
      url: 'http://localhost:9000/v1/api/factura_detalle/' + id,
      method: 'GET',
      dataType: 'json',
      success: function (data) {
        $('#id').val(data.id);
        $('#factura_id').val(data.factura_id);
        $('#producto_id').val(data.product_id);
        //$('#valor_pagar').val(data.valor_pagar);
        //$('#cantidad').val(data.cantidad);
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
  
  function deleteById(id) {
    $.ajax({
      url: 'http://localhost:9000/v1/api/factura_detalle/' + id,
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
    $('#cantidad').val('');
    $('#valor_pagar').val('');
    //$('#producto_id').val('');
    //$('#factura_id').val('');
    $('#estado').val('');
  }
  
  