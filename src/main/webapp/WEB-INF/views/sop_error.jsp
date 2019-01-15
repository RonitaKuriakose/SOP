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
        <%-- <link rel="icon" type="image/icon" href="<c:url value="/resources/css/images/favicon.ico" />"/> --%>
        <link rel="icon" type="image/icon" href="<c:url value="/resources/css/images/favicon.ico" />" />





        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">


        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>



       <%--  <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"> --%>
       <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">


    </head>

    <body>

        <header class="header_class">
            <!--<div class="container">-->
            <div class="col-sm-12 header_12 m0p0">
                <%-- <img src="<c:url value="/resources/css/images/logo.png" />" class="logo" /> --%>
                <img src="<c:url value="/resources/css/images/logo.png" />" class="logo" />
            </div>

            <div class="container-fluid sop_fluid m0p0">
                <div class="sop_container">
                    <div class="col-sm-12 sop_hed_12 m0p0">
                        <div class="col-sm-6">
                            <h3 class="hedh3">SOP ACCOUNTABILITY STATUS</h3>
                        </div>
                        <div class="col-sm-6">
                            <h3 class="userh3"><i class="fa fa-user" aria-hidden="true"></i> <span class="user_span">Vishnulal UC</span><span class="logout"><a href="javascript:void(0)">Logout</a></span></h3>
                        </div>
                    </div>
                </div>
            </div>
            <!--</div>-->

        </header>


        <div class="container-fluid m0p0">
            <div class="_404_parent">
                <div class="">
                   
                    <h1 class="_404"><label>404</label> PAGE NOT FOUND</h1>
                    <a href="#" class="return_home">Return to Home</a>

                </div>


            </div>
        </div>










        <footer>

            <script>



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

                        $("input.serrr").val(this.value.replace(/^ /g, ""));

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