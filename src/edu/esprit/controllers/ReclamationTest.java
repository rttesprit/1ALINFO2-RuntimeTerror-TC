package edu.esprit.controllers;

import edu.esprit.entities.Reclamation;
import edu.esprit.iservices.IReclamationService;
import edu.esprit.services.ReclamationService;


public class ReclamationTest {

    public static void main(String[] args) {
        Reclamation reclamation = new Reclamation();
        reclamation.setId(1571);
        reclamation.setIduser(1);
        reclamation.setIdobjet(6);
        reclamation.setDescription("TestFromJAVA");
        reclamation.setRaison("ReclamationTest");
        reclamation.setTypeobjet("Test");

         IReclamationService reclamationDAO = new ReclamationService();
        System.out.println("----------");
        reclamationDAO.addReclamation(reclamation);
        System.out.println("*****************");

    }
}
