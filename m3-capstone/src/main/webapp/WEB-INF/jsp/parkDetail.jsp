<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="${park.parkName}" />
</c:import>

	<c:url var="parkImageUrl" value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />
	<div class="parkDetailImage" style="background-image: url(${parkImageUrl});">
		<div class="quote">"<c:out value="${park.inspirationalQuote}" />"
			<div class="quoteSource"><c:out value="${park.inspirationalQuoteSource}" /></div>
		</div>
	</div>
		
	<div id="parkDetailMain">
		<c:import url="/WEB-INF/jsp/parts/parkDetail-details.jsp" />
	</div>
		
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />