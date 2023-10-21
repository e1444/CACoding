package interface_adapter.clear_users;

public class ClearState {
    private String usersRemoved = "";
    private String clearError = null;

    public ClearState() {};

    public String getClearError() {
        return clearError;
    }

    public void setClearError(String clearError) {
        this.clearError = clearError;
    }

    public String getUsersRemoved() {
        return usersRemoved;
    }

    public void setUsersRemoved(String usersRemoved) {
        this.usersRemoved = usersRemoved;
    }
}
