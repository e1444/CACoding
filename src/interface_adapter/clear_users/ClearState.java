package interface_adapter.clear_users;

public class ClearState {
    private String clearError = null;

    public ClearState() {};

    public String getClearError() {
        return clearError;
    }

    public void setClearError(String clearError) {
        this.clearError = clearError;
    }
}
