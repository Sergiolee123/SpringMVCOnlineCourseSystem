
<html>
<head>
    <title>Lecture detail</title>
</head>
<body>
<c:url value="/lecture/addComment/" var="addCommentURL" />
<c:url value="/lecture/material/" var="downloadURL" />
<c:url value="/lecture/edit/uploadMaterial/" var="uploadURL"/>
<c:url value="/lecture/edit/deleteMaterial/" var="deleteMaterialURL"/>

<c:choose>
    <c:when test="${empty lecture}">
        <p>There is no such lectures at this course</p>
    </c:when>
    <c:otherwise>
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
                <li><a href="${downloadURL}${material.materialID}">${material.materialName}</a>
                <p>material uploaded at <fmt:formatDate value="${material.date}" pattern="dd-MM-yyyy HH:mm"/>&nbsp;<security:authorize access="hasAnyRole('ADMIN','LECTURER')">
                    <a href="${deleteMaterialURL}${material.materialID}">Delete Material</a>
                </security:authorize></p></li>
            </c:forEach>
            </ul><br>
        </c:if>
        <c:if test="${not empty lecture.comments}">
            <h3>List of Comments</h3>
            <ul>
                <c:forEach var="comment" items="${lecture.comments}">
                    <li><p>${comment.content}</p>
                        <p>comment written by ${comment.user.fullName} at <fmt:formatDate value="${comment.date}" pattern="dd-MM-yyyy HH:mm"/> </p></li>
                </c:forEach>
            </ul>
        </c:if>
        <a href="${addCommentURL}${lecture.lectureID}">Add Comment</a>
        <security:authorize access="hasAnyRole('ADMIN','LECTURER')">
            &nbsp;<a href="${uploadURL}${lecture.lectureID}">Add Material</a>
        </security:authorize>
    </c:otherwise>
</c:choose>
</body>
</html>
