package li.zhang.app.persistence.dao.base;

import li.zhang.app.persistence.entity.base.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserInfoDAO extends JpaRepository<UserInfo, Long>, QueryByExampleExecutor<UserInfo> {
}
