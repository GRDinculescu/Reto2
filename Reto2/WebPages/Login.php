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
                'http://localhost:8080/Reto2/login', {
                    body: JSON.stringify({
                        codigo: document.getElementById('codigo').value,
                        pwd: document.getElementById('contraseña').value,
                    }),
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8'
                    }
                }
                ).then(
                    res => res.json()
                ).then( data => {
                    if(data.nombre != null){
                        fetch('http://localhost/saveSession?nombre='+data.nombre+'&seguridad='+data.seguridad)
                        .then(
                            document.location.href = 'Listado.php'
                        )
                    } else {
                        document.getElementById("error").style.display = 'block';
                        document.getElementById("error").innerText = "Usuario o contraseña incorrectos";
                    }
                });
            } catch (error) {
                console.error('Hubo un problema con la petición:', error);
            }
        }
    </script>
</head>
<body class="container-fluid d-flex vh-100 justify-content-center align-items-center px-5" style="background-color: gainsboro;">
    <div style="background-color: #f0f0f0; width: 500px; border-radius: 10px; border: 1px gray solid;" class="px-4 py-3 mt-3">
        <h3 id="nombre">Login</h3>
        <form method="post" onsubmit="obtenerDatos(event);">
            <div id="error" class="alert alert-danger mt-3" style="display: none;"></div>
            <div class="form-group row">
                <label for="codigo">Titular</label>
                <input type="text" name="codigo" id="codigo" class="form-control" placeholder="Codigo...">
            </div>
            <div class="form-group row mt-2">
                <label for="Contraseña">Contraseña</label>
                <input type="password" name="contraseña" id="contraseña" class="form-control" placeholder="Contraseña...">
            </div>
            <div class="form-group row mt-2">
                <input type="submit" value="Entrar" class="btn btn-secondary col-sm-2">
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
