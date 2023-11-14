<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <script src="https://www.w3schools.com/lib/w3data.js"></script> -->
    <script src="https://www.w3schools.com/lib/w3data.js"></script>
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/adminstyle.css">
  
    <title>Admin | Hospital</title>
</head>

<body>

    <div w3-include-html="../navbar.jsp"></div>

    <div class="wrapper">
        <div class="sidebar">
            <ul>
                <li>
                    <a href="/userregistry/getall">Utenti</a>
                </li>
                <li>
                    <span class="item">Visite</span>
                    <a href="/medicalExamination/getall">Tutte le visite</a>
                    <a href="/addvisit.jsp">Aggiungi nuovo</a>
                </li>
                <li>
                    <a href="/appointment/getalladmin">Prenotazioni</span>

                </li>
                <li>
                    <a href="/userregistry/read?id=${user.getId()}">Il mio profilo</a>
                </li>
                <li>
                    <a href="/hospital/read?id=${user.getId()}">Ospedale</a>
                </li>
            </ul>
        </div>
        

        <div id="template" class="template"></div>   
            
    </div>
   
</body>

<script>
    w3IncludeHTML();
</script>
<script src="../script/quek.js"></script>


</html>
