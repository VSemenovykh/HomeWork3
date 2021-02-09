package ru.ncedu.model;

/**
 * This class Email
 * @version 1.0, 5 Feb 2021
 * @author Vladislav Semenovykh
 */
public class Email {
    private String message;
    private String toEmail;
    private String subject;
    private String fromEmail;

    /**
     * Method to get field {@link #message}
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Procedure for determination field {@link #message}
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Method to get field {@link #toEmail}
     * @return toEmail
     */
    public String getToEmail() {
        return toEmail;
    }

    /**
     * Procedure for determination field {@link #toEmail}
     * @param toEmail
     */
    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    /**
     * Method to get field {@link #subject}
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Procedure for determination field {@link #subject}
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Method to get field {@link #fromEmail}
     * @return fromEmail
     */
    public String getFromEmail() {
        return fromEmail;
    }

    /**
     * Procedure for determination field {@link #fromEmail}
     * @param fromEmail
     */
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    /**
     * String representation
     * @return "Email[message={@link #message},
     *               toEmail={@link #toEmail},
     *               subject={@link #subject},
     *               fromEmail={@link #fromEmail}]"
     */
    @Override
    public String toString() {
        return "Email{" +
                "message='" + message + '\'' +
                ", toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", fromEmail='" + fromEmail + '\'' +
                '}';
    }
}
