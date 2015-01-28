<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Library 2.0 | utkine.net</title>
</head>
<body>

<form:form method="post" action="/add_book" commandName="book">
  <table>
    <tr>
      <td><form:label path="nameBook"><spring:message code="label.book.nameBook"/></form:label></td>
      <td><form:input path="nameBook" /></td>
    </tr>
    <tr>
      <td><form:label path="datePublic"><spring:message code="label.book.datePublic"/></form:label></td>
      <td><form:input path="datePublic" /></td>
    </tr>
    <tr>
      <td><form:label path="genre"><spring:message code="label.book.genre"/></form:label></td>
      <td><form:input path="genre" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="add"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>