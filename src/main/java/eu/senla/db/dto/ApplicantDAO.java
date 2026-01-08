package eu.senla.db.dto;

import eu.senla.db.entity.Applicant;

import java.util.Optional;

public interface ApplicantDAO extends GenericDao<Applicant> {

    Optional<Applicant> findByEmail(String email);

}
