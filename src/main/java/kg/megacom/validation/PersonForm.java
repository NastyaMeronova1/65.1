package kg.megacom.validation;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;

public class PersonForm {
    @NotNull
    @Size(min = 2, max = 30, message = "Имя должно содержать не менее 2 и не более 30 символов")
    private String name;

    @NotNull(message = "Возраст не может быть пустым")
    @Min(18)
    private Integer age;

    @NotEmpty
    @Email()
    private String email;

    @Min(1)
    @Max(5)
    @Positive
    private int experience;

    @Past
    private Date carierStart;

    @Future
    private Date endContract;

    @PastOrPresent
    private Date birthday;
    @AssertTrue
    private boolean isActive;
    @Size(min= 1, max=3)
    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCarierStart() {
        return carierStart;
    }

    public void setCarierStart(Date carierStart) {
        this.carierStart = carierStart;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    @NotBlank
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String ipAddress;

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
