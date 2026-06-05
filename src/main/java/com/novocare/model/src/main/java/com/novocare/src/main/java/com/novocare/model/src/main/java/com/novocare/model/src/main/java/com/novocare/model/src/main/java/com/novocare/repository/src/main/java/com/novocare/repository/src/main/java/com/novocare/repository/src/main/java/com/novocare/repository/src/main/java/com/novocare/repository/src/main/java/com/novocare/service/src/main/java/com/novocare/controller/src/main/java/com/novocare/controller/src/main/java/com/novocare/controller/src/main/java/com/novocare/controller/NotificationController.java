package com.novocare.controller;

import com.novocare.model.Notification;
import com.novocare.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @PostMapping("/send")
    public Notification sendNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
}
