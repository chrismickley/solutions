<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="grid-container">
  <div class="ParkDescription"><c:out value="${park.parkDescription}" /></div>
  <div class="ParkName">
    <div class="Name gridParkName"><c:out value="${park.parkName}" /></div>
    <div class="StateFounded">
      <div class="State textState"><c:out value="${park.state}" /></div>
      <div class="Founded textRight">Founded <c:out value="${park.yearFounded}" /></div>
    </div>
  </div>
  <div class="VisitorInfo">
    <div class="campSitesTitle title">Campsites:</div>
    <div class="VisitorTitle title">Annual Visitors:</div>
    <div class="FeeTitle title">Entry Fee:</div>
    <div class="CampSitesCount"><c:out value="${park.numberOfCampsites}" /></div>
    <div class="VisitorCount"><c:out value="${park.annualVisitorCount}" /></div>
    <div class="EntryFee"><c:out value="${park.entryFee}" /></div>
  </div>
  <div class="ParkDetail">
    <div class="ClimateTitle title">Climate:</div>
    <div class="Climate"><c:out value="${park.climate}" /></div>
    <div class="AcerageTitle title">Acerage:</div>
    <div class="Acerage"><c:out value="${park.acreage}" /></div>
    <div class="milesTrailsTitle title">Miles of Trails:</div>
    <div class="milesOfTrails"><c:out value="${park.milesOfTrail}" /></div>
    <div class="elevationTitle title">Elevation:</div>
    <div class="elevation"><c:out value="${park.elevationInFeet}" />ft</div>
    <div class="animalsTitle title">Animal Species:</div>
    <div class="animalsCount"><c:out value="${park.numberOfAnimalSpecies}" /></div>
  </div>
  <div class="parkWeather">
	<c:import url="/WEB-INF/jsp/parts/parkDetail-weather.jsp" />
  </div>
</div>