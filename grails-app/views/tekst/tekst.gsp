<!DOCTYPE html>
<html>
<head>
    <style>
    input {
        background-color: #0056b3;
        border: none;
        color: white;
        padding: 15px 25px;
        text-align: center;
        font-size: 18px;
        cursor: pointer;
    }

    </style>
</head>
<div class="header" style="background-color: #80bdff; color: #fefefe">
    <br/>
    <h1 style="text-align: center">Teksti helindamine</h1>
    <p style="text-align: center">CGI testöö</p>
    <p style="text-align: right">Töö teostaja: Margit Aun</p>
</div>
<body style="background-color:#fefefe">
<div align="center" color="80bdff">
<g:form controller="tekst" action="helinda">
    <div align="center" color="#3C89E3">
    <label>Sisesta helindatav tekst: </label>
    <br />
    </div>
    <g:textArea name="helindatavTekst" rows="5" cols="40"/><br/><br/>
    <g:actionSubmit value="Helinda"/>

</g:form>
</div>
<div align="center" color="#0c5460">
<br/>
<a href="${createLink(controller: 'tekst', action: 'nimekiri')}">Olemasolevad failid</a>
</div>
</body>
</html>
