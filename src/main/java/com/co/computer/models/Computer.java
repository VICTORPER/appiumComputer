package com.co.computer.models;

public class Computer {

    private String name;
    private String introduced;
    private String discontinued;
     private  String company;


    public Computer(String name, String introduced, String discontinued, String company) {
        this.name = name;
        this.introduced = introduced;
        this.discontinued= discontinued;
        this.company = company;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduced() {
        return introduced;
    }

    public void setIntroduced(String introduced) {
        this.introduced = introduced;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
