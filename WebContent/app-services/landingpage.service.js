(function () {
    'use strict';

    angular
        .module('app')
        .factory('LandingService', LandingService);

    LandingService.$inject = ['$timeout', '$filter', '$q', '$http'];
    function LandingService($timeout, $filter, $q, $http) {
        var service = {};

        //service.GetAll = GetAll;
       // service.GetById = GetById;
       // service.GetByUsername = GetByUsername;
       // service.Create = Create;
       // service.Update = Update;
        //service.Delete = Delete;
        service.GetTopUsers = GetTopUsers;
        service.FeaturedStory = FeaturedStory;

        return service;
        
        function FeaturedStory() {
            var deferred = $q.defer();

            $timeout(function () {
            	GetFeaturedStory()
                    .then(function (response) {
                    	
                    	if(response.length > 0) {
                    		
                    		deferred.resolve({ success: true, story: response });
                    		
                    		
                    		/* if (response.data === 'success') {
                             	alert('save');
                             	//save user to the DB
                             	$http.post('http://localhost:8080/AngularLoginSample/rest/api/register', { username: user.username, password: user.password, firstname: user.firstName, lastname: user.lastName })
                                 .success(function (response) {
                                 	
                                 	deferred.resolve({ success: true });
                                 });
                             	
                             	
                                
                             } else {

                             	 deferred.resolve({ success: false, message: response.data });
                             }*/
                    	}
                       
                    });
            }, 1000);

            return deferred.promise;
        }
        
        
        /*function GetAll() {
            return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get('/api/users/' + username).then(handleSuccess, handleError('Error getting user by username'));
        }

        function Create(user) {
            return $http.post('/api/users', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + user.id).then(handleSuccess, handleError('Error deleting user'));
        }*/
        
        function GetTopUsers() {
        	return $http.get('http://localhost:8080/AngularLoginSample/rest/api/landingpage/getTopUsers/5').then(handleSuccess, handleError('Error deleting user'));
        }
        
        function GetFeaturedStory() {
        	return $http.get('http://localhost:8080/AngularLoginSample/rest/api/landingpage/getFeaturedStory').then(handleSuccess, handleError('Error retrieving featured story'));
        }
        
        // private functions

        function handleSuccess(data) {
        	
        	//console.log(data.data);
            
        	return data.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();