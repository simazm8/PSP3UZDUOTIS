package com.simo.psp3.controllers;
import com.simo.psp3.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    private UserRepository userRepository;
    userController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/user/{id}")
    User getUser(@PathVariable Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception(("ID not found: ") + id));
    }
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) throws Exception {
        userRepository.deleteById(id);

    }

    @PutMapping("/user/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User newUser) throws Exception {
        if(!validateUser(newUser)) {
            throw new Exception("Account info not valid");
        }

        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setSurname(newUser.getSurname());
            user.setAddress(newUser.getAddress());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setPhonenumber(newUser.getPhonenumber());
            return userRepository.save(user);
        }).orElseGet(()->{
            newUser.setId(id);
            return userRepository.save(newUser);
        });
    }


    private boolean validateUser(User user) throws Exception {
        String email = user.getEmail();
        String phoneNumber = user.getPhonenumber();
        String password = user.getPassword();

        if(!validateEmail(email)) {
            throw new Exception("Invalid email address: "+email);
        }

        if(!validatePassword(password)) {
            throw new Exception("Invalid password");
        }

        if(!validatePhoneNumber(phoneNumber)) {
            throw new Exception("Invalid phone number: " + phoneNumber);
        }
        return true;
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        Country CV = new Country(12, "+370", '6');

        phone phoneValidator = new phone();
        if(!phoneValidator.checkIsValidForCountry(phoneNumber,CV.getNumberPrefix()))
            return false;
        if(!phoneValidator.checkLength(phoneNumber, CV.getNumberLength()))
            return false;
        if(!phoneValidator.onlyNumbers(phoneNumber))
            return false;
        return true;
    }

    private boolean validatePassword(String password) {
        Passwords passwordValidator = new Passwords();
        String specialSymbols = "~!$%^&*_=+}{'?-.";
        if(!passwordValidator.isOfCorrectLength(password))
            return false;
        if(!passwordValidator.upperCase(password))
            return false;
        if(!passwordValidator.checkSymb(password,specialSymbols))
            return false;
        return true;
    }

    private boolean validateEmail(String emailString)
    {
        String illegalSymbols = "¡¢£¤€\"";;
        email emailValidator = new email();
        if(!emailValidator.checkDomain(emailString))
            return false;
        if(!emailValidator.checkTLD(emailString))
            return false;
        if(!emailValidator.checkSymb(emailString,illegalSymbols))
            return false;
        if(!emailValidator.atSign(emailString))
            return false;
        return true;
    }


}