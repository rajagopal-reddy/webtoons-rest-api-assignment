package com.webtoons.app.service;

import com.webtoons.app.model.Webtoons;
import com.webtoons.app.repository.WebtoonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebtoonsServiceImpl implements WebtoonsService{

    private final WebtoonsRepository webtoonRepository;

    @Override
    public List<Webtoons> getAllWebtoons() {
        return webtoonRepository.findAll();
    }

    @Override
    public Webtoons getWebtoonsById(String id) {
        return webtoonRepository.findById(id).orElse(null);
    }

    @Override
    public Webtoons addWebtoons(Webtoons webtoon) {
        return webtoonRepository.save(webtoon);
    }

    @Override
    public void deleteWebtoons(String id) {
        webtoonRepository.deleteById(id);
    }
}
