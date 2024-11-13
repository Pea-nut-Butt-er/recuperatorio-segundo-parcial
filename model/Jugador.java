package model;

public class Jugador {
    private String _id;
    private String guid;
    private Boolean isActive;
    private Double balance;
    private Integer age;
    private String eyeColor;
    private Name name;
    private String email;
    private String phone;
    private String position;

    public Jugador() {
    }

    public Jugador(String _id, String guid, Boolean isActive, Double balance, Integer age, String eyeColor, Name name, String email, String phone, String position) {
        this._id = _id;
        this.guid = guid;
        this.isActive = isActive;
        this.balance = balance;
        this.age = age;
        this.eyeColor = eyeColor;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "_id='" + _id + '\'' +
                ", guid='" + guid + '\'' +
                ", isActive=" + isActive +
                ", balance='" + balance + '\'' +
                ", age=" + age +
                ", eyeColor='" + eyeColor + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
