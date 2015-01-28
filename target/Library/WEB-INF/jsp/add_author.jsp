<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Spring 3 MVC Series - Contact Manager | viralpatel.net</title>
</head>
<body>

<h2>Author Manager</h2>

<form:form method="post" action="/add_author" commandName="author">

  <table>
    <tr>
      <td><form:label path="fio"><spring:message code="label.author.fio"/></form:label></td>
      <td><form:input path="fio" /></td>
    </tr>
    <tr>
      <td><form:label path="birthDate"><spring:message code="label.author.birthDate"/></form:label></td>
      <td><form:input path="birthDate" /></td>
    </tr>
    <tr>
      <td><form:label path="bio"><spring:message code="label.author.bio"/></form:label></td>
      <td><form:input path="bio" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="<spring:message code="label.author.addAuthor"/>"/>
      </td>
    </tr>
  </table>
</form:form>

