function save(){
    var data = {
        'username' : $('#username').val(),
        'password' : $('#password').val(),
        'person' : { 
            'id' : $('#person').val()
        },
        'role' : [{ 
            'id' : $('#role').val()
        }],
        'state' : $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/user',
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
    var data = {
        'username' : $('#username').val(),
        'password' : $('#password').val(),
        'person' : { 
            'id' : $('#person').val()
        },
        'role' : [{ 
            'id' : $('#role').val()
        }],
        'state' :parseInt ($('#state').val())
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/user/' + id, 
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
        url: 'http://localhost:9000/seguridad/v1/api/user', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    var roles = "";
                    item.role.forEach(function(role){
                        roles += role.name + ", ";
                    });
                    roles = roles.slice(0, -2); // Elimina la última coma y el espacio

                    html += `<tr>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.person.firstName}</td>
                    <td>${roles}</td>
                    <td>${item.state === true ? 'Activo': 'Inactivo'}</td>
                    <td><button onclick="findById(${item.id})">Editar</button></td>
                    <td><button onclick="deleteById(${item.id})">Eliminar</button></td>
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


function loadPerson(){
    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/person',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
                response.data.forEach(function(person){
                    options += `<option value="${person.id}">${person.firstName}</option>`;
                });
                $('#person').html(options);
            } else {
                console.error('La estructura no es la esperada: ', response);
            }
        },
        error : function(error){
            console.error('Error al cargar las ciudades: ',error);
        }
    });
}

function loadRole(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/role', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
               response.data.forEach(function(role){
                options += `<option value="${role.id}">${role.name}</option>`;
               });
               $('#role').html(options);
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
        url : 'http://localhost:9000/seguridad/v1/api/user/' + id, 
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.data.id);
            $('#username').val(data.data.username);
            $('#password').val(data.data.password);
            $('#person').val(data.data.person.id);
            $('#role').val(data.data.role.id);
            $('#state').val(data.data.state === true ? 1 : 0);

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
        url : 'http://localhost:9000/seguridad/v1/api/user/' + id, 
        method : 'DELETE',
        dataType : 'json',
        headers : {
            'Content-Type' : 'application/jsons'
        }
    }).done(function(result){
        alert("Registro eliminado exitoso");
        loadData();
        clearData();
    }).fail(function(xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}

function clearData(){
    $('#username').val('');
    $('#password').val('');
    $('#person').val('');
    $('#view').val('');
    $('#state').val('');
}