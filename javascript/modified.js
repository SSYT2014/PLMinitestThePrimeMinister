function modified(){
	var date = new Date(document.lastModified);
	var year = date.getYear()+1900;
	var month = date.getMonth()+1;
	var day = date.getDate();
	document.write("Updated "+year+"/"+month+"/"+day);
}
