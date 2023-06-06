package com.lucsilva.taskbuddy.entities.enums;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4);

    private int code;
    private Priority(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Priority valueOf(int code) {
        for(Priority item : Priority.values()){
            if(item.getCode() == code){
                return item;
            }
        }
        throw new IllegalArgumentException("Invalid status code.");
    }
}
