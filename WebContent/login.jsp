<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<html>
<head>
<jsp:include page="HTML/Header.jsp"></jsp:include>


<!-- Custom styles for this template -->
<link href="HTML/css/login.css" rel="stylesheet">

<title>Login</title>
</head>

<body>

	<%
		if (request.getAttribute("error") != null) {
	%>
			<div class="alert alert-danger"><strong>Danger!</strong><% out.println(request.getAttribute("error")); %></div>
	<%
		}
	%>


	<div class="container" id="login">
		<div>
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Sign in</h1>
				<div class="account-wall">
					<img class="profile-img"
						src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
						alt="">
					<form class="form-signin" ACTION="login" id="Loginform" name="Loginform" method="POST">
						<div class="form-group">
							<input class="form-control" type="text" name="UserName" requiredautofocus id="UserName" placeholder="Enter UserName">
						</div>
						<div class="form-group">
							<input class="form-control" type="password" name="Password"id="Password" placeholder="Enter Password">
						</div>

						<button class="btn btn-lg btn-primary btn-block"name="loginbutton" id="loginbutton" value="Login" type="submit">
							Sign in</button>
					</form>
				</div>

				<br>

			</div>
		</div>
	</div>
</body>
</html>