public final class Grok extends Chatbot {
    public Grok(CasualResponseStyle responseStyle, WebDeliveryChannel deliveryChannel) {
        super("Grok", responseStyle, deliveryChannel);
    }

    @Override
    protected String respondToQuestion(UserMessage message) {
        String content = message == null ? "" : message.getContent();
        if (content == null || content.trim().isEmpty()) {
            return "Here is the requested information.";
        }
        return "Here is the information requested: " + content;
    }

    @Override
    protected String respondToGreeting(UserMessage message) {
        return "Greetings, it's Grok. How may I assist you today?";
    }

    @Override
    protected String respondToUnknown(UserMessage message) {
        return "Please be clear about your request.";
    }
}
