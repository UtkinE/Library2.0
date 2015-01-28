<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Library 2.0 | utkine.net</title>
</head>
<body>
<h2>Authors Viewer</h2>
<c:if  test="${!empty authorList}">
  <table class="data">
    <tr>
      <th>FIO</th>
      <th>BirthDate</th>
      <th>Bio</th>
      <th>&nbsp;</th>
    </tr>
    <c:forEach items="${authorList}" var="author">
      <tr>
        <td>${author.fio}</td>
        <td>${author.birthDate}</td>
        <td>${author.bio}</td>
        <td><a href="/view_books/${author.id}">show books</a></td>
        <td><a href="/view_this_author/${author.id}">view</a></td>
        <td><a href="/assign_book_of_this_author/${author.id}">add book</a></td>
        <td><a href="/remove_author/${author.id}">remove author</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<a href="/view_all_books">Show all books</a>
<a href="/add_author_form">Add author</a>
<a href="/add_book_form">Add book</a>
</body>
</html>