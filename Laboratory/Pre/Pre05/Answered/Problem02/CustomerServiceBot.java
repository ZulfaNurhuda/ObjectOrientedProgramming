public class CustomerServiceBot extends Chatbot {
    public CustomerServiceBot(String name) {
        super(name);
    }

    @Override
    public void respond() {
        System.out.println("Customer service bot " + getName() + " siap melayani Anda");
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer Service Bot " + getName() + " telah melayani " + getSessionCount() + " sesi");
    }

    public void handleComplaint(String complaint) {
        System.out.println("Menangani keluhan: " + complaint);
    }
}
