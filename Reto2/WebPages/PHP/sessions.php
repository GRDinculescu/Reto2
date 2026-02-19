<?php
    function setSession($codigoSeguridad, $nombre) {
        $_SESSION['seguridad'] = $codigoSeguridad;
        $_SESSION['nombre'] = $nombre;
    }

    function clearSession() {
        session_start();
        session_unset();
        session_destroy();
    }

    function getSeguridad() {
        return $_SESSION['seguridad'] ?? null;
    }

    function getNombre() {
        return $_SESSION['nombre'] ?? null;
    }
?>