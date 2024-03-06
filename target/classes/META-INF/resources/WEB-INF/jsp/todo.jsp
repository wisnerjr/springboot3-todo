<html>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

		<head>
			<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css"
				rel="stylesheet">
			<title>Add Todo Page</title>
		</head>

		<body>
			<div class="container">
				<form:form method="post" modelAttribute="todo">
					<form:hidden path="id" />
					<fieldset class="form-group">
						<form:label path="description">Description</form:label>
						<form:input path="description" type="text" class="form-control" required="required" />
						<form:errors path="description" cssClass="text-warning" />
					</fieldset>

					<fieldset class="form-group">
						<form:label path="targetDate">Target Date</form:label>
						<form:input path="targetDate" type="text" class="form-control" required="required" />
						<form:errors path="targetDate" cssClass="text-warning" />
					</fieldset>
                    <br />
					<input type="submit" class="btn btn-success"></input>
				</form:form>
			</div>
			<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
			<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
            <script type="text/javascript">
                $('#targetDate').datepicker({
                    format: 'yyyy-mm-dd',
                    startDate: '-0d'
                });
            </script>
		</body>

<%@ include file="common/footer.jspf" %>

</html>