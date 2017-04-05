<%--

 @author Yassir Aguila
 @version $Revision: 1.0 $ $Date: 2017-04-03
 @since 1.8

--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Student/Class Assignment --- Web Portal</title>
</head>
<body>

<h1>Student/Class Assignment --- Web Portal</h1>

<P>  Current time: ${serverTime}. </P>
<P>  Students: ${students}. </P>
<P>  Classes: ${classes}. </P>
<P>  Assignments: ${assignments}. </P>
</body>
</html>
