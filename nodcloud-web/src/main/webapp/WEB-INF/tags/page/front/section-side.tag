<%@ tag pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!--BEGIN SLIDER -->
<div class="tp-banner-container">
    <div class="tp-banner" id="home">
        <ul>
            <!-- SLIDE  -->
            <li data-transition="fade" data-slotamount="5" data-masterspeed="700">
                <!-- MAIN IMAGE -->
                <img src="${ctx}/assets/img/bg/slide_one.jpg" alt="slidebg1" data-bgfit="cover"
                     data-bgposition="center center" data-bgrepeat="no-repeat">


                <!-- LAYERS -->
                <div class="tp-caption mediumlarge_light_white_center sft tp-resizeme slider"
                     data-x="center" data-hoffset="0"
                     data-y="60"
                     data-speed="500"
                     data-start="800"
                     data-easing="Power4.easeOut"
                     data-endspeed="300"
                     data-endeasing="Power1.easeIn"
                     data-captionhidden="off"
                     style="z-index: 6"><h2 class="text-white custom-font title ">便捷的云服务<br> 一切只为你</h2>

                </div>
                <div class="tp-caption sfb slider tp-resizeme slider"
                     data-x="center"
                     data-hoffset="0"
                     data-y="240"
                     data-speed="800"
                     data-start="1000"
                     data-easing="Power4.easeOut"
                     data-endspeed="300"
                     data-endeasing="Power1.easeIn"
                     data-captionhidden="off"
                     style="z-index: 6"><a href="${ctx}/register"
                                           class="btn btn-purple btn-lg  btn-large m-r-10">马上获得</a>
                </div>
                <div class="tp-caption fade slider tp-resizeme slider"
                     data-x="center"
                     data-hoffset="0"
                     data-y="300"
                     data-speed="500"
                     data-start="800"
                     data-easing="Power4.easeOut"
                     data-endspeed="300"
                     data-endeasing="Power1.easeIn"
                     data-captionhidden="off"
                     style="z-index: 6"><a href="#" class="text-white m-r-10">关注我们的社交网络</a>
                </div>
            </li>
            <li data-transition="fade" data-slotamount="5" data-masterspeed="700">
                <!-- MAIN IMAGE -->
                <img src="${ctx}/assets/img/bg/picture-1.jpg" alt="slidebg2" data-bgfit="cover"
                     data-bgposition="center center" data-bgrepeat="no-repeat">

                <!-- LAYERS -->
                <div class="tp-caption mediumlarge_light_white_center sft tp-resizeme slider"
                     data-x="center" data-hoffset="0"
                     data-y="60"
                     data-speed="500"
                     data-start="800"
                     data-easing="Power4.easeOut"
                     data-endspeed="300"
                     data-endeasing="Power1.easeIn"
                     data-captionhidden="off"
                     style="z-index: 6"><h2 class="text-white custom-font title ">更好的体验<br> 一切只为你</h2>

                </div>
                <div class="tp-caption sfb slider tp-resizeme slider"
                     data-x="center"
                     data-hoffset="0"
                     data-y="240"
                     data-speed="800"
                     data-start="1000"
                     data-easing="Power4.easeOut"
                     data-endspeed="300"
                     data-endeasing="Power1.easeIn"
                     data-captionhidden="off"
                     style="z-index: 6"><a href="${ctx}/register"
                                           class="btn btn-danger btn-lg  btn-large m-r-10">马上获得</a>
                </div>

            </li>
            <!-- SLIDE  -->
            <li data-transition="parallaxtoright" data-slotamount="7" data-masterspeed="1000"
                data-fstransition="fade" data-fsmasterspeed="1000" data-fsslotamount="7">
                <!-- MAIN IMAGE -->
                <img src="${ctx}/assets/video/first-frame.jpg" alt="video_forest" data-bgposition="center center"
                     data-bgfit="cover" data-bgrepeat="no-repeat">

                <!-- LAYERS -->

                <!-- LAYER NR. 1 -->
                <div class="tp-caption tp-fade fadeout fullscreenvideo"
                     data-x="0"
                     data-y="0"
                     data-speed="1000"
                     data-start="1100"
                     data-easing="Power4.easeOut"
                     data-endspeed="1500"
                     data-endeasing="Power4.easeIn"
                     data-autoplay="true"
                     data-autoplayonlyfirsttime="false"
                     data-nextslideatend="true"
                     data-forceCover="1"
                     data-dottedoverlay="twoxtwo"
                     data-aspectratio="16:9"
                     data-forcerewind="on"
                     style="z-index: 2">


                    <video class="video-js vjs-default-skin" preload="none" style="width:100%;height:100%;"
                           poster='${ctx}/assets/video/first-frame.jpg' data-setup="{}">
                        <source src='${ctx}/assets/video/home.mp4' type='video/mp4'/>
                        <source src='${ctx}/assets/video/home.webm' type='video/webm'/>
                        <source src='${ctx}/assets/video/home.ogv' type='video/ogg'/>
                    </video>

                </div>

                <!-- LAYER NR. 2 -->
                <div class="tp-caption large_bold_white_25 customin customout tp-resizeme"
                     data-x="center" data-hoffset="0"
                     data-y="170"
                     data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:5;scaleY:5;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                     data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                     data-speed="600"
                     data-start="1400"
                     data-easing="Power4.easeOut"
                     data-endspeed="600"
                     data-endeasing="Power0.easeIn"
                     style="z-index: 3">云之基石<br/>

                </div>

                <!-- LAYER NR. 3 -->
                <div class="tp-caption medium_text_shadow customin customout tp-resizeme"
                     data-x="center" data-hoffset="0"
                     data-y="bottom" data-voffset="-140"
                     data-customin="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:5;scaleY:5;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                     data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                     data-speed="600"
                     data-start="1700"
                     data-easing="Power4.easeOut"
                     data-endspeed="600"
                     data-endeasing="Power0.easeIn"
                     style="z-index: 4">NodCloud
                </div>
            </li>
        </ul>
        <div class="tp-bannertimer"></div>
    </div>
</div>
<!--END SLIDER

-->