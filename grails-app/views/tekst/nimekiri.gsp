<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <style>

    th {
        background-color: #80bdff;
        text-align: center;
        border-bottom: 1px solid black;
    }

    table {
        border-collapse: collapse;
        width: 75%;
    }
    tr, td { border: none; }

    </style>
    <title></title>
</head>
<body>
<table>
    <tr>
        <th>Faili nimekiri</th>
        <th>Mängi salvestist</th>
        <th>Kustuta fail</th>
    </tr>
    <g:each in="${nimekiri}" var="failiNimi">
        <tr>
            <td>${failiNimi}</td>
            <td>
                <audio controls>
                    <source src="/assets/${failiNimi}" type="audio/wav">
                </audio>
            </td>
            <td>
                <a href="${createLink(controller: 'tekst', action: 'kustuta', params:[failiNimi:failiNimi])}">Kustuta</a>
            </td>
        </tr>
    </g:each>
    </table>
</body>
</html>