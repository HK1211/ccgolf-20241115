package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SHARED_CODE_PROGRAM_MANAGEMENT", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_PROGRAM_MANAGEMENT_IDX_01", columnNames = {"CODE_TYPE", "CODE", "PROGRAM_ID"}),
        @UniqueConstraint(name = "UNIQUE_PROGRAM_MANAGEMENT_IDX_02", columnNames = {"PROGRAM_PATH"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodeProgramManagement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_PROGRAM_MANAGEMENT_SEQ", nullable = false)
    private Long sharedCodeProgramManagementSeq;

    @Column(name = "CODE_TYPE", nullable = false, length = 20)
    private String codeType;

    @Column(name = "CODE", nullable = false, length = 10)
    private String code;

    @Column(name = "PROGRAM_ID", length = 10)
    private String programId;

    @Column(name = "PROGRAM_TYPE_CODE", length = 10)
    private String programTypeCode;

    @Column(name = "PROGRAM_NAME", nullable = false, length = 20)
    private String programName;

    @Column(name = "PROGRAM_DESCRIPTION", length = 255)
    private String programDescription;

    @Column(name = "PROGRAM_PATH", length = 255)
    private String programPath;

    @Column(name = "PROGRAM_PARAMETER", length = 255)
    private String programParameter;

    @Column(name = "PROGRAM_USE_START_DATE")
    private LocalDateTime programUseStartDate;

    @Column(name = "PROGRAM_USE_END_DATE")
    private LocalDateTime programUseEndDate;

    @Column(name = "PROGRAM_SORT_ORDER")
    private Integer programSortOrder;
}
