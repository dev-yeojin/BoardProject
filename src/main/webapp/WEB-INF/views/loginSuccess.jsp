<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
</head>
<body>
${msg}
<button onclick="location.href='/member/update'">회원정보 수정</button>
<button onclick="location.href='/logout'">로그아웃</button>
<button onclick="location.href='/member/memberList'">회원정보 보기</button>
</body>
</html>