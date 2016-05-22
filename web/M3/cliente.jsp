       <%@include file="head1.jsp" %>
        <title>Cliente</title>
              <%@include file="head2.jsp" %>

        
        <br /> 
        <div id="content"> Sezione di navigazione 
        <nav> <a href="http://localhost:8080/Amm2016/SimpleRegistration" > Login </a> 
            <a href="descrizione.jsp" > Descrizione </a></nav>

        <br /> 
        <br /> 
        
        <table>
            <tr>
                <th>Nome del servizio</th>
                <th>Foto descrittiva</th>
                <th>Quantità</th>
                <th>Prezzo</th>
                <th>Link</th>
            </tr>
            <tr>
                <td> Prodotto finanziario alto rischio </td>
                <td><img title="foto descrittiva" alt="Foto prodotto alto rischio" 
                         src="alto.jpg" width="50" height="45"></td>
                <td>1</td>
                <td>150 €</td>
                <td><a href="cliente.jsp" > Cliente </a></td>
            </tr>
            <tr>
                <td>Prodotto finanziario medio-alto rischio</td>
                <td><img title="foto descrittiva" alt="Foto prodotto medio alto rischio" 
                         src="medioalto.jpg" width="50" height="45"></td>
                <td>1</td>
                <td>125 €</td>
                <td><a href="cliente.jsp" > Cliente </a></td>
            </tr>
            <tr>
                <td>Prodotto finanziario medio rischio</td>
                <td><img title="foto descrittiva" alt="Foto prootto medio rischio" 
                         src="medio.jpg" width="50" height="45"></td>
                <td>1</td>
                <td>100 €</td>
                <td><a href="cliente.jsp" > Cliente </a></td>
            </tr>
            <tr>
                <td>Prodotto finanziario medio-basso rischio</td>
                <td><img title="foto descrittiva" alt="Foto prodotto medio basso rischio" 
                         src="mediobasso.jpg" width="50" height="45"></td>
                <td>1</td>
                <td>75 €</td>
                <td><a href="cliente.jsp" > Cliente </a></td>
            </tr>
            <tr>
                <td>Prodotto finanziario basso rischio</td>
                <td><img title="foto descrittiva" alt="Foto prodotto basso rischio" 
                         src="basso.jpg" width="50" height="45"></td>
                <td>1</td>
                <td>50 €</td>
                <td><a href="cliente.jsp" > Cliente </a></td>
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
