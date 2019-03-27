<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Survey" />
</c:import>

<div class="sv-grid-container">
  <div class="sv-surveyTitle"><h1>National Parks Survey</h1></div>
  <div class="sv-surveyDescription">Please tell us a little about yourself and your favorite national park.</div>
  <div class="sv-survey">
  	<form:form action="" method="POST" modelAttribute="survey">
  	
  		<div>
  			<form:errors path="*" cssClass="validationError"/>
  		</div>
  	
  	 	<div class="surveyFormItem">
	  		<label for="parkCode">Favorite Park:</label>
	  		<form:select path="parkCode">
	  			<form:option value="" label="--- Select a park ---" />
	  			<form:options items="${parks}" itemValue="parkCode" itemLabel="parkName"/>
	  		</form:select>
	  		
  		</div>
  		
  		<div class="surveyFormItem">
	  		<label for="emailAddress">Email Address:</label>
	  		<form:input path="emailAddress" />
  		</div>
  		
  		<div class="surveyFormItem">
	  		<label for="state">State of Residence:</label>
	  		<form:select path="state">
	  			<form:option value="" label="--- Select your state ---" />
	  			<form:options items="${stateList}" />
	  		</form:select>
  		</div>
  		
  		<div class="surveyFormItem">
  			<label for="acivityLevel">Activity Level:</label>
	  		<form:radiobutton path="acivityLevel" value="inactive" />Inactive
	  		<form:radiobutton path="acivityLevel" value="sedentary" />Sedentary
	  		<form:radiobutton path="acivityLevel" value="active" />Active
	  		<form:radiobutton path="acivityLevel" value="extremely active" />Extremely Active
  		</div>	
  		
  		<div class="surveyFormItem">
  			<input class="surveySubmitButton" type="submit" value="Save Answers" />
  		</div>
  	</form:form>
  </div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />