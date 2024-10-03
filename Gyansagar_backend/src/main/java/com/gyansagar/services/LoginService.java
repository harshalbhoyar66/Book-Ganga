package com.gyansagar.services;

import java.util.Base64;
import java.util.Optional;

import com.gyansagar.exceptions.DuplicateEntryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gyansagar.entities.Buyer;
import com.gyansagar.entities.Login;
import com.gyansagar.entities.Seller;
import com.gyansagar.exceptions.NotFoundException;
import com.gyansagar.repository.BuyerRepository;
import com.gyansagar.repository.LoginRepository;
import com.gyansagar.repository.SellerRepository;
import com.gyansagar.utils.Constants;

@Service
public class LoginService {
    @Autowired
    LoginRepository lrepo;
    
    @Autowired
    BuyerRepository brepo;
    
    @Autowired
    SellerRepository srepo;
    
    public Login add(Login l) throws DuplicateEntryException {
        // Check if username already exists
        if (lrepo.findByUsername(l.getUsername()).isPresent()) {
            throw new DuplicateEntryException(String.format("Username=%s already exists.", l.getUsername()));
        }
        
        // Directly save the plain password
        return lrepo.save(l); // Save the Login object
    }
    
    public Object checkLogin(String uname, String pwd) throws NotFoundException {
        // Find the user by username
        Optional<Login> loginOptional = lrepo.findByUsername(uname);

        // Check if the user exists and is not deleted
        if (loginOptional.isPresent() && !loginOptional.get().isDeleted()) {
            Login login = loginOptional.get();

            // Compare the plain password directly with the stored password
            if (pwd.equals(login.getPassword())) {
                // Password matches, return appropriate user details based on role
                switch (login.getRole()) {
                    case "buyer":
                        Optional<Buyer> buyerOptional = brepo.findByUserid(login);
                        return buyerOptional.orElseThrow(() -> new NotFoundException(Constants.INVALID_CREDENTIALS_ERROR));
                    case "seller":
                        Optional<Seller> sellerOptional = srepo.findByUserid(login);
                        return sellerOptional.orElseThrow(() -> new NotFoundException(Constants.INVALID_CREDENTIALS_ERROR));
                    case "admin":
                        return login; // Return the Login object for admin
                    default:
                        throw new NotFoundException(Constants.INVALID_CREDENTIALS_ERROR);
                }
            } else {
                throw new NotFoundException(Constants.INVALID_CREDENTIALS_ERROR); // Password does not match
            }
        } else {
            throw new NotFoundException(Constants.INVALID_CREDENTIALS_ERROR); // User not found or deleted
        }
    }
}