public class Chatbot {
    private String name;
    private int numSessions = 0;

    public Chatbot(String name) {
        this.name = name;
    }

    /** ================== GETTER ================== */
    public String getName() {
        return new String(name);
    }

    public int getSessionCount() {
        return numSessions;
    }
    /** ============================================ */

    public void respond() {
        /** In this function, an override will be performed in the subclass. */
        System.out.println("Chatbot " + name + " siap membantu");
    }

    public void startSession() {
        this.numSessions++;
        System.out.println("Session started for " + name);
    }

    public void displayInfo() {
        /** In this function, an override will be performed in the subclass. */
        System.out.println("Bot " + name + " telah melayani " + numSessions + " sesi");
    }

    public String getBotType() {
        String botType;
        if (this instanceof EcommerceBot) {
            botType = "Ecommerce Bot";
        } else if (this instanceof MathTutorBot) {
            botType = "Math Tutor Bot";
        } else if (this instanceof CustomerServiceBot) {
            botType = "Customer Service Bot";
        } else if (this instanceof EducationalBot) {
            botType = "Educational Bot";
        } else {
            botType = "Chatbot";
        }
        return botType;
    }
}