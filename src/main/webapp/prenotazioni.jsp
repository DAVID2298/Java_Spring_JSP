<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AppointmentDTO, java.util.List, it.contrader.dto.MedicalExaminationDTO"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/visits.css">
    <link rel="stylesheet" href="../css/adminstyle.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <script src="https://www.w3schools.com/lib/w3data.js"></script>


    <title>Document</title>
</head>
<body>


    <div w3-include-html="navbar.jsp"></div>

    <div class="wrapper">
        <div class="sidebar">
            <ul>
                <li>
                    <a href="">Utenti</a>
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



    <div class="wrappa">
        <div class="visit-wrapper">
            <h1>Tutte le prenotazioni</h1>

            <!-- CREAZIONE TABELLA -->
            <div class="table-wrapper">
            	<%
            		List<AppointmentDTO> list = (List<AppointmentDTO>) request.getAttribute("list");
            	%>

            <table id="table">
                <tr>

                    <th>DATA VISITA</th>
                    <th>ORARIO</th>
                    <th>COSTO</th>

                    <th></th>
                </tr>
                <%
                	for (AppointmentDTO u : list) {

                %>
                <tr>
    		<td><%=u.getDate()%></td>
    		<td> <%=u.getHour()%></td>
    		<td> <%=u.getCost()%></td>

    		<td><a href="/appointment/preupdate?id=<%=u.getId()%>"><button>ACCETTAZIONE</button></a>
    		<td><a href="/appointment/delete?id=<%=u.getId()%>"><button>RIFIUTA</button></a>



                </tr>
                                		<%
                                			}
                                		%>
            </table>
            </div>


        </div>


    </div>


</div>
<script>
    w3IncludeHTML();
</script>
<script src="../script/scriptvisite.js"></script>
<script src="../script/prenotazioni.js"></script>


</body>
</html>