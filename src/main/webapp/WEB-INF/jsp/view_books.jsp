<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Library 2.0 | utkine.net</title>
</head>
<body>
<h2>View books</h2>
<c:if  test="${!empty bookList}">
  <table class="data">
    <tr>
      <th>nameBook</th>
      <th>datePublic</th>
      <th>genre</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
      <tr>
        <td>${book.nameBook}</td>
        <td>${book.datePublic}</td>
        <td>${book.genre}</td>
        <td>
          <form:form method="post" action="/delete_book_this_author/${book.id_book}" commandName="book">
            <input type="submit" value="delete author"/>
          </form:form>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<a href="/view_all_authors">Back</a>
</body>
</html>
