package use_case.clear_users;

import use_case.signup.SignupOutputData;

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
        userDataAccessObject.deleteAll();
        ClearOutputData clearOutputData = new ClearOutputData(false);
        clearPresenter.prepareSuccessView(clearOutputData);
    }
}
