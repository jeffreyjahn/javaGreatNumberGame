<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.lang.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Great Number Game!!</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id="wrapper">
		<h2>Welcome to the Great Number Game</h2>
		<p>I am thinking of a number between 1 and 100</p>
		<p>Take a guess!</p>
		<c:choose>
			<c:when test = "${result.equals('correct') }" >
				<div id="answer" class="right">
					<h3><c:out value="${ answer }"/> was the answer!</h3>
				
				<form action="gng" method="Post">
					<input type="hidden" name="reset" value="reset">
					<input type="submit" value="Play again">
				</form>
				</div>
			</c:when>
			<c:otherwise>
				<div id="answer" class="wrong">
					<c:choose>
						<c:when test ="${result.equals('lower') }">
							<h3>Too low!</h3>
						</c:when>
						<c:when test = "${result.equals('higher') }">
							<h3>Too high!!!</h3>
						</c:when>
					</c:choose>
				</div>
			</c:otherwise>
		</c:choose>
		<c:if test ="${ result != 'correct' }">
			<form action="gng" method="Post">
				<input type="number" name="guess">
				<input type="submit" value="Submit">
			</form>
	
			<form action="gng" method="Post">
				<input type="hidden" name="reset" value="reset">
				<input type="submit" value="Reset">
			</form>
		</c:if>
	</div>
</body>
</html>