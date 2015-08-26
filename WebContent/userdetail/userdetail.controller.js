(function () {
    'use strict';

    angular
        .module('app')
        .controller('UserDetailController', UserDetailController);

    UserDetailController.$inject = ['UserService', '$rootScope', '$routeParams', '$scope'];
    function UserDetailController(UserService, $rootScope, $routeParams, $scope) {
        
    	 var vm = this;
    	 $scope.username = $routeParams.username;
    	 //alert($scope.username);
         vm.userDetail ='';

         initController();

         function initController() {
             
        	 loadUserDetail();
         }

         function loadUserDetail() {
        	 UserService.GetUserDetail($scope.username)
                 .then(function (response) {
                	 
                	 if(response.success=true) {
                		 
                		 //console.log(response);
                         vm.userDetail = response.message[0];
                         //console.log(response.message[0]);
                	 }
                	 
                 });
         }
         
    }

})();