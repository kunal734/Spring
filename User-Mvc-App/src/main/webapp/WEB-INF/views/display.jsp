<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>User Id: ${u.getId() }</h2>
	<h2>User Name: ${u.getName()}</h2>
	<h2>User Phone: ${u.getPhone() }</h2>
	<h2>User Gender: ${u.getGender() }</h2>
	<h2>User Age: ${u.getAge() }</h2>
	<h2>User Email: ${u.getEmail() }</h2>
	<h2>User Password: ${u.getPassword() }</h2>
</body>
</html>