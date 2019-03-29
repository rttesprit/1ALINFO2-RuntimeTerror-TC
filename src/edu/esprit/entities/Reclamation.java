package edu.esprit.entities;

public class  Reclamation{

private  int id;
private int iduser;
private int idobjet;
private String description;
private String raison;
private String typeobjet;

public int getIduser(){
        return iduser;
        }

public void setIduser(int iduser){
        this.iduser=iduser;
        }

public int getIdobjet(){
        return idobjet;
        }

public void setIdobjet(int idobjet){
        this.idobjet=idobjet;
        }

public String getDescription(){
        return description;
        }

public void setDescription(String description){
        this.description=description;
        }

public String getRaison(){
        return raison;
        }

public void setRaison(String raison){
        this.raison=raison;
        }

public String getTypeobjet(){
        return typeobjet;
        }

public void setTypeobjet(String typeobjet){
        this.typeobjet=typeobjet;
        }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}