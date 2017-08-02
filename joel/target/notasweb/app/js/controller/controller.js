/**
 * Created by Alumno on 20/05/2017.
 */

var controlador = app.controller('micontrolador',function($scope,$http){
    $scope.codigo = null;
    $scope.clave = null;
    $scope.nombre = null;
    $scope.apellidoPaterno = null;
    $scope.apellidoMaterno = null;
    $scope.cicloRelativo = null;
    $scope.especialidad = null;
    $scope.mensaje = null;
    $scope.pagina = 1;
    $scope.alumnos = null;
    $scope.config = {
        headers : {
            'Content-Type': 'application/json;charset=utf-8;'
        }
    };
    $scope.validarUsuario = function () {

        var data  = {
            "codigo" : $scope.codigo,
            "clave" : $scope.clave
        };


        var res = $http.post('/validarUsuario', data, $scope.config);
        res.then(function (response) {
            var respuesta = response.data;
            if(respuesta.codigo == null && respuesta.codigo == ""){
                $scope.mensaje = 'No ingreso';
            }
            if( respuesta.codigo != ""){
                $scope.mostrarAlumnos();
                $scope.pagina = 2;
            }
        });
    };
    $scope.mostrarAlumnos = function () {

        var data  = {
        };



        var res = $http.post('/mostrarAlumnos', data, $scope.config);
        res.then(function (response) {
            var respuesta = response.data;
            $scope.alumnos = respuesta.lista;
        });
    };
    $scope.pagRegistro = function () {
        $scope.pagina = 3;
    }
    $scope.pagLogeo = function () {
        $scope.pagina = 1;
    }
    $scope.registrarUsuario = function () {

        var data  = {
            "nombres" : $scope.nombre,
            "paterno" : $scope.apellidoPaterno,
            "materno" : $scope.apellidoMaterno,
            "cicloRelativo" : $scope.cicloRelativo,
            "especialidad" : $scope.especialidad,
            "codigo" : $scope.codigo,
            "clave" : $scope.clave
        };


        var res = $http.post('/registrarUsuario', data, $scope.config);
        res.then(function (response) {
            var respuesta = response.data;
            if(respuesta.codigo == $scope.codigo && respuesta.clave == $scope.clave){
                $scope.pagina = 1 ;
                $scope.codigo = null;
                $scope.clave = null;
            }
        });
    };
});