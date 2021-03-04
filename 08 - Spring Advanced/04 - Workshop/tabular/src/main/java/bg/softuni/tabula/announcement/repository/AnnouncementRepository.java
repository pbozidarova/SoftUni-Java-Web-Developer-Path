package bg.softuni.tabula.announcement.repository;

import bg.softuni.tabula.announcement.model.AnnouncementEntity;
import java.time.Instant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Long> {

  void deleteByUpdatedOnBefore(Instant updatedOn);

}
