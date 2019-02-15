<html>
<head>
<script language="javascript">
function check()    {

chosen = ""
len = document.myform.chk.length
alert(len);
for (i = 0; i <len; i++) {
if (document.myform.chk[i].checked) {
	alert(document.myform.chk[i].checked);
chosen = document.myform.chk[i].value
}
}

if (chosen == "") {
alert("No Option selected");
return false;
}
else {
alert("option selected");
return true;
}
}
</script>
</head>
<body>
<form name="myform" onsubmit = "return check();">
<input type = "radio" name = "chk" id = "1" value = "1" >
<input type = "radio" name = "chk" id = "2" value = "2" >
<input type = "radio" name = "chk" id = "3" value = "3" >

<input type="submit" value="submit">

</form>
</body>
</html>