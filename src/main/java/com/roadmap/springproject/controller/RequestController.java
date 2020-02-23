package com.roadmap.springproject.controller;

import com.roadmap.springproject.LibraryService;
import com.roadmap.springproject.util.LibraryMappings;
import com.roadmap.springproject.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class RequestController {

    private final LibraryService libraryService;

    @Autowired
    public RequestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(LibraryMappings.LIBRARY)
    public String library(@RequestParam(defaultValue = "1") long shelf, Model model) {
        log.info("library called");
        model.addAttribute("shelf", libraryService.getShelf(shelf));
        return ViewNames.LIBRARY;
    }

    @GetMapping(LibraryMappings.BOX)
    public String viewBox(@RequestParam(defaultValue = "1") long box, Model model) {
        log.info("viewBox called");
        model.addAttribute("box", libraryService.getBox(box));
        return ViewNames.BOX;
    }

    @GetMapping(LibraryMappings.CARD)
    public String viewCard(@RequestParam(defaultValue = "1") long card, Model model) {
        log.info("viewCard called");
        model.addAttribute("card", libraryService.getCard(card));
        return ViewNames.CARD;
    }

}
