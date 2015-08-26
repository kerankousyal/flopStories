(function () {
    'use strict';

    angular
        .module('app')
        .controller('LandingPageController', LandingPageController);

    LandingPageController.$inject = ['LandingService', '$rootScope'];
    function LandingPageController(LandingService, $rootScope) {
        
    	 var vm = this;
         vm.allTopUsers ='';
         vm.featuredStory ='';

         initController();

         function initController() {
             loadTopUsers();
             loadFeaturedStory();
         }

         function loadTopUsers() {
        	 LandingService.GetTopUsers()
                 .then(function (users) {
                     vm.allTopUsers = users;
                     console.log(users);
                 });
         }
         
         function loadFeaturedStory() {
        	 LandingService.FeaturedStory()
                 .then(function (response) {
                	 if (response.success) {
                         
                		 vm.featuredStory = response.story[0];
                     } else {
                    	 
                    	 console.log('get featured story failed!');
                     }
                	 
                 });
         }


    }

})();