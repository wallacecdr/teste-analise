package br.com.udemy.phonebook.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessagingChannels {

    String PHONEBOOK_NOTIFICATION_INPUT = "phonebook-notification-input";
    String PHONEBOOK_NOTIFICATION_OUTPUT = "phonebook-notification-output";

    @Input(PHONEBOOK_NOTIFICATION_INPUT)
    SubscribableChannel phonebookNotificationInput();

    @Output(PHONEBOOK_NOTIFICATION_OUTPUT)
    MessageChannel phonebookNotificationOutput();
}
