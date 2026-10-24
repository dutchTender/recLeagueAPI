package li.zhang.app.persistence.entity.base;

import jakarta.persistence.*;
import li.zhang.app.model.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name="Role")
public class Role implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Role() {
    }
    public Role(String roleName, Set<Permission> permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }
    private Set<Permission> permissions;
    private String roleName;
    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }
    public void removePermission(Permission permission) {
        this.permissions.remove(permission);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(roleName, role.roleName) && Objects.equals(permissions, role.permissions);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }
}
