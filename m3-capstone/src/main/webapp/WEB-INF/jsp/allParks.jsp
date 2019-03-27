<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Home" />
</c:import>
		
		
	<c:forEach var="park" items="${parks}">
		<c:url var="parkDetailUrl" value="/parkDetail">
			<c:param name="parkCode" value="${park.parkCode}" />
		</c:url>
		<div class="parkInfo">
			<div class="parkImage">	
				<a href="${parkDetailUrl}">
				<img src="<c:url value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />" />
				</a>
			</div>
			<div class="parkShortDetails">
				<h1><a href="${parkDetailUrl}">${park.parkName}</a></h1>
				<h4>${park.state}</h4> 
				<p>${park.parkDescription}</p>
			</div>
		</div>
	</c:forEach>
		
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />