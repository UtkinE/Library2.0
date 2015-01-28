<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Book</title>
</head>
<body>

<h2>Books List</h2>


<c:if  test="${!empty bookList}">
  <table class="data">
    <tr>
      <th>Title of the book</th>
      <th>Publication Date</th>
      <th>Genre</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
      <tr>
        <td>${book.nameBook}</td>
        <td>${book.datePublic}</td>
        <td>${book.genre}</td>
        <td>
          <form:form method="post" action="/add_book_this_author/${authorId}/${book.id_book}" commandName="authorId">
            <input type="submit" value="add author"/>
          </form:form>
        </td>
        <td colspan="2"></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<a href="/view_all_authors">Back</a>
</body>
</html>
