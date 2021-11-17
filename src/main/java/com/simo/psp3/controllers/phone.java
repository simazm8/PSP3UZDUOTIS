package com.simo.psp3.controllers;

import java.util.ArrayList;
import java.util.Arrays;

public class phone {


    Country[] CV = new Country[] { new Country(12, "+370", '6')};
    ArrayList<Country> countries = new ArrayList<Country>(Arrays.asList(CV));


    boolean addValidationRule(int numberLength, String numberPrefix, char numberAfterPrefix)
    {
        for (int i=0; i<countries.size(); i++)
        {
            if (countries.get(i).numberPrefix == numberPrefix)
            {
                return false;
            }
        }

        Country newCountry = new Country(numberLength, numberPrefix, numberAfterPrefix);
        countries.add(newCountry);
        return true;
    }


    boolean checkIsValidForCountry(String number, String numberPrefix)
    {
        for (int i=0; i<countries.size(); i++) {

            if (!(countries.get(i).numberPrefix == numberPrefix)) {

                return false;
            }
            if (!(countries.get(i).numberLength == number.length())) {

                return false;
            }
            if (!(number.charAt(numberPrefix.length()) == countries.get(i).numberAfterPrefix)) {

                return false;
            }
        }
        return true;
    }

    boolean onlyNumbers(String phone)
    {
        if (phone.charAt(0)=='+')
        {
            for (int i=1; i<phone.length(); i++)
            {
                if (!(phone.charAt(i) >= '0' && phone.charAt(i) <= '9'))
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            for (int i=0; i<phone.length(); i++)
            {
                if (!(phone.charAt(i) >= '0' && phone.charAt(i) <= '9'))
                {
                    return false;
                }
            }
            return true;
        }
    }

    boolean check(String number){
        if (number.charAt(0) == '8')
            return true;
        else return false;
    }


    String addCountryPrefix(String number)
    {
        if (check(number) == true)
        {
            String numberWithCountryPrefix = number.replace("8", "+370");
            return numberWithCountryPrefix;
        }
        else return number;
    }


    boolean checkLength(String number, int length)
    {
        if (number.length() == length)
        {
            return true;
        }
        else return false;
    }

    boolean checkPrefix(String number, String correctPrefix)
    {
        String prefix = number.substring(0, correctPrefix.length());
        if (prefix.equals(correctPrefix))
        {
            return true;
        }
        else return false;
    }
}
