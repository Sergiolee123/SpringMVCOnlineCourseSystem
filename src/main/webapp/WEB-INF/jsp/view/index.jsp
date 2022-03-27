
<html>
    <head>
        <title>Hello Spring MVC</title>
    </head>
    <body>
        <h1>Course Name: ${course}</h1>
        <c:url value="/lecture/edit/addLecture" var="editLectureURL" />
        <c:url value="/lecture/view/" var="viewLectureURL" />

        <a href="${editLectureURL}">AddLecture</a>

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

    </body>
</html>
