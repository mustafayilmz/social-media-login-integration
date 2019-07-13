<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Facebook - Login</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/social-buttons.css"/>" rel="stylesheet">
</head>
<body style="background-color: #fff; padding-top: 20px;">
<div class="container">
    <div class="jumbotron text-center">
        <h2>Login with Facebook using Java</h2>
        <div class="text-center">
            <div><a
                    href="${facebookLoginUri}"
                    class="btn btn-lg btn-social btn-facebook"> <i
                    class="fa fa-facebook"></i> Sign in with Facebook
            </a></div>
        </div>
    </div>
</div>
</body>
</html>