package com.razorpay.batch.repository;

import com.razorpay.batch.entity.Batch;
import com.razorpay.batch.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends BaseRepository<Batch, Long> {
}
