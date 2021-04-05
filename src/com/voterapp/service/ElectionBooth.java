package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;

public interface ElectionBooth {

	boolean checkEligibility(int age,String locality,int vid) throws InvalidVoterException;
}
