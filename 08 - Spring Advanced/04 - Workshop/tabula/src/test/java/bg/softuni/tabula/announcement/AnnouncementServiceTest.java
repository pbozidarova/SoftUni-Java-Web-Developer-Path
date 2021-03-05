package bg.softuni.tabula.announcement;

import bg.softuni.tabula.announcement.AnnouncementService;
import bg.softuni.tabula.announcement.dto.AnnouncementDTO;
import bg.softuni.tabula.announcement.model.AnnouncementEntity;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnnouncementServiceTest {

    private AnnouncementService serviceToTest;

    @Mock
    AnnouncementRepository mockAnnouncementRepository;

    @BeforeEach
    public void setUp(){
        serviceToTest = new AnnouncementService(mockAnnouncementRepository);
    }

    @Test
    public void testFindAll(){
        AnnouncementEntity announcementEntity = new AnnouncementEntity();

        announcementEntity.setTitle("Test announcement");
        announcementEntity.setDescription("Test description");
        announcementEntity.setUpdatedOn(Instant.now());
        announcementEntity.setCreatedOn(Instant.now());

        when(mockAnnouncementRepository.findAll())
                .thenReturn(List.of(announcementEntity));

        //act
        List<AnnouncementDTO> announcementDTOS = serviceToTest.findAll();

        //assert
        Assertions.assertEquals(1, announcementDTOS.size());
        AnnouncementDTO actualDTO = announcementDTOS.get(0);

        Assertions.assertEquals(announcementEntity.getTitle(), actualDTO.getTitle());
        Assertions.assertEquals(announcementEntity.getDescription(), actualDTO.getDescription());


    }

}
