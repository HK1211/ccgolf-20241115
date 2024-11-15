package com.ccgolf.sharedCodeService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SHARED_CODE_MENU_MANAGEMENT", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_MENU_MANAGEMENT_IDX_01", columnNames = {"CODE_TYPE", "CODE", "UPPER_MENU_ID", "MENU_CODE"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SharedCodeMenuManagement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHARED_CODE_MENU_MANAGEMENT_SEQ", nullable = false)
    private Long sharedCodeMenuManagementSeq;

    @Column(name = "CODE_TYPE", nullable = false, length = 20)
    private String codeType;

    @Column(name = "CODE", nullable = false, length = 10)
    private String code;

    @Column(name = "UPPER_MENU_ID")
    private Long upperMenuId;

    @Column(name = "MENU_CODE", length = 10)
    private String menuCode;

    @Column(name = "MENU_LEVEL", nullable = false)
    private Integer menuLevel = 0;

    @Column(name = "MENU_NAME", nullable = false, length = 20)
    private String menuName;

    @Column(name = "MENU_SORT_ORDER")
    private Integer menuSortOrder;

    @Column(name = "MENU_USE_START_DATE")
    private LocalDateTime menuUseStartDate;

    @Column(name = "MENU_USE_END_DATE")
    private LocalDateTime menuUseEndDate;

    @Column(name = "MENU_DESCRIPTION", length = 255)
    private String menuDescription;

    @Column(name = "MENU_TYPE_CODE", length = 10)
    private String menuTypeCode;

    @Column(name = "MENU_TYPE_NAME", length = 20)
    private String menuTypeName;

    @Column(name = "MENU_TYPE_DESCRIPTION", length = 255)
    private String menuTypeDescription;

    @Column(name = "MENU_PARAMETER", length = 255)
    private String menuParameter;

    @Column(name = "MULTI_OPEN_STATUS")
    private Boolean multiOpenStatus;

    @Column(name = "HELP_PAGE_LINK", length = 255)
    private String helpPageLink;
}
