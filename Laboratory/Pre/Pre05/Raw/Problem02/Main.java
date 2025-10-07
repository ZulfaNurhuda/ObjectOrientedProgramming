public class Main {
    public static void main(String[] args) {
        Chatbot[] arrayBot = new Chatbot[4];
        arrayBot[0] = new CustomerServiceBot("BotA");
        arrayBot[1] = new EducationalBot("BotB");
        arrayBot[2] = new EcommerceBot("BotC", "Tokopedia");
        arrayBot[3] = new MathTutorBot("BotD", "Calculus");

        System.out.println("=== RESPOND TEST ===");
        for (int i = 0; i < 4; i++) {
            arrayBot[i].respond();
        }

        System.out.println("\n=== SESSION TEST ===");
        for (int i = 0; i < 4; i++) {
            arrayBot[i].startSession();
        }

        System.out.println("\n=== DISPLAY INFO TEST ===");
        for (Chatbot bot : arrayBot) {
            bot.displayInfo();
        }

        System.out.println("\n=== SPECIFIC METHOD TEST ===");
        CustomerServiceBot csBot = (CustomerServiceBot) arrayBot[0];
        csBot.handleComplaint("Produk tidak sesuai");

        EducationalBot eduBot = (EducationalBot) arrayBot[1];
        eduBot.teachTopic("Polymorphism");

        EcommerceBot ecomBot = (EcommerceBot) arrayBot[2];
        ecomBot.processOrder("Laptop");

        MathTutorBot mathBot = (MathTutorBot) arrayBot[3];
        mathBot.solveProblem("integral x^2");

        System.out.println("\n=== METHOD OVERRIDING TEST ===");
        Chatbot bot1 = new EcommerceBot("BotE", "Shopee");
        bot1.respond();
        bot1.displayInfo();

        System.out.println("\n=== INSTANCEOF TEST ===");
        checkBotType(arrayBot[0]);
        checkBotType(arrayBot[2]);
        checkBotType(bot1);

        System.out.println("\n=== POLYMORPHIC ARRAY TEST ===");
        CustomerServiceBot tempBot1 = new EcommerceBot("PolyBot1", "Lazada");
        EducationalBot tempBot2 = new MathTutorBot("PolyBot2", "Algebra");

        tempBot1.respond();
        tempBot2.respond();

        System.out.println("\n=== INHERITANCE CHAIN TEST ===");
        System.out.println("EcommerceBot extends CustomerServiceBot:");
        ((CustomerServiceBot)arrayBot[2]).handleComplaint("Layanan lambat");

        System.out.println("\nMathTutorBot extends EducationalBot:");
        ((EducationalBot)arrayBot[3]).teachTopic("Algebra");

        System.out.println("\n=== DYNAMIC METHOD DISPATCH TEST ===");
        Chatbot[] mixedBots = {
            new CustomerServiceBot("DynamicBot1"),
            new EcommerceBot("DynamicBot2", "Bukalapak"),
            new EducationalBot("DynamicBot3"),
            new MathTutorBot("DynamicBot4", "Physics")
        };

        for (Chatbot bot : mixedBots) {
            bot.respond();
        }
    }

    // Method untuk test instanceof dan downcasting
    public static void checkBotType(Chatbot bot) {
        System.out.print("Bot " + bot.getBotType() + " - ");
        if (bot instanceof EcommerceBot) {
            System.out.println("Ini adalah EcommerceBot");
            ((EcommerceBot) bot).processOrder("Test Item");
        } else if (bot instanceof MathTutorBot) {
            System.out.println("Ini adalah MathTutorBot");
            ((MathTutorBot) bot).solveProblem("test problem");
        } else if (bot instanceof CustomerServiceBot) {
            System.out.println("Ini adalah CustomerServiceBot");
            ((CustomerServiceBot) bot).handleComplaint("Test complaint");
        } else if (bot instanceof EducationalBot) {
            System.out.println("Ini adalah EducationalBot");
            ((EducationalBot) bot).teachTopic("Test topic");
        }
    }
}
