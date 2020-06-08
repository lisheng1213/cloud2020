package com.ls.springcloud.service.impl;

import com.ls.springcloud.dao.StorageDao;
import com.ls.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SGDBDS
 * @create 2020-06-02
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer numcount) {
        storageDao.decrease(productId,numcount);
        logger.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,numcount);
        logger.info("------->storage-service中扣减库存结束");
    }
}
