package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alf.api.web.models.CompanyInfo;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {

}