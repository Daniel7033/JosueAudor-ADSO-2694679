function save(){
    var data ={
        'nit' : $('#nit').val(),
        'rs' : $('#rs').val(),
        'address' : $('#address').val(),
        'city' : {'id' : $('#city').val()},
        'web' : $('#web').val(),
        'email' : $('#email').val(),
        'phone' : $('#phone').val(),
        'state' : $('#state').val() == 1 ? true : false 
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/company',
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
        'nit' : $('#nit').val(),
        'rs' : $('#rs').val(),
        'address' : $('#address').val(),
        'city' : {'id' : $('#city').val()},
        'web' : $('#web').val(),
        'email' : $('#email').val(),
        'phone' : $('#phone').val(),
        'state' : parseInt($('#state').val()) 
    };

    var id = $('#id').val();
    var jsonData = JSON.stringify(data);

    $.ajax({
        url : 'http://localhost:9000/seguridad/v1/api/company/' + id, 
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
        url : 'http://localhost:9000/seguridad/v1/api/company',
        method: "GET",
        dataType: 'json',
        success : function(response){
            var html = '';
            var data = response.data;

            if(Array.isArray(data)){
                data.forEach(function(item){
                    html += `<tr>
                    <td>${item.nit}</td>
                    <td>${item.rs}</td>
                    <td>${item.address}</td>
                    <td>${item.city.name}</td>
                    <td>${item.web}</td>
                    <td>${item.email}</td>
                    <td>${item.phone}</td>
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

function loadCity(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/city', 
        method : 'GET',
        dataType : 'json',
        success : function(response){
            var options = '';

            if(response.status && Array.isArray(response.data)){
               response.data.forEach(function(city){
                options += `<option value="${city.id}">${city.name}</option>`;
               });
               $('#city').html(options);
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
        url : 'http://localhost:9000/seguridad/v1/api/company/' + id,
        method: "GET",
        dataType: 'json',
        success : function(data){
            $('#id').val(data.data.id);
            $('#nit').val(data.data.nit);
            $('#rs').val(data.data.rs);
            $('#address').val(data.data.address);
            $('#city').val(data.data.city.id);
            $('#web').val(data.data.web);
            $('#email').val(data.data.email);
            $('#phone').val(data.data.phone);
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
        url : 'http://localhost:9000/seguridad/v1/api/company/' + id,
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
    $('#nit').val('');
    $('#rs').val('');
    $('#address').val('');
    $('#city').val('');
    $('#web').val('');
    $('#email').val('');
    $('#phone').val('');
    $('#state').val('');
}