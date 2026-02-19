<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container-fluid d-flex vh-100 justify-content-center align-items-center px-5" style="background-color: gainsboro;">
    <div style="background-color: #f0f0f0; width: 500px; border-radius: 10px; border: 1px gray solid;" class="px-4 py-3 mt-3">
        <h3 id="nombre">Login</h3>
        <form action="" method="post">
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
