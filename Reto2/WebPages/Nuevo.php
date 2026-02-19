<?php
session_start();
require_once("PHP/sessions.php");

if (getSeguridad() == null) {
    header("Location: Login.php");
    exit();
}

?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script>

        async function obtenerDatos(e) {

            e.preventDefault();
            document.getElementById("error").style.display = 'none';
            document.getElementById("error").innerText = "";

            try {
                const respuesta = await fetch(
                'http://localhost:8080/Reto2/noticia', {
                    body: JSON.stringify({
                        titular: document.getElementById('titular').value,
                        texto: document.getElementById('texto').value,
                        fecha: document.getElementById('fecha').value,
                    }),
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8',
                        'x-seguridad': '<?php echo getSeguridad(); ?>'
                    }
                });
                
                // Validar si la petición fue exitosa (status 200-299)
                if (!respuesta.ok) {
                    throw new Error(`Error en la red: ${respuesta.status}`);
                    document.getElementById("error").style.display = 'block';
                    document.getElementById("error").innerText = "Error al guardar la noticia ("+${respuesta.status}+")";

                } else {
                    document.location.href = 'Listado.php';
                }

            } catch (error) {
                console.error('Hubo un problema con la petición:', error);
            }
        }

    </script>

</head>
<body class="container px-5 d-flex vh-100 justify-content-center align-items-center" style="background-color: gainsboro;">
    <div style="background-color: #f0f0f0; width: 500px; border-radius: 10px; border: 1px gray solid;" class="px-4 py-3 mt-3">
        <h3 id="nombre">aaaaaaaaaaaaa</h3>
        <form action="" method="post">
            <div id="error" class="alert alert-danger mt-3" style="display: none;"></div>
            <div class="form-group row">
                <label for="titular">Titular</label>
                <input type="text" name="titular" id="titular" class="form-control" placeholder="Titular...">
            </div>
            <div class="form-group row mt-2">
                <label for="texto">Texto</label>
                <textarea name="texto" id="texto" class="form-control" placeholder="Cuerpo de la noticia..."></textarea>
            </div>
            <div class="form-group row mt-2">
                <label for="fecha">Fecha</label>
                <input type="date" name="fecha" id="fecha" class="form-control">
            </div>
            <div class="form-group row mt-2">
                <input type="submit" value="Guardar" class="btn btn-primary col-sm-2">
                <input type="button" value="Volver" id="btnVolver" class="btn btn-secondary col-sm-2 mx-2">
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
