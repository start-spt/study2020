//package com.spt.test.mybatisplus.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//@Service("transactionService")
//public class TransactionService {
//
//    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
//
//    /**
//     * 事务管理
//     */
//    @Autowired
//    private PlatformTransactionManager baiTTransactionManager;
//
//    /**
//     * 事务开始
//     *
//     * @return
//     */
//    public TransactionStatus init() {
//        long start = System.currentTimeMillis();
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_COMMITTED);
//        TransactionStatus ts = baiTTransactionManager.getTransaction(def);
//        long end = System.currentTimeMillis();
//        logger.info("---start transaction cost:{}", (end - start));
//        return ts;
//    }
//
//    /**
//     * 事务提交
//     *
//     * @param status
//     */
//    public void commit(TransactionStatus status) {
//        if (status != null) {
//            baiTTransactionManager.commit(status);
//        }
//    }
//
//    /**
//     * 回滚事务
//     *
//     * @param status
//     */
//    public void rollback(TransactionStatus status) {
//        if (status != null) {
//            baiTTransactionManager.rollback(status);
//        }
//    }
//}