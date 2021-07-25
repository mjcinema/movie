package com.icia.mjcinema.service;

import com.icia.mjcinema.domain.Screening;
import com.icia.mjcinema.mapper.ScreenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ScreenService {

    private final ScreenMapper screenMapper;

    public List<Screening> screenlist() {
        return screenMapper.getScreens();
    }
}
