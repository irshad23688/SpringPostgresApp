package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.Note;



@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
