package ru.ncedu.model;

import lombok.Data;
import javax.validation.constraints.*;

/**
 * This class Registration
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
@Data
public class Registration {
    /**
     * This const field for email pattern
     */
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * This const field for work place pattern
     */
    private static final String WORKPLACE_PATTERN = "([\\w+\\s*]*)";

    /**
     * This const field for lastName, firstName, middleName pattern
     */
    private static final String NAME_PATTERN = "[A-Za-z-]{1,}";

    @NotEmpty(message = "Last can not be empty!!")
    @Pattern(regexp = NAME_PATTERN, message = "English letters only!!")
    private String lastName;

    @NotEmpty(message = "First can not be empty!!")
    @Pattern(regexp = NAME_PATTERN, message = "English letters only!!")
    private String firstName;

    @NotEmpty(message = "Middle can not be empty!!")
    @Pattern(regexp = NAME_PATTERN, message = "English letters only!!")
    private String middleName;

    @Min(value = 0, message = "Should age > -1!!")
    private int age;

    @Min(value = 0, message = "Salary should >= 0!!")
    private double salary;

    @Pattern(regexp = EMAIL_PATTERN, message = "You entered an invalid e-mail address!!")
    private String email;

    @Pattern(regexp = WORKPLACE_PATTERN, message = "English letters only!!")
    private String workPlace;

    /**
     * Method to get field {@link #lastName}
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Procedure for determination field {@link #lastName}
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method to get field {@link #firstName}
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Procedure for determination field {@link #firstName}
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method to get field {@link #middleName}
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Procedure for determination field {@link #middleName}
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Method to get field {@link #age}
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Procedure for determination field {@link #age}
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method to get field {@link #salary}
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Procedure for determination field {@link #salary}
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Method to get field {@link #email}
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Procedure for determination field {@link #email}
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get field {@link #workPlace}
     * @return workPlace
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * Procedure for determination field {@link #workPlace}
     * @param workPlace
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * String representation
     * @return "Email[lastName={@link #lastName},
     *               firstName={@link #firstName},
     *               middleName={@link #middleName},
     *               age={@link #age},
     *               salary={@link #salary},
     *               email={@link #email},
     *               workPlace={@link #workPlace}]"
     */
    @Override
    public String toString() {
        return "Registration{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", workPlace='" + workPlace + '\'' +
                '}';
    }
}
