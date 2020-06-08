app.controller('users-controller',[
    '$scope',
    'http_service',

    function ($scope, http_service) {
        $scope.model = {};
        $scope.name = "";
        $scope.model.selected = {};

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

        $scope.init_add_students = function(){
            $scope.model.student = {};
            $scope.model.selected = $scope.model.genders[0];
        }

        $scope.saveStudent = function($event) {
            $event.preventDefault();
            $scope.model.student.gender = $scope.model.selected.key;
            http_service.postRequest("users", function (response) {
                console.log(response);
            }, $scope.model.student);

        }

        $scope.init_student = function (id) {
            http_service.getRequest('users?source=students&id='+id, function (response) {
                $scope.model.student = response.data;
            });

        }

        $scope.model.genders = [
            {
                key: 'MALE',
                value: 'Male'
            },
            {
                key: 'FEMALE',
                value: 'Female'
            },
            {
                key: 'OTHERS',
                value: 'Others'
            }

        ];
    }
]);