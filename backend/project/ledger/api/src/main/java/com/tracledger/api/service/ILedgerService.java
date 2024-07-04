package com.tracledger.api.service;

import com.tracledger.dsp.entity.WorkEntryEntity;

public interface ILedgerService {
    void addWorkEntry(WorkEntryEntity entry);
}
