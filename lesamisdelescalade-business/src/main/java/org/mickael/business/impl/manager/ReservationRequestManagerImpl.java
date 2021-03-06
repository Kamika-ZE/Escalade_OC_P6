package org.mickael.business.impl.manager;

import org.mickael.business.contract.manager.ReservationRequestManager;
import org.mickael.business.impl.AbstractManager;
import org.mickael.model.bean.ReservationRequest;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReservationRequestManagerImpl extends AbstractManager implements ReservationRequestManager {
    @Override
    public void createReservationRequest(ReservationRequest reservationRequest) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getReservationRequestDao().createReservationRequest(reservationRequest);
            }
        });
    }

    @Override
    public ReservationRequest findReservationRequestById(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ReservationRequest reservationRequest = transactionTemplate.execute(transactionStatus -> {
            ReservationRequest reservationRequestTransaction;
            reservationRequestTransaction = getDaoFactory().getReservationRequestDao().findReservationRequestById(id);
            return reservationRequestTransaction;
        });

        return reservationRequest;
    }

    @Override
    public ReservationRequest findReservationRequestByGuidebookId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ReservationRequest reservationRequest = transactionTemplate.execute(transactionStatus -> {
            ReservationRequest reservationRequestTransaction;
            reservationRequestTransaction = getDaoFactory().getReservationRequestDao().findReservationRequestByGuidebookId(id);
            return reservationRequestTransaction;
        });

        return reservationRequest;
    }

    @Override
    public ReservationRequest findReservationRequestByMemberId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ReservationRequest reservationRequest = transactionTemplate.execute(transactionStatus -> {
            ReservationRequest reservationRequestTransaction;
            reservationRequestTransaction = getDaoFactory().getReservationRequestDao().findReservationRequestByMemberId(id);
            return reservationRequestTransaction;
        });

        return reservationRequest;
    }

    @Override
    public ReservationRequest findReservationRequestByMemberAndGuidebookId(Integer memberId, Integer guidebookId) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ReservationRequest reservationRequest = transactionTemplate.execute(transactionStatus -> {
            ReservationRequest reservationRequestTransaction;
            reservationRequestTransaction = getDaoFactory().getReservationRequestDao().findReservationRequestByMemberAndGuidebookId(memberId, guidebookId);
            return reservationRequestTransaction;
        });

        return reservationRequest;
    }

    @Override
    public ReservationRequest findReservationRequestByState(String status) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        ReservationRequest reservationRequest = transactionTemplate.execute(transactionStatus -> {
            ReservationRequest reservationRequestTransaction;
            reservationRequestTransaction = getDaoFactory().getReservationRequestDao().findReservationRequestByState(status);
            return reservationRequestTransaction;
        });

        return reservationRequest;
    }

    @Override
    public void updateReservationRequest(ReservationRequest reservationRequest) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getReservationRequestDao().updateReservationRequest(reservationRequest);
            }
        });

    }

    @Override
    public void deleteReservationRequest(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                getDaoFactory().getReservationRequestDao().deleteReservationRequest(id);
            }
        });

    }

    @Override
    public List<ReservationRequest> findAllReservationRequest() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<ReservationRequest> reservationRequestList = transactionTemplate.execute(transactionStatus -> {
            List<ReservationRequest> reservationRequestListTransaction = new ArrayList<>();
            reservationRequestListTransaction = getDaoFactory().getReservationRequestDao().findAllReservationRequest();
            return  reservationRequestListTransaction;
        });

        return reservationRequestList;
    }

    @Override
    public List<ReservationRequest> findAllReservationRequestByMemberId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<ReservationRequest> reservationRequestList = transactionTemplate.execute(transactionStatus -> {
            List<ReservationRequest> reservationRequestListTransaction = new ArrayList<>();
            reservationRequestListTransaction = getDaoFactory().getReservationRequestDao().findAllReservationRequestByMemberId(id);
            return  reservationRequestListTransaction;
        });

        return reservationRequestList;
    }

    @Override
    public List<ReservationRequest> findAllReservationRequestByGuidebookId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<ReservationRequest> reservationRequestList = transactionTemplate.execute(transactionStatus -> {
            List<ReservationRequest> reservationRequestListTransaction = new ArrayList<>();
            reservationRequestListTransaction = getDaoFactory().getReservationRequestDao().findAllReservationRequestByGuidebookId(id);
            return  reservationRequestListTransaction;
        });

        return reservationRequestList;
    }

    @Override
    public List<ReservationRequest> findAllReservationRequestByOwnerId(Integer id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());

        List<ReservationRequest> reservationRequestList = transactionTemplate.execute(transactionStatus -> {
            List<ReservationRequest> reservationRequestListTransaction = new ArrayList<>();
            reservationRequestListTransaction = getDaoFactory().getReservationRequestDao().findAllReservationRequestByOwnerId(id);
            return  reservationRequestListTransaction;
        });

        return reservationRequestList;
    }
}
