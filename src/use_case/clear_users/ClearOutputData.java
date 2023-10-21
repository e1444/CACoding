package use_case.clear_users;

import java.util.List;

public class ClearOutputData {
    private List<String> usersRemoved;
    private boolean useCaseFailed;

    public ClearOutputData(List<String> usersRemoved, boolean useCaseFailed) {
        this.usersRemoved = usersRemoved;
        this.useCaseFailed = useCaseFailed;
    }

    public List<String> getUsersRemoved() {
        return usersRemoved;
    }
}
