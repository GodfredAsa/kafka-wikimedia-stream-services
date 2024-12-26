package io.redit.kafkaconsumerdb.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {
}
