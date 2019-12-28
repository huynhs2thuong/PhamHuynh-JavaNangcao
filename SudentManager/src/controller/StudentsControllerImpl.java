package controller;

import model.StudentsModel;
import view.StudentsView;

public class StudentsControllerImpl implements StudentsController {

    private StudentsView view;

    public StudentsControllerImpl(StudentsModel model) {

        this.view = new StudentsView(model);
    }

    @Override
    public void deleteStudent() {
    }
}
