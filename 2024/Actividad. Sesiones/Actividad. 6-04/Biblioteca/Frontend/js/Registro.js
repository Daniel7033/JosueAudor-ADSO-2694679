function save(){
    var data ={
        'fechaInicio' : $('#fechaInicio').val(),
        'fechaFin' : $('#fechaFin').val(),
        'libroId' : { 'id' : parseInt($('#libroId').val()) },
        'lectorId' : { 'id' : parseInt($('#lectorId').val()) },
        'state' : parseInt($('#state').val())
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/registro',
        method : 'POST',
        dataType : 'json',
        contentType : 'application/json',
        data : jsonData,
        success : function(data){
            alert("Registro guardado.");
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
        'fechaInicio' : $('#fechaInicio').val(),
        'fechaFin' : $('#fechaFin').val(),
        'libroId' : { 'id' : parseInt($('#libroId').val()) },
        'lectorId' : { 'id' : parseInt($('#lectorId').val()) },
        'state' : parseInt($('#state').val()) 
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/registro/' + id, 
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
        url : 'http://localhost:9000/biblioteca-backend/v1/api/registro',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.fechaInicio}</td>
                    <td>${item.fechaFin}</td>
                    <td>${item.libroId.titulo}</td>
                    <td>${item.lectorId.personaId.nombre}</td>
                    <td>${item.state === true ? "<img src='../asset/icon/icons8-emoji-circulo-verde-48.png'>" : "<img src='../asset/icon/icons8-emoji-circulo-rojo-48.png'>"}</td>
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

function loadLibro(){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/libro',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(item){
                    options += `<option value="${item.id}">${item.titulo}</option>`;
                });
                $('#libroId').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar las ciudades: ',error);
        }
    });
}

function loadLector(){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/lector',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(item){
                    options += `<option value="${item.id}">${item.personaId.nombre}</option>`;
                });
                $('#lectorId').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar las ciudades: ',error);
        }
    });
}

function findById(id){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/registro/' + id,
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.id);
            $('#fechaInicio').val(data.fechaInicio);
            $('#fechaFin').val(data.fechaFin);
            $('#libroId').val(data.libroId.id);
            $('#lectorId').val(data.lectorId.id);
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
        url : 'http://localhost:9000/biblioteca-backend/v1/api/registro/' + id,
        method: "DELETE",
        headers : {
            'Content-Type' : 'application/json'
        }
    }).done(function(result){
        alert("Registro eliminado.");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}

function clearData(){
    $('#fechaInicio').val('');
    $('#fechaFin').val('');
    $('#libroId').val('');
    $('#lectorId').val('');
    $('#state').val('');
}