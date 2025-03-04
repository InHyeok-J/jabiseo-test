package com.jabiseo.certificate.repository;

import com.jabiseo.certificate.domain.Certificate;
import com.jabiseo.certificate.domain.CertificateRepository;
import com.jabiseo.certificate.exception.CertificateBusinessException;
import com.jabiseo.certificate.exception.CertificateErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CertificateRepositoryImpl implements CertificateRepository {

    private final JpaCertificateRepository jpaCertificateRepository;

    public Certificate findById(String id) {
        return jpaCertificateRepository.findById(id)
                .orElseThrow(() -> new CertificateBusinessException(CertificateErrorCode.CERTIFICATE_NOT_FOUND));
    }

    public List<Certificate> findAll() {
        return jpaCertificateRepository.findAll();
    }
}
