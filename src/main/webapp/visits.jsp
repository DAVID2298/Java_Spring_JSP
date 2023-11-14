<%@ page import="it.contrader.dto.MedicalExaminationDTO" import="java.util.*"%>
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
    <div w3-include-html="./navbar.jsp"></div>

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
                            <a href="/appointment/getalladmin">Prenotazioni</a>

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


    <div class="wrappa">
        <div class="visit-wrapper">
            <h1>Tutte le visite</h1>

            <!-- CREAZIONE TABELLA -->
            <div class="table-wrapper" id="visit-table">
	<%
		List<MedicalExaminationDTO> list = (List<MedicalExaminationDTO>) request.getAttribute("list");
	%>
	            <table
                <tr>

                    <th>TIPOLOGIA</th>
                    <th>COSTO</th>
                    <th>CODICE</th>
                    <th></th>
                </tr>
                		<%
                			for (MedicalExaminationDTO u : list) {
                			if (u.getTypology()!=(null)){
                		%>
	<tr

        			<td>
		<td><%=u.getTypology()%></td>
		<td> <%=u.getCost()%></td>
		<td> <%=u.getCode()%></td>
		<td><a href="/medicalExamination/preupdate?id=<%=u.getId()%>">Edit</a></td>
        <td><a href="/medicalExamination/delete?id=<%=u.getId()%>">Delete</a></td>
        <td><a href="/medicalExamination/read?id=<%=u.getId()%>">Dettaglio</a></td>



	</tr>

                    </td>
                 		<%
                                			}
                                		%>
                		<%
                			}
                		%>
            </table>
            </div>

        </div>


    </div>

    <div class="charts">
            <div class="chart-wrapper">
                <div class="chart">
                    <canvas class="myChart" id="myChart" width="180"></canvas>
                </div>
            </div>
                 <div class="chart-pren-wrapper">
                        <canvas class="myChart2" id="myChart2"></canvas>
                    </div>
        </div>
                    </div>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>


    <script>

    var table = document.getElementById("visit-table"), rIndex;
    var firstChilds = table.querySelectorAll("td:first-child");
    var allName = [];
    for(i=0; i<firstChilds.length; ++i){
      allName.push(firstChilds[i].innerHTML);
    }

    var map = allName.reduce((cnt, cur) => (cnt[cur] = cnt[cur] + 1 || 1, cnt), {});

    // map is an associative array mapping the elements to their frequency:
    console.log(map);

    let value2 = Object.values(map);
    let key = Object.keys(map);
    console.log(value2);

    const ctx = document.getElementById('myChart');

      new Chart(ctx, {
        type: 'doughnut',
        data: {
          labels: key,
          datasets: [{
            label: '# of Visits',
            data: value2,
            borderWidth: 2
          }]
        },
        options: {

          scales: {
            y: {
                display: false
            },
            x: {
                display: false
            }
          }
        }
      });


    </script>

    <script>
        const cts = document.getElementById('myChart2').getContext('2d');
        var gradient = cts.createLinearGradient(0, 0, 0, 300);
        gradient.addColorStop(0, 'rgba(52, 235, 128)');
        gradient.addColorStop(1, 'rgba(52, 235, 128, 0.4)')
        gradient.addColorStop(1, 'rgba(52, 235, 128, 0.3)');


    new Chart(cts, {
      type: 'line',
      data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'Agust', 'September', 'October', 'November', 'December', ],
        datasets: [{
          label: '# of Votes',
          data: [12, 19, 3, 5, 2, 3, 4, 8, 20, 12, 11, 5],
          borderWidth: 2,
          borderColor: 'rgba(52, 235, 128)',
          backgroundColor: gradient,
          pointBackgroundColor: 'white',
          pointBorderColor:'rgba(52, 235, 128)',
          fill: true
        }]
      },
      options: {

        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
    </script>


</div>
</body>
<script>
    w3IncludeHTML();
</script>
</html>