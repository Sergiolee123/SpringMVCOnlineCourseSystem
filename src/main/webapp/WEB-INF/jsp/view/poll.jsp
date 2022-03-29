<html>
<head>
    <title>Poll detail</title>
</head>
<body>
<c:choose>
    <c:when test="${empty poll}">
        This poll does not exist
    </c:when>
    <c:otherwise>
        <p>Question: ${poll.question}</p><br>
        <p>Answer: </p><br>
        <p>A: </p>
    </c:otherwise>
</c:choose>

</body>
</html>
