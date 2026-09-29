package li.zhang.app.persistence.entity.base;

import jakarta.persistence.*;
import li.zhang.app.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name="Permission")
public class Permission implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String entityName;
    private String entityPermission;

    public Permission() {
    }

    public Permission(String entityName, String entityPermission) {
        this.entityName = entityName;
        this.entityPermission = entityPermission;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) && Objects.equals(entityName, that.entityName) && Objects.equals(entityPermission, that.entityPermission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityName, entityPermission);
    }
}
