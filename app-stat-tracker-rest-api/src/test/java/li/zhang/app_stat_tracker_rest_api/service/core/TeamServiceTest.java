package li.zhang.app_stat_tracker_rest_api.service.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.List;

import li.zhang.app_stat_tracker_rest_api.persistence.dao.core.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.core.TeamDTO;

import li.zhang.app_stat_tracker_rest_api.services.core.TeamService;
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
        TeamDTO result = service.find(entityId);
        assertNotNull(result);
        assertEquals("Alice", result.getTeamName());
        verify(repository, times(1)).findTeamById(entityId);
    }
}

