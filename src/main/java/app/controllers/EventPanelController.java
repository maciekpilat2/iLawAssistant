package app.controllers;

import app.models.Event;
import app.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import app.models.Scan;
import app.repositories.ScanRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import app.services.ScanService;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Pilat
 */
@Controller
public class EventPanelController {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    ScanService scanService;
    @Autowired
    ScanRepository scanRepository;

    private static String UPLOADED_FOLDER = "E://iLawAssistant//";

    @GetMapping("/eventpanel")
    public String eventPanel(@RequestParam("eventId") Long eventId, Model model) {
        Scan scan = new Scan();
        model.addAttribute("scan", scan);
        model.addAttribute("event", eventRepository.findOne(eventId));
        model.addAttribute("scanList", scanRepository.findAllScanToEvent(eventId));
        System.out.println("To lista skanów: " + scanRepository.findAllScanToEvent(eventId).contains(scan));
        return "eventpanel";
    }
    @PostMapping("/eventpanel")
    public String eventPanelSubmit(
            @RequestParam("eventId") Long eventId,
            Model model,
            @ModelAttribute Scan scan,
            @ModelAttribute Event event,
            @RequestParam("scanMultipart") MultipartFile scanMultipart,
            RedirectAttributes redirectAttributes
    ) throws IOException {

        if (scanMultipart.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Wybierz skan dokumentu!");
            redirectAttributes.addAttribute("eventId", eventId);
            return "redirect:eventpanel";
        }
        try {

// Tworzy plik i zapisuje tam gdzie wskazuje stala
            byte[] bytes = scanMultipart.getBytes();
            redirectAttributes.addFlashAttribute("message", "Zapisałeś plik: '" + scanMultipart.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
// zapisuje na FTP
        scanService.uploadFileToFtp(scanMultipart.getBytes(), scan.getScanName() + ".jpg");
        redirectAttributes.addAttribute("eventId", eventId);
// zapisuje dane i url dla MySQL zenbox
        scan.setScanUrl("http://maciekpilat.pl/iLawAssistantScans/" + scan.getScanName());
        scan.setEvent(eventRepository.findOne(eventId));
// wysylam zapytanie do api o OCR,  i umieszczam w obiekcie SCAN do zpisania w MySQL        
        scan.setScanJSON(scanService.sendOCRRequest(scan.getScanUrl()));
        scanRepository.save(scan);
        return "redirect:/eventpanel";
    }
}
