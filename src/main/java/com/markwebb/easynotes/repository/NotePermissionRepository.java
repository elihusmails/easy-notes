package com.markwebb.easynotes.repository;

import com.markwebb.easynotes.model.NotePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotePermissionRepository extends JpaRepository<NotePermission,Long> {

}
