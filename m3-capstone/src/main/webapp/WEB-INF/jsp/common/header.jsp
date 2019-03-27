<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/css/parkDetail.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/css/survey.css"/>" rel="stylesheet" type="text/css" />
		<link href="https://fonts.googleapis.com/css?family=Lora|Roboto|Courgette|Roboto+Slab" rel="stylesheet" />
		<title>National Park Geek - <c:out value="${param.pageTitle}"/></title>
	</head>
	<body>
		<header>
			<c:url var="logoImg" value="img/logo.png" />
			<img src="${logoImg}" />
			<div>
				<c:url var="homeUrl" value="/" />
				<c:url var="surveyUrl" value="/survey" />
				<nav>
					<a href="${homeUrl}">Home</a> |
					<a href="${surveyUrl}">Survey</a>
				</nav>
			</div>
		</header>
		<section id="main">