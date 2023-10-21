package use_case.clear_users;

import entity.User;
import use_case.signup.SignupOutputData;

import java.util.List;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;
    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface,
                           ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute() {
        List<String> usersRemoved = userDataAccessObject.deleteAll();
        ClearOutputData clearOutputData = new ClearOutputData(usersRemoved, false);
        clearPresenter.prepareSuccessView(clearOutputData);
    }
}
