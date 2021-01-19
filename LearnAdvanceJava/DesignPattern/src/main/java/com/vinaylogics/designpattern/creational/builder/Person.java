package com.vinaylogics.designpattern.creational.builder;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate dob;
    private String place;
    private Gender gender;
    private String qualification;
    private MaritalStatus maritalStatus;
    private Status status;
    private JobType jobType;
    private String nationality;
    private String position;

    private Person(PersonBuilder personBuilder){
        name = personBuilder.name;
        dob = personBuilder.dob;
        place = personBuilder.place;
        gender = personBuilder.gender;
        qualification = personBuilder.qualification;
        maritalStatus = personBuilder.maritalStatus;
        status = personBuilder.status;
        jobType = personBuilder.jobType;
        nationality = personBuilder.nationality;
        position = personBuilder.position;
    }

    public static class PersonBuilder {
        private String name;
        private LocalDate dob;
        private String place;
        private Gender gender;
        private String qualification;
        private MaritalStatus maritalStatus;
        private Status status;
        private JobType jobType;
        private String nationality;
        private String position;

        public PersonBuilder name(String name){
            this.name = name;
            return this;
        }

        public PersonBuilder dob(LocalDate dob){
            this.dob = dob;
            return this;
        }

        public PersonBuilder place(String place){
            this.place = place;
            return this;
        }

        public PersonBuilder gender(Gender gender){
            this.gender = gender;
            return this;
        }
        public PersonBuilder qualification(String qualification){
            this.qualification = qualification;
            return this;
        }
        public PersonBuilder maritalStatus(MaritalStatus maritalStatus){
            this.maritalStatus = maritalStatus;
            return this;
        }
        public PersonBuilder status(Status status){
            this.status = status;
            return this;
        }
        public PersonBuilder jobType(JobType jobType){
            this.jobType = jobType;
            return this;
        }

        public PersonBuilder nationality(String nationality){
            this.nationality = nationality;
            return this;
        }
        public PersonBuilder position(String position){
            this.position = position;
            return this;
        }

        public Person build(){
            return new Person(this);
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
