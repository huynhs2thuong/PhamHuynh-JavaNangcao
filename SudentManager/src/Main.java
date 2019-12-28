import controller.StudentsController;
import controller.StudentsControllerImpl;
import model.StudentsModel;
import model.StudentsModelImpl;

public class Main {

    public static void main(String[] args) {

        StudentsModel model = new StudentsModelImpl();
        StudentsController controller = new StudentsControllerImpl(model);
    }
}
