<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.MedicalExaminationDTO, it.contrader.dto.UserDTO, it.contrader.dto.AppointmentDTO"%>
    <!DOCTYPE html>
<html lang="en">
<%MedicalExaminationDTO u = (MedicalExaminationDTO) request.getAttribute("dto");%>
<%AppointmentDTO c = (AppointmentDTO) request.getAttribute("app");%>
<%UserDTO d = (UserDTO) request.getSession().getAttribute("user");%>



<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/dettaglio.css">
    <title>Document</title>
</head>

<body>

    <div class="nav-bar">
        <img src="/image/hospital-logo.png" class="logo">
        <div class="square"></div>
        <a href="/homeuser.jsp">Home</a>
    </div>

    <div class="main-wrapper">
        <div class="detail-wrapper">
            <div class="image-wrapper">
            </div>
            <div class="info-wrapper">
                <h1><%=u.getTypology()%></h1>
                <p class="cost"><%=u.getCost()%> euro</p>
                <div class="inline">
                    <div class="tipologia">
                        <h1>TIPOLOGIA</h1>
                        <p><%=u.getTypology()%></p>
                    </div>
                    <div class="codice">
                        <h1>COSTO VISITA</h1>
                        <p><%=u.getCost()%> euro</p>
                    </div>
                </div>
                <h2>CODICE</h2>
                <p><%=u.getCode()%></p>
                <div class="inline">
                    <form action="/appointment/insert" method="post">

                          <input type="hidden" name="date" value="">
                          <input type="hidden" name="hour" value="">
                          <input type="hidden" name="meid" value="<%=u.getId()%>">
                          <input type="hidden" name="cost" value="<%=u.getCost()%>">
                          <input type="hidden" name="typology" value="<%=u.getTypology()%>">
                            <select name="hour" id="hour">
                             <option value="" disabled selected>Scegli orario</option>
                             <option value="15">15:00</option>
                             <option value="18">18:00</option>
                              </select>
                        <button type="submit">PRENOTA</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>