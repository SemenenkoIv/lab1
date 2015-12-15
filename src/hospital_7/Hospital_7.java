/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_7;

import hospital_7.Entity.*;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Semenenko
 */
public class Hospital_7 {
    public static Scanner scan = new Scanner(System.in,"cp1251");    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DB.ConnectDB();
        DAOReg reg = new DAOReg();
        DAOVisited vis = new DAOVisited();
                
        Visited vs_entity = new Visited();
        RegistrCard rc_entity = new RegistrCard();
        
        System.out.println("Chouse menu:\n"+"1. view Patient visited"+"\n2. Patient data");
        if (scan.nextInt()==1){
            
            System.out.println(vis.select());
            System.out.println("\tSelect menu:"
            +"\n1.Update "+ "\n2. Insert"+"\n3. Delete");
            
            switch (scan.nextInt()){
                // UPDATE
                case 1:
                    System.out.println("Please, write value...\n1ID: ");
                    int ID_P = scan.nextInt();System.out.println("Doctor's name: ");
                    vs_entity.setNameD(scan.next());
                    
                    System.out.println("Cabinet: ");
                    vs_entity.setCabinet(scan.next());
                    
                    vis.update(ID_P, vs_entity);
                    
                    break;
                // Insert    
                case 2:
                    System.out.println("Please, write value...\n1Doctor Name: ");
                    vs_entity.setNameD(scan.next());
                    System.out.println("\nEnter\nCabiten:");
                    vs_entity.setCabinet(scan.next());
                    vis.insert(vs_entity);                     
                    break;
                case 3:
                    System.out.println("Delete seans:Insert ID: ");
                    vis.delete(scan.nextInt());
                     
                    break;
               
                    
            }System.out.println("New Table: " + vis.select());
        }
         if   (scan.nextInt()==2) {
            System.out.println(reg.select());
            System.out.println("\tSelect menu:"
            +"\n1.Update "+ "\n2. Insert"+"\n3. Delete"+"\n4. EXIT");
            switch (scan.nextInt()){
                // UPDATE
                case 1:
                    System.out.println("Please, write value...\n1ID: ");
                    int ID_P = scan.nextInt();System.out.println("Patient's name: ");
                    rc_entity.setNamep(scan.next());
                    
                    System.out.println("Date of Birth: ");
                    rc_entity.setDateOfBirthday(scan.next());
                    
                    System.out.println("Adress: ");
                    rc_entity.setAdress(scan.next());
                                        
                    System.out.println("Date of Admition: ");
                    rc_entity.setDateOfAdmission(scan.next());
                    
                    reg.update(ID_P, rc_entity);
                    
                    break;
                // Insert    
                case 2:
                    System.out.println("Please, write value...\n1Patient's Name: ");
                    rc_entity.setNamep(scan.next());
                    
                    System.out.println("Date of Birth:");
                    rc_entity.setDateOfBirthday(scan.next());
                    
                    System.out.println("Adress:");
                    rc_entity.setAdress(scan.next());
                    
                    System.out.println("Date of Admition:");
                    rc_entity.setDateOfAdmission(scan.next());
                    
                    reg.insert(rc_entity);                     
                    break;
                case 3:
                    System.out.println("Delete seans:Insert ID: ");
                    reg.delete(scan.nextInt());
                     
                    break;
                case 4:
                    break;
               
                    
            }System.out.println("New Table: " + reg.select());
            }
        else {System.out.println("OK! BY!");}
        
    }
    
}
