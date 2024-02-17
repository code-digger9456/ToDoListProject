<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ToDo List</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https:////cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" />
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<style>
a {
	color: white;
}

a:hover {
	color: white;
	text-decoration: none;
}
</style>
</head>
<body>


<div class="container">
		<h1 class="p-3">Edit ToDo Item</h1>
		<form:form action="/editSaveToDoItem" method="post" modelAttribute="todo">
		<form:input type="hidden" path="id"/>
			<div class="row">
				<div class=" form-group col-md-12">
					<label class="col-md-3">Title</label>
					<div class="col-md-6">
						<form:input type="text" path="title" id="title"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class=" form-group col-md-12">
					<label class="col-md-3">Date</label>
					<div class="col-md-6">
						<form:input type="date" path="date" id="date"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class=" form-group col-md-12">
					<label class="col-md-3">Status</label>
					<div class="col-md-6">
						<form:input type="text" path="status" id="status"
							class="form-control input-sm" value="Incomplete" />
					</div>
				</div>
			</div>

			<div class="row p-2">
				<div class=" col-md-2">
					<button type="submit" value="Register" class="btn btn-success">Save</button>
				</div>
			</div>
		</form:form>
	</div>
	<script th:inline="javascript">
		window.onload = function() {
         
			 var msg="${message}";
			 console.log(msg);
			 if(msg == "Edit Failure")
				 {
				 Command: toaster["error"]("Something went wrong with the edit.")
				 }
			 
			 toastr.options = {
						"closeButton" : true,
						"debug" : false,
				        "newestOnTop" : false,
						"progressBar" : true,
						"positionClass" : "toast-top-right",
						"preventDuplicates" : false,
						"onclick" : null,
						"showDuration" : "300",
						"hideDuration" : "1000",
						"timeOut" : "5000",
						"extendedTimeOut" : "1000",
						"showEasing" : "swing",
						"hideEasing" : "linear",
						"showMethod" : "fadeIn",
						"hideMethod" : "fadeOut"
					}
		}
	</script>
</body>
</html>