package com.simo.psp3.controllers;

public class Passwords {

    int passwordLength = 8;

    boolean isOfCorrectLength(String password)
    {
        if (password.length() >= passwordLength)
        {
            return true;
        }
        else return false;
    }

    int hasLength(String password)
    {
        return password.length();
    }

    boolean upperCase(String password)
    {
        for (int i=0; i<password.length(); i++)
        {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                return true;
        }
        return false;
    }

    boolean checkSymb(String password, String specialSymbols)
    {
        for (int i=0; i<password.length(); i++)
        {
            for (int j=0; j<specialSymbols.length(); j++)
            {
                if (password.charAt(i) == specialSymbols.charAt(j))
                    return true;
            }
        }
        return false;
    }
}
