package com.webtoons.app.service;

import com.webtoons.app.model.Webtoons;

import java.util.List;

public interface WebtoonsService {
    List<Webtoons> getAllWebtoons();

    Webtoons getWebtoonsById(String id);

    Webtoons addWebtoons(Webtoons webtoon);

    void deleteWebtoons(String id);
}
