<%@page import="com.hrblock.sop.app.model.SopMainDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/icon"
	href="<c:url value="/SMC/AMS/sop/resources/css/images/favicon.ico" />" />
<!-- /SMC/AMS/sop/resources/css/images/favicon.ico   /resources/css/images/favicon.ico -->




<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">


<!-- Latest compiled and minified JavaScript -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>



<link rel="stylesheet" href="<c:url value="/SMC/AMS/sop/resources/css/style.css" />">
<!-- /SMC/AMS/sop/resources/css/style.css    /resources/css/style.css -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="https://fonts.googleapis.com/css?family=Noto+Sans"
	rel="stylesheet">


</head>

<body>

	<header class="header_class">
		<!--<div class="container">-->
		<div class="col-sm-12 header_12 m0p0">
			<img src="<c:url value="/SMC/AMS/sop/resources/css/images/logo.png" />"
				class="logo" />
			<!-- /SMC/AMS/sop/resources/css/images/logo.png    /resources/css/images/logo.png -->
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
								class="user_span">${userName}</span><span class="logout"><a
								href="javascript:void(0)">Logout</a></span>
						</h3>
					</div>
				</div>
			</div>
		</div>
		<!--</div>-->

	</header>


	<div id="warning_p" class="container-fluid bd_fluid m0p0">
		<div class="sop_container">

			<h4 class="card-title ">Office Name/Number: ${officeNumber}</h4>
			<h4 class="card-title ">OM Name: ${omName}</h4>
			<a href="/sop/home" class="back_a">Back</a>

			<c:set var="verbstatus" value="no" scope="page" />
			<%-- <c:set var="warningName" value="" scope="page" /> --%>
			<c:set var="writstatus" value="no" scope="page" />
			<c:set var="finalstatus" value="no" scope="page" />
			<c:set var="descstatus" value="no" scope="page" />

			<div class="card">
				<div class="card-header card-header-primary">
					<h4 class="card-title ">Verbal Warning</h4>
					<a id="excptn_id" class="plus_ahref" href="javascript:void(0)"><i
						class="fa fa-arrow-up" aria-hidden="true"></i></a>
					<!--<p class="card-category"> Here is a subtitle for this table</p>-->
					<%-- <c:set var="warningName" value="1" /> --%>

				</div>
				<div class="card-body">
					<form>
						<div class="table-responsive">

							<table id="tbl1" class="table  table-striped table-bordered"
								style="width: 100%">
								<thead>
									<tr>

										<th>Date</th>
										<th>OM Warning Status</th>
										<th>Exception</th>
										<th>Exception Reason</th>
										<th><i class="fa fa-check" aria-hidden="true"></i></th>
									</tr>
								</thead>
								<tbody>

									<%--Starting Fetching Main Map --%>
									<c:forEach var="map" items="${sopOfficeDetails}">
										<!-- Starting Checking map for verbal warning details -->
										<c:choose>
											<c:when test="${map.key eq 'verbal'}">

												<%--  <c:set var="verb" value="${map.value}"/> --%>

												<c:forEach var="verb" items="${map.value}">



													<tr>
														<td>${verb.date}</td>
														<td>${verb.omWarningStatus}</td>
														<c:choose>
															<c:when test="${verb.omWarningStatus eq 'CONFIRMED'}">
																<c:set var="verbstatus" value="yes" />
															</c:when>
															<c:otherwise>

															</c:otherwise>
														</c:choose>
														<td>${verb.exception}</td>
														<c:choose>
															<c:when test="${verb.exception eq 'Yes'}">
																<td>${verb.exceptionReason}</td>
															</c:when>
															<c:otherwise>
																<td></td>
															</c:otherwise>
														</c:choose>
														<td></td>
													</tr>
												</c:forEach>

												<%-- <c:forEach var="warningStatusDetailsBean"
										items="${map.value}">
										
										${warningStatusDetailsBean.date}
										</c:forEach> --%>

											</c:when>
										</c:choose>
										<!-- Ending Checking map for verbal warning details -->
									</c:forEach>
									<%--Ending Fetching Main Map --%>
								</tbody>

								<%-- Code for adding new row against verbal warning --%>
								<tfoot>

									<tr class="new_inp_row_tr">

										<c:set var="today" value="<%=new java.util.Date()%>" />

										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="RECEIVED">RECEIVED</option>
													</c:when>
													<c:when test="${(role=='DIRECTMANAGER') || (role=='RD')}">
														<option value="CONFIRMED">CONFIRMED</option>
														<option value="EXCEPTION">EXCEPTION</option>
													</c:when>
													<c:otherwise>
														<input disabled type="text" value="" class="textbox">
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><span class="exception">No</span> <!-- <select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select> --></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a> <input
											type="hidden" id="warningName" name="warningName" value="1">
										</th>
									</tr>
								</tfoot>
							</table>

							<c:forEach var="map" items="${sopOfficeDetails}">
								<c:choose>
									<c:when test="${map.key eq 'verbal'}">
										<!-- Condition to check for role and give the permission to add status -->
										<c:set var="verb" value="${map.value}" />

										<c:forEach var="verb" items="${map.value}" varStatus="loop">
											<c:if test="${loop.last}">
												<c:choose>

													<c:when test="${empty verb.date}">

													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${role=='ARC'}">

																<c:choose>
																	<c:when test="${verbstatus=='yes'}">
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:when>
																	<c:otherwise>
																	</c:otherwise>
																</c:choose>

															</c:when>
															<c:when
																test="${(role=='DIRECTMANAGER') || (role=='RD')}">
																<c:choose>
																	<c:when test="${verbstatus=='yes'}">

																	</c:when>
																	<c:otherwise>
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:otherwise>
																</c:choose>
															</c:when>
															<c:otherwise>
																<a class="new_inp_row_a" href="javascript:void(0)"><i
																	class="fa fa-plus" aria-hidden="true"></i></a>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</c:forEach>

						</div>
					</form>
				</div>
			</div>
			<div class="card">
				<div class="card-header card-header-primary">
					<h4 class="card-title ">Written Warning</h4>
					<a class="plus_ahref" href="javascript:void(0)"><i
						class="fa fa-arrow-down" aria-hidden="true"></i></a>
					<!--<p class="card-category"> Here is a subtitle for this table</p>-->
					<%-- <c:set var="warningName" value="2" /> --%>

				</div>
				<div class="card-body">
					<form>
						<div class="table-responsive">

							<table id="tbl2" class="table  table-striped table-bordered"
								style="width: 100%">
								<thead>
									<tr>

										<th>Date</th>
										<th>OM Warning Status</th>
										<th>Exception</th>
										<th>Exception Reason</th>
										<th><i class="fa fa-check" aria-hidden="true"></i></th>
									</tr>
								</thead>
								<tbody>

									<%--Starting Fetching Main Map --%>
									<c:forEach var="map" items="${sopOfficeDetails}">

										<c:choose>
											<c:when test="${map.key eq 'written'}">

												<%-- <c:set var="verb" value="${map.value}"/> --%>

												<c:forEach var="verb" items="${map.value}">
													<tr>
														<td>${verb.date}</td>
														<td>${verb.omWarningStatus}</td>
														<c:choose>
															<c:when test="${verb.omWarningStatus eq 'CONFIRMED'}">
																<c:set var="writstatus" value="yes" />
															</c:when>
															<c:otherwise>

															</c:otherwise>
														</c:choose>
														<td>${verb.exception}</td>
														<c:choose>
															<c:when test="${verb.exception eq 'Yes'}">
																<td>${verb.exceptionReason}</td>
															</c:when>
															<c:otherwise>
																<td></td>
															</c:otherwise>
														</c:choose>
														<td></td>
													</tr>
												</c:forEach>
											</c:when>
										</c:choose>
									</c:forEach>
									<%--Ending Fetching Main Map --%>

								</tbody>

								<%-- Code for adding new row against written warning --%>
								<tfoot>

									<tr class="new_inp_row_tr">

										<c:set var="today" value="<%=new java.util.Date()%>" />
										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="RECEIVED">RECEIVED</option>
													</c:when>
													<c:when test="${(role=='DIRECTMANAGER') || (role=='RD')}">
														<option value="CONFIRMED">CONFIRMED</option>
														<option value="EXCEPTION">EXCEPTION</option>
													</c:when>
													<c:otherwise>
														<input disabled type="text" value="" class="textbox">
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><span class="exception">No</span>
										<!-- <select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select> --></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a> <input
											type="hidden" id="warningName" name="warningName" value="2">
										</th>
									</tr>
								</tfoot>
							</table>

							<c:forEach var="map" items="${sopOfficeDetails}">
								<c:choose>
									<c:when test="${map.key eq 'written'}">
										<!-- Condition to check for role and give the permission to add status -->
										<%-- <c:set var="verb" value="${map.value}"/> --%>
										<c:forEach var="verb" items="${map.value}" varStatus="loop">
											<c:if test="${loop.last}">
												<c:choose>

													<c:when test="${empty verb.date}">

													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${role=='ARC'}">

																<c:choose>
																	<c:when test="${writstatus=='yes'}">
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:when>
																	<c:otherwise>
																	</c:otherwise>
																</c:choose>

															</c:when>
															<c:when
																test="${(role=='DIRECTMANAGER') || (role=='RD')}">
																<c:choose>
																	<c:when test="${writstatus=='yes'}">

																	</c:when>
																	<c:otherwise>
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:otherwise>
																</c:choose>
															</c:when>
															<c:otherwise>
																<a class="new_inp_row_a" href="javascript:void(0)"><i
																	class="fa fa-plus" aria-hidden="true"></i></a>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</c:forEach>

						</div>
					</form>
				</div>
			</div>
			<div class="card">
				<div class="card-header card-header-primary">
					<h4 class="card-title ">Final Warning</h4>
					<a class="plus_ahref" href="javascript:void(0)"><i
						class="fa fa-arrow-down" aria-hidden="true"></i></a>
					<!--<p class="card-category"> Here is a subtitle for this table</p>-->
				</div>
				<div class="card-body">
					<form>
						<div class="table-responsive">

							<table id="tbl3" class="table  table-striped table-bordered"
								style="width: 100%">
								<thead>
									<tr>

										<th>Date</th>
										<th>OM Warning Status</th>
										<th>Exception</th>
										<th>Exception Reason</th>
										<th><i class="fa fa-check" aria-hidden="true"></i></th>
									</tr>
								</thead>
								<tbody>

									<%--Starting Fetching Main Map --%>
									<c:forEach var="map" items="${sopOfficeDetails}">

										<c:choose>
											<c:when test="${map.key eq 'final'}">

												<%-- <c:set var="verb" value="${map.value}"/> --%>
												<c:forEach var="verb" items="${map.value}">
													<tr>
														<td>${verb.date}</td>
														<td>${verb.omWarningStatus}</td>
														<c:choose>
															<c:when test="${verb.omWarningStatus eq 'CONFIRMED'}">
																<c:set var="finalstatus" value="yes" />
															</c:when>
															<c:otherwise>

															</c:otherwise>
														</c:choose>
														<td>${verb.exception}</td>
														<c:choose>
															<c:when test="${verb.exception eq 'Yes'}">
																<td>${verb.exceptionReason}</td>
															</c:when>
															<c:otherwise>
																<td></td>
															</c:otherwise>
														</c:choose>
														<td></td>
													</tr>
												</c:forEach>
											</c:when>
										</c:choose>

									</c:forEach>
									<%--Ending Fetching Main Map --%>

								</tbody>

								<%-- Code for adding new row against final warning --%>
								<tfoot>

									<tr class="new_inp_row_tr">
										<c:set var="today" value="<%=new java.util.Date()%>" />
										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="RECEIVED">RECEIVED</option>
													</c:when>
													<c:when test="${(role=='DIRECTMANAGER') || (role=='RD')}">
														<option value="CONFIRMED">CONFIRMED</option>
														<option value="EXCEPTION">EXCEPTION</option>
													</c:when>
													<c:otherwise>
														<input disabled type="text" value="" class="textbox">
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><span class="exception">No</span>
										<!-- <select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select> --></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a> <input
											type="hidden" id="warningName" name="warningName" value="3">
										</th>
									</tr>
								</tfoot>
							</table>

							<c:forEach var="map" items="${sopOfficeDetails}">
								<c:choose>
									<c:when test="${map.key eq 'written'}">
										<!-- Condition to check for role and give the permission to add status -->
										<%-- <c:set var="verb" value="${map.value}"/> --%>
										<c:forEach var="verb" items="${map.value}" varStatus="loop">
											<c:if test="${loop.last}">
												<c:choose>

													<c:when test="${empty verb.date}">

													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${role=='ARC'}">

																<c:choose>
																	<c:when test="${finalstatus=='yes'}">
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:when>
																	<c:otherwise>
																	</c:otherwise>
																</c:choose>

															</c:when>
															<c:when
																test="${(role=='DIRECTMANAGER') || (role=='RD')}">
																<c:choose>
																	<c:when test="${finalstatus=='yes'}">

																	</c:when>
																	<c:otherwise>
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:otherwise>
																</c:choose>
															</c:when>
															<c:otherwise>
																<a class="new_inp_row_a" href="javascript:void(0)"><i
																	class="fa fa-plus" aria-hidden="true"></i></a>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</form>
				</div>
			</div>

			<div class="card">
				<div class="card-header card-header-primary">
					<h4 class="card-title ">Decision</h4>
					<a class="plus_ahref" href="javascript:void(0)"><i
						class="fa fa-arrow-down" aria-hidden="true"></i></a>
					<!--<p class="card-category"> Here is a subtitle for this table</p>-->
				</div>
				<div class="card-body">
					<form>
						<div class="table-responsive">

							<table id="tbl4" class="table  table-striped table-bordered"
								style="width: 100%">
								<thead>
									<tr>

										<th>Date</th>
										<th>OM Warning Status</th>
										<th>Exception</th>
										<th>Exception Reason</th>
										<th><i class="fa fa-check" aria-hidden="true"></i></th>
									</tr>
								</thead>
								<tbody>
									<%--Starting Fetching Main Map --%>
									<c:forEach var="map" items="${sopOfficeDetails}">


										<c:choose>
											<c:when test="${map.key eq 'decision'}">

												<%-- <c:set var="verb" value="${map.value}"/> --%>
												<c:forEach var="verb" items="${map.value}">
													<tr>
														<td>${verb.date}</td>
														<td>${verb.omWarningStatus}</td>
														<c:choose>
															<c:when test="${verb.omWarningStatus eq 'CONFIRMED'}">
																<c:set var="descstatus" value="yes" />
															</c:when>
															<c:otherwise>

															</c:otherwise>
														</c:choose>
														<td>${verb.exception}</td>
														<c:choose>
															<c:when test="${verb.exception eq 'Yes'}">
																<td>${verb.exceptionReason}</td>
															</c:when>
															<c:otherwise>
																<td></td>
															</c:otherwise>
														</c:choose>
														<td></td>
													</tr>
												</c:forEach>
											</c:when>
										</c:choose>

									</c:forEach>
									<%--Ending Fetching Main Map --%>
								</tbody>

								<%-- Code for adding new row against decision warning --%>
								<tfoot>

									<tr class="new_inp_row_tr">
										<c:set var="today" value="<%=new java.util.Date()%>" />
										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="RECEIVED">RECEIVED</option>
													</c:when>
													<c:when test="${(role=='DIRECTMANAGER') || (role=='RD')}">
														<option value="CONFIRM-FIT FOR ROLE">CONFIRM-FIT
															FOR ROLE</option>
														<option value="CONFIRM-KEEP COACHING">CONFIRM-KEEP
															COACHING</option>
														<option value="CONFIRM-TERMINATION">CONFIRM-TERMINATION</option>
														<option value="EXCEPTION">EXCEPTION</option>
													</c:when>
													<c:otherwise>
														<input disabled type="text" value="" class="textbox">
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><span class="exception">No</span>
										<!-- <select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select> --></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a> <input
											type="hidden" id="warningName" name="warningName" value="4">
										</th>
									</tr>
								</tfoot>
							</table>

							<c:forEach var="map" items="${sopOfficeDetails}">
								<c:choose>
									<c:when test="${map.key eq 'written'}">
										<!-- Condition to check for role and give the permission to add status -->
										<%-- <c:set var="verb" value="${map.value}"/> --%>
										<c:forEach var="verb" items="${map.value}" varStatus="loop">
											<c:if test="${loop.last}">
												<c:choose>

													<c:when test="${empty verb.date}">

													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${role=='ARC'}">

																<c:choose>
																	<c:when test="${descstatus=='yes'}">
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:when>
																	<c:otherwise>
																	</c:otherwise>
																</c:choose>

															</c:when>
															<c:when
																test="${(role=='DIRECTMANAGER') || (role=='RD')}">
																<c:choose>
																	<c:when test="${descstatus=='yes'}">

																	</c:when>
																	<c:otherwise>
																		<a class="new_inp_row_a" href="javascript:void(0)"><i
																			class="fa fa-plus" aria-hidden="true"></i></a>
																	</c:otherwise>
																</c:choose>
															</c:when>
															<c:otherwise>
																<a class="new_inp_row_a" href="javascript:void(0)"><i
																	class="fa fa-plus" aria-hidden="true"></i></a>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</form>
				</div>
			</div>


		</div>
	</div>










	<footer>

		<script>
                $(document).ready(function () {
                    $('#tbl1').DataTable();
                    $('#tbl2').DataTable();
                    $('#tbl3').DataTable();
                    $('#tbl4').DataTable();
                });
            </script>

		<script>
                $(document).ready(function () {

//                    for slide toggle at opening beg
                    $(".plus_ahref").parent(".card-header").siblings(".card-body").slideToggle();
                    $("#excptn_id").parent(".card-header").siblings(".card-body").slideToggle();

//                    for slide toggle at opening end


//                    clear values beg
                    function clear_val(tbl_id) {
                        $("#" + tbl_id).find(".reason").val("");
                        $("#" + tbl_id).find(".error_msg").text("");
                        $("#" + tbl_id + ' .exception').html("No");
                    }
//                    clear values end


//                expand and collapse beg
                    $(".plus_ahref").click(function () {
                        $(this).children("i.fa").toggleClass("fa-arrow-up fa-arrow-down");
                        $(this).parent(".card-header").siblings(".card-body").slideToggle();
                    })
//                expand and collapse end


//show new row beg
                    $(".new_inp_row_a").click(function () {
                        clear_val($(this).siblings(".dataTables_wrapper").find("table").attr("id"));
                        $(this).siblings(".dataTables_wrapper").find("table").find(".new_inp_row_tr").show();
                    });
//show new row end
//change warnig status function beg
                    $(document).on('change', '.w_status', function () {
                        if ($(this).val() == "EXCEPTION") {
//                            $(this).parent("th").siblings("th").children(".exception").prop("disabled", false);
                            $(this).parent("th").siblings("th").children('.exception').html('Yes');
                            $(this).parent("th").siblings("th").children('.reason').show();
                        } else {
                            $(this).parent("th").siblings("th").children('.exception').html('No');
                            $(this).parent("th").siblings("th").children('.reason').hide();
                        }
                    });
//change warnig status function end

//save new row beg

                    $(document).on("click", ".save_a", function () {
                    	var this_event=this;
                        var t = $(this).closest("table").DataTable();

                        var reason = $(this).parent("th").siblings("th").children(".reason").val();
                        var exception = $(this).parent("th").siblings("th").children(".exception").val();
                        var w_status = $(this).parent("th").siblings("th").children(".w_status").val();
                        var date = $(this).parent("th").siblings("th").children(".date").val();
                        

                        if (exception == "Yes") {
                            if (reason.length < 15 | reason.length > 250) {
                                $(this).parent("th").siblings("th").children(".error_msg").text("Input text length should be greater than 60 and lesser than 250");
                                return false;
                            }
                        }
                        
                        var officeId=${officeNumber};
                        var warningCycleId=${warningCycleId};
                        var warningNameId = $(this).parent('th').children('input').val();
                        $.ajax({
        					type : 'POST',
        					url : "/sop/warningStatus",
        					data : { officeId :officeId , warningName : warningNameId ,date :date , omWarningStatus : w_status ,
        						exception :exception , exceptionReason : reason, warningCycleId : warningCycleId },
        					dataType : 'html',
        					async : false,
        					success : function(response) {
        						console.debug(response);
        						if(response == "success"){
        							//alert("faild");
        							t.row.add([
        	                            date,
        	                            w_status,
        	                            exception,
        	                            reason,
        	                            '<a class="icn_oprn"><i class="fa fa-check" aria-hidden="true"></i></a>'
        	                        ]).draw(false);
        	//hide plus button when save received beg
        	                        if (w_status == "RECEIVED") {
        	                            $(this_event).closest("table").parents().children(".new_inp_row_a").hide();
        	                        }
        	//hide plus button when save received end

        	                        $(this_event).closest("tr").hide(); 
        						}
        						
        					},
        					error : function() {
        						alert("Some error occured. Please try after sometime.");
        					}
        				});
                        
                        
                        
                        
                        
                        
                    });
//save new row end

//delete new row beg
                    $(".delete_a").click(function () {
                        $(this).closest("tr").hide();
                    });
//delete new row end
//edit row beg

                    $(document).on("click", ".edit_a", function () {
                        $(this).closest("tr").hide();
                        var this_ = $(this);
                        $(this).closest("tr").siblings(".new_inp_row_tr").show();
                        $(this).closest("tr").siblings(".new_inp_row_tr").find(".icn_oprn").addClass('update_a');
                        $(this).closest("tr").siblings(".new_inp_row_tr").find(".icn_oprn").removeClass('save_a');


                    });
//edit row end

                });
            </script>

	</footer>

</body>

</html>