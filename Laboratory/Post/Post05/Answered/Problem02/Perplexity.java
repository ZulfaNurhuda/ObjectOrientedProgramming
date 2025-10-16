public final class Perplexity extends Chatbot {
    public Perplexity(CasualResponseStyle responseStyle, WebDeliveryChannel deliveryChannel) {
        super("Perplexity", responseStyle, deliveryChannel);
    }

    @Override
    protected String respondToQuestion(UserMessage message) {
        String content = message == null ? "" : message.getContent();
        if (content == null || content.trim().isEmpty()) {
            return "That's a tricky question, but let's figure it out together!";
        }
        return "Great question! Let's explore: " + content;
    }

    @Override
    protected String respondToGreeting(UserMessage message) {
        return "Hi friend! Awesome to hear from you.";
    }

    @Override
    protected String respondToUnknown(UserMessage message) {
        return "I might need a hint to answer that.";
    }
}
