<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="form-category">
		<form:form modelAttribute="category" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Category ID</td>
					<td><form:input path="id" /></td>
					<td><form:errors path="id" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Name</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Description</td>
					<td><form:textarea path="description" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Image</td>
					<td><input type="file" name="imageFile"></td>
					<td></td>
				</tr>

				<tr>
					<td><input type="submit" value="Create Category"></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div id="category-list">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryList}" var="cat">
					<tr>
						<td>${cat.id}</td>
						<td>${cat.name}</td>
						<td>${cat.description}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>