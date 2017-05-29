<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

</head>
<body>
10 countries with highest number of airports:<br/>
<div>
    <table id="tblCountryAirportsTopHighest"  border = 1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Code</th>
                <th>Name</th>
                <th>Continent</th>
                <th>Count</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${countryAirportsTopHighest}" var="item">
                <tr>
                    <td>${item.country.id}</td>
                    <td>${item.country.code}</td>
                    <td>${item.country.name}</td>
                    <td>${item.country.continent}</td>
                    <td>${item.count}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<br/>
10 countries with lowest number of airports:<br/>
<div>
    <table id="tblCountryAirportsTopLowest"  border = 1>
        <thead>
        <tr>
            <th>Id</th>
            <th>Code</th>
            <th>Name</th>
            <th>Continent</th>
            <th>Count</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${countryAirportsTopLowest}" var="item">
            <tr>
                <td>${item.country.id}</td>
                <td>${item.country.code}</td>
                <td>${item.country.name}</td>
                <td>${item.country.continent}</td>
                <td>${item.count}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br/>
Type of runways (as indicated in "surface" column) per country:<br/>
<div>
    <table id="tblCountryRunWayTypes"  border = 1>
        <thead>
        <tr>
            <th>Id</th>
            <th>Code</th>
            <th>Name</th>
            <th>Continent</th>
            <th>runwayType</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${countryRunWayTypes.entrySet()}" var="item">
            <tr>
                <td>${item.key.id}</td>
                <td>${item.key.code}</td>
                <td>${item.key.name}</td>
                <td>${item.key.continent}</td>
                <td>
                <c:forEach items="${item.value}" var="runway">
                    ${runway}</br>
                </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<br/>
10 most common runway identifications (indicated in "le_ident" column):<br/>
<div>
    <table id="tblTopRunWayIdents" border = 1>
        <thead>
        <tr>
            <th>le_ident</th>
            <th>Count</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${topRunWayIdents}" var="item">
            <tr>
                <td>${item.le_ident}</td>
                <td>${item.cnt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>

</html>