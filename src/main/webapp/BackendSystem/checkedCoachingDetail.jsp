<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

    <section class="member_Backend">
        <div class="container-fluid">
            <div class="row vh-100">
                <!-- 側邊欄 -->
                <jsp:include page="/BackendSystem/sideBar.jsp" />


                <div class="col-10 p-0">
                    <!-- 導覽列 -->
                    <jsp:include page="/BackendSystem/navBar.jsp" />

                    <!-- 次導覽列 -->
                    <nav class="nav_second mb-4 mt-3"> 
                        <div class="nav d-flex align-items-center border-bottom mb-4">
                            <div class="nav-link text-dark">
                                <span>會員管理</span>
                            </div>
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                            <div class="nav-link text-dark">
                                <span>會員列表</span>
                            </div>
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                            <div class="nav-link text-dark fw-bold">
                                <span>教練資料</span>
                            </div>
                        </div>
                    </nav>

                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <div class="col-4">
                                <div class="mb-3 ms-4">
                                    <img class="ratio ratio-1x1" src="<c:url value='${CoachBean.coachImage}' />" alt="">
                                </div>
                            </div>
                            <div class="col-8">
                                <ul class="list-unstyled ms-3">
                                    <li>
                                        <label class="col-auto col-form-label-lg me-3">證照上傳</label> 
                                        <span class="btn btn-outline-dark" data-bs-toggle="modal" data-bs-target="#showPhotoLicense">預覽</span>
                                    </li>
                                    <li>
                                        <label class="col-auto col-form-label-lg me-3">銀行帳戶</label> 
                                        <span>${CoachBean.account}</span>
                                    </li>
                                    <li>
                                        <label class="col-auto col-form-label-lg me-3">申請時間</label> 
                                        <span>${CoachBean.applyTime}</span>
                                    </li>
                                    <li>
                                        <label class="col-auto col-form-label-lg me-3">審核時間</label> 
                                        <span><fmt:formatDate value="${CoachBean.checkTime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></span>
                                    </li>
                                    <li>
                                        <label class="col-auto col-form-label-lg me-3">教練專長</label> 
                                        <span>${CoachBean.skill}</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                
                        <div class="row">
                            <div class="col-7">
                                <ul class="list-unstyled ms-4 mb-5">
                                    <li>
                                        <label class="col-form-label-lg">教練簡介</label> 
                                        <p class="pe-5">${StringCoachInfo}</p>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-5">
                                <ul class="list-unstyled ms-2 mb-5">
                                    <li>
                                        <label class="col-form-label-lg">教練經歷</label> 
                                        <p class="pe-5">${CoachBean.experience}</p>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="d-flex justify-content-center mb-5">
                            <a href="<c:url value='/Member/MemberListPageServlet' />" class="btn btn-outline-primary">
                                <span>回上一頁</span>
                            </a>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </section>

    <!-- 教練證照彈跳視窗 -->
    
    <div class="modal fade" id="showPhotoLicense" tabindex="-1" aria-labelledby="showPhotoLicense" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="showPhotoLicense">教練證照</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <img class="ratio ratio-1x1 " src="${CoachBean.certification }" alt="">
            </div>
          </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>