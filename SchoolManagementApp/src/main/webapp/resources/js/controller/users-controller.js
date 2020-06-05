app.controller('users-controller',[
    '$scope',
    'http_service',

    function ($scope, http_service) {
        $scope.model = {};
        $scope.name = "";

        $scope.init_students = function () {
          http_service.getRequest('users?source=students', function (response) {
            $scope.model.students = response.data;
          });
        };

        $scope.init_teachers = function(){
            http_service.getRequest('users?source=teachers', function (response) {
                $scope.model.teachers = response.data;
            });
        };

        $scope.init_student = function (id) {
            http_service.getRequest('users?source=students&id='+id, function (response) {
                $scope.model.student = response.data;
            });

        }
    }
]);