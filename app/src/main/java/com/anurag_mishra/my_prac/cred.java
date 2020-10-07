package com.anurag_mishra.my_prac;

public class cred {
    private String[] aws_cred =  new String[2];
    public cred(){
        this.aws_cred[0] = " ";
        this.aws_cred[1] = " ";
    }
    public String[] getCred(){
        return aws_cred;
    }
}
