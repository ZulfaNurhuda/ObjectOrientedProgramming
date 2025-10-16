public class UserMessage {
    private final String content;
    private final MessageType type;

    public UserMessage(String content, MessageType type) {
        this.content = content == null ? "" : content;
        this.type = type == null ? MessageType.UNKNOWN : type;
    }

    public final String getContent() {
        return content;
    }

    public final MessageType getType() {
        return type;
    }

    public String deliverTo(Chatbot chatbot) {
        if (chatbot == null) {
            return "No chatbot available to respond.";
        }
        return chatbot.reply(this);
    }
}
