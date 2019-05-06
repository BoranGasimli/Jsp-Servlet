<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../common/meta.jsp"/>
    <title>AZEX Index Page</title>
    <jsp:include page="../common/css.jsp"/>
</head>

<body class="fixed-navbar">
<div class="page-wrapper">


    <jsp:include page="header.jsp"/>


    <jsp:include page="menu.jsp"/>

    <div class="content-wrapper">
        <!-- START PAGE CONTENT-->
        <div class="page-content fade-in-up">

            <div class="row">
                <div class="col-lg-8">
                   Xaricdeki unvanlarim
                </div>
            </div>
            <style>
                .visitors-table tbody tr td:last-child {
                    display: flex;
                    align-items: center;
                }

                .visitors-table .progress {
                    flex: 1;
                }

                .visitors-table .progress-parcent {
                    text-align: right;
                    margin-left: 10px;
                }
            </style>
            <div>
                <a class="adminca-banner" href="http://admincast.com/adminca/" target="_blank">
                    <div class="adminca-banner-ribbon"><i class="fa fa-trophy mr-2"></i>PREMIUM TEMPLATE</div>
                    <div class="wrap-1">
                        <div class="wrap-2">
                            <div>
                                <img src="./assets/img/adminca-banner/adminca-preview.jpg" style="height:160px;margin-top:50px;" />
                            </div>
                            <div class="color-white" style="margin-left:40px;">
                                <h1 class="font-bold">ADMINCA</h1>
                                <p class="font-16">Save your time, choose the best</p>
                                <ul class="list-unstyled">
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>High Quality Design</li>
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>Fully Customizable and Easy Code</li>
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>Bootstrap 4 and Angular 5+</li>
                                    <li class="m-b-5"><i class="ti-check m-r-5"></i>Best Build Tools: Gulp, SaSS, Pug...</li>
                                    <li><i class="ti-check m-r-5"></i>More layouts, pages, components</li>
                                </ul>
                            </div>
                        </div>
                        <div style="flex:1;">
                            <div class="d-flex justify-content-end wrap-3">
                                <div class="adminca-banner-b m-r-20">
                                    <img src="./assets/img/adminca-banner/bootstrap.png" style="width:40px;margin-right:10px;" />Bootstrap v4</div>
                                <div class="adminca-banner-b m-r-10">
                                    <img src="./assets/img/adminca-banner/angular.png" style="width:35px;margin-right:10px;" />Angular v5+</div>
                            </div>
                            <div class="dev-img">
                                <img src="./assets/img/adminca-banner/sprite.png" />
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        <!-- END PAGE CONTENT-->
        <jsp:include page="../common/footer.jsp"/>
    </div>
</div>


<jsp:include page="../common/paga.jsp"/>


<!-- CORE PLUGINS-->
<jsp:include page="../common/script.jsp"/>
<script src="../assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
<script src="../assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- PAGE LEVEL PLUGINS-->
<script src="../assets/vendors/chart.js/dist/Chart.min.js" type="text/javascript"></script>
<script src="../assets/vendors/jvectormap/jquery-jvectormap-2.0.3.min.js" type="text/javascript"></script>
<script src="../assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
<script src="../assets/vendors/jvectormap/jquery-jvectormap-us-aea-en.js" type="text/javascript"></script>
<!-- PAGE LEVEL SCRIPTS-->
<script src="../assets/js/scripts/dashboard_1_demo.js" type="text/javascript"></script>
</body>

</html>