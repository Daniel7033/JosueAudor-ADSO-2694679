function save() {
    try {
        // cargar los libros
        let selectedLibro = parseInt($("#selectedLibro").val());
        if (isNaN(selectedLibro) || selectedLibro === null) {
            console.error("ID de libro no válido");
            return;
        }
        //Cargar los lectores
        var selectedLector = parseInt($("#selectedLector").val());
        if (isNaN(selectedLector) || selectedLector === null) {
            console.error("ID de lector no válido");
            return;
        }
        var data = {
            'fechaInicio': $('#fechaInicio').val(),
            'fechaFin': $('#fechaFin').val(),
            'libroId': { 'id': selectedLibro },
            'lectorId': { 'id': selectedLector },
            'state': parseInt($('#state').val())
        };

        var jsonData = JSON.stringify(data);
        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/registro',
            method: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (data) {
                alert("Registro guardado.");
                loadData();
                loadRegistros();
                clearData();
            },
            error: function (error) {
                console.error('Error al guardar: ', error);
            }
        });
    } catch {

    }
}

function update() {
    try {
        // cargar los libros
        var selectedLibro = parseInt($("#selectedLibro").val());
        if (isNaN(selectedLibro) || selectedLibro === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        //Cargar los lectores
        var selectedLector = parseInt($("#selectedLector").val());
        if (isNaN(selectedLector) || selectedLector === null) {
            console.error("ID de ciudad no válido");
            return;
        }
        var data = {
            'fechaInicio': $('#fechaInicio').val(),
            'fechaFin': $('#fechaFin').val(),
            'libroId': { 'id': selectedLibro },
            'lectorId': { 'id': selectedLector },
            'state': parseInt($('#state').val())
        };
        var id = $('#id').val();
        var jsonData = JSON.stringify(data);

        $.ajax({
            url: 'http://localhost:9000/seguridad/v1/api/registro/' + id,
            method: "PUT",
            dataType: 'json',
            contentType: 'application/json',
            data: jsonData,
            success: function (result) {
                alert("Actualizado.");
                loadData();
                loadRegistros();
                clearData();

                var btnAgregar = $('button[name="btnAgregar"]');
                btnAgregar.text('Agregar');
                btnAgregar.attr('onclick', 'save()');
            },
            error: function (error) {
                console.error('Error al actualizar: ', error);
            }
        });
    } catch {

    }
}

function cargarTabla() {
    return loadData(), loadRegistros();
}
//Carga a la tabla los datos 
function loadData() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/registro',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;

            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.fechaInicio}</td>
                    <td>${item.fechaFin}</td>
                    <td>${item.libroId.titulo}</td>
                    <td>${item.lectorId.personId.nombre}</td>
                    <td>${item.state === true ? "<img src='../asset/icon/icons8-emoji-circulo-verde-48.png'>" : "<img src='../asset/icon/icons8-emoji-circulo-rojo-48.png'>"}</td>
                    <td><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="findById(${item.id})"><img src="../asset/icon/pencil-square.svg"></button></td>
                    <td><button class="btn btn-danger" onclick="deleteById(${item.id})"><img src="../asset/icon/trash3-fill.svg"></button></td>
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
//Carga al Modal tabla los datos resumidos
function loadRegistros() {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/registro/registros',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            var html = '';
            var data = response.data;

            if (Array.isArray(data)) {
                data.forEach(function (item) {
                    html += `<tr>
                    <td>${item.nombre}</td>
                    <td>${item.total}</td>
                    </tr>`;
                });
            } else {
                console.error('El atributo "data" no es un arreglo: ', data);
            }
            $('#result').html(html);
        },
        error: function (error) {
            console.error('Error al cargar: ', error);
        }
    });
}

function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/registro/' + id,
        method: "GET",
        dataType: 'json',
        success: function (data) {
            $('#id').val(data.data.id);
            $('#fechaInicio').val(data.data.fechaInicio);
            $('#fechaFin').val(data.data.fechaFin);
            $('#libroId').val(data.data.libroId.titulo);
            $('#lectorId').val(data.data.lectorId.personId.nombre);
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
        url: 'http://localhost:9000/seguridad/v1/api/registro/' + id,
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        }
    }).done(function (result) {
        alert("Registro eliminado.");
        loadData();
        clearData();
    }).fail(function (xhr, status, error) {
        console.error("Error al eliminar el registro:", error);
    });
}

function clearData() {
    $('#fechaInicio').val('');
    $('#fechaFin').val('');
    $('#libroId').val('');
    $('#lectorId').val('');
    $('#state').val('');
}

//autocomplete
function autocomplete() {
    return loadLibro(), loadLector();
}
function loadLibro() { //Libro
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/libro',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function (libro) {
                    return {
                        label: libro.titulo,
                        value: libro.id
                    };
                });

                $('#libroId').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(cities, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        $("#selectedLibro").val(ui.item.value);
                        $("#libroId").val(ui.item.label);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });
            } else {
                console.error("No se obtuvo la lista de ciudades.");
            }
        },
        error: function (error) {
            console.error("Error en la solicitud: ", error);
        }
    });
}
function loadLector() { //Lector
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/lector',
        method: "GET",
        dataType: 'json',
        success: function (response) {
            if (response.status && Array.isArray(response.data)) {
                var cities = response.data.map(function (lector) {
                    return {
                        label: lector.personId.nombre,
                        value: lector.id
                    };
                });

                $('#lectorId').autocomplete({
                    source: function (request, response) {
                        var results = $.ui.autocomplete.filter(cities, request.term);
                        if (!results.length) {
                            results = [{ label: 'No se encontraron resultados', value: null }];
                        }
                        response(results);
                    },
                    select: function (event, ui) {
                        $("#selectedLector").val(ui.item.value);
                        $("#lectorId").val(ui.item.label);
                        return false; // Evita la actualización del valor del input después de la selección.
                    }
                });
            } else {
                console.error("No se obtuvo la lista de ciudades.");
            }
        },
        error: function (error) {
            console.error("Error en la solicitud: ", error);
        }
    });
}
function libroTotal(){
    $.ajax({
        url: 'http://localhost:9000/seguridad/v1/api/libro/cantidad',
        method: 'GET',
        dataType: 'json',
        success : function(data){
             var cantidadLibros = data;
            $('#libros').val(cantidadLibros);
            console.log("Cantidad de libros disponibles:", cantidadLibros);
        },
        error: function (error){
            console.error('Error al obtener la cantidad de libros:', error);
        }
    });
}

//FECHA ACTUAL
document.addEventListener('DOMContentLoaded', function () {
    var fechaInput = document.getElementById('fechaInicio');
    var hoy = new Date();
    var dia = ('0' + hoy.getDate()).slice(-2); // Añade un cero si es necesario y toma los últimos dos dígitos
    var mes = ('0' + (hoy.getMonth() + 1)).slice(-2); // Los meses van de 0 a 11, por lo que se suma 1
    var ano = hoy.getFullYear();
    var fechaHoy = `${ano}-${mes}-${dia}`; // Formato necesario para inputs de tipo 'date'
    fechaInput.value = fechaHoy;
});