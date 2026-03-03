package com.rohit.ems.dto;

import lombok.Data;
import java.util.List;

@Data
public class EmployeeResult {
    private Long id;
    private String name;
    private String email;
    // private PassportResult passport;
    // private DepartmentResult department;
    // private List<AddressResult> addresses;
}
