package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SHARED_CODE_PERMISSION")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodePermission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_PERMISSION_SEQ", nullable = false)
    private Long sharedCodePermissionSeq;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "TYPE", nullable = false, length = 20)
    private String type;
}
