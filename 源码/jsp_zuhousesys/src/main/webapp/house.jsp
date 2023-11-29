<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LCL短租民宿</title>
    <link rel="stylesheet" href="css/house.css">
    <script src="js/jquery-1.12.4.js"></script>
</head>
<body>
<!-- head -->
<div class="header">
    <!-- top -->
    <div class="head-top">
        <div class="top-link">
            <p>你好，user <a href="userLogin.html">[退出]</a></p>
        </div>
    </div>
    <!-- top -->

    <!-- bottom -->
    <div class="head-bottom">
        <div class="logo">
            <img src="img/logo.png" alt="logo">
        </div>
        <div class="nav clearfix">
            <ul>
                <li><a href="javascript:;">首页</a></li>
                <li class="index-a sort-nav"><a href="HouseServlet?sort=null">短租民宿</a></li>
                <li class="search-nav"><a href="javascript:;">民宿查询</a></li>
                <li><a href="OrderPageServlet?status=1">查看订单</a></li>
                <li><a href="HistoryOrderServlet?status=-1">历史订单</a></li>
             </ul>
        </div>
    </div>
    <!-- bottom -->
</div>
<!-- head -->


<!-- house-bady -->
<div class="house-bady clearfix">
    <!-- sort -->
    <div class="sort clearfix">
        <ul class="clearfix">
            <li class="default current-sort"><a href="javascript:;">默认排序</a></li>
            <li class="desc"><a href="javascript:;">按租金</a><span><img src="img/sort.png" alt="sort"></span></li>
            <li class="asc"><a href="javascript:;">按租金</a><span><img src="img/sort.png" alt="sort"></span></li>
        </ul>
        <span></span>
    </div>
    <!-- sort -->

    <%-- search --%>
    <div class="search clearfix">
        <button id="search-but">搜索</button>
        <input type="text" id="search-txt">
    </div>
    <%-- search --%>

    <div class="houseTypeList clearfix">
        <%-- div模板
            <div class="houselist clearfix  ">
                <ul>
                    <li>
                        <div class="house-img">
                            <img src="images/雪佛兰新科鲁兹.jpg"/>
                        </div>
                    </li>
                    <li>
                        <div class="houseinfo">
                            <p class="name">雪佛兰新科鲁兹</p>
                            <p class="info">三厢|1.5自动|乘坐5人</p>
                        </div>
                    </li>
                    <li>
                        <div class="price">
                            <span class="rmb">￥</span>
                            <span class="num">534</span>
                            <span class="unit">/套餐价</span>
                        </div>
                        <div class="price-a"><a href="javascript:;">套餐预约</a></div>
                    </li>
                </ul>
            </div>
            --%>
        <%-- 通过jstl循环产生div --%>

        <c:forEach var="house" items="${houses}">
            <div class="houselist clearfix">
                <ul>
                    <li>
                        <div class="house-img">
                            <img src="${house.cimg}"/>
                        </div>
                    </li>
                    <li>
                        <div class="houseinfo">
                            <p class="name">${house.cname}</p>
                            <p class="info">${house.cinfo}</p>
                        </div>
                    </li>
                    <li>
                        <div class="price">
                            <span class="rmb">￥</span>
                            <span class="num">${house.crent}</span>
                            <span class="unit">/套餐价</span>
                        </div>
                        <div class="price-a"><a href="OrderServlet?cid=${house.cid}">套餐预约</a></div>
                    </li>
                </ul>
            </div>
        </c:forEach>

    </div>
</div>
<!-- house-bady -->

</body>

<script>
    $(function () {
        $(".nav>ul>li").click(function () {
            $(this).addClass("index-a").siblings().removeClass("index-a");
        });

        $(".sort > ul > li").click(function () {
            $(this).addClass("current-sort").siblings().removeClass("current-sort");
        });

        //sort ajax实现排序
        $(".desc").click(function () {
            $.get(
                "HouseServlet",
                "sort=" + "desc",
                function (result) {
                    $(".houselist").remove();
                    console.log(typeof (result));
                    $.each(result, function (key, value) {
                        var str = jsonToStr(value);
                        $(".houseTypeList").append(str);
                    });
                }, "json"
            );
        });

        $(".asc").click(function () {
            $.get(
                "HouseServlet",
                "sort=" + "asc",
                function (result) {
                    $(".houselist").remove();

                    $.each(result, function (key, value) {
                        var str = jsonToStr(value);
                        $(".houseTypeList").append(str);
                    });
                }, "json"
            );
        });

        //按cname排序
        $(".default").click(function () {
            $.get(
                "HouseServlet",
                "sort=" + "default",
                function (result) {
                    $(".houselist").remove();

                    $.each(result, function (key, value) {
                        var str = jsonToStr(value);
                        $(".houseTypeList").append(str);
                    });
                }, "json"
            );
        });

        //判断可用民宿屋
        // *共有种民宿型可以租用

        $(".sort>span").text("*共有" + $(".houselist").length + "种民宿型可以租用")
    });

    //点击导航栏，切换短租民宿和搜索栏目
    $(".sort-nav").click(function () {
        $(".sort").css("display", "block");
        $(".search").css("display", "none");
    });

    $(".search-nav").click(function () {
        $(".sort").css("display", "none");
        $(".search").css("display", "block");
    });

    //点击搜索按钮
    $("#search-but").click(function () {
        $.post(
            "HouseSearchServlet",
            {cname: $("#search-txt").val()},
            function (data) {
                $(".houselist").remove();

                $.each(data, function (key, value) {
                    var str = jsonToStr(value);
                    $(".houseTypeList").append(str);
                });

            }, "json"
        );
    });

    function jsonToStr(value) {
        var str = "<div class=\"houselist clearfix\">\n" +
            "                <ul>\n" +
            "                    <li>\n" +
            "                        <div class=\"house-img\">\n" +
            "                            <img src= " + value.cimg + ">\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <div class=\"houseinfo\">\n" +
            "                            <p class=\"name\">" + value.cname + "</p>\n" +
            "                            <p class=\"info\">" + value.cinfo + "</p>\n" +
            "                        </div>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <div class=\"price\">\n" +
            "                            <span class=\"rmb\">￥</span>\n" +
            "                            <span class=\"num\">" + value.crent + "</span>\n" +
            "                            <span class=\"unit\">/套餐价</span>\n" +
            "                        </div>\n" +
            "                        <div class=\"price-a\"><a href=\"OrderServlet?cid=" + value.cid + "\">套餐预约</a></div>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "            </div>";
        // console.log(str);
        return str;
    }

</script>

</html>