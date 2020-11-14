<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="HTML/Header.jsp"></jsp:include>
	<title>User Registration</title>

	<script>
	        function validateForm() {
	            var x = document.forms["RegisterForm"]["FirstName"].value;
	            if (x == null || x == "") {
	                alert("Name must be filled out");
	                return false;
	            }
	        }

	       function submitForm(event){
	           event.preventDefault();
	       }

	 </script>

</head>
<body>

	<%
		if (request.getAttribute("error") != null) {
	%>
			<div class="alert alert-danger"><strong>Danger!</strong><% out.println(request.getAttribute("error")); %></div>
	<%
		}
	%>

                <div class="container">

 				<a href="../JavaWebDemo" class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span> Back</a>

                    <h2>UserRegistration</h2>

                    <form class="form-horizontal" role="form" action="UserRegistration" id="RegisterForm" onsubmit=" onsubmit="submitForm(event)" name="RegisterForm" method="POST">


                        <div class="form-group">
                            <label for="firstName" class="col-sm-3 control-label">Full Name</label>
                            <div class="col-sm-9">
                                <input type="text" name="FName" id="FirstName" placeholder="First Name" class="form-control" autofocus>
                                <span class="help-block"> First Name</span>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="firstName" class="col-sm-3 control-label">Full Name</label>
                            <div class="col-sm-9">
                                <input type="text" name="LName" id="LastName" placeholder="Last Name" class="form-control" autofocus>
                                <span class="help-block">Last Name</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>
                            <div class="col-sm-9">
                                <input type="email" id="email" name="Email" placeholder="Email" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
                            <div class="col-sm-9">
                                <input type="date" id="birthDate" name="BirthDay" class="form-control">
                            </div>
                        </div>

                    
                        <div class="form-group">
                            <label for="username" class="col-sm-3 control-label">UserName</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" placeholder="UserName" name="UserName" id="UserName">
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">Password</label>
                            <div class="col-sm-9">
                                <input type="password" name="Password" id="password" placeholder="Password" class="form-control">
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-3">
                                <button name="RegisterButton" class="btn btn-primary btn-block" type="submit" id="RegisterButton" value="Submit">Register</button>
                            </div>
                        </div>

                        <input type="hidden" name="RegisterForm" value="reg">
                    </form>
                </div>

</body>
</html>