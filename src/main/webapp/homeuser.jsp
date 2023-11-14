<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/homeUser.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">

    <title>Home | Hospital</title>
</head>

<body>

    <div class="nav-bar">
        <img src="/images/hospital-logo.png" class="logo">
        <div class="quek">
            <div class="nav-items">
                <a href="/medicalExamination/getvisite">Visite</a>
                <p>|</p>
                <a href="/appointment/getall">Prenotazioni</a>
            </div>

            <div class="prof-wrapper">
                <div class="profile">
                    <i class='bx bx-user-circle'>
                        <div class="dropdown-content">
                            <a href="/userregistry/read?id=${user.getId()}">Profilo</a>
                            <a href="/user/logout" id="logout">Logout</a>
                        </div>
                    </i>
                </div>
            </div>
        </div>
    </div>

    <div class="wrapper">
        <div class="circle">
            <h1>Benvento in Contrader</h1>
            <div class="paragraph">
                <p>Lorem ipsum dolor sit amet. Nam soluta quos id fugiat assumenda et mollitia voluptas ut ratione magni
                    vel explicabo doloribus ut itaque odit. Id dolores quam non dolorum omnis est sunt rerum 33 velit
                    voluptatum At facilis sunt est mollitia maiores. Et quos placeat ea rerum ratione eum tenetur
                    possimus. Ut dolor quos hic quos nemo ut doloremque nobis aut vitae dolorum sed fuga officiis sed
                    exercitationem quod.</p>
            </div>
            <button type="button">SIUM</button>
        </div>
    </div>

    <div class="popup-wrap hidden" id="pop-wrap">
        <div class="popup">

            <h1>Sei sicuro di voler eliminare il tuo profilo?</h1>
            <p>Questa operazione Ã¨ irreversibile. Cliccando su "Elimina" perderai tutti i tuoi dati e lo storico delle tue prenotazioni.</p>
            <div class="dash"></div>
            <div class="sub">
                <button type="button" class="annulla" onclick="closePop()">ANNULLA</button>
                <button type="submit" class="elimina">ELIMINA</button>

        </div>
        </div>
    </div>

</body>
<script>
    let pop = document.getElementById("pop-wrap");
    function closePop(){
        pop.classList.add("hidden");
    }
    function openPop(){
        pop.classList.remove("hidden");
    }

</script>
</html>