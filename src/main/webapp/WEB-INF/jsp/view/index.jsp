
<html>
    <head>
        <title>Hello Spring MVC</title>
    </head>
    <body>
        <h1>Course Name: ${course}</h1>
        <c:url value="/" var="LectureURL" />
    <c:if test="${not empty lectures}">
       <ul>
           <c:forEach var="lecture" items="${lectures}">
                <li><a href="">${lecture.lectureTitle}</li>
           </c:forEach>
       </ul>
    </c:if>
    </body>
</html>
