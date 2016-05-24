       <%@include file="head1.jsp" %>
        <title>Venditore</title>
               <%@include file="head2.jsp" %>

        <br /> 
       
        <div id="content"> Sezione di navigazione 
        <nav>  <a href="http://localhost:8080/Amm2016/SimpleRegistration" > Login </a> 
            <a href="descrizione.jsp" > Descrizione </a> </nav>

        <br /> 
        <br /> 
        <form action="user_form.asp" method="get">

            <table>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td> <label for="nome_oggetto">Nome dell'oggetto</label> </td>
                    <td>    <input type="text" name="nome_oggetto"
                                   id="nome_oggetto" value="" /></td>

                </tr>
                <tr>
                    <td><label for="url_immagine">Immagine dell'oggetto</label></td>
                    <td><input type="url" name="url_immagine"
                               id="url_immagine" value="" /></td>

                </tr>
                <tr>
                    <td><label for="descr">Descrizione dell'oggetto</label></td>
                    <td><textarea rows=4 cols=20 name="descr" id="descr">
                        </textarea></td>

                </tr>
                <tr>
                    <td><label for="prezzo">Prezzo</label></td>
                    <td><input type="number" name="prezzo"
                               id="prezzo" value="" /></td>

                </tr>
                <tr>
                    <td><label for="quantita'">Quantita'</label></td>
                    <td> <input type="number" name="quantita'"
                                id="quantita'" value="" /></td>

                </tr>

            </table>
            <input class="button" type="submit" value="Invia dati" />
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

                </div> 


    </body>
   
                   
</html>
