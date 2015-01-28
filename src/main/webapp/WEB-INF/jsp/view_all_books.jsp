<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Book</title>
</head>
<body>

<h2>Books List</h2>

<c:if  test="${!empty booksExt}">
  <table class="data">
    <tr>
      <th>Title of the book</th>
      <th>Publication Date</th>
      <th>Genre</th>
      <th>Author</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach items="${booksExt}" var="bookArr">
      <tr>
        <td>${bookArr.get(1)}</td>
        <td>${bookArr.get(2)}</td>
        <td>${bookArr.get(3)}</td>
        <td>${bookArr.get(5)}</td>
        <td><a href="/remove_book/${bookArr.get(0)}">remove book</a></td>
        <td><a href="/view_this_book/${bookArr.get(0)}">view</a></td>
        <td colspan="2">
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<a href="/view_all_authors">Back</a>
</body>
</html>