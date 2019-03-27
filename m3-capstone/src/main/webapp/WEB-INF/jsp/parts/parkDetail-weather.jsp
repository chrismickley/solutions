<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="scaleSwitch">
	<c:set var="otherScale" value="Celsius" />
	<c:if test="${temperatureScale.celsius == true}">
		<c:set var="otherScale" value="Farenheit" />
	</c:if>
	
	<c:url var="switchScaleUrl" value="/switchScale">
		<c:param name="parkCode" value="${park.parkCode}" />
		<c:param name="isCelsius" value="${!temperatureScale.celsius}" />
	</c:url>
	<a href="${switchScaleUrl}"><span><c:out value="Show in ${otherScale}" /></span></a>
	
</div>
<div class="parkWeatherMain">
	<c:forEach var="day" items="${weather.dailyWeather}" varStatus="iteration"> 
		<c:set var="weatherClass" value="weatherDay" />
		<c:if test="${iteration.index == 0 }">
			<c:set var="weatherClass" value="weatherToday" />
		</c:if>
		<div class="${weatherClass} weatherDisplay">
			<h3><c:out value="${day.dayName}" /></h3>
			<img src="<c:url value="img/weather/${fn:replace(day.forecast,' ', '')}.png" />" />
			<h4><c:out value="${day.forecast}" /></h4>
			<div class="tempContainer">
				<div class="temp tempHigh">
					<div class="tempTitle">High</div><div><c:out value="${day.highWithScale}" /></div>
				</div>
				<div class="temp tempLow">
					<div class="tempTitle">Low</div><div><c:out value="${day.lowWithScale}" /></div>
				</div>
			</div>
		
			<div class="warnings">
				<ul>
				<c:forEach var="warning" items="${day.warnings}">
					<li><c:out value="${warning}" /></li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</c:forEach>
</div>
