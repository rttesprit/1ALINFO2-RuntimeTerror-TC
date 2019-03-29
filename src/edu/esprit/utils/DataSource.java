package edu.esprit.utils;


import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
    String url="jdbc:mysql://localhost:3306/charity";
    String login="root";
    String pwd="";
    static java.sql.Connection cnx =null;

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Connexion non etablie" + ex.getMessage());
        }
    }

    public static java.sql.Connection getInstance(){
        if(cnx==null){ // s'il n'y a pas d'instance , l crée une
            new DataSource();
        }
        return cnx;
    }


}