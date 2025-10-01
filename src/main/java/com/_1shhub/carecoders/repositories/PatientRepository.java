package com._1shhub.carecoders.repositories;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

public interface AddressRepository extends JpaRepository<Address, Long> {
}

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

public interface HealthStatusRepository extends JpaRepository<HealthStatus, Long> {
}

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}

public interface ReportRepository extends JpaRepository<Report, Long> {
}

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
}
