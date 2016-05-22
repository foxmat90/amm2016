/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author foxma
 */
public class Factory {
    
    
    Factory()
    {
        
    }
   
   public List<Esame> FactoryMethod()
   {
       
    List<Esame> esami = new ArrayList<>();
    Esame esame1 = new Esame();
    Esame esame2 = new Esame();
    Esame esame3 = new Esame();
    esame1.setNomeStudente("Edoardo");
    esame1.setCognomeStudente("Cazzaro");
    esame1.setMatricolaStudente("12345");
    esame1.setNomeEsame("Amm");
    esame1.setVoto("30");
    esami.add(esame1);
    esame2.setNomeStudente("Giacomo");
    esame2.setCognomeStudente("Cintu");
    esame2.setMatricolaStudente("00000");
    esame2.setNomeEsame("Psi");
    esame2.setVoto("29");
    esami.add(esame2);
    esame3.setNomeStudente("Nicola");
    esame3.setCognomeStudente("Turu");
    esame3.setMatricolaStudente("13579");
    esame3.setNomeEsame("DB");
    esame3.setVoto("19");
    esami.add(esame3);
    return esami;
   }
   
   public String toText(List<Esame> esamiToText)
   {
       String result = "";
       int size1 = esamiToText.size();
       
       for(Esame exam : esamiToText)
       {
           result = result.concat(exam.getCognomeStudente() + exam.getMatricolaStudente() + exam.getNomeEsame() + exam.getNomeStudente() + exam.getVoto());           
       }   
       return result;
   }
}
