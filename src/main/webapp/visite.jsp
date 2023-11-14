<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MedicalExaminationDTO, java.util.List"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/visite.css">
    <title>Visite | Hospital</title>
</head>
<body>

    <div class="nav-bar">
        <img src="/images/hospital-logo.png" class="logo">
        <div class="square"></div>
       <a href="/homeuser.jsp">Home</a>
    </div>

    <div class="banner">
        <h1>UN PASSO VERSO <br> UNA VITA PIU SANA</h1>
    </div>

    <div class="search-bar">
        <form>
            <input type="text" name="" id="search-item" placeholder="Ricerca visita" onkeyup="search()">
        </form>
    </div>
    	<%
    		List<MedicalExaminationDTO> list = (List<MedicalExaminationDTO>) request.getAttribute("list");
    	%>



    <div class="visit-wrapper" id="visit-list">

        	                		<%
                            			for (MedicalExaminationDTO u : list) {
                            			if (u.getTypology()!=(null)){

                            		%>
        <div class="card-wrapper" id="card-wrapper">
            <img src="/images/pharma-role-in-healthcare-feature-e1651753319942.jpg" id="card-image">
            <div class="card-elements">
                <div class="info-wrapper">
                    <h1><%=u.getTypology()%></h1>
                    <p class="cost"><%=u.getCost()%></p>
                                </div>
                <button type="button" onclick='window.location.href = "/medicalExamination/read?id=<%=u.getId()%>"' class="btnMod">DETTAGLIO VISITA</button>
            </div>
        </div>
	<%
                                			}
                                		%>
        <%
           }
        %>
    </div>



</body>
<script src="../script/visite.js"></script>
</html>