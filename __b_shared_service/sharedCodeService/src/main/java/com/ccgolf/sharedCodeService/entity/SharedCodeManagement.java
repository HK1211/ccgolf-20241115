package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SHARED_CODE_MANAGEMENT", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_CODE_MANAGEMENT_IDX_01", columnNames = {"CODE_TYPE", "CODE"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodeManagement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_MANAGEMENT_SEQ", nullable = false)
    private Long sharedCodeManagementSeq;

    @Column(name = "CODE_TYPE", nullable = false, length = 20)
    private String codeType;

    @Column(name = "PARENT_CODE", length = 10)
    private String parentCode;

    @Column(name = "CODE", nullable = false, length = 10)
    private String code;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Column(name = "SORT_ORDER")
    private Integer sortOrder;
}
