package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "CREATE_USER_ID", length = 50, updatable = false)
    private String createUserId;

    @Column(name = "CREATE_USER_NAME", length = 50, updatable = false)
    private String createUserName;

    @Column(name = "CREATE_IP", length = 15, updatable = false)
    private String createIp;

    @Column(name = "UPDATED_AT", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "UPDATE_USER_ID", length = 50, insertable = false)
    private String updateUserId;

    @Column(name = "UPDATE_USER_NAME", length = 50, insertable = false)
    private String updateUserName;

    @Column(name = "UPDATE_IP", length = 15, insertable = false)
    private String updateIp;

    @Column(name = "VERSION", nullable = false, insertable = false)
    private Long version;
}
