package tabula.announcement.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tabula.announcement.service.AnnouncementService;

@AllArgsConstructor
@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping
    public String announcement(Model model){

        model.addAttribute("announcements", announcementService.findAll());

        return "announcement/announcements";

    }
}
