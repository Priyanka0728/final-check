<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Movies List</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png"> <a id="favorite" href="ShowFavorites">Favorite</a>
	<a id="movie" href="ShowMovieListCustomer">Movies</a> </header>

	<div class="count">
		<h2>Favorites</h2>

		<table class="table">
			<h2>
				<p id="gren">${msg}</p>
			</h2>
			<tr>
				<th class="left">Title</th>
				<th class="rite">Gross</th>
				<th class="cent">Genre</th>
				<th class="cent"></th>
			</tr>

			<c:forEach items="${movieItemListCustomer}" var="movie">
				<tr>
					<td class="left">${movie.title}</td>
					<td class="ledt">${movie.gross}</td>
					<td class="cent">${movie.gence}</td>
					<td class="cent"><a
						href="RemoveFavorites?movieItemId=${movie.id}">Delete</a></td>

				</tr>
			</c:forEach>
			<tr>
				<th></th>
				<td class="cent">No.of Favorites:</b>${fn:length(movieItemListCustomer) }</td>

				<th></th>
			</tr>



		</table>
	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>



