package edu.esprit.services;



import edu.esprit.entities.Reclamation;
import edu.esprit.iservices.IReclamationService;
import edu.esprit.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReclamationService implements IReclamationService {

    private Connection connection;


    public ReclamationService() {
         connection = DataSource.getInstance();

    }

    @Override
    public void addReclamation(Reclamation reclamation) {

        try {
            String query = "INSERT INTO `reclamation` VALUES (null, ?, ?, ?,? , ?);";

            PreparedStatement ps = connection.prepareStatement(query);

            //ps.setInt(1,reclamation.getId());
            ps.setInt(1,reclamation.getIduser());
            ps.setInt(2,reclamation.getIdobjet());
            ps.setString(3,reclamation.getDescription());
            ps.setString(4,reclamation.getRaison());
            ps.setString(5,reclamation.getTypeobjet());

            System.out.println(ps);
            ps.executeUpdate();
            System.out.println("a Reclamation has been added successfully ");


        } catch (SQLException e) {
            System.out.println("erreur lors de l'insertion d'une reclamation" + e.getMessage());
        }

    }

    @Override
    public void updateReclamation( Reclamation reclamation) {
        try {
      String query= "UPDATE `reclamation` SET" +
              "`idobjet` = ?, " +
              "`description` = ?, " +
              "`raison` = ?, " +
              "`typeobjet`  =? " +
              "WHERE `reclamation`.`idrec` = ?;";


            PreparedStatement   ps = connection.prepareStatement(query);
            ps.setInt(1,reclamation.getIdobjet());
            ps.setString(2,reclamation.getDescription());
            ps.setString(3,reclamation.getRaison());
            ps.setString(4,reclamation.getTypeobjet());
            ps.setInt(5,reclamation.getId());


            ps.executeUpdate();
            System.out.println("a Reclamation has been updated ");

        } catch (SQLException e) {
            System.out.println("erreur lors de le mise à jour de Reclamation " + e.getMessage());
        }




    }



    @Override
    public void deleteReclamation(Reclamation reclamation) {
        String query = "DELETE FROM `reclamation` WHERE `id`=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, reclamation.getId());
            ps.executeUpdate();
            System.out.println("a reclamation has been deleted");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }

    @Override
    public List<Reclamation> getReclamations() {
        List<Reclamation> listReclamations = new ArrayList<>();
        try {
        String query = "select * from `reclamation`;";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Reclamation reclamation = new Reclamation();
                setReclamation(rs, reclamation);


                listReclamations.add(reclamation);

            }
            return listReclamations;
        } catch (SQLException e) {
            System.out.println("erreur liste " + e.getMessage());        }





        return null;
    }

    private void setReclamation(ResultSet rs, Reclamation reclamation) throws SQLException {
        reclamation.setId(rs.getInt(1));
        reclamation.setIduser(rs.getInt(2));
        reclamation.setIdobjet(rs.getInt(3));
        reclamation.setDescription(rs.getString(4));
        reclamation.setRaison(rs.getString(5));
        reclamation.setTypeobjet(rs.getString(6));
    }

    @Override
    public Reclamation findReclamationById(int id) {

        String query = "SELECT * FROM `reclamation` WHERE `id`='"+id+"'";

        try {
            return getReclamation(query);
        } catch (SQLException ex) {

            System.out.println("erreur findReclamationById" + ex.getMessage());
        }
        return null;
    }

    @Override
    public Reclamation findReclamationByIdUser(int idUser) {
        String query = "SELECT * FROM `reclamation` WHERE `iduser`='"+idUser+"'";

        try {
            return getReclamation(query);
        } catch (SQLException ex) {

            System.out.println("erreur findReclamationByIdUser" + ex.getMessage());
        }
        return null;
    }

    @Override
    public Reclamation findReclamationByTypeObjet(String typeObjet) {
        String query = "SELECT * FROM `reclamation` WHERE `typeobjet`='"+typeObjet+"'";

        try {
            return getReclamation(query);
        } catch (SQLException ex) {

            System.out.println("erreur findReclamationByTypeObjet" + ex.getMessage());
        }
        return null;
    }

    private Reclamation getReclamation(String query) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();


        Reclamation reclamation = new Reclamation();
        while (rs.next()) {

            setReclamation(rs, reclamation);


        }


        return reclamation;
    }
}
