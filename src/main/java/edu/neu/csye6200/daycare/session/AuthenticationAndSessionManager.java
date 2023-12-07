package edu.neu.csye6200.daycare.session;

import edu.neu.csye6200.daycare.Listeners;
import edu.neu.csye6200.daycare.controllers.ApplicationController;
import edu.neu.csye6200.daycare.model.Person;
import edu.neu.csye6200.daycare.model.Student;
import edu.neu.csye6200.daycare.model.Teacher;
import edu.neu.csye6200.daycare.utils.Constants;
import edu.neu.csye6200.daycare.utils.FunctionalUtilities;

import java.sql.SQLException;


public class AuthenticationAndSessionManager {

    public static AuthenticationAndSessionManager mInstance;
    private Person currentPerson;
    private Listeners.SessionManager sessionManagementListener;

    private int reqData = 0;

    private AuthenticationAndSessionManager() {
    }

    public int getReqData() {
        return reqData;
    }

    public void setReqData(int data) {
        this.reqData = data;
    }

    public void sendEmail(String to, String subject, String body) {
        if (sessionManagementListener != null) sessionManagementListener.sendEmail(to, subject, body);
    }

    public void authenticate(String userName, String password, FunctionalUtilities.BiFunction<Boolean, String> result) {
        assert sessionManagementListener != null;
        if (this.currentPerson == null) {
            try {
                this.currentPerson = sessionManagementListener.validateTeacher(userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (this.currentPerson == null) {
            try {
                this.currentPerson = sessionManagementListener.validateParent(userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (this.currentPerson != null) {
            result.accept(true, "Login Success");
            sessionManagementListener.onNewSessionEvent(this.getLoggedInUserType());
        } else {
            result.accept(false, "Invalid UserName/Password");
            sessionManagementListener.onNewSessionEvent(Constants.SESSION_FAILED_AUTH);
        }
    }

    public void setSessionManagementListener(Listeners.SessionManager sessionManagementListener) {
        assert sessionManagementListener instanceof ApplicationController;
        this.sessionManagementListener = sessionManagementListener;
    }

    public Person getCurrentPerson() {
        return this.currentPerson;
    }

    public void logOut() {
        this.currentPerson = null;
        this.sessionManagementListener.onNewSessionEvent(Constants.EVENT_LOGOUT);
    }

    public int getLoggedInUserType() {
        if (currentPerson == null) return Constants.SESSION_INVALID;
        else if (currentPerson instanceof Teacher) return Constants.SESSION_TEACHER;
        else if (currentPerson instanceof Student) return Constants.SESSION_PARENT;
        else return Constants.SESSION_INVALID;
    }

    public static AuthenticationAndSessionManager getInstance() {
        if (mInstance == null) {
            synchronized (AuthenticationAndSessionManager.class) {
                mInstance = new AuthenticationAndSessionManager();
            }
        }
        return mInstance;
    }
}
