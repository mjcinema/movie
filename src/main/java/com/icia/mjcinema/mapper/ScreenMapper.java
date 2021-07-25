package com.icia.mjcinema.mapper;

import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.domain.Screening;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScreenMapper {
    List<Screening> getScreens();
}
