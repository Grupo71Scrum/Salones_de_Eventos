var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getSalones(false, "ASC");

        $("#ordenar-categoria").click(ordenarSalones);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getSalones(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletSalonesListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarSalones(parsedResult);
                console.log("Estoy en el if que ejecuta mostrar salones");
            } else {
                console.log("Error recuperando los datos de los salones");
            }
        }
    });
}
function mostrarSalones(salones) {

    let contenido = "";

    $.each(salones, function (index, salon) {

        salon = JSON.parse(salon);
        let precio;

        if (salon.bandera > 0) {

            if (user.premium) {

                if (salon.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (salon.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + salon.id + '</th>' +
                    '<td>' + salon.nombre + '</td>' +
                    '<td>' + salon.categoria + '</td>' +
                    '<td>' + salon.capacidad + '</td>' +
                    '<td>' + salon.bandera + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + salon.id + '" disabled ';
            if (salon.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarPelicula(' + salon.id + ',' + precio + ');" class="btn btn-success" ';
            if (user.saldo < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'

        }
    });
    $("#salones-tbody").html(contenido);
}




