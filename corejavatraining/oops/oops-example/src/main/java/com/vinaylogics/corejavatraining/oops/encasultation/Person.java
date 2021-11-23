package com.vinaylogics.corejavatraining.oops.encasultation;

public class Person {

    private String readName = "Read Access";
    private String writeName;
    private String name;
    private String noAccess = "NoAccess";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReadName() {
        return readName;
    }

    public void setWriteName(String writeName) {
        this.writeName = writeName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "readName='" + readName + '\'' +
                ", writeName='" + writeName + '\'' +
                ", name='" + name + '\'' +
                ", noAccess='" + noAccess + '\'' +
                '}';
    }
}
