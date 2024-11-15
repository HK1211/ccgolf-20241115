package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "SHARED_CODE_SEQ_MANAGEMENT", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_SEQ_MANAGEMENT_IDX_01", columnNames = {"TABLE_NAME", "COLUMN_NAME", "SEQUENCE_NUMBER"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodeSeqManagement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_SEQ_MANAGEMENT_SEQ", nullable = false)
    private Long sharedCodeSeqManagementSeq;

    @Column(name = "TABLE_NAME", nullable = false, length = 50)
    private String tableName;

    @Column(name = "COLUMN_NAME", nullable = false, length = 50)
    private String columnName;

    @Column(name = "SEQUENCE_NUMBER", nullable = false)
    private Long sequenceNumber;
}
