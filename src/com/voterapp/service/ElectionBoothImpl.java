package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIdException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements ElectionBooth {

	String [] localities = {"Rishikesh","Haridwar","Dehradun","Delhi"}; 
	
	private boolean checkAge(int age) throws UnderAgeException {
    	if (age<18) {
    		throw new UnderAgeException("You Are UnderAge");
    	}else
    	return true;
    }
	
	private boolean checkLocality(String locality) throws LocalityNotFoundException {
    	boolean flag = false;
    	for(String name : localities) {
    		if(name.equalsIgnoreCase(locality)) {
    			flag = true;
    			break;
    			}
    		}
    		if(flag) {
    			return true;
    		}
    		else
    			{
    			throw new LocalityNotFoundException("Locality not Found ");    	}
    }

	private boolean checkVoterId(int vid) throws NoVoterIdException{
    	if (vid>=1000 && vid<=3000) {
    		return true;
    	}else
    		throw new NoVoterIdException("Your Voter Id Does Not Belong To this Area ");
    }
	
	@Override
	public boolean checkEligibility(int age, String locality, int vid) throws InvalidVoterException {		
		boolean agestatus = checkAge(age);
		boolean localitystatus = checkLocality(locality);
		boolean vidstatus = checkVoterId(vid);
		if (!agestatus && !localitystatus && !vidstatus) {
			return false;
		}else
		return true;
	}
}