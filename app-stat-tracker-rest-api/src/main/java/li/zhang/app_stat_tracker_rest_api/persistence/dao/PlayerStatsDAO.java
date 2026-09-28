package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerStatsDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.PlayerStats;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.util.List;
import java.util.Optional;


public interface PlayerStatsDAO extends JpaRepository<PlayerStats, Long>, QueryByExampleExecutor<PlayerStats> {
                   Optional<PlayerStatsDAO> findPlayerStatsBy(String playerName);
                   Optional<PlayerStatsDTO> findPlayerStatsById(long id);
                   List<PlayerStatsDTO> findAllBy();
                   Page<PlayerStatsDTO> findAllBy(Pageable pageable);
                   List<PlayerStats> findAllPlayerStatsBy(Example<PlayerStats> example);
                   Optional<PlayerStats> findPlayerStatsBy(Example<PlayerStats> example);
}
