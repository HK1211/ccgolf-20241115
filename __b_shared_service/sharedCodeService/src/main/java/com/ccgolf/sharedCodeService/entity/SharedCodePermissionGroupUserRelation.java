package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SHARED_CODE_PERMISSION_GROUP_USER_RELATION")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodePermissionGroupUserRelation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_PERMISSION_GROUP_USER_RELATION_SEQ", nullable = false)
    private Long sharedCodePermissionGroupUserRelationSeq;

    @Column(name = "PERMISSION_GROUP_SEQ", nullable = false)
    private Long permissionGroupSeq;

    @Column(name = "LOGIN_ID", nullable = false, length = 20)
    private String loginId;
}
