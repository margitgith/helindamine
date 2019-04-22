<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>helinda</title>
</head>

<body>
<h1 style="background-color: #80bdff">Mängi ette salvestatud fail: ${failiNimi}</h1>

<audio controls>
    <source src="/assets/${failiNimi}" type="audio/wav">
</audio>
<br />
<br/>
<a href="${createLink(controller: 'tekst', action: 'nimekiri')}">Olemasolevad failid</a>
<br />
<br />

</body>
</html>