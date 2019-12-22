package xyz.justblink.core.database;

import org.springframework.data.repository.CrudRepository;

public interface BlinkRepository<E, T> extends CrudRepository<E, T> { }
