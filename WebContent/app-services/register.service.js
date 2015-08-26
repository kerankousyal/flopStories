(function () {
    'use strict';

    angular
        .module('app')
        .factory('RegisterService', RegisterService);

    RegisterService.$inject = ['$timeout', '$filter', '$q', '$http'];
    
    function RegisterService($timeout, $filter, $q, $http) {

        var service = {};

        service.GetByUsername = GetByUsername;
        service.Create = Create;

        return service;


        function GetByUsername(username) {
           return $http.get('http://localhost:8080/AngularLoginSample/rest/api/duplicateuser/' + username).then(handleSuccess, handleError('Error getting user by username'));
            
        }

        function Create(user) {
            var deferred = $q.defer();

            $timeout(function () {
                GetByUsername(user.username)
                    .then(function (response) {
                    	console.log(response);
                    	if(response.status === 200) {
                    		
                    		 if (response.data === 'success') {
                             	alert('save');
                             	//save user to the DB
                             	$http.post('http://localhost:8080/AngularLoginSample/rest/api/register', { username: user.username, password: user.password, firstname: user.firstName, lastname: user.lastName ,email: user.email })
                                 .success(function (response) {
                                 	
                                 	deferred.resolve({ success: true });
                                 });
                             	
                             	
                                
                             } else {

                             	 deferred.resolve({ success: false, message: response.data });
                             }
                    	}
                       
                    });
            }, 1000);

            return deferred.promise;
        }
        

        // private functions
        function handleSuccess(data) {
            return data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }

    }
})();