<html>
<head>
    <title>Poll detail</title>
</head>
<body>
<c:url value="/poll/submit/${poll.pollID}/" var="submitURL"/>
<c:choose>
    <c:when test="${empty poll}">
        This poll does not exist
    </c:when>
    <c:otherwise>
        <p>Question: ${poll.question}</p><br>
        <p>Answer: </p><br>
        <p><a href="${submitURL+="A"}">A: ${poll.optionA}</a></p>
        <p><a href="${submitURL+="B"}">B: ${poll.optionB}</a></p>
        <p><a href="${submitURL+="C"}">C: ${poll.optionC}</a></p>
        <p><a href="${submitURL+="D"}">D: ${poll.optionD}</a></p>
    </c:otherwise>
</c:choose>

</body>
</html>
