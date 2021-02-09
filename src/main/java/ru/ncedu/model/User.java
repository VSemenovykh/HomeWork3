package ru.ncedu.model;

/**
 * This class User
 * @version 1.0, 2 Feb 2021
 * @author Vladislav Semenovykh
 */
public class User {
    private String lastName;
    private String firstName;

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
     * String representation
     * @return "User[lastName={@link #lastName},
     *               firstName={@link #firstName}]"
     */
    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
