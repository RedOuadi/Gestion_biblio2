<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.MembreDAOImpl, metier.Membre" %>

<html>
<head>
    <title>Update Profile</title>
</head>
<body>

<%
    String username = null;
    Membre membre = null;

    // Récupérer le nom d'utilisateur de la session
    Object usernameObj = session.getAttribute("username");
    if (usernameObj != null) {
        username = (String) usernameObj;
        // Récupérer le membre à partir de son nom d'utilisateur
        MembreDAOImpl membreDAO = new MembreDAOImpl();
        membre = membreDAO.getMembreByUsername(username);
    }
%>

<h1>Update Profile</h1>

<form action="updateProfile" method="post">
    <!-- Ne pas inclure le champ "id" s'il ne doit pas être modifié -->
    <!-- <input type="hidden" name="id" value="<%= membre.getId_membre() %>"> -->
    <label for="username">Username:</label>
    <% if (membre != null) { %>
    <input type="text" id="username" name="username" value="<%= membre.getUsername() %>" required><br>
    <% } %>
    <label for="password">Password:</label>
    <% if (membre != null) { %>
    <input type="password" id="password" name="password" value="<%= membre.getPassword() %>" required><br>
    <% } %>
    <label for="nom_membre">Nom:</label>
    <% if (membre != null) { %>
    <input type="text" id="nom_membre" name="nom_membre" value="<%= membre.getNom_membre() %>" required><br>
    <% } %>
    <label for="adresse">Adresse:</label>
    <% if (membre != null) { %>
    <input type="text" id="adresse" name="adresse" value="<%= membre.getAdresse() %>"><br>
    <% } %>
    <label for="tele">Téléphone:</label>
    <% if (membre != null) { %>
    <input type="text" id="tele" name="tele" value="<%= membre.getTele() %>"><br>
    <% } %>
    <input type="submit" value="Update">
</form>

</body>
</html>





