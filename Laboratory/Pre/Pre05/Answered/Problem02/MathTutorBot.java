public class MathTutorBot extends EducationalBot {
    public String courseName;

    public MathTutorBot(String name, String courseName) {
        super(name);
        this.courseName = courseName;
    }

    @Override
    public void respond() {
        System.out.println("Math tutor bot " + getName() + " untuk subject " + courseName + " siap membantu");
    }

    @Override
    public void displayInfo() {
        System.out.println("Math Tutor Bot " + getName() + " untuk subject " + courseName + " telah melayani "
                + getSessionCount() + " sesi");
    }

    public void solveProblem(String problem) {
        System.out.println("Menyelesaikan soal " + courseName + ": " + problem);
    }
}
