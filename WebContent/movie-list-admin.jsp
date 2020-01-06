<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<html>
<head>
<title>Movies List</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png"> <a id="movie" href="ShowMovieListAdmin">Movies</a>
	</header>

	<div class="count">
		<h2>Movies</h2>
		<table>
			<tr>
				<th class="left">Title</label></th>
				<th class="rite">Gross</label></th>
				<th class="cent">Active</label></th>
				<th class="cent">Date of launch</label></th>
				<th class="cent">Gence</label></th>
				<th class="cent">Teaser</label></th>
				<th class="cent">Action</label></th>
			</tr>

			<c:forEach items="${movieItemList}" var="movie">
				<tr>
					<td class="left">${movie.title}</td>
					<td class="rite">${movie.gross}</td>
					<td class="cent"><c:if test="${movie.active}">Yes</c:if> <c:if
							test="${!movie.active}">No</c:if></td>
					<td class="cent"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateOfLaunch}" /></td>
					<td class=cent">${movie.gence}</td>
					<td class="cent"><c:if test="${movie.hasTeaser}">Yes</c:if> <c:if
							test="${!movie.hasTeaser}">No</c:if></td>
					<td class="cent"><a
						href="ShowEditMovie?movieItemId=${movie.id}" target="_blank">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>



