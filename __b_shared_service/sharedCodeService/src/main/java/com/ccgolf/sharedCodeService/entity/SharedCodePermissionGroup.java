package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SHARED_CODE_PERMISSION_GROUP", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_PERMISSION_GROUP_IDX_01", columnNames = {"CODE_TYPE", "CODE", "PERMISSION_GROUP_ID"}),
        @UniqueConstraint(name = "UNIQUE_PERMISSION_GROUP_IDX_02", columnNames = {"PERMISSION_GROUP_ID"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodePermissionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_PERMISSION_GROUP_SEQ", nullable = false)
    private Long sharedCodePermissionGroupSeq;

    @Column(name = "CODE_TYPE", nullable = false, length = 20)
    private String codeType;

    @Column(name = "CODE", nullable = false, length = 10)
    private String code;

    @Column(name = "PERMISSION_GROUP_ID", nullable = false, length = 20)
    private String permissionGroupId;

    @Column(name = "PERMISSION_GROUP_NAME", nullable = false, length = 20)
    private String permissionGroupName;

    @Column(name = "PERMISSION_GROUP_DESCRIPTION", length = 255)
    private String permissionGroupDescription;

    @Column(name = "PERMISSION_GROUP_START_DATE")
    private LocalDateTime permissionGroupStartDate;

    @Column(name = "PERMISSION_GROUP_END_DATE")
    private LocalDateTime permissionGroupEndDate;
}
