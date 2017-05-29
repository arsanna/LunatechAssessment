<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/query.js" />"></script>
</head>
<body>
Query Option will ask the user for the country name or code and print the airports & runways at each airport. The input can be country code or country name</br>
</br>
<label id="countryCode" for="inputCode">Country code:</label>
<input id="inputCode" name="inputCode" type="text"></input>
<label id="countryName" for="inputName">Country name:</label>
<input id="inputName" name="inputName" type="text"></input>
<button id="queryResult" name = "queryResult" onclick="queryResultClick()">Ok</button>

</br>
<div id = "divAirports">
</div>

</body>

</html>