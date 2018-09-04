package com.virtualan.test.model;

/**
 * Spring boot and Apache CXF with virtualan
 * 
 * @author Elan Thangamani
 *
 */
public class User {
    private String email;
    private String firstName;
    private String lastName;
        
    public User() {
    }
    
    public User(final String email, final String firstName, final String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
        
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
}
