
<html>
    <head>
        <title>Hello Spring MVC</title>
    </head>
    <body>
        <h1>Course Name: ${course}</h1>
        <c:url value="/login" var="loginURL" />
        <c:url value="/admin/createAccount" var="createAccountURL" />
        <c:url value="/lecture/edit/addLecture" var="addLectureURL" />
        <c:url value="/lecture/view/" var="viewLectureURL" />
        <c:url value="/lecture/edit/editLecture/" var="editLectureURL"/>
        <c:url value="/poll/edit/addPoll" var="addPollURL"/>
        <c:url value="/poll/view/" var="viewPollURL"/>
        <c:url value="/registry" var="registryURL" />

        <security:authorize access="hasAnyRole('LECTURER','ADMIN')">
            <a href="${addLectureURL}">Add Lecture</a>
        </security:authorize>
        <security:authorize access="hasAnyRole('LECTURER','ADMIN')">
            &nbsp;<a href="${addPollURL}">Add Poll</a>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <a href="${loginURL}">Login</a> <br>
            <a href="${registryURL}">Registry</a>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <br><br><a href="${createAccountURL}">CreateAccount</a>
        </security:authorize>

        <c:choose>
            <c:when test="${empty lectures}">
                <p>There is no lectures in this course</p>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="lecture" items="${lectures}">
                        <li><a href="${viewLectureURL}${lecture.lectureID}">${lecture.lectureTitle}</a>&nbsp;<security:authorize access="hasAnyRole('ADMIN','LECTURER')">
                            <a href="${editLectureURL}${lecture.lectureID}">Edit Title</a>
                        </security:authorize></li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>
    
    <c:choose>
        <c:when test="${empty polls}">
            <p>There is no poll in this course</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="poll" items="${polls}">
                    <li><a href="${viewPollURL}${poll.pollID}">${poll.question}</a> </li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
    
    </body>
</html>
