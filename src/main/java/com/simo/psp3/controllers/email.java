package com.simo.psp3.controllers;

public class email {

    boolean atSign(String email)
    {
        for (int i=0; i<email.length(); i++)
        {
            if (email.charAt(i)=='@')
                return true;
        }
        return false;
    }

    boolean checkSymb(String email, String illegalSymbols)
    {
        for (int i=0; i<email.length(); i++)
        {
            for (int j=0; j<illegalSymbols.length(); j++)
            {
                if (email.charAt(i) == illegalSymbols.charAt(j))
                    return false;
            }
        }
        return true;
    }


    boolean checkTLD(String email)
    {
        String TLD = email.substring(email.indexOf('@') + 1);
        TLD = TLD.substring(TLD.indexOf('.') + 1);

        for (int i=0; i<TLD.length(); i++)
        {
            char ch = TLD.charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch == '.'))
            {
                return false;
            }
        }
        return true;
    }

    boolean checkDomain(String email)
    {
        String domain = email.substring(email.indexOf('@') + 1);

        if (domain.length() >= 1 && domain.length() <= 63)
        {
            if (!(domain.startsWith("-") || domain.charAt(domain.length()-1) == '-'))
            {
                return true;
            }
            else return false;
        }
        else return false;
    }



}
