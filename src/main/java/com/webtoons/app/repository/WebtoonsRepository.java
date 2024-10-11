package com.webtoons.app.repository;

import com.webtoons.app.model.Webtoons;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebtoonsRepository extends MongoRepository<Webtoons, String> {
}
