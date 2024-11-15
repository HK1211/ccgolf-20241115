package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_DETAIL_ATTRIBUTE_MANAGEMENT_IDX_01", columnNames = {"CODE_TYPE", "CODE", "ATTRIBUTE_CODE"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodeDetailAttributeManagement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_DETAIL_ATTRIBUTE_MANAGEMENT_SEQ", nullable = false)
    private Long sharedCodeDetailAttributeManagementSeq;

    @Column(name = "CODE_TYPE", nullable = false, length = 20)
    private String codeType;

    @Column(name = "CODE", nullable = false, length = 10)
    private String code;

    @Column(name = "ATTRIBUTE_CODE", nullable = false, length = 10)
    private String attributeCode;

    @Column(name = "ATTRIBUTE_NAME", nullable = false, length = 20)
    private String attributeName;

    @Column(name = "ATTRIBUTE_DESCRIPTION", length = 255)
    private String attributeDescription;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;
}
