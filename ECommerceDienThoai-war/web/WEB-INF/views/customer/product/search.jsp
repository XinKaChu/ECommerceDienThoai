<%-- 
    Document   : search
    Created on : Dec 15, 2017, 1:22:46 AM
    Author     : DacTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container" style="width: 100%">

    <!-- BỘ LỌC BÊN TRÁI -->
    <div class="col-md-3 w3ls_mobiles_grid_left">
        <div class="w3ls_mobiles_grid_left_grid">
            <h3>Khoảng giá</h3>
            <div class="w3ls_mobiles_grid_left_grid_sub">
                <div class="ecommerce_color ecommerce_size">
                    <ul>
                        <li><a href="#">< 1 triệu</a></li>
                        <li><a href="#">1 - 3 triệu</a></li>
                        <li><a href="#">3 - 7 triệu</a></li>
                        <li><a href="#">7 - 10 triệu</a></li>
                        <li><a href="#">10 - 15 triệu</a></li>
                        <li><a href="#">> 15 triệu</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="w3ls_mobiles_grid_left_grid">
            <h3>Màn hình</h3>
            <div class="w3ls_mobiles_grid_left_grid_sub">
                <div class="ecommerce_color ecommerce_size">
                    <ul>
                        <li><a href="#">&lt; 4 inch</a></li>
                        <li><a href="#">4 - 5 inch</a></li>
                        <li><a href="#">5 - 6 inch</a></li>
                        <li><a href="#">&gt; 6 inch</a></li>

                    </ul>
                </div>
            </div>
        </div>

        <div class="w3ls_mobiles_grid_left_grid">
            <h3>Ram</h3>
            <div class="w3ls_mobiles_grid_left_grid_sub">
                <div class="ecommerce_color ecommerce_size">
                    <ul>
                        <li><a href="#">< 1 GB</a></li>
                        <li><a href="#">1 - 2 GB</a></li>
                        <li><a href="#">2 - 3 GB</a></li>
                        <li><a href="#">> 3 GB</a></li>

                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- /BỘ LỌC BÊN TRÁI -->

    <!-- SẢN PHẨM BÊN PHẢI -->
    <div class="col-md-9 wthree_banner_bottom_right">
        <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">

            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
                    <div class="w3ls_mobiles_grid_right_grid2" style="margin: 0;">
                        <div class="w3ls_mobiles_grid_right_grid2_left">
                            <h3 style="margin: 0;font-size: 1.5em;">Kết quả cho từ khóa: ${keywords}</h3>
                        </div>
                        <!--                        <div class="w3ls_mobiles_grid_right_grid2_right">
                                                    <select name="select_item" class="select_item">
                                                        <option selected="selected">Default sorting</option>
                                                        <option>Sort by popularity</option>
                                                        <option>Sort by average rating</option>
                                                        <option>Sort by newness</option>
                                                        <option>Sort by price: low to high</option>
                                                        <option>Sort by price: high to low</option>
                                                    </select>
                                                </div>-->
                        <div class="clearfix"> </div>
                    </div>

                    <div class="agile_ecommerce_tabs">


                        <c:forEach var="sp" items="${list}">
                            <!-- SẢN PHẨM -->
                            <div class="item" style="width: 25%; float: left;">
                                <div class="item-container" style="background-color: white; border: 1px solid;position: relative">
                                    <a href="product/detail/${sp.id}.php">
                                        <c:if test="${sp.soLuong <= 0}">
                                            <img src="assets/images/hethang.png" style="top: 0;right: 0;width: 100px;position: absolute;">
                                        </c:if>
                                        <div class="item-img" style="height: 250px; ">
                                            <img src="assets/images/products/${sp.hinhAnh}" style="">
                                        </div>
                                        <div class="item-info">
                                            <div class="item-name">${sp.tenMay}</div>
                                            <div class="item-price">
                                                <fmt:formatNumber type="number" value="${sp.giaBan}" pattern="###,###,###" /> VND
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <!-- /SẢN PHẨM -->
                        </c:forEach>


                        <!--                        <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test2.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Iphone 6s lock 16Gb Grey</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                        
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test3.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                        
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test2.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                        
                        
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test3.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                        
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                        
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test3.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                        
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test2.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                
                                                <div class="item" style="width: 25%; float: left;">
                                                    <div style="background-color: white; border: 1px solid;">
                                                        <a href="#">
                                                            <div class="item-img" style="height: 250px; ">
                                                                <img src="assets/customer/images/test.jpg" style="">
                                                            </div>
                                                            <div class="item-info">
                                                                <div class="item-name">Samsung</div>
                                                                <div class="item-price">18.000.000 VND</div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>-->

                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div> 
    </div>
    <!-- /SẢN PHẨM BÊN PHẢI -->
    <div class="clearfix"> </div>

    <!-- Thương hiệu -->
    <div class="top-brands">
        <div class="container">
            <h3>Top Brands</h3>
            <div class="sliderfig">
                <div class="nbs-flexisel-container"><div class="nbs-flexisel-inner"><ul id="flexiselDemo1" class="nbs-flexisel-ul" style="left: -285px; display: block;">			
                            <li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb5.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb1.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb2.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb3.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb4.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb5.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb1.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb2.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb3.jpg" alt=" " class="img-responsive">
                            </li><li class="nbs-flexisel-item" style="width: 285px;">
                                <img src="assets/customer/images/tb4.jpg" alt=" " class="img-responsive">
                            </li></ul><div class="nbs-flexisel-nav-left" style="top: 22.5px;left:0"></div><div class="nbs-flexisel-nav-right" style="top: 22.5px;right:0"></div></div></div>
            </div>
            <script type="text/javascript">
                $(window).load(function () {
                    $("#flexiselDemo1").flexisel({
                        visibleItems: 4,
                        animationSpeed: 1000,
                        autoPlay: true,
                        autoPlaySpeed: 3000,
                        pauseOnHover: true,
                        enableResponsiveBreakpoints: true,
                        responsiveBreakpoints: {
                            portrait: {
                                changePoint: 480,
                                visibleItems: 1
                            },
                            landscape: {
                                changePoint: 640,
                                visibleItems: 2
                            },
                            tablet: {
                                changePoint: 768,
                                visibleItems: 3
                            }
                        }
                    });

                });
            </script>
        </div>
    </div>
</div>
