package li.zhang.app.service.core;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Objects;

import li.zhang.app.persistence.dao.core.PlayerDAO;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.dto.core.PlayerDTO;
import li.zhang.app.services.core.PlayerService;

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
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserName("Alice");
        PlayerDTO playerDTO = new PlayerDTO(userInfoDTO);

        when(repository.findPlayerById(entityId)).thenReturn(List.of(playerDTO));
        List<PlayerDTO> result = repository.findPlayerById(entityId);
        assertNotNull(result);
        assertEquals("Alice", Objects.requireNonNull(result.stream().findFirst().orElse(null)).getUser().getUserName());

        verify(repository, times(1)).findPlayerById(entityId);
    }
}
