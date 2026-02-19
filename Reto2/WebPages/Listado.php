<?php
    session_start();
    include_once './PHP/sessions.php';
    $codigoSeguridad = getSeguridad();
    $nombre = getNombre();
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-5">
    <h3 id="nombre">Listado de noticias de <?= $nombre ?></h3>
    <form action="" method="post" >
        <div class="d-flex mt-2 gap-2">
            <input type="text" name="txtBuscar" id="txtBuscar" class="form-control w-25">
            <a href="#" class="btn btn-primary p-1 d-flex align-items-center justify-content-center">
                <img src="./images/ic_search.png" alt="" class="d-block" style="width: 32px">
            </a>
            <a href="./nuevo.php" class="btn btn-primary ms-auto">Nuevo</a>
        </div>

    </form>
    <table class="table table-striped table-hover mt-3">
        <thead>
            <tr>
                <th style="width: 15%;">Fecha</th>
                <th style="width: 25%;">Titular</th>
                <th>Texto</th>
                <th style="width: 5%;"></th>
            </tr>
        </thead>
        <tbody id="tablaDatos">
            <script>
                fetch("http://localhost:8080/Reto2/noticias", {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        "x-seguridad": '10db0cf8-0151-4045-baae-85004406664e'
                    }
                }).then(response => response.json())
                .then(data => {
                    if (data.length === 0) {
                        const tabla = document.getElementById("tablaDatos");
                        const fila = document.createElement("tr");
                        fila.innerHTML = `
                            <td colspan="4" class="text-center">No hay noticias disponibles</td>
                        `;
                        tabla.appendChild(fila);
                        return;
                    }
                    const tabla = document.getElementById("tablaDatos");
                    data.forEach(noticia => {
                        const fila = document.createElement("tr");
                        fila.innerHTML = `
                            <td>${noticia.fecha}</td>
                            <td>${noticia.titular}</td>
                            <td>${noticia.texto}</td>
                            <td>
                                <a id="btnBorrar${noticia.id}" href="#" class="btn btn-sm btn-primary p-1 d-flex align-items-center justify-content-center">
                                    <img src="./images/ic_delete.png" alt="borrar" class="d-block" style="width: 25px">
                                </a>
                            </td>
                        `;
                        tabla.appendChild(fila);
                    })
                })
            </script>
        </tbody>
    </table>
    <script src="./JS/noticias.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
