package com.utilities;

public class RandomDataGenerator {
    
    public static String getRandomUserName(String value){
        StringBuffer finalString = new StringBuffer(value);
        
        for(int i=0; i<3; i++){
            finalString.append(Math.round(Math.random()));
        }
        return finalString.toString();
    }


}
