<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Movies List</title>
<link rel="stylesheet" type="text/css" href="./style/style.css">
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png"> <a id="favorite" href="ShowFavorites">Favotites</a>
	<a id="movie" href="ShowMovieListCustomer">Movies</a> </header>
	<div class="count">
		<h2>Favorites</h2>

		<table>
			<tr>
				<h3>
					<p id="gry">
						No items in Favorite.<a class="movieitem"
							href="ShowMovieListCustomer">Movie List</a>
					</p>
				</h3>
			</tr>
		</table>

	</div>
	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>



