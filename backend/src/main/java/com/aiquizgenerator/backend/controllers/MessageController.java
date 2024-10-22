package com.aiquizgenerator.backend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiquizgenerator.backend.models.Message;
import com.aiquizgenerator.backend.services.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/public")
    public Message getPublic() {
        return messageService.getPublicMessage();
    }

    @GetMapping("/protected")
    public Message getProtected() {
        return messageService.getProtectedMessage();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('read:admin-messages')")
    public Message getAdmin() {
        return messageService.getAdminMessage();
    }
}
