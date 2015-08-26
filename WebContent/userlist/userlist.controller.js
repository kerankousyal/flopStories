(function () {
    'use strict';

    angular
        .module('app')
        .controller('UserListController', UserListController);

    UserListController.$inject = ['UserService', '$rootScope'];
    function UserListController(UserService, $rootScope) {
        
    	 var vm = this;
         vm.userList ='';

         initController();

         function initController() {
             
        	 loadAllUsers();
         }

         function loadAllUsers() {
        	 UserService.GetAll()
                 .then(function (users) {
                	 
                     vm.userList = users;
                     console.log(users);
                 });
         }
         
    }

})();