<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <!-- <link rel="stylesheet" href="./css/style.css"> -->
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
                                <i class="bx bx-video"></i>
                                <span>課程管理</span>
                            </div>
                            <div class="nav-link text-dark">
	                          <i class="fa fa-angle-right" aria-hidden="true"></i>
	                          <span class="ms-3">未審核課程</span>
	                        </div>
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                            <span class="ms-3 fw-bold">課程資料</span>
                        </div>
                    </nav>

                    <div class="container-fluid">


                        <div class="row align-items-center">
                            <div class="col-5">
                                <div class="mb-3 ms-4">
                                    <video class="w-100" src="${VideoBean.videoPath}" controls></video>
                                </div>
                            </div>
                            <div class="col-7">
                                <ul class="list-unstyled">
                                    <li>
                                        <label class="col-sm-2 col-form-label-lg">申請教練:</label> 
                                        <span>${VideoBean.coach.member.memberName}</span>
                                    </li>
                                    <li>
                                        <label class="col-sm-2 col-form-label-lg">申請狀態:</label> 
                                        <span>待審核</span>
                                    </li>
                                    <li>
                                        <label class="col-sm-2 col-form-label-lg">申請時間:</label> 
                                        <span>${VideoBean.time}</span>
                                    </li>
                                    <li>
                                        <label class="col-sm-2 col-form-label-lg">審核時間:</label> 
                                        <span>待審核</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                       
                        <ul class="list-unstyled ms-4 mb-5"">
                            <li>
                                <label class="col-sm-2 col-form-label-lg">課程名稱:</label> 
                                <span>${VideoBean.name}</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">器材需求:</label> 
                                <span>${VideoBean.equipment}</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">課程適合對象:</label> 
                                <span>Level${VideoBean.level}</span>
                            </li>

                            <li>
                                <label class="col-sm-2 col-form-label-lg">價錢:</label> 
                                <sapn>${VideoBean.price}</sapn>
                            </li>
                            <li>
                                <label class="col-form-label-lg">課程介紹:</label> 
                                <p class="pe-5">${StringVideoInfo}</p>
                            </li>
                        </ul>
					
                     <form method="post" action="<c:url value='/Course/notCheckCoursePage/checking' />">
                        <div class="d-flex justify-content-center mb-5">
                         <input type="hidden" name="videoId" value="${VideoBean.videoId}">
					       <input type="submit" class="btn-check" name="passOrNot" value="1" id="btn-check-outlined" autocomplete="off">
					       <label class="btn btn-outline-primary  me-5" for="btn-check-outlined">通過</label>
					       <input type="submit" class="btn-check" name="passOrNot" value="0" id="danger-outlined" autocomplete="off">
					       <label class="btn btn-outline-danger ms-5" for="danger-outlined">拒絕</label>

                        </div>
                        </form>
                    </div>



                  

                </div>
            </div>
        </div>
    </section>


</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>