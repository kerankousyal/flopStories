(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['AuthenticationService','StoryService', '$rootScope', 'FlashService',  '$location'];
    function HomeController(AuthenticationService,StoryService, $rootScope, FlashService,  $location) {
        var vm = this;

        vm.user = null;
        
        vm.story = null;
        
        
        console.log($rootScope.globals.currentUser);
        vm.user=$rootScope.globals.currentUser;
        initController();

        function initController() {
            loadCurrentUser();
        }

        function loadCurrentUser() {
        	
        }
        
               
        $rootScope.submit = function(){
        	vm.dataLoading = true;
        	StoryService.saveStory(vm.user,vm.story)
            .then(function (response) {
                if (response.success) {
                    FlashService.Success('Story Saved successful', true);
                    vm.dataLoading = false;
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };

    }

})();