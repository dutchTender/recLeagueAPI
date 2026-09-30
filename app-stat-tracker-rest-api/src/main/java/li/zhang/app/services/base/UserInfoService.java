package li.zhang.app.services.base;

import li.zhang.app.model.core.BaseService;
import li.zhang.app.persistence.dao.base.UserInfoDAO;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserInfoService implements BaseService<UserInfo, UserInfoDTO> {

    private static final Logger logger = Logger.getLogger(UserInfoService.class.getName());
    private final UserInfoDAO userInfoDAO;

    public UserInfoService(UserInfoDAO userInfoDAO)
    {
        this.userInfoDAO = userInfoDAO;
    }
    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public UserInfoDTO find(Long id) {
        return this.userInfoDAO.findUserInfoBy(id).orElse(null);
    }

    @Override
    public UserInfo findByExample(Example<UserInfo> example) {
        return this.userInfoDAO.findUserInfoBy(example).orElse(null);
    }

    @Override
    public List<UserInfoDTO> findAll() {
        return this.userInfoDAO.findAllUserInfo();
    }

    @Override
    public List<UserInfo> findAllByExample(Example<UserInfo> example) {
        return this.userInfoDAO.findAllUserInfoBy(example);
    }

    @Override
    public Page<UserInfoDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return this.userInfoDAO.findAllUserInfoPage(pageable);
    }

    @Override
    public UserInfo create(UserInfo entity) {
        return this.userInfoDAO.save(entity);
    }

    @Override
    public UserInfo update(UserInfo entity) {
        return this.userInfoDAO.save(entity);
    }

    @Override
    public void delete(UserInfo entity) {
            this.userInfoDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
            this.userInfoDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
            this.userInfoDAO.deleteAll();
    }

    @Override
    public long count() {
        return this.userInfoDAO.count();
    }
}
