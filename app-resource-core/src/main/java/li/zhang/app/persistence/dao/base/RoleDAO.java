package li.zhang.app.persistence.dao.base;

import li.zhang.app.persistence.entity.base.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RoleDAO extends JpaRepository<Role, Long>, QueryByExampleExecutor<Role> {
}
