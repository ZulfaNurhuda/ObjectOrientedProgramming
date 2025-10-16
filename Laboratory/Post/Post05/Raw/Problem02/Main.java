public class Main {
    public static void main(String[] args) {
        CasualResponseStyle casual = new CasualResponseStyle();
        WebDeliveryChannel webDeliveryChannel = new WebDeliveryChannel();

        Grok grok = new Grok(casual, webDeliveryChannel);
        Perplexity perplexity = new Perplexity(casual, webDeliveryChannel);

        UserMessage[] messages = new UserMessage[] {
                new UserMessage("Hi there!", MessageType.GREETING),
                new UserMessage("How do I reset my password?", MessageType.QUESTION),
                new UserMessage("", null)
        };

        System.out.println("== Perplexity chatbot ==");
        for (UserMessage message : messages) {
            System.out.println("User: " + message.getContent());
            System.out.println("Bot : " + message.deliverTo(perplexity));
        }

        System.out.println("== Grok chatbot ==");
        for (UserMessage message : messages) {
            System.out.println("User: " + message.getContent());
            System.out.println("Bot : " + message.deliverTo(grok));
        }
    }
}
