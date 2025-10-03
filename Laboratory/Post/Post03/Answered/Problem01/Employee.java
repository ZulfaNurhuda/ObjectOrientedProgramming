public abstract class Employee {
    protected String name;        
    protected int salary;         
    protected String position;    
    protected static int employeeCount = 0; 

    public Employee(String name, int salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        employeeCount++;

        System.out.println(name + " (" + position + ") telah bergabung");
    }

    public void displayInfo() {
        System.out.println("Nama : " + name);
        System.out.println("Jabatan : " + position);
        System.out.println("Gaji : " + salary);
    }
    
    public void resign() {
        employeeCount--;
        System.out.println("Jumlah karyawan: " + employeeCount);
    }

    
    public void work(){
        System.out.println(name + " (" + position + ") sedang bekerja");
    }
    
    public abstract int calculateBonus();

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
