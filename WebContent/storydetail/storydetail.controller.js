(function () {
    'use strict';

    angular
        .module('app')
        .controller('StoryDetailController', StoryDetailController);

    StoryDetailController.$inject = ['StoryService', '$rootScope', '$routeParams', '$scope', 'FlashService'];
    function StoryDetailController(StoryService, $rootScope, $routeParams, $scope, FlashService) {
        
    	 var vm = this;
    	 $scope._id = $routeParams._id;
    	 //alert($scope._id);
         vm.storyDetail ='';
         vm.storyDetail.comments='';
        

         initController();

         function initController() {
             
        	 loadStoryDetail();
         }

         function loadStoryDetail() {
        	 StoryService.GetStoryDetail($scope._id)
                 .then(function (response) {
                	 
                	 if(response.success=true) {
                		 
                		 //console.log(response.message[0]);
                		 
                		 vm.storyDetail = response.message[0];
                         //console.log(response.message[0]);
                	 }
                     
                 });
         }
         
        $scope.submitComments = function submitComments() {
         	
         	
         	//if logged in user set his username here
         	
         	var commentDetail='';
         	
         	
         	StoryService.saveComments(vm.storyDetail._id.$oid, vm.commentDetail)
         	.then(function(response){
         		
         		// console.log(response);
         		 
         		if(response.success=true) {
           		 
         			FlashService.Success('Comment Saved', true);
           		 
           	 } else {
           		 
           		 FlashService.Error('Comment Save failed..try after sometime..');
           	 }
         		
         	});
         	
         };
         
    }
    

})();