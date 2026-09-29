package li.zhang.app.dao;


import li.zhang.app.persistence.dao.core.PlayerDAO;
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
    @Autowired
    public PlayerDAOTest(PlayerDAO repository) {
        this.repository = repository;
    }

    @Test
    void saveAndFindById_ShouldReturnProduct() {

        Player entity = new Player();
        Player savedEntity = repository.save(entity);
        Optional<Player> foundProduct = repository.findById(savedEntity.getId());
        assertThat(foundProduct).isPresent();

    }

    @Test
    void findByCategory_ShouldReturnMatchingProducts() {

        List<Player> playerList = repository.findAll();
        assertThat(playerList).hasSize(3);

    }
}
