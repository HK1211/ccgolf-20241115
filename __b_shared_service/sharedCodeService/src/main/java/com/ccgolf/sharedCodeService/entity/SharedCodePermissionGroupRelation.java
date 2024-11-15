package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SHARED_CODE_PERMISSION_GROUP_RELATION")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodePermissionGroupRelation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_PERMISSION_GROUP_RELATION_SEQ", nullable = false)
    private Long sharedCodePermissionGroupRelationSeq;

    @Column(name = "PERMISSION_GROUP_SEQ", nullable = false)
    private Long permissionGroupSeq;

    @Column(name = "PERMISSION_SEQ", nullable = false)
    private Long permissionSeq;
}
