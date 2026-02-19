<?php
session_start();
require_once("PHP/sessions.php");

setSession($_REQUEST["seguridad"], $_REQUEST["nombre"]);

?>