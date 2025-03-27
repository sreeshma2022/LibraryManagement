package model;

import exceptions.InvalidInputException;

public enum AvailabilityStatus {
    AVAILABLE, CHECKED_OUT;

    public static boolean isValid(String status){
        if(status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("checked_out")) {
            return true;
        }else {
            return false;
        }
    }
}
