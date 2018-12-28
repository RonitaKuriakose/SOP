<%@page import="com.hrblock.sop.app.model.SopMainDetailsBean"%>
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
	href="<c:url value="/resources/css/images/favicon.ico" />" />
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



<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
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
			<img src="<c:url value="/resources/css/images/logo.png" />" class="logo" />
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

									<c:forEach var="verb" items="${verbal}">
										
										<%-- <c:set var="warningName" value="${verb.warningName}" /> --%>
										<tr>
											<td>${verb.date}</td>
											<td>${verb.omWarningStatus}</td>
											<c:choose>
												<c:when test="${verb.omWarningStatus=='Confirmed'}">
													<c:set var="verbstatus" value="yes" />
												</c:when>
												<c:otherwise>

												</c:otherwise>
											</c:choose>
											<td>${verb.exception}</td>

											<c:choose>
												<c:when test="${verb.exception=='Yes'}">
													<td>${verb.exceptionReason}</td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>

											<td></td>
										</tr>
									</c:forEach>

								</tbody>
								<tfoot>

									<tr class="new_inp_row_tr">

										<c:set var="today" value="<%=new java.util.Date()%>" />

										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="Received">Received</option>
													</c:when>
													<c:otherwise>
														<option value="Active">Active</option>
														<option value="Confirmed">Confirmed</option>
														<option value="Exception">Exception</option>
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a>
												
												<input type="hidden" id="warningName" name="warningName"
											value="1">
											</th>
									</tr>
								</tfoot>
							</table>
							<c:choose>
								<c:when test="${empty verbal}">
								</c:when>
								<c:otherwise>
									<!-- Condition to check for role and give the permission to add status -->
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
										<c:otherwise>
											<a class="new_inp_row_a" href="javascript:void(0)"><i
												class="fa fa-plus" aria-hidden="true"></i></a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

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
									<c:forEach var="verb" items="${written}">
									
										<%-- <c:set var="warningName" value="${verb.warningName}" /> --%>
										<tr>
											<td>${verb.date}</td>
											<td>${verb.omWarningStatus}</td>
											<c:choose>
												<c:when test="${verb.omWarningStatus=='Confirmed'}">
													<c:set var="writstatus" value="yes" />
												</c:when>
												<c:otherwise>

												</c:otherwise>
											</c:choose>
											<td>${verb.exception}</td>
											<c:choose>
												<c:when test="${verb.exception=='Yes'}">
													<td>${verb.exceptionReason}</td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<td></td>
										</tr>
									</c:forEach>

								</tbody>
								<tfoot>

									<tr class="new_inp_row_tr">

										<c:set var="today" value="<%=new java.util.Date()%>" />
										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="Received">Received</option>
													</c:when>
													<c:otherwise>
														<option value="Active">Active</option>
														<option value="Confirmed">Confirmed</option>
														<option value="Exception">Exception</option>
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a>
												
												<input type="hidden" id="warningName" name="warningName"
											value="2">
											</th>
									</tr>
								</tfoot>
							</table>
							<c:choose>
								<c:when test="${empty written}">
								</c:when>
								<c:otherwise>
									<!-- Condition to check for role and give the permission to add status -->
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
										<c:otherwise>
											<a class="new_inp_row_a" href="javascript:void(0)"><i
												class="fa fa-plus" aria-hidden="true"></i></a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

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
									<c:forEach var="verb" items="${finals}">
										<c:set var="warningName" value="${verb.warningName}" />
										<tr>
											<td>${verb.date}</td>
											<td>${verb.omWarningStatus}</td>
											<c:choose>
												<c:when test="${verb.omWarningStatus=='Confirmed'}">
													<c:set var="finalstatus" value="yes" />
												</c:when>
												<c:otherwise>

												</c:otherwise>
											</c:choose>
											<td>${verb.exception}</td>
											<c:choose>
												<c:when test="${verb.exception=='Yes'}">
													<td>${verb.exceptionReason}</td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<td></td>
										</tr>
									</c:forEach>

								</tbody>
								<tfoot>

									<tr class="new_inp_row_tr">
										<c:set var="today" value="<%=new java.util.Date()%>" />
										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="Received">Received</option>
													</c:when>
													<c:otherwise>
														<option value="Active">Active</option>
														<option value="Confirmed">Confirmed</option>
														<option value="Exception">Exception</option>
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a>
												
												<input type="hidden" id="warningName" name="warningName"
											value="3">
												</th>
									</tr>
								</tfoot>
							</table>

							<c:choose>
								<c:when test="${empty finals}">
								</c:when>
								<c:otherwise>
									<!-- Condition to check for role and give the permission to add status -->
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
										<c:otherwise>
											<a class="new_inp_row_a" href="javascript:void(0)"><i
												class="fa fa-plus" aria-hidden="true"></i></a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

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
									<c:forEach var="verb" items="${decision}">
										<c:set var="warningName" value="${verb.warningName}" />
										<tr>
											<td>${verb.date}</td>
											<td>${verb.omWarningStatus}</td>
											<c:choose>
												<c:when test="${verb.omWarningStatus=='Confirmed'}">
													<c:set var="descstatus" value="yes" />
												</c:when>
												<c:otherwise>

												</c:otherwise>
											</c:choose>
											<td>${verb.exception}</td>
											<c:choose>
												<c:when test="${verb.exception=='Yes'}">
													<td>${verb.exceptionReason}</td>
												</c:when>
												<c:otherwise>
													<td></td>
												</c:otherwise>
											</c:choose>
											<td></td>
										</tr>
									</c:forEach>

								</tbody>
								<tfoot>

									<tr class="new_inp_row_tr">
										<c:set var="today" value="<%=new java.util.Date()%>" />
										<th><input disabled type="text"
											value="<fmt:formatDate pattern="MM-dd-yyyy" value="${today}" />"
											class="date"></th>
										<th><select class="w_status">
												<c:choose>
													<c:when test="${role=='ARC'}">
														<option value="Received">Received</option>
													</c:when>
													<c:otherwise>
														<option value="Active">Active</option>
														<option value="Confirmed – Fit for Role">Confirmed – Fit for Role</option>
														<option value="Confirmed – Keep Coaching">Confirmed – Keep Coaching</option>
														<option value="Confirmed – Termination">Confirmed – Termination</option>
													</c:otherwise>
												</c:choose>
										</select></th>
										<th><select disabled class="exception">
												<option value="Yes">Yes</option>
												<option selected value="No">No</option>
										</select></th>
										<th><textarea style='display: none;' class="reason"></textarea><br>
											<h6 class="error_msg"></h6></th>
										<th><a class="save_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-floppy-o" aria-hidden="true"></i></a> <a
											class="delete_a icn_oprn" href="javascript:void(0)"><i
												class="fa fa-trash" aria-hidden="true"></i></a>
												
												
												<input type="hidden" id="warningName" name="warningName"
											value="4">
												</th>
									</tr>
								</tfoot>
							</table>
							<c:choose>
								<c:when test="${empty decision}">
								</c:when>
								<c:otherwise>
									<!-- Condition to check for role and give the permission to add status -->
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
										<c:otherwise>
											<a class="new_inp_row_a" href="javascript:void(0)"><i
												class="fa fa-plus" aria-hidden="true"></i></a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>

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
                        $("#" + tbl_id + ' .exception option[value="No"]').attr("selected", "selected");
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
                        if ($(this).val() == "Exception") {
//                            $(this).parent("th").siblings("th").children(".exception").prop("disabled", false);
                            $(this).parent("th").siblings("th").children('.exception').val('Yes').trigger('change');
                            $(this).parent("th").siblings("th").children('.reason').show();
                        } else {
                            $(this).parent("th").siblings("th").children('.exception').val('No').trigger('change');
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
                        var warningNameId = $(this).parent('th').children('input').val();
                        $.ajax({
        					type : 'POST',
        					url : "api/sop/warningStatus/",
        					data : { officeId :officeId , warningName : warningNameId ,date :date , omWarningStatus : w_status ,
        						exception :exception , exceptionReason : reason },
        					dataType : 'json',
        					async : true,
        					success : function(result) {
        						
        						if(result.status == "success"){
        							//alert("faild");
        							t.row.add([
        	                            date,
        	                            w_status,
        	                            exception,
        	                            reason,
        	                            '<a class="icn_oprn"><i class="fa fa-check" aria-hidden="true"></i></a>'
        	                        ]).draw(false);
        	//hide plus button when save received beg
        	                        if (w_status == "Received") {
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