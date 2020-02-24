<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#btn').click(function() {
		var requestData = $("#inputy").val();
		var baseUrl = 'employees/';
		var myurl = baseUrl.concat(requestData);
	$.ajax({
	type: 'GET',	
	url: myurl,
	success: function(data){
		$("#di1").html("Full Name: "+data.firstName+" "+data.lastName );
		$("#di2").html("Gender: "+data.gender );
		$("#di3").html("Birth Date: "+data.birthDate );
		$("#di4").html("Hire Date: "+data.hireDate );
	}
	})	
	})
})
</script>

</head>
<body>
 <br>
 <h3> Employee Detail Information Page</h3>
  <br>
 
Enter Employee's Id No: <input type="text" id="inputy">

<input id="btn" type="button" value="find">
<br>
<br>
<div id="di">
	<div id=di1>
	
	</div>
	<div id=di2>
	
	</div>
	<div id=di3>
	
	</div>
	<div id=di4>
	
	</div>
</div>

</body>

</html>