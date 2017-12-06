<%-- 
    Document   : banner
    Created on : Nov 16, 2017, 3:33:37 PM
    Author     : DacTien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cart" value="${sessionScope['scopedTarget.cart']}"/>

<div class="container" style="    width: 100%;
     background-color: #333333;
     /*    										position: fixed;
                                                                                     z-index: 1000;*/
     background: url(assets/customer/images/banner4.jpg);">
    <c:choose>
        <c:when test="${empty sessionScope.nguoiMua}">
            <div class="col-sm-12 log-in" style="margin-top: 5px">
                <span style="float: right; color: red;">
                    <a href="#" data-toggle="modal" data-target="#myModal88" id="check-dang-nhap">
                        Đăng nhập
                    </a>
                </span>
                <span style="float: left; color: red">
                    <a href="merchant/account/index.php">
                        Kênh người bán
                    </a>
                </span>
                <div class="clearfix"></div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="col-sm-12 log-in" style="margin-top: 5px"  id="check-dang-nhap">
                <!--                <a href="#" class="dropdown" style="float: right; color: white;font-size: 16px;">
                                    Chào ${sessionScope.nguoiMua.hoTen}
                                </a>-->

                <div  style="float: right; font-size: 16px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="check-dang-nhap">
                        Chào ${sessionScope.nguoiMua.hoTen}
                    </a>
                    <ul class="dropdown-menu list-unstyled" style="right: 0; left: 86%">
                        <li><a href="account/edit.php">Tài khoản của tôi</a></li>
                        <li><a href="#">Đơn hàng đã mua</a></li>
                        <li><a href="account/logoff.php">Đăng xuất</a></li>
                    </ul>
                </div>
                <!--                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <span class="glyphicon glyphicon-user"></span><span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="account/login.php">a</a></li>
                                        <li><a href="account/forgot.php">b</a></li>
                                        <li><a href="account/register.php">c</a></li>
                                    </ul>
                                </li>-->
            </div>

            <div class="clearfix"></div>
        </c:otherwise>
    </c:choose>


    <div class="w3l_logo" style="margin-left: 0em; padding-top: 5px;" id="home1">
        <a href="home/index.php">
            <h1>
                <img src="assets/customer/logo/pikachu.png" style="width: 70px ">
                <span style="font-size: 30px;margin-left: -10px;font-family: fantasy;color: #fcd458">DIGIWORLD</span>
            </h1>
        </a>
    </div>
    <form>
        <input type="text" name="search" placeholder="Tìm sản phẩm" style="margin-top: 8px;height: 40px;margin-left: 100px;width: 700px;/*background-image: url('logo/search-32.png');*/padding: 12px 20px 12px 10px;" >
        <button class="btn btn-primary my-btn-search">
            <span class="glyphicon glyphicon-search"></span>
        </button>
        <div class="cart cart box_1 row my-cart" style="margin-right: 0"> 
            <ul style="float: left;color: white; font-size: 16px; padding-top: 4px; margin-right: 10px" class="list-unstyled">
                    <li><span id="count">${cart.count}</span> sản phẩm</li>
<!--                    <li>0 VND</li>-->
            </ul>
            <input type="hidden" name="display" value="1" />
            <a href="shopping-cart/view.php" class="w3view-cart" style="position: inherit;margin-right: 30px;"><i class="fa fa-cart-arrow-down" aria-hidden="true" ></i></a> 
        </div>
    </form>

</div>

<div class="banner" class="banner" style="padding-top: 0">
    <div class="container" style="position: relative;">
        <img src="assets/customer/logo/smart-phone-banner-5.jpg" class="banner-img">
        <h3 class="banner-slogan" style="margin-top: auto; margin-left: 7%">
            TRẢI NGHIỆM PHONG CÁCH MUA SẮM TRỰC TUYẾN HIỆN ĐẠI VỚI 
            <span style="font-size: 2em;margin: 1em 1em 1em 2em;color: #fcd458; font-family: fantasy;">
                DIGIWORLD
            </span>
        </h3>
    </div>
</div>