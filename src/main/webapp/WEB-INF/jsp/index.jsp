<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
</head>

    <script type="text/javascript">
        function openURL(url, name) {
            location.reload();
            location.href=url;
            //window.open(url, name);
        }
    </script>

<body>

Please choose the action: </br>
<button id="queryButton" onclick="openURL('/query');">Query</button>
<button id="reportButton" onclick="openURL('/reports');">Report</button>

</body>
</html>