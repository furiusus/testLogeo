/**
 * Created by furiusus on 6/29/17.
 */
var controlador = app.controller('MyController',function ($scope,$http) {
    $scope.idUsuario=null;
    $scope.passUsuario=null;
    $scope.mensaje=null;
    $scope.usuarios=null;
    $scope.pagina=1;
    $scope.config = {
        headers : {
            'Content-Type': 'application/json;charset=utf-8;'
        }
    };
    $scope.validarUsuario=function () {
        var data={
            "usuario" : $scope.idUsuario,
            "pass" : $scope.passUsuario 
        };
        var res=$http.post('/validarUsuario',data,$scope.config);
        res.then(function (response) {
            var respuesta=response.data;
            if(respuesta.idUsuario===null && respuesta.passUsuario===null){
                $scope.mensaje='No existe dicha cuenta'
            }
            if(respuesta.idUsuario!==null){
                $scope.mostrarListaUsuario();
                $scope.pagina=2;
                $scope.mensaje='Ingresa'
            }
        });
    };
    $scope.mostrarListaUsuario=function () {
        var data={
        };
        var res=$http.post('/mostrarListaUsuario',data,$scope.config);
        res.then(function (response) {
            var respuesta = response.data;
            $scope.usuarios=respuesta.lista;
        });
    }

});