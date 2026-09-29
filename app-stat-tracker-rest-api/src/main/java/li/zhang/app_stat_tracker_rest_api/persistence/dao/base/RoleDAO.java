package li.zhang.app_stat_tracker_rest_api.persistence.dao.base;

import li.zhang.app_stat_tracker_rest_api.persistence.entity.base.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RoleDAO extends JpaRepository<Role, Long>, QueryByExampleExecutor<Role> {
}
