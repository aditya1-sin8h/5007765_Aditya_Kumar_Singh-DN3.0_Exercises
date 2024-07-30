package MVCPatternExample;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Create the model
        Student model = new Student("1", "Aditya", "A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(model, view);

        // Update view
        controller.updateView();

        // Update model data
        controller.setStudentName("Aditya Singh");
        controller.setStudentGrade("B");

        // Update view again
        controller.updateView();
    }
}
