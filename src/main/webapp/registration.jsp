<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/regstyle.css">
    <script src="./script/regscript.js"></script>
    <title>Registration | Hospital</title>
</head>
<body>

    <div class="up-bar">
        <img src="images/hospital-logo.png" class="logo">
    </div>

    <div class="wrapper">
        <h1>Registrati</h1>
        <p>Inserisci i tuoi dati e procedi con la registrazione</p>
        <div class="divider"></div>
        <div class="steps-wrapper">
            <div class="step-number" id="1">1</div>
            <p class="" id="p1">Accesso</p>
            <p> > </p>
            <div class="blank"></div>
            <div class="step-number unsigned" id="2">2</div>
            <p class="punsigned" id="p2">Anagrafica</p>
        </div>
        <div class="para">CREDENZIALI DI ACCESSO</div>

        <!-- FORM REGISTRAZIONE -->

        <form id="form-a" action="/user/insert" method="post">
            <div class="form-wrapper" id="tab1">
                <div class="input-box">
                    <input type="text" name="username" placeholder="Username" spellcheck="false" required>
                </div>
                <div class="input-box">
                    <input type="password" name="password" placeholder="Password" spellcheck="false" id="myPsw" required>
                </div>
                <div class="input-box">
                    <select name="usertype" id="usertype">
                        <option value="1" disabled selected>Tipo di utente</option>
                        <option value="ADMIN">Admin</option>
                        <option value="USER">User</option>
                    </select>
                </div>
            </div>
        </form>
 <div class="divider"></div>

               <div class="choices1" id="choice1">
                   <p><a href="/index.html">TORNA ALLA LOGIN</a></p>
                   <button type="submit" form="form-a" id="nxtBtn">AVANTI</button>
               </div>

</body>
</html>