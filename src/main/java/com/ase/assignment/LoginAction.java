package com.ase.assignment;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Action class performing login validation for a user.
 */
public class LoginAction extends ActionSupport {
    /**
     * Model object exposed to the login view to store credentials entered by the user.
     */
    private LoginCredentials loginCredentials;

    /**
     * Method called by the login view on form submission, mapped via Struts.
     * It contains the logic for login validation for a user.
     * @return String result to be interpreted by the Struts framework. Returns "success" if validation is successful, "error" otherwise.
     */
    public String execute() {
        Connection connection = DatabaseController.getDatabaseConnection();

        if (connection == null) {
            addFieldError("error-field", "Unable to connect to the database.");
            return ERROR;
        }

        String query = "SELECT `username` FROM `users` WHERE `username` = ? AND `password` = ?;";
        boolean loginSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, loginCredentials.getUsername());
            statement.setString(2, loginCredentials.getPassword());
            ResultSet result = statement.executeQuery();
            loginSuccess = result.next();
            if (!loginSuccess) addFieldError("error-field", "Login unsuccessful.");
        } catch (Exception e) {
            e.printStackTrace();
            addFieldError("error-field", "Something went wrong.");
        }

        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginSuccess ? SUCCESS : ERROR;
    }

    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public void setLoginCredentials(LoginCredentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }
}
