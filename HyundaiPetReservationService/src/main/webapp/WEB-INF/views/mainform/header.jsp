<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/thepet/resources/basic/css/menu.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous" ></script>
<style>
   .material-symbols-outlined {
       font-variation-settings:
          'FILL' 0,
          'wght' 400,
          'GRAD' 0,
          'opsz' 48
        }
</style>
</head>
<body>
   <header>
      <div class="header_container">
         <div class="logo_container">
            <img class="logo" src="/thepet/resources/basic/img/thehyundai.png" alt="">
            <div class="user_box">
               <p>
                  <%= request.getParameter("userName") %>
               </p>
               <div class="bell1">
                  <span class="material-symbols-outlined"> notifications </span>
               </div>
            </div>
         </div>
      </div>
      <div class="menu_container">
         <div class="menu_bar">
            <a class="menu-trigger" href="#"> 
               <span></span> 
               <span></span> 
               <span></span>
            </a> 
            <span>Gift</span> <span>New</span> <span>Store In</span> <span>Show-Room</span><span>Re.Green</span> <span>Event</span>
         </div>
         <div class="user_box1"></div>
      </div>
   </header>
   <script src="/thepet/resources/basic/js/rotate.js"></script>
</body>
</html>