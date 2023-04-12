package br.com.udemy.phonebook.messaging;

import br.com.udemy.phonebook.messaging.dto.NotificationDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer {

    private final MessagingChannels channels;

    public NotificationProducer(MessagingChannels channels) {
        this.channels = channels;
    }

    public void sendEvent(String notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setNotification("Testando");

        Message<NotificationDTO> notificationMessage = MessageBuilder.withPayload(notificationDTO).build();
        channels.phonebookNotificationOutput().send(notificationMessage);
    }
}
