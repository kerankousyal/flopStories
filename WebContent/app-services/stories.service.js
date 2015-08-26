(function () {
    'use strict';

    angular
        .module('app')
        .factory('StoryService', StoryService);

    StoryService.$inject = ['$timeout', '$filter', '$q', '$http'];
    
    function StoryService($timeout, $filter, $q, $http) {

        var service = {};

        service.saveStory = saveStory;
        
        service.GetAllStories = GetAllStories;
        
        service.GetStoryDetail = GetStoryDetail;
        
        service.saveComments = saveComments;

        return service;
        
        function GetAllStories() {
        	
        	 return $http.get('http://localhost:8080/AngularLoginSample/rest/api/stories/getallstories').then(handleSuccess, handleError('Error getting stories list'));
        }
        
        function GetStory(_id) {
        	
        	return $http.get('http://localhost:8080/AngularLoginSample/rest/api/stories/getstorydetail/'+_id).then(handleSuccess, handleError('Error getting story'));
       }
        
        function GetStoryDetail(_id) {
            var deferred = $q.defer();

            // simulate api call with $timeout
            $timeout(function () {
            	GetStory(_id)
                    .then(function (response) {
                        
                    	//console.log(response);
	                    	if(response.status === '200') {
	                    		
			                   			 deferred.resolve({ success: true, message: response.data });
			                               
			                   	}
	                    	else {
	                    		
                           	 	deferred.resolve({ success: false, message: response.data });
	                    	}
                    	
                    });
            }, 1000);

            return deferred.promise;
        }

        function saveStory(user,story) {
            var deferred = $q.defer();

            $timeout(function () {
            	Save(user.username,story)
                    .then(function (response) {

                    	if(response.status === 200) {
                    		
                    		 if (response.data === 'success') {
                             	
                    			 deferred.resolve({ success: true, message: response.data });
                                
                             } else {
                            	 console.log(story);
                             	 deferred.resolve({ success: false, message: response.data });
                             }
                    	}
                       
                    });
            }, 1000);

            return deferred.promise;
        }
        
        function Save(username,story) {
        	
            return $http.post('http://localhost:8080/AngularLoginSample/rest/api/stories/savestory', { storyName: story.storyName, shortDescription: story.storyDesc, storyContent: story.message, ownerName: username ,category : story.storySubCat}).then(handleSuccess, handleError('Error saving story'));
         }
        
        function saveComments(storyid, commentDetail) {
            var deferred = $q.defer();

            $timeout(function () {
            	saveComment(storyid, commentDetail)
                    .then(function (response) {

                    	if(response.status === 200) {
                    		
                    		 if (response.data === 'success') {
                             	
                    			 //alert('comments saved -- service');
                    			 deferred.resolve({ success: true, message: response.data });
                                
                             } else {
                            	 
                             	 deferred.resolve({ success: false, message: response.data });
                             }
                    	}
                       
                    });
            }, 1000);

            return deferred.promise;
        }
        
        function saveComment(storyid, commentDetail) {
        	
            return $http.post('http://localhost:8080/AngularLoginSample/rest/api/stories/savecomments',{ _id : storyid, comments : [{  comments : commentDetail.comments, commentedUser : commentDetail.username }]} ).then(handleSuccess, handleError('Error saving comment'));
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