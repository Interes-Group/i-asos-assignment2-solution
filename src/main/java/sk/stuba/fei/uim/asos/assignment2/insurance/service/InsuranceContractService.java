package sk.stuba.fei.uim.asos.assignment2.insurance.service;

import sk.stuba.fei.uim.asos.assignment2.ws.InsuranceBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InsuranceContractService {

    private final AtomicLong idCounter;
    private final Map<Long, InsuranceBase> contracts;

    public InsuranceContractService() {
        idCounter = new AtomicLong(0);
        contracts = new HashMap<>();
    }

    public InsuranceBase create(InsuranceBase contract) {
        contract.setId(idCounter.incrementAndGet());
        contracts.put(contract.getId(), contract);
        return contract;
    }

    public InsuranceBase update(InsuranceBase contract) {
        if (!contracts.containsKey(contract.getId()))
            throw new IllegalArgumentException("Contract id:" + contract.getId() + " has not been found!");
        return contracts.put(contract.getId(), contract);
    }

    public List<InsuranceBase> getAll() {
        return new ArrayList<>(contracts.values());
    }

    public List<InsuranceBase> getByUserId(Long userId) {
        return contracts.values().stream().filter(insuranceBase -> insuranceBase.getInsurerId() == userId)
                .collect(Collectors.toList());
    }
}
