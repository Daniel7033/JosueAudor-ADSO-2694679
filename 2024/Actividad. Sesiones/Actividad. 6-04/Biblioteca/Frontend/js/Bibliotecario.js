function save(){
    var data ={
        'personaId' : { 'id' : parseInt($('#personaId').val()) },
        'state' : parseInt($('#state').val())
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/bibliotecario',
        method : 'POST',
        dataType : 'json',
        contentType : 'application/json',
        data : jsonData,
        success : function(data){
            alert("registro guardado.");
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
        'personaId' : { 'id' : parseInt($('#personaId').val()) },
        'state' : parseInt($('#state').val()) 
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/bibliotecario/' + id, 
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
        url : 'http://localhost:9000/biblioteca-backend/v1/api/bibliotecario',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.personaId.nombre}</td>
                    <td>${item.personaId.email}</td>
                    <td>${item.personaId.telefono}</td>
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

function loadPersona(){
    $.ajax({
        url : 'http://localhost:9000/biblioteca-backend/v1/api/persona',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(item){
                    options += `<option value="${item.id}">${item.nombre}</option>`;
                });
                $('#personaId').html(options);
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
        url : 'http://localhost:9000/biblioteca-backend/v1/api/bibliotecario/' + id,
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.id);
            $('#personaId').val(data.personaId.id);
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
        url : 'http://localhost:9000/biblioteca-backend/v1/api/bibliotecario/' + id,
        method: "DELETE",
        headers : {
            'Content-Type' : 'application/json'
        }
    }).done(function(result){
        alert("bibliotecario eliminado.");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el bibliotecario:", error);
    });
}

function clearData(){
    $('#personaId').val('');
    $('#state').val('');
}