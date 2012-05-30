<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tribus register</title>
</head>
<body>
<form aciton="http://localhost:8080/tribus_spring/user/registerAction.action" method="POST">
name:
<input type="text" name="name" value="">
<input type="text" name="name" value="">
<input type="text" name="name" value="">
--${error.message}--
email:
<input type="text" name="email" value="">
pwd:
<input type="text" name="pwd" value="">

<input type="submit" name="submit"  value="submit"/>
</form>
</body>
</html>