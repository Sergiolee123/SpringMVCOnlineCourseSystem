<html>
<head>
  <title>Add Comment</title>
</head>
<body>
<h1>Add Lecture</h1>
<form:form method="POST" modelAttribute="comment">
  <form:label path="lectureTitle">Lecture Title: </form:label>
  <form:input type="text" path="lectureTitle"/><br>
  <input type="submit" name="add" value="Add">

</form:form>

</body>
</html>
