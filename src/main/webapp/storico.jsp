<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.AppointmentDTO, java.util.List, it.contrader.dto.UserDTO"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/storico.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">

<%UserDTO c = (UserDTO) request.getSession().getAttribute("user");%>
.

    <title>Document</title>
</head>
<body>


 <a href="/homeuser.jsp">Home</a>
<div class="nav-bar">
    <img src="/images/hospital-logo.png" class="logo">
    <div class="square"></div>
    <a href="/homeuser.jsp">Home</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>


<div class="wrapper">
                <%
                    List<AppointmentDTO> list = (List<AppointmentDTO>) request.getAttribute("list");
                %>

<div class="visit-wrapper">
    <h1>Storico prenotazioni</h1>

    <!-- CREAZIONE TABELLA -->

    <table id="visit-table">

<%


    for (AppointmentDTO u : list) {

    if (u.getUserId() == c.getId()) {
%>

    <tr>

        <td>data= <%= u.getDate() %></td>
        <td>ora= <%= u.getHour() %></td>
        <td>costo= <%= u.getCost() %></td>

    </tr>
<%
        }
    }
%>

    </table>

</div>
</div>


</body>

</html>