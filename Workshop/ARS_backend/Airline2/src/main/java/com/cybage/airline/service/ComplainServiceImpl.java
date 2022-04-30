package com.cybage.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.Complain;

import com.cybage.airline.repository.ComplainRepo;

@Service
public class ComplainServiceImpl
{
    @Autowired
	private ComplainRepo repo;
	
	public List<Complain> findAll()
	{
		return repo.findAll();
	}//get-all
	
	
    public Complain getComplainById(int id) {
		
    	Optional<Complain> comp = repo.findById(id);
    	
		return comp.orElse(null);
	}//get-by-id
	

	public  Complain save(Complain comp)
	{
		return repo.save(comp);
		
	}//add-data


	public boolean deleteComplain(int id)
	{
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return true;
		}
		return false ;
	}//main


	public Complain update(Complain comp)
	{
		return repo.save(comp);
	}



	public Complain getComplainByStatus(String complainStatus) {
		return repo.findComplainByComplainStatus(complainStatus);
	}
	
	

}//main
