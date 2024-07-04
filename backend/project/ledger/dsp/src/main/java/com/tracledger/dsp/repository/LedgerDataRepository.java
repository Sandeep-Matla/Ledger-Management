package com.tracledger.dsp.repository;

import com.tracledger.dsp.entity.WorkEntryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
public interface LedgerDataRepository extends CrudRepository<WorkEntryEntity, Integer> {

    @Query(value = "select * from work_entries e where e.customer_id = " +
            "(select customer_id from customer_info c where c.first_name = ?1 and c.last_name = ?2)"
            , nativeQuery = true)
    public List<WorkEntryEntity> getAllEntriesOfCustomerByName(String customerFirstName, String  customerLastName);

    @Query("select e from WorkEntryEntity e where e.customer_id = ?1")
    public List<WorkEntryEntity> getAllEntriesOfCustomer(String customerId);

    @Query("select e from WorkEntryEntity e where e.customer_id = ?1")
    public List<WorkEntryEntity> getLatestEntriesOfCustomer(String customerId, Pageable pageable);

    @Query("select e from WorkEntryEntity e where e.date = ?1")
    public List<WorkEntryEntity> getLedgerOnDate(Date onDate);

    @Query("select e from WorkEntryEntity e where e.date between ?1 and ?2")
    public List<WorkEntryEntity> getLedgerInDateRange(Date fromDate ,Date toDate);

    @Query("select e from WorkEntryEntity e where e.customer_id = ?1 and e.date between ?2 and ?3")
    public List<WorkEntryEntity> getEntriesOfCustomerInDateRange(String customerId, Date fromDate ,Date toDate);

}
