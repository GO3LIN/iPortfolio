package com.iporfilio.beans;

import java.util.List;

import com.iportfolio.commentaires.Commentaires;
import com.iportfolio.commentaires.CommentairesDAO;


public class CommentairesPL {
	private CommentairesDAO commentaireDAO; 

    public CommentairesDAO getUserDAO() { 
        return commentaireDAO; 
    } 

    public void setCommentaireDAO(CommentairesDAO userDAO) { 
        this.commentaireDAO = userDAO; 
    } 
    
    public void addCommentaires(Commentaires user) { 
    	commentaireDAO.save(user); 
    } 
    
    public Commentaires findCommentairesById(Integer id) { 
        return commentaireDAO.findById(id); 
    } 
    
    
    public void updateCommentaires(Commentaires user) { 
    	commentaireDAO.merge(user); 
    } 
    
    public void deleteCommentaires(Commentaires user) { 
    	commentaireDAO.delete(user); 
    } 
    public List findAll()
    { return commentaireDAO.findAll();}

	public com.iportfolio.commentaires.CommentairesDAO getCommentaireDAO() {
		return commentaireDAO;
	}
}
