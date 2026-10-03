package li.zhang.app.service.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Objects;

import li.zhang.app.persistence.dao.core.TeamDAO;
import li.zhang.app.persistence.dto.core.TeamDTO;

import li.zhang.app.services.core.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {

    @Mock
    private TeamDAO repository;

    @InjectMocks
    private TeamService service;


    @Test
    void getById_ShouldReturnEntity_WhenEntityExists() {
        // Arrange
        Long entityId = 1L;
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("Alice");
        when(repository.findTeamById(entityId)).thenReturn(List.of(teamDTO));
        List<TeamDTO> result = repository.findTeamById(entityId);
        assertNotNull(result);
        assertEquals("Alice", Objects.requireNonNull(result.stream().findFirst().orElse(null)).getTeamName());
        verify(repository, times(1)).findTeamById(entityId);
    }
}

