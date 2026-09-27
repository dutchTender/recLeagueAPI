package li.zhang.app_stat_tracker_rest_api.service.core;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Optional;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.services.core.PlayerService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerDAO repository;

    @InjectMocks
    private PlayerService service;
    @Test
    void getById_ShouldReturnEntity_WhenEntityExists() {
        // Arrange
        Long entityId = 1L;
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setUserName("Alice");
        when(repository.findPlayerById(entityId)).thenReturn(Optional.of(playerDTO));
        PlayerDTO result = service.find(entityId);
        assertNotNull(result);
        assertEquals("Alice", result.getUserName());

        verify(repository, times(1)).findPlayerById(entityId);
    }
}
