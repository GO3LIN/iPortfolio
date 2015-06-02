package com.iporfilio.beans;

import java.util.List;

import com.iportfolio.realisations.*;


public class RealisationsPL {

	private RealisationsDAO Realisation; 

    public RealisationsDAO getRealisationDAO() { 
        return Realisation; 
    } 

    public void setRealisationDAO(RealisationsDAO realisationDAO) { 
        this.Realisation = realisationDAO; 
    } 
    
    public void addRealisation(Realisations realis) { 
    	Realisation.save(realis); 
    } 
    
    public Realisations findRealisationById(Integer id) { 
        return Realisation.findById(id); 
    } 
    
    
    public void updateRealisation(Realisations realis) { 
    	Realisation.merge(realis); 
    } 
    
    public void deleteRealisation(Realisations realis) { 
    	Realisation.delete(realis); 
    } 
    public List findAll()
    { return Realisation.findAll();}
}
