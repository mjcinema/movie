package com.icia.mjcinema.controller;

import com.icia.mjcinema.domain.Screening;
import com.icia.mjcinema.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ScreenController {

    private final ScreenService screenService;

    // 영화 예약페이지 상영관 리스트
    @GetMapping("/cinemaList")
    public String Screen(Model model) {
        List<Screening> screenings = screenService.screenlist();
        model.addAttribute("screenlist" , screenings);
        return "/movies/MovieReservation";
    }
}
