<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" ng-app="userApp">
<head>
<meta charset="utf-8">
<title>My HTML File</title>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.20/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>
<!-- <script type="text/javascript" src="<c:url value='/bower_components/restangular/dist/restangular.js'/>"></script> -->
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.4.4/underscore-min.js"></script>
<script type="text/javascript" src="http://cdn.jsdelivr.net/restangular/latest/restangular.js"></script>
<script type="text/javascript" src="http://cdn.jsdelivr.net/restangular/latest/restangular.min.js"></script>
<script type="text/javascript" src="<c:url value="/js/indexangular.js"/>" ></script>
</head>
<body ng-controller="UsersCtrl">
    
    
    <form action="user" method="post">
        name: <input name="name" type="text"> <br>
        age: <input name="age" type="text"> <br>
        <input type="submit" value="submit">
    </form>
    
    the user name is {{username}}

</body>
</html>