<%@include file="head1.jsp" %>
<title>Cliente</title>
<%@include file="head2.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<br /> 
<div id="content"> Sezione di navigazione 
    <nav> <a href="http://localhost:8080/Amm2016/SimpleRegistration" > Login </a> 
        <a href="descrizione.jsp" > Descrizione </a>
        <a href="LogoutServlet">Logout</a></nav>


    <br /> 
    <br /> 
    
    
    <ul>


</ul>
    


    <table>
        <tr>
            <th>Nome del servizio</th>
            <th>Foto descrittiva</th>
            <th>Quantit√†</th>
            <th>Prezzo</th>
            <th>Link</th>
        </tr>
        
        
         <c:forEach items="${requestScope.listServices}" var="serv">
        <tr>
            <td> <c:out value="${serv.getNameService()}"></c:out> </td>
            <td><img title="foto descrittiva" alt="Foto prodotto alto rischio" 
                     src=<c:out value="${serv.getPicService()}"></c:out> width="50" height="45"></td>
            <td><c:out value="${serv.getNumbersService()}"></c:out></td>
            <td><c:out value="${serv.getPriceService()}"></c:out>¨</td>
            <td><a href="cliente.jsp" > Cliente </a></td>
        </tr>
        </c:forEach>
       
        <tr>
       

</tr>



    </table>

    
</div>
<div id="sidebar" >
    <h2 id="help" class="icon-title">Istruzioni</h2>
    <p>
        Seleziona una delle  voci disponibili nel menu in alto
    </p>
    <ol>
        <li>
            <strong>Venditore</strong> per inserire i dati 
            dei prodotti.
        </li>
        <li>
            <strong>Cliente</strong> per visualizzare i prodotti acquistabili.
        </li>
        <li>
            <strong>Login</strong> per autenticarsi con le proprie credenziali
        </li>
    </ol>
</div>

<div id="footer">
    <p>
        Milestone per l'esame di Amministrazione di Sistema
    </p>
</body>
</html>
