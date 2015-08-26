(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService', '$rootScope'];
    function LoginController($location, AuthenticationService, FlashService, $rootScope) {
        var vm = this;

        vm.login = login;
       
        //reset loggedin user to false
       $rootScope.isLoggedInUser = false;
        
        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                if (response.success) {
                	
                	 //FlashService.Success('Login successful', true);
                    //AuthenticationService.SetCredentials(vm.username, vm.password);
                    
                    // set loggedin user to true here..
                    $rootScope.isLoggedInUser = true;
                    
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();
