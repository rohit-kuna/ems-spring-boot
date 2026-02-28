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
    - get by id, GET - /employees/{id}
    - update by id, PATCH - /employees/{id}
    - delete by id. DELETE - /employees/{id}
    - reqBody : should include address and passport details
- department :
    - get all departments, GET - /departments
    - create new department, POST - /departments
    - get department by id, POST - /departments/{id}
    - update a department, PATCH - /departments/{id}
- project :
    - get all projects, GET - /projects
    - create new project, POST - /projects
    - get project by id, GET - /projects/{id}
    - update a project by id, PATCH - /projects/{id}
    - delete a project by id, DELETE - /projects/{id}
- training :
    - get all trainings, GET - /trainings
    - create a new training, POST - /trainings
    - get training by id, GET - /trainings/{id}
    - update training details by id, PATCH - /trainings/{id}
    - deactivate training by id, - PATCH - /trainings/{id}/deactivate

## Associations functions needed :
- employee_projects :
    - get all projects assigned to an employee, GET - /employees/{empId}/projects
    - view all employees under a project, GET - /projects/{projectid}/employees
    - assign project to an employee, POST - /employees/{empId}/projects/{projectId}
    - unassign project to an employee, DELETE - /employees/{empId}/projects/{projectId}
- employee_training
    - view trainings assigned to an employee, GET - /employees/{empId}/trainings
    - assign trainings to an employee, POST - /employees/{empId}/trainings/{trainingId}
    - unassign trainings to an employee, DELTE - /employees/{empId}/trainings/{trainingId}
    - update the training details for an employee, PATCH - /employees/{empId}/trainings/{trainingId}
        - reqBody : update the dates for trainings start , end
