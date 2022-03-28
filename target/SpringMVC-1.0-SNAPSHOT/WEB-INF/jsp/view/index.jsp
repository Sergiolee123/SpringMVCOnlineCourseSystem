
<html>
    <head>
        <title>Hello Spring MVC</title>
    </head>
    <body>
        <h1>Course Name: ${course}</h1>
        <c:url value="/login" var="loginURL" />
        <c:url value="/lecture/edit/addLecture" var="editLectureURL" />
        <c:url value="/lecture/view/" var="viewLectureURL" />

        <security:authorize access="hasRole('LECTURER')">
            <a href="${editLectureURL}">AddLecture</a>
        </security:authorize>

        <c:choose>
            <c:when test="${empty lectures}">
                <p>There is no lectures at this course</p>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="lecture" items="${lectures}">
                        <li><a href="${viewLectureURL}${lecture.lectureID}">${lecture.lectureTitle}</a></li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>

        <security:authorize access="isAnonymous()">
            <a href="${loginURL}">Login</a>
        </security:authorize>
    </body>
</html>
