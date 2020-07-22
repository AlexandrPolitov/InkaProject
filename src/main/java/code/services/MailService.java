package code.services;

public interface MailService {
    public boolean sendMessage(String to, String subject, String text);
}
