<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台畫面</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<style>

    body{
        background-color: black;
    }

    .box{
        background-color: rgba(255, 255, 255, 0.2);
        border: 2px solid white;
    }
    
    .box label{
        color: white;
    }

</style>
<body>


 	<form action="<c:url value='/loginServlet.do' />" method="POST" name="loginForm" >
	    <section class="backend">
	        <div class="container-fluid d-flex flex-column justify-content-center align-items-center" style="height: 100vh;">
	        	<div class="d-flex align-items-center justify-content-center mb-4">
	                <img style="width: 10%;" class="me-3" src="<c:url value='/BackendSystem/image/logo_white.png'></c:url>" alt="">
	                <h1 class="text-white">HomeGym 後台系統</h1>
            	</div>
	            <div class="box col-6 p-4 rounded-3">
	                <div class="mb-3 row align-items-center">
	                    <label for="static" class="fs-5 col-auto col-form-label">員工編號</label>
	                    <div class="col-10">
	                        <input class="form-control form-control-lg" name="staffId" id="static" value="${param.staffId}" type="text" placeholder="請輸入編號" aria-label="form-control-lg example">
	                    </div>
                        <p class="text-danger text-center">${messageKey.accountEmpty}</p>
	                </div>
	                <div class="mb-3 row align-items-center">
	                    <label for="inputPassword" class="fs-5 col-auto col-form-label">員工密碼</label>
	                    <div class="col-10">
	                      <input type="password" class="form-control  form-control-lg" name="staffPassword" id="inputPassword" value="${param.staffPassword}" placeholder="請輸入密碼">
	                    </div>
	                    <p class="text-danger text-center">${messageKey.passwordEmpty}</p>
	                    <p class="text-danger text-center">${messageKey.loginFail}</p>
	                </div>
	                  <div class="d-flex justify-content-center">
	                      <button type="submit" class="btn btn-outline-light ms-2  ps-4 pe-4">登入</button>
	                  </div>
	            </div>
        		
	        </div>
	    </section>
	</form>


</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>