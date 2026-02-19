<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-5">
    <h3 id="nombre"></h3>
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
            <?php
                for ($i=0; $i < 20; $i++) { 
                    echo '<tr class="table-primary">
                            <td class="text-danger">2024-06-01</td>
                            <td>Juan Pérez</td>
                            <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
                            <td>
                                <a href="#" class="btn btn-sm btn-primary p-1 d-flex align-items-center justify-content-center">
                                    <img src="./images/ic_delete.png" alt="borrar" class="d-block" style="width: 25px">
                                </a>
                            </td>
                        </tr>';
                }
            ?>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
