<%@page import="com.hrblock.sop.app.model.SopMainDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="icon" type="image/icon" href="/images/favicon.ico" /> -->
<link rel="icon" type="image/icon" href="<c:url value="/resources/css/images/favicon.ico" />" />




<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">


<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>



<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"> --%>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<!-- /style.css -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans"
	rel="stylesheet">


</head>

<body>

	<header class="header_class">
		<!--<div class="container">-->
		<div class="col-sm-12 header_12 m0p0">
			<img src="<c:url value="/resources/css/images/logo.png" />" class="logo" />
		</div>

		<div class="container-fluid sop_fluid m0p0">
			<div class="sop_container">
				<div class="col-sm-12 sop_hed_12 m0p0">
					<div class="col-sm-6">
						<h3 class="hedh3">SOP ACCOUNTABILITY STATUS</h3>
					</div>
					<div class="col-sm-6">
						<h3 class="userh3">
							<i class="fa fa-user" aria-hidden="true"></i> <span
								class="user_span">Vishnulal UC</span><span class="logout"><a
								href="javascript:void(0)">Logout</a></span>
						</h3>
					</div>
				</div>
			</div>
		</div>
		<!--</div>-->

	</header>


	<%-- <div class="container-fluid bd_fluid m0p0">
		<div class="sop_container">
			<div class="card">
				<div class="card-header card-header-primary">
					<h4 class="card-title ">Wireframe</h4>
					<!--<p class="card-category"> Here is a subtitle for this table</p>-->
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div class="col-sm-12">
							<h3 class="label_filer">Filter By:</h3>
							<select id="category_select"
								class="filter_sel form-control form-control-sm">
								<option value="1">Market</option>
								<option value="2">Region</option>
								<option value="3">District</option>
								<option value="4">Office</option>
								<option value="5">Warning Status</option>
								<option value="6">Last Updated</option>
							</select>
							<h3 class="label_filer label_filer2">Search By:</h3>
							<input type="text" id="user_search"
								class="search_fil form-control form-control-sm"
								placeholder="Search">
							<button class="ser_butt" id="serach_button" type="button"
								onclick="SearchItem();">Go</button>
						</div>

						<table id="sop_table" class="table table-striped table-bordered"
							style="width: 100%">
							<thead>
								<tr>
									<th>Market</th>
									<th>Region</th>
									<th>District</th>
									<th>Office</th>
									<th>OM Warning Status</th>
									<th>Last Updated</th>
								</tr>
							</thead>
							<tbody>




								
									<c:forEach var="item" items="${jsondata}">
<tr>
										<td>${item.market}</td>
										<td>${item.region}</td>
										<td>${item.district}</td>
										<td><a href="/sop/officedetails?officeId=${item.officeId}" >${item.officeId}</a></td>
										<td>${item.omWarningStatusId}</td>
										<td>${item.lastUpdated}</td>
</tr>
									</c:forEach>
								



							</tbody>

						</table>
					</div>
				</div>
			</div>


		</div>
	</div>
 --%>



	<div class="container-fluid bd_fluid m0p0">
		<div class="sop_container">
			<div class="card">
				<div class="card-header card-header-primary">
					<h4 class="card-title ">Wireframe</h4>
					<!--<p class="card-category"> Here is a subtitle for this table</p>-->
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div class="col-sm-12">
							<h3 class="label_filer">Filter By:</h3>
							<select id="filter_field"
								class="filter_sel form-control form-control-sm">
								<option value="0">Market</option>
								<option value="1">Region</option>
								<option value="2">District</option>
								<option value="3">Office</option>
								<option value="4">Warning Status</option>
								<option value="5">Last Updated</option>
							</select>
							<h3 class="label_filer label_filer2">Search By:</h3>
							<input type="text"
								class="search_fil serrr form-control form-control-sm"
								placeholder="Serarch">
						</div>

						<table id="example" class="table table-striped table-bordered"
							style="width: 100%">
							<thead>
								<tr>
									<th>Market</th>
									<th>Region</th>
									<th>District</th>
									<th>Office</th>
									<th>OM Warning Status</th>
									<th>Last Updated</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach var="item" items="${jsondata}">
									<tr>
										<td>${item.market}</td>
										<td>${item.region}</td>
										<td>${item.district}</td>
										<td><a
											href="/sop/officedetails?officeId=${item.officeId}">${item.officeId}</a></td>
										<td>${item.omWarningStatusName}</td>
										<td>${item.lastUpdated}</td>
									</tr>
								</c:forEach>


							</tbody>

						</table>
					</div>
				</div>
			</div>


		</div>
	</div>








	<footer>

		<script>
			$(document).ready(function() {
				$('#sop_table').DataTable();

			});

			/* var SearchItem = function() {

				/* var select_value = document.getElementById("category_select").value;
				var entered_value = document.getElementById("user_search").value;
				var searched_value = select_value + "_" + entered_value;
				
				$.ajax({
					type : 'GET',
					url : '/sop/MySearch/' + searched_value,
					dataType : 'json',
					async : true,
					success : function(result) {
						alert("success");
					},
					error : function() {
						alert("error");
					}
				}); */

				/* var filters = $("#filter_field option:selected").val();
				var searchVal = $("#user_search").val();

				alert(filters);
				alert(searchVal);

				//alert("The button was clicked.");

				$.ajax({
					url : "/sop/MySearch",
					type : "GET",
					data : "filters=" + filters + "&searchVal=" + searchVal,

					success : function() {
						alert("success");
					},
					error : function() {
						alert("error");
					}
				});
			} */
			
			 $(document).ready(function () {


                 // DataTable
                 var table = $('#example').DataTable();
                 // Apply the search
                 $('input.serrr').attr("data-id", $("#filter_field").val());
                 $("#filter_field").change(function () {

                     $('input.serrr').val("");
                     var ser_str = "";
                     var coloumn_index_ = $('input.serrr').attr("data-id");
                     coloumn_index_ = parseInt(coloumn_index_);
                     var that = table.columns(coloumn_index_);
                     that.search(ser_str)
                             .draw();

                     $('input.serrr').attr("data-id", $(this).val());
                 });

                 $('input.serrr').keyup(function () {


                     var ser_str = this.value;
                     var coloumn_index_ = $('input.serrr').attr("data-id");
                     coloumn_index_ = parseInt(coloumn_index_);
                     var that = table.columns(coloumn_index_);
                     that.search(ser_str)
                             .draw();

                 });



             });
			
		</script>

	</footer>

</body>

</html>