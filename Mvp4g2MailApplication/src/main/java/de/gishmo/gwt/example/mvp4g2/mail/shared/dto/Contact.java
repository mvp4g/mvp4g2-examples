package de.gishmo.gwt.example.mvp4g2.mail.shared.dto;

public class Contact {

  private String email;
  private String name;

  public Contact() {
  }

  public Contact(String name,
                 String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}
