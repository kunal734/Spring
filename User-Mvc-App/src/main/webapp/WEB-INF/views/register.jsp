<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.hero {
	border: 2px;
	text-align: center;
	background-color: yellow;
}

.hero h1 {
	color: red;
}

#button {
	background-color: green;
	padding: 10px 30px;
	border-radius: 5px;
	color: white;
	border: none;
	text-align: center;
}

#button:hover {
	background-color: Red;
}
</style>

</head>
<body>
	<div class="hero">
	<h1>Details for Registration</h1>
		<form:form modelAttribute="u" action="register">
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<br><br>
			<form:label path="phone">Phone Number</form:label>
			<form:input path="phone" />
			<br><br>
			<form:label path="gender">Gender</form:label>
			<form:radiobutton path="gender" value="Male" />Male
			<form:radiobutton path="gender" value="Female" />Female
			<br><br>
			<form:label path="age">Age</form:label>
			<form:input path="age" />
			<br><br>
			<form:label path="email">Email</form:label>
			<form:input path="email" />
			<br><br>
			<form:label path="password">Password</form:label>
			<form:password path="password" />
			<br><br>
			<form:button id="button">REGISTER</form:button>
		</form:form>
	</div>
</body>
</html>