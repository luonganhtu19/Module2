public class InforPerson {
    private String numberTelephone;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDay;
    private String email;

    public String getNumberTelephone() {
        return numberTelephone;
    }

    public void setNumberTelephone(String numberTelephone) {
        this.numberTelephone = numberTelephone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  ""+numberTelephone + "," + group + "," + fullName+
                "," + gender  + "," + address ;
    }
    public String toStringFull(String full) {
        return  ""+numberTelephone + "," + group + "," + fullName+
                "," + gender  + "," + address +"," + birthDay + "," + email;
    }
    public String toString(String coutine) {
        return  ""+birthDay + "," + email;
    }
}
