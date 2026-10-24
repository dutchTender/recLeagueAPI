package li.zhang.app.services.base;

import li.zhang.app.model.core.BaseService;
import li.zhang.app.persistence.dao.base.UserInfoDAO;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import li.zhang.app.persistence.mapper.UserInfoMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserInfoService implements BaseService<UserInfo, UserInfoDTO> {

    private static final Logger logger = Logger.getLogger(UserInfoService.class.getName());
    private final UserInfoMapper mapper;
    private final UserInfoDAO userInfoDAO;

    public UserInfoService(UserInfoMapper mapper, UserInfoDAO userInfoDAO)
    {
        this.mapper = mapper;
        this.userInfoDAO = userInfoDAO;
    }
    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public UserInfoDTO find(Long id) {
        return mapper.toDTO(this.userInfoDAO.findUserInfoBy(id).orElse(null));
    }

    public UserInfoDTO findByUserName(String username) {
        return mapper.toDTO(this.userInfoDAO.findByUserName(username).orElse(null));
    }
    @Override
    public UserInfo findByExample(Example<UserInfo> example) {
        return this.userInfoDAO.findUserInfoBy(example).orElse(null);
    }

    @Override
    public List<UserInfoDTO> findAll() {
        return mapper.toDTOList(this.userInfoDAO.findAllBy());
    }

    @Override
    public List<UserInfo> findAllByExample(Example<UserInfo> example) {
        return this.userInfoDAO.findAllBy(example);
    }


    public Page<UserInfoDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        Page<UserInfo> userPage =  this.userInfoDAO.findAllBy(pageable);

        return userPage.map(userInfo -> {
            UserInfoDTO dto = new UserInfoDTO();
            dto.setId(userInfo.getId());
            dto.setUserName(userInfo.getUserName());
            dto.setFirstName(userInfo.getFirstName());
            dto.setLastName(userInfo.getLastName());
            dto.setEmail(userInfo.getEmail());
            dto.setPhone(userInfo.getPhone());
            dto.setAddress(userInfo.getAddress());
            dto.setGender(userInfo.getGender());
            dto.setHeight(userInfo.getHeight());
            dto.setWeight(userInfo.getWeight());
            dto.setActive(userInfo.isActiveUser());

            return dto;
        });
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
