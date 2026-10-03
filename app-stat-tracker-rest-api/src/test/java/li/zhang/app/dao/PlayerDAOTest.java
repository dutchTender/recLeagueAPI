package li.zhang.app.dao;


import li.zhang.app.persistence.dao.base.UserInfoDAO;
import li.zhang.app.persistence.dao.core.PlayerDAO;
import li.zhang.app.persistence.dto.core.PlayerDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import li.zhang.app.persistence.entity.core.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerDAOTest {

    private final PlayerDAO  repository;
    private final UserInfoDAO userInfoDAO;
    @Autowired
    public PlayerDAOTest(PlayerDAO repository, UserInfoDAO userInfoDAO) {
        this.repository = repository;
        this.userInfoDAO = userInfoDAO;
    }

    @Test
    void saveAndFindById_ShouldReturnProduct() {

        Player entity = new Player();
        Player savedEntity = repository.saveAndFlush(entity);
        Optional<Player> foundProduct = repository.findById(savedEntity.getId());
        assertThat(foundProduct).isPresent();

    }

    @Test
    void findByCategory_ShouldReturnMatchingProducts() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("li");
        userInfoDAO.saveAndFlush(userInfo);
        Player entity = new Player(userInfo);
        Player savedEntity = repository.saveAndFlush(entity);
        List<PlayerDTO> playerList = repository.findAllBy();
        assertThat(playerList).hasSize(1);
        assertThat(playerList.stream().findFirst().orElse(null).getUser().getUserName()).isEqualTo(savedEntity.getUser().getUserName());

    }
}
