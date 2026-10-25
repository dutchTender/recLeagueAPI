package li.zhang.app.persistence.dao.base;

import li.zhang.app.persistence.entity.base.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PermissionDAO  extends JpaRepository<Permission, Long>, QueryByExampleExecutor<Permission> {
}
