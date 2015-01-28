<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Library 2.0 | utkine.net</title>
</head>
<body>

<form:form method="post" action="/view_edit_author/${author.id}" commandName="author">
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
        <input type="submit" value="Edit"/>
      </td>
    </tr>
  </table>
</form:form>





</body>
</html>