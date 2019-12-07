function validation() {
	var a = document.forms["editmovie"]["txtTitle"].value;
	if (a==""){
		alert("Title is required");
		return false;
	}
	if ((a.length < 2) || (a.length >100)) {
		alert("Title should have 2 to 100 charecter.");
		document.forms["editmovie"]["txtTitle"].select();
		return false;
	}
    var b = document.forms["editmovie"]["txtGross"].value;
	if (b==""){
		alert("gross is required");
		document.forms["editmovie"]["txtGross"].focus;
		return false;
	}
	if (/[^0-9]/.test(b)){
		alert("gross has to be a number.");
		return false;
	}
	var c = document.forms["editmovie"]["txtDate"].value;
	if (c==""){
		alert("date is required");
		document.forms["editmovie"]["txtDate"].focus;
		return false;
	}
	alert("Details submitted successfully");
}

	
	  
		