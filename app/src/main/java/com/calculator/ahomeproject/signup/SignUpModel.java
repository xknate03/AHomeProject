package com.calculator.ahomeproject.signup;

public class SignUpModel {


    public boolean isPasswordValid(String password) {
        char index;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;

        if(password.length() >= 6) {
            for(int i =0; i <password.length();i++) {
                index = password.charAt(i);
                if(Character.isDigit(index)){
                    numberFlag = true;
                }else if(Character.isUpperCase(index)) {
                    capitalFlag = true;
                }else if(Character.isLowerCase(index)) {
                    lowerCaseFlag = true;
                }
                if(capitalFlag && lowerCaseFlag && numberFlag)
                    return true;
            }
        }
        return false;
    }

    public boolean isMatching(String password, String retypePassword) {
        return password.equals(retypePassword);
    }





}
