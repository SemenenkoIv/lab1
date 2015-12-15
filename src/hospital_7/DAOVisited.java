/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_7;

import static hospital_7.DB.*;
import hospital_7.Entity.Visited;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Semenenko
 */
public class DAOVisited implements DAO<Visited>{

    @Override
    public ArrayList<Visited> select() {
       ArrayList<Visited> result=new ArrayList<>();
       int i =0;
        try {
            rs= st.executeQuery("SELECT * FROM 'Visited';");
            while (rs.next()) {
                result.add(new Visited());
                result.get(i).setIdP(rs.getInt("ID_P"));
                result.get(i).setNameD(rs.getString("Name_D"));
                result.get(i).setCabinet(rs.getString("Cabinet"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVisited.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;

    }

    @Override
    public void insert(Visited t) {
        try {
            st.execute("INSERT INTO 'Visited' VALUES("+
                    t.getIdP()+",'"+t.getNameD()+"','"+t.getCabinet()+"')"
            );
        } catch (SQLException ex) {
            Logger.getLogger(DAOVisited.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            st.execute("DELETE FROM 'Visited' WHERE 'Visited'.'ID_P'="+id);
        } catch (SQLException ex) {
            Logger.getLogger(DAOVisited.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(int id, Visited t) {
        try {
            st.execute("UPDATE 'Visited' set"+
                    "'NAME_D'='"+t.getNameD()+
                    "','Cabinet'='"+t.getCabinet()+"' WHERE 'Visited'.'ID_P'="+id);
        } catch (SQLException ex) {
            Logger.getLogger(DAOVisited.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
