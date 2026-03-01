## Entities classification :

---
| Table | Relationship meaning |
| --- | --- |
| `employee` | Strong |
| `passport` | Child to employee (1-1) |
| `address` | Child to employee (M-1) |
| `department` | Strong |
| `project` | Strong |
| `training` | Strong |
| `employee_training_lookup` | Relationship resource |
| `employee_project` | Relationship only |
---

Functionalities : Think of APIs as functionalities not CRUD as basic CRUD methods to talk to repository are already present in JPA

## Strong Entity :
- employee :
    - get all employees, GET - /employees
    - create new employee, POST - /employees
    - get by id, GET - /employees/{employeId}
    - update by id, PATCH - /employees/{employeId}
    - delete by id. DELETE - /employees/{employeId}
    - reqBody : should include address and passport details
- department :
    - get all departments, GET - /departments
    - create new department, POST - /departments
    - get department by id, POST - /departments/{departmentId}
    - update a department, PATCH - /departments/{departmentId}
- project :
    - get all projects, GET - /projects
    - create new project, POST - /projects
    - get project by id, GET - /projects/{projectId}
    - update a project by id, PATCH - /projects/{projectId}
    - delete a project by id, DELETE - /projects/{projectId}
- training :
    - get all trainings, GET - /trainings
    - create a new training, POST - /trainings
    - get training by id, GET - /trainings/{trainingId}
    - update training details by id, PATCH - /trainings/{trainingId}
    - deactivate training by id, - PATCH - /trainings/{trainingId}/deactivate

## Associations functions needed :
- employee_projects :
    - get all projects assigned to an employee, GET - /employees/{employeeId}/projects
    - view all employees under a project, GET - /projects/{projectid}/employees
    - assign project to an employee, POST - /employees/{employeeId}/projects/{projectId}/assign
    - unassign project to an employee, DELETE - /employees/{employeeId}/projects/{projectId}/unassign
- employee_training
    - view trainings assigned to an employee, GET - /employees/{employeeId}/trainings
    - update the training details for an employee, PATCH - /employees/{employeeId}/trainings/{trainingId}
        - reqBody : update the dates for trainings start , end
    - assign trainings to an employee, POST - /employees/{employeeId}/trainings/{trainingId}
    - unassign trainings to an employee, DELTE - /employees/{employeeId}/trainings/{trainingId}

