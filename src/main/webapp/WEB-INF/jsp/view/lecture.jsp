
<html>
<head>
    <title>Lecture detail</title>
</head>
<body>
<c:url value="/lecture/addComment/" var="addCommentURL" />
<c:choose>
    <c:when test="${empty lecture}">
        <p>There is no such lectures at this course</p>
    </c:when>
    <c:otherwise>
        <p>Lecture id: ${lecture.lectureID}</p>
        <p>Lecture Title: ${lecture.lectureTitle}</p><br>

        <c:if test="${empty lecture.materials}">
            <p>There are no material for this lecture</p><br>
        </c:if>
        <c:if test="${empty lecture.comments}">
            <p>There are no comment for this lecture</p><br>
        </c:if>
        <c:if test="${not empty lecture.materials}">
            <h3>List of Materials</h3>
            <ul>
            <c:forEach var="material" items="${lecture.materials}">
                <li>${material.materialName}<a href="${material.materialID}">download</a></li>
            </c:forEach>
            </ul><br>
        </c:if>
        <c:if test="${not empty lecture.comments}">
            <h3>List of Comments</h3>
            <ul>
                <c:forEach var="comment" items="${lecture.comments}">
                    <li><p>${comment.content}</p><br>
                        <p>comment written by ${comment.user.fullName} at <fmt:formatDate value="${comment.date}" pattern="dd-mm-yyyy HH:mm"/> </p></li>
                </c:forEach>
            </ul>
        </c:if>
        <a href="${addCommentURL}${lecture.lectureID}">add comment</a>
    </c:otherwise>
</c:choose>
</body>
</html>
