package li.zhang.app.persistence.dao.base;

import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface UserInfoDAO extends JpaRepository<UserInfo, Long>, QueryByExampleExecutor<UserInfo> {
    Optional<UserInfoDTO> findByUserName(String username);
    Optional<UserInfoDTO> findByEmail(String email);
    Optional<UserInfoDTO> findUserInfoBy(Long id);
    List<UserInfoDTO> findAllBy();
    Page<UserInfoDTO> findAllBy(Pageable pageable);
    Optional<UserInfo> findUserInfoBy(Example<UserInfo> example);

    List<UserInfo> findAllBy(Example<UserInfo> example);
}
