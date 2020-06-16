package com.company;

public class Client {

    private int id;
    private String name;
    private int zp;
    private String date;
    private int per;


    public Client(int id){
        this.id = id;
        this.zp = FunctionForClient.ZP(id);
        this.name = FunctionForClient.Name(id);
        this.per = FunctionForClient.Perevod(id);
        this.date = FunctionForClient.Date(id);

    }

    public void hu(){
        System.out.println(getName());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getZp() {
        return zp;
    }

    public String getDate() {
        return date;
    }

    public int getPer() {
        return per;
    }
}


