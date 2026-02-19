<?php
    function setSession($codigoSeguridad, $nombre) {
        session_start();
        $_SESSION['seguridad'] = $codigoSeguridad;
        $_SESSION['nombre'] = $nombre;
    }

    function getSeguridad() {
        session_start();
        return $_SESSION['seguridad'] ?? null;
    }

    function getNombre() {
        session_start();
        return $_SESSION['nombre'] ?? null;
    }
?>