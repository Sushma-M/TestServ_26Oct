/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testserv_26oct.adventureworks2014.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testserv_26oct.adventureworks2014.VjobCandidate;
import com.testserv_26oct.adventureworks2014.VjobCandidateId;


/**
 * ServiceImpl object for domain model class VjobCandidate.
 *
 * @see VjobCandidate
 */
@Service("AdventureWorks2014.VjobCandidateService")
public class VjobCandidateServiceImpl implements VjobCandidateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VjobCandidateServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2014.VjobCandidateDao")
    private WMGenericDao<VjobCandidate, VjobCandidateId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<VjobCandidate, VjobCandidateId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VjobCandidate getById(VjobCandidateId vjobcandidateId) throws EntityNotFoundException {
        LOGGER.debug("Finding VjobCandidate by id: {}", vjobcandidateId);
        VjobCandidate vjobCandidate = this.wmGenericDao.findById(vjobcandidateId);
        if (vjobCandidate == null){
            LOGGER.debug("No VjobCandidate found with id: {}", vjobcandidateId);
            throw new EntityNotFoundException(String.valueOf(vjobcandidateId));
        }
        return vjobCandidate;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public VjobCandidate findById(VjobCandidateId vjobcandidateId) {
        LOGGER.debug("Finding VjobCandidate by id: {}", vjobcandidateId);
        return this.wmGenericDao.findById(vjobcandidateId);
    }


	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public Page<VjobCandidate> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all VjobCandidates");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Page<VjobCandidate> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all VjobCandidates");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2014 for table VjobCandidate to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2014TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

