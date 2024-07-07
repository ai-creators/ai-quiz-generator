package com.aiquizgenerator.backend.account.entities;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 30, unique = true, nullable = false)
    private String sub;

    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedAt;

    public Account(String sub, String username) {
        this.sub = sub;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getSub() {
        return sub;
    }

    public String getUsername() {
        return username;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }
}
