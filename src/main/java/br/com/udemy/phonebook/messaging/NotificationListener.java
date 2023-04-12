package br.com.udemy.phonebook.messaging;

import br.com.udemy.phonebook.messaging.dto.NotificationDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MessagingChannels.class)
public class NotificationListener {

    @StreamListener(target = MessagingChannels.PHONEBOOK_NOTIFICATION_INPUT)
    public void handleNotification(NotificationDTO notification) {
        System.out.println("Mensagem recebida: " + notification.getNotification());
    }
}
