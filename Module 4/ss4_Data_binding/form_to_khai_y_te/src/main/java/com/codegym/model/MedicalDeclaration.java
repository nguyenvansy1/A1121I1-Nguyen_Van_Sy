package com.codegym.model;

public class MedicalDeclaration {
    private int id;
    private String name;
    private String yearOfBirth;
    private String gender;
    private String nationality;
    private String CMND;
    private String vehicle;
    private String vehicleNumber;
    private int numberOfSeats;
    private String departureDay;
    private String endDate;
    private String beenInCities;
    private String city;
    private String district;
    private String commune;
    private String address;
    private String phoneNumber;
    private String email;
    private boolean fever;
    private boolean cough;
    private boolean difficultyBreathing;
    private boolean soreThroat;
    private boolean vomiting;
    private boolean diarrhea;
    private boolean hemorrhage;
    private boolean rash;
    private boolean contactWithAnimals;
    private boolean contactWithSickPeople;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(int id, String name, String yearOfBirth, String gender, String nationality, String CMND, String vehicle, String vehicleNumber, int numberOfSeats, String departureDay, String endDate, String beenInCities, String city, String district, String commune, String address, String phoneNumber, String email, boolean fever, boolean cough, boolean difficultyBreathing, boolean soreThroat, boolean vomiting, boolean diarrhea, boolean hemorrhage, boolean rash, boolean contactWithAnimals, boolean contactWithSickPeople) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.CMND = CMND;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.numberOfSeats = numberOfSeats;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.beenInCities = beenInCities;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.difficultyBreathing = difficultyBreathing;
        this.soreThroat = soreThroat;
        this.vomiting = vomiting;
        this.diarrhea = diarrhea;
        this.hemorrhage = hemorrhage;
        this.rash = rash;
        this.contactWithAnimals = contactWithAnimals;
        this.contactWithSickPeople = contactWithSickPeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBeenInCities() {
        return beenInCities;
    }

    public void setBeenInCities(String beenInCities) {
        this.beenInCities = beenInCities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isDifficultyBreathing() {
        return difficultyBreathing;
    }

    public void setDifficultyBreathing(boolean difficultyBreathing) {
        this.difficultyBreathing = difficultyBreathing;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isVomiting() {
        return vomiting;
    }

    public void setVomiting(boolean vomiting) {
        this.vomiting = vomiting;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isHemorrhage() {
        return hemorrhage;
    }

    public void setHemorrhage(boolean hemorrhage) {
        this.hemorrhage = hemorrhage;
    }

    public boolean isRash() {
        return rash;
    }

    public void setRash(boolean rash) {
        this.rash = rash;
    }

    public boolean isContactWithAnimals() {
        return contactWithAnimals;
    }

    public void setContactWithAnimals(boolean contactWithAnimals) {
        this.contactWithAnimals = contactWithAnimals;
    }

    public boolean isContactWithSickPeople() {
        return contactWithSickPeople;
    }

    public void setContactWithSickPeople(boolean contactWithSickPeople) {
        this.contactWithSickPeople = contactWithSickPeople;
    }
}
