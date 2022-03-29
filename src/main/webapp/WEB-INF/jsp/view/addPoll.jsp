<html>
<head>
  <title>Add Poll</title>
</head>
<body>
<h1>Add Poll</h1>
<form:form method="POST" modelAttribute="poll">
  <form:label path="lectureTitle">Poll Question: </form:label>
  <form:input type="text" path="question"/><br>
  <input type="submit" name="add" value="Add">

</form:form>

</body>
</html>
