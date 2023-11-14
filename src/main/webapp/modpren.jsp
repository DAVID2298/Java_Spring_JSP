<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AppointmentDTO, it.contrader.dto.MedicalExaminationDTO"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../css/visits.css">
    <link rel="stylesheet" href="../css/adminstyle.css">
    <script src="https://www.w3schools.com/lib/w3data.js"></script>

    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">

    <title>Document</title>
</head>
<body>

    <div w3-include-html="navbar.jsp"></div>

    <div class="wrapper">
        <div class="sidebar">
            <ul>
                <li>
                    <span class="item" href="#" onclick='loadHtml("template","allUsers.html")'>Utenti</span>
                </li>
                <li>
                    <span class="item">Visite</span>
                    <a class="visit-item" href="/medicalExamination/getall" onclick='loadHtml("template","visits.html")'>Tutte le visite</a>
                    <a class="visit-item" href="/addvisit.jsp" onclick='loadHtml("template","addVisit.html")'>Aggiungi nuovo</a>
                </li>
                <li>
                    <span class="item" href="/appointment/getalladmin" onclick='loadHtml("template","prenotazioni.html")'>Prenotazioni</span>

                </li>
                <li>
                    <span class="item" href="/userregistry/read?id=${user.getId()}">Il mio profilo</span>
                </li>
                <li>
                    <span class="item" href="/hospital/read?id=${user.getId()}">Ospedale</span>
                </li>
            </ul>
        </div>


        <div class="wrappa">
            <div class="visit-wrapper">
                <h1>Inserisci la data e ora della prenotazione</h1>
                <%MedicalExaminationDTO c = (MedicalExaminationDTO) request.getAttribute("medto");%>
                <%AppointmentDTO u = (AppointmentDTO) request.getAttribute("dto");%>


                <form class="pren-form" action="/appointment/update?id=<%=u.getId()%>" method="post">
                    <div class="pren-up">
                    <input type="text" name = "date" placeholder="Data">
                    <input type="text" name = "hour" placeholder="Orario">
                    <input type="hidden" name = "cost" value="<%=u.getCost()%>">
                    <input type="hidden" name = "userId" value="<%=u.getUserId()%>">
                    <input type="hidden" name = "meid" value="<%=u.getVisitaId()%>">

                <div class="input-box">

                </div>                    </div>
                    <div class="submit-form-2">
                    <button type="submit">CONFERMA</button>
                    </div>
                </form>
            </div>
        </div>

</body>
<script>
    w3IncludeHTML();
</script>
</html>