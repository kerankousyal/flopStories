(function () {
    'use strict';

    angular
        .module('app')
        .controller('StoryListController', StoryListController);

    StoryListController.$inject = ['StoryService', '$rootScope'];
    function StoryListController(StoryService, $rootScope) {
        
    	 var vm = this;
         vm.storyList ='';

         initController();

         function initController() {
             
        	 loadAllStories();
         }

         function loadAllStories() {
        	 StoryService.GetAllStories()
                 .then(function (stories) {
                	 
                     vm.storyList = stories.data;
                     console.log(stories);
                 });
         }
         
    }

})();