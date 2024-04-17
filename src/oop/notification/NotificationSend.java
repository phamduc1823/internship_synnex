package oop.notification;
import java.util.HashMap;
import java.util.Map;

interface NotificationService {
    void sendNotification(String recipient, String message);
}

abstract class BaseNotificationService implements NotificationService {
    private Map<String, String> history = new HashMap<>();

    public Map<String, String> getHistory() {
        return history;
    }

    public void setHistory(String recipient, String message) {
        history.put(recipient, message);
    }

    @Override
    public void sendNotification(String recipient, String message) {
        //store request
        storeRequest(recipient, message);
        //send notification
        sendNotificationInternal(recipient, message);
        //store result
        storeResponse(recipient, message);
    }

    public void storeRequest(String recipient, String message) {
        setHistory(recipient, message);
    }

    public void storeResponse(String recipient, String message) {
        setHistory(recipient, message);
    }

    protected abstract void sendNotificationInternal(String recipient, String message);

}

class EmailNotificationService extends BaseNotificationService {
    @Override
    public void sendNotificationInternal(String recipient, String message) {
        System.out.println("Gui email toi " + recipient + ": " + message);
    }
}

class SmsNotificationService extends BaseNotificationService {
    @Override
    public void sendNotificationInternal(String recipient, String message) {
        System.out.println("Gui SMS toi " + recipient + ": " + message);
    }
}

class WhatsAppNotificationService extends BaseNotificationService {
    @Override
    public void sendNotificationInternal(String recipient, String message) {
        System.out.println("Gui WhatsApp toi " + recipient + ": " + message);
    }
}

public class NotificationSend {
    public static void main(String[] args) {
        NotificationService emailService = new EmailNotificationService();
        emailService.sendNotification("khang@vn.com", "Tien da thanh toan");

        NotificationService smsService = new SmsNotificationService();
        smsService.sendNotification("086895954", "Tien da thanh toan");

        NotificationService whatsAppService = new WhatsAppNotificationService();
        whatsAppService.sendNotification("0352621452", "Tien da thanh toan");

        // Lấy và in ra lịch sử của các thông báo đã gửi
        BaseNotificationService baseEmailService = (BaseNotificationService) emailService;
        BaseNotificationService baseSmsService = (BaseNotificationService) smsService;
        BaseNotificationService baseWhatsAppService = (BaseNotificationService) whatsAppService;

        System.out.println("Lich su gui email: " + baseEmailService.getHistory());
        System.out.println("Lich su gui SMS: " + baseSmsService.getHistory());
        System.out.println("Lich su gui WhatsApp: " + baseWhatsAppService.getHistory());
    }
}