package app.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Employees")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int companyId;
    private int userId;
    private String roleId;
    private int workLoad;
    private String status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Assignment.class,
    mappedBy = "employee")
//    @JsonIgnoreProperties("employee")
    @JsonbTransient
    private List<Assignment> assignments = new LinkedList<>();

    public Employee() {
    }

    public Employee(int id, int companyId, int userId, String roleId,
                    int workLoad, String status) {
        this.id = id;
        this.companyId = companyId;
        this.userId = userId;
        this.roleId = roleId;
        this.workLoad = workLoad;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public int getWorkLoad() {
        return workLoad;
    }

    public void setWorkLoad(int workLoad) {
        this.workLoad = workLoad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<Assignment> getAssignments() {
        return assignments;
    }


    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

//    @Override
//    public String toString() {
//        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
//                .add("id=" + id)
//                .add("companyId=" + companyId)
//                .add("userId=" + userId)
//                .add("roleId='" + roleId + "'")
//                .add("workLoad=" + workLoad)
//                .add("status='" + status + "'")
//                .toString();
//    }
}
