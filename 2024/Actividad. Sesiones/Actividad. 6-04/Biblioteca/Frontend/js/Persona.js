function save(){
    var data ={
        'nombre' : $('#nombre').val(),
        'direccion' : $('#direccion').val(),        
        'email' : $('#email').val(),        
        'telefono' : $('#telefono').val(),        
        'state' : parseInt($('#state').val())
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona',
        method : 'POST',
        dataType : 'json',
        contentType : 'application/json',
        data : jsonData,
        success : function(data){
            alert("persona guardado.");
            loadData();
            clearData();
        },
        error : function(error){
            console.error('Error al guardar: ',error);
        }
    });
}

function update(){
    var data ={
        'nombre' : $('#nombre').val(),
        'direccion' : $('#direccion').val(),        
        'email' : $('#email').val(),        
        'telefono' : $('#telefono').val(),        
        'state' : parseInt($('#state').val()) 
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona/' + id, 
        method: "PUT",
        dataType: 'json',
        contentType: 'application/json',
        data: jsonData,
        success : function(result){
            alert("Actualizado.");
            loadData(); 
            clearData();

            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Agregar');
            btnAgregar.attr('onclick', 'save()');
        },
        error : function(error){
            console.error('Error al actualizar: ', error);
        }
    });
}

function loadData(){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.direccion}</td>
                    <td>${item.email}</td>
                    <td>${item.telefono}</td>
                    <td>${item.state === true ? 'activo' : 'inactivo'}</td>
                    <td><button onclick="findById(${item.id})"><img src="../asset/icon/pencil-square.svg"></button></td>
                    <td><button onclick="deleteById(${item.id})"><img src="../asset/icon/trash3-fill.svg"></button></td>
                    </tr>`;
                });
            } else {
                console.error('El atributo "data" no es un arreglo: ',data);
            }
            $('#resultData').html(html);
        },
        error : function(error){
            console.error('Error al cargar: ',error);
        }
    });
}

function findById(id){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona/' + id,
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.id);
            $('#nombre').val(data.nombre);
            $('#direccion').val(data.direccion);
            $('#email').val(data.email);
            $('#telefono').val(data.telefono);
            $('#state').val(data.state === true ? 1 : 0);
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text('Actualizar');
            btnAgregar.attr('onclick', 'update()');

        },
        error : function(error){
            console.error('Error al encontrar: ',error);
        }
    });
}

function deleteById(id){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona/' + id,
        method: "DELETE",
        headers : {
            'Content-Type' : 'application/json'
        }
    }).done(function(result){
        alert("persona eliminado.");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el persona:", error);
    });
}

function clearData(){
    $('#nombre').val('');
    $('#direccion').val('')
    $('#email').val('')
    $('#telefono').val('')
    $('#state').val('');
}