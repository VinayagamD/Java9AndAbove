
app.factory("http_service",[
    '$http',
    '$q',
    '$location',
    '$log',
    '$parse',
    '$rootScope',
    '$window'
    , function ($http, $q, $location, $log, $parse, $rootScope, $window) {
    const baseUrl = "http://localhost:8080/SchoolManagementApp_war/";
    return {

      postRequest: function(url, callback, data){
          return $http.post(baseUrl+url, data).then(function(response){
           callback(response.data)
          }, function(errorResponse){
              console.log(errorResponse);
          });
      }  ,
        getRequest: function (url, callback) {
            return $http.get(baseUrl+url).then(function(response){
                callback(response.data)
            }, function(errorResponse){
                console.log(errorResponse);
            });
        }
    };

}]);