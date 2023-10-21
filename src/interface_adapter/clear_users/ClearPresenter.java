package interface_adapter.clear_users;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel,
                          SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        // On success switch to the signup view
        StringBuilder stringBuilder = new StringBuilder();

        for (String str : response.getUsersRemoved()) {
            stringBuilder.append(str).append("\n");
        }

        String result = stringBuilder.toString();
        ClearState clearState = clearViewModel.getState();
        clearState.setUsersRemoved(result);
        clearViewModel.setState(clearState);

        clearViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setClearError(error);
        clearViewModel.setState(clearState);
    }
}
