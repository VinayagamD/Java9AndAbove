app.controller('students-controller',[
    '$scope',
    'http_service',

    function ($scope, http_service) {
        $scope.model = {};
        $scope.name = "";

        $scope.init_students = function () {
          http_service.getRequest('students?page=students', function (response) {
            $scope.model.students = response.data;
          });
        };
    }
]);