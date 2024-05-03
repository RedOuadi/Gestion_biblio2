<%@ page import="java.util.List" %>
<%@ page import="metier.Livre" %>
<%@ page import="dao.LivreDAOImpl" %>
<%@ page import="dao.IlivreDao" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% IlivreDao Ilivre = new LivreDAOImpl();
    List<Livre> Livres = Ilivre.LivreParMc("");
    System.out.println(Livres.get(0));
%>


<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>heeelo zen hanii</h1>
<table>
    <tr>
        <td>id</td>
        <td>titre</td>
        <td>auteur</td>
        <td>editeur</td>
        <td>annee pub </td>
        <td>genre</td>

    </tr>
    <% for (Livre livre : Livres){%>

<tr>
    <td> <%= livre.getId_livre()%></td>
    <td> <%= livre.getTitre_livre()%></td>

    <td> <%= livre.getAuteur_livre()%></td>
    <td> <%= livre.getEditeur_livre()%></td>
    <td> <%= livre.getDate_pub()%></td>
    <td> <%= livre.getGenre()%></td>

</tr>
</table>
<% } %>
</body>
</html>
