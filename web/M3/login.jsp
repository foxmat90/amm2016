 <%@include file="head1.jsp" %>

        <title>Login</title>

        <%@include file="head2.jsp" %>
    
            
        <br /> 
        <div id="content"> Sezione di navigazione 
        <nav> <a href="M3/descrizione.jsp" > Descrizione </a>
            <a href="M3/cliente.jsp" > Cliente </a>
            <a href="M3/venditore.jsp" > Venditore </a> </nav>
        <br />
        <br />

        <form action="/Amm2016/LoginServlet" method="post">
            <label for="user">Username </label>
            <input type="text" name="user"
                   id="username" value=""  />
            <br />
            <label for="pwd">Password </label>
            <input type="password" name="pwd"
                   id="pswd" value="" />
            <br />
            <input class="button" type="submit" value="Accedi" />
        </form>
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
