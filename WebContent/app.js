(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies', 'ngQuill', 'ui.bootstrap'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'home/home.view.html',
                controllerAs: 'vm'
            })

            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
            })

            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })
            
            .when('/commonhome', {
                controller: 'LandingPageController',
                templateUrl: 'landingpage/landingPage.view.html',
                controllerAs: 'vm'
            })
            
            .when('/storylist', {
                controller: 'StoryListController',
                templateUrl: 'storylist/storylist.view.html',
                controllerAs: 'vm'
            })
            
            .when('/userlist', {
                controller: 'UserListController',
                templateUrl: 'userlist/userlist.view.html',
                controllerAs: 'vm'
            })
            
            .when('/userlist/:username', {
                controller: 'UserDetailController',
                templateUrl: 'userdetail/userdetail.view.html',
                controllerAs: 'vm'
            })
            
            .when('/storylist/:_id', {
                controller: 'StoryDetailController',
                templateUrl: 'storydetail/storydetail.view.html',
                controllerAs: 'vm'
            })
            
            .otherwise({ redirectTo: '/commonhome' });
    }

    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        
    	//set loggedinuser
    	$rootScope.isLoggedInUser = false;
    	// keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
        	
        	//alert($location.path());
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register', '/commonhome', '/storylist', '/userlist', '/userlist/', '/storylist']) === -1;
            
           if($location.path().indexOf('/userlist/')!= -1 || $location.path().indexOf('/storylist/')!= -1) {
        	   
        	 restrictedPage=false;
           }
            	
            var loggedIn = $rootScope.globals.currentUser;
            
            if($location.path()=='') {
            	
            	$location.path('/commonhome');
            }else {
            	
            	if (restrictedPage && !loggedIn) {
                 	
                    $location.path('/login');
                 }
            }
            	 
           
        });
    }
  
    

})();