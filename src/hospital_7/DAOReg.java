/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_7;

import hospital_7.Entity.RegistrCard;
import java.util.ArrayList;
import static hospital_7.DB.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Semenenko
 */
public class DAOReg implements DAO<RegistrCard>{

    @Override
    public ArrayList<RegistrCard> select() {
        ArrayList<RegistrCard> result = new ArrayList<>();
        int i=0;
        try {
            rs = st.executeQuery("select * from 'registr_card';");
            while(rs.next()){
                result.add(new RegistrCard());
                result.get(i).setIdP(rs.getInt("ID_P"));
                result.get(i).setNamep(rs.getString("Name_p"));
                result.get(i).setDateOfBirthday(rs.getString("DateOfBirthday"));
                result.get(i).setAdress(rs.getString("Adress"));
                result.get(i).setDateOfAdmission(rs.getString("DateOfAdmission"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOReg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void insert(RegistrCard t) {
        try {
            
            st.execute("INSERT INTO 'registr_card' VALUES("+
                t.getIdP()+ ",'"+
                t.getNamep()+"','"+    
                t.getDateOfBirthday()+ "','"+
                t.getAdress()+"','"+
                t.getDateOfAdmission()+"')");
            rs = st.executeQuery("SELECT MAX('registr_card'.'ID_P') from 'registr_card'");
    
            t.setIdP(rs.getInt(1)+1);
                    
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOReg.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         
    }

    @Override
    public void delete(int id) {
        try {
            st.execute("DELETE FROM 'registr_card' WHERE 'registr_card'.'ID_P' = "+id);
        } catch (SQLException ex) {
            Logger.getLogger(DAOReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int id, RegistrCard t) {
        try {
            st.execute("UPDATE 'RegistrCard' set"
                    + "'Name_p'='"+t.getNamep()+"',"
                    + "'DateOfBirthday'='"+t.getDateOfBirthday()+"'"
                    +"'Adress'='"+t.getAdress()+"'"
                    +"'DateOfAdmission'='"+ t.getDateOfAdmission()+"'"
                    + "WHERE 'registr_card'.'ID_P' ="+id                 
            );
        } catch (SQLException ex) {
            Logger.getLogger(DAOReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
