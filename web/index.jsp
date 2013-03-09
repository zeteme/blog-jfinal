<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fo'z - Blog</title>
    <link rel="stylesheet" href="/assets/lib/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/lib/bootstrap/css/bootstrap-responsive.min.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/assets/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/lib/underscore.js"></script>
    <script src="/assets/lib/backbone.js"></script>

</head>
<body>
<div class="container">
    <div class="navbar navbar-inverse">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="./index.html">Bootstrap</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active">
                            <a href="#">Home</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="content container">
        <div class="row">
            <div id="side_nav" class="span3">
                <ul class="nav nav-list affix">
                    <li class="active"><a href="#global"><i class="icon-chevron-right"></i> Global styles</a></li>
                    <li class=""><a href="#gridSystem"><i class="icon-chevron-right"></i> Grid system</a></li>
                    <li class=""><a href="#fluidGridSystem"><i class="icon-chevron-right"></i> Fluid grid system</a></li>
                    <li class=""><a href="#post"><i class="icon-chevron-right"></i> post</a></li>
                    <li class=""><a href="#login"><i class="icon-chevron-right"></i> login</a></li>
                </ul>
            </div>
            <div id="blog_list" class="span9"></div>
            <div id="blog_detail" class="hide span9"></div>
        </div>
    </div>
</div>
<div id="dialog">
    <div class="modal fade">
        <div class="modal-header">
            <button type="button" class="close">×</button>
            <h3 class="title">Modal Heading</h3>
        </div>
        <div class="modal-body"></div>
        <div class="modal-footer">
            <button class="btn btn-close">Close</button>
            <button class="btn btn-primary">confirm</button>
        </div>
    </div>
    <div class="modal-backdrop hide fade"></div>
</div>
<script src="/assets/js/app.js"></script>
</body>
</html>