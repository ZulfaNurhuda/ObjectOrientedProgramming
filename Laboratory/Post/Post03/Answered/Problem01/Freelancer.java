public class Freelancer extends Employee {
    // TODO: Buat atribut private int projectCount, int payPerProject
    private int projectCount;
    private int payPerProject;

    // TODO: Buat constructor yang menerima name, payPerProject
    // Gunakan super constructor dengan salary 0 dan position "Freelancer"
    // Set projectCount = 0
    public Freelancer(String name, int payPerProject) {
        super(name, 0, "Freelancer");
        this.payPerProject = payPerProject;
        projectCount = 0;
    }

    // TODO: Override method displayInfo()
    // Panggil displayInfo() pada kelas Employee terlebih dahulu, lalu tampilkan:
    // "Jumlah Proyek : <projectCount>"
    // "Bayaran per Proyek : <payPerProject>"
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jumlah Proyek : " + projectCount);
        System.out.println("Bayaran per Proyek : " + payPerProject);
    }

    // TODO: Override method work()
    // Panggil work() pada kelas Employee terlebih dahulu, increment projectCount, tambahkan payPerProject ke salary
    // Tampilkan: "<name> menyelesaikan proyek ke-<projectCount>"
    @Override
    public void work(){
        super.work();
        projectCount++;
        int salary = super.getSalary() + payPerProject;
        super.setSalary(salary);
        System.out.println(super.getName() + " menyelesaikan proyek ke-" + projectCount);
    }

    // TODO: Override method calculateBonus()
    // Freelancer mendapatkan bonus 100000 jika projectCount >= 5
    @Override
    public int calculateBonus() {
        return (projectCount >= 5) ? 100000 : 0;
    }

    // TODO: Override method resign()
    // Tampilkan: "<name> (<position>) berhenti sebagai freelancer"
    // Lalu panggil resign() pada kelas Employee
    @Override
    public void resign() {
        System.out.println(super.getName() + " (Freelancer) berhenti sebagai freelancer");
        super.resign();
    }

    // TODO: Buat getter untuk projectCount dan payPerProject
    public int getProjectCount() {
        return projectCount;
    }

    public int getPayPerProject() {
        return payPerProject;
    }

    // TODO: Buat setter untuk payPerProject
    public void setPayPerProject(int newPayPerProject) {
        payPerProject = newPayPerProject;
    }
}