package com.webtoons.app.controller;

import com.webtoons.app.model.Webtoons;
import com.webtoons.app.service.WebtoonsService;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/webtoons")
public class WebtoonsController {
    @Autowired
    private WebtoonsService webtoonsService;

    // GET /webtoons: Fetch all webtoons
    @GetMapping
    public List<Webtoons> getAllWebtoons() {
        return webtoonsService.getAllWebtoons();
    }

    // GET /webtoons/{id}: Fetch a webtoon by ID
    @GetMapping("/{id}")
    public Webtoons getWebtoonById(@PathVariable String id) {
        return webtoonsService.getWebtoonsById(id);
    }

    // POST /webtoons: Add a new webtoon
    @PostMapping
    public Webtoons addWebtoon( @RequestBody Webtoons webtoon) {
        return webtoonsService.addWebtoons(webtoon);
    }

    // DELETE /webtoons/{id}: Delete a webtoon by ID
    @DeleteMapping("/{id}")
    public void deleteWebtoon(@PathVariable String id) {
        webtoonsService.deleteWebtoons(id);
    }
}

