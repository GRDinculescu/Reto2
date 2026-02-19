<?php
session_start();
require_once("PHP/Session.php");

setSession($_REQUEST["seguridad"], $_REQUEST["nombre"]);

?>