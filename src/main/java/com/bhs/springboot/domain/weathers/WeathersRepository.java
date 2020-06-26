package com.bhs.springboot.domain.weathers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeathersRepository extends MongoRepository<Weathers, String> {



}
