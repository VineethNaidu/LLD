package org.example.lld.casestudies.parkinglot.repository;

import org.example.lld.casestudies.parkinglot.model.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> findGateByGateNumber(int gateNumber) {
        if(gates.containsKey(gateNumber)){
            return Optional.of(gates.get(gateNumber));
        }
        // db.execute('Select * from gates where id = 11');
        return Optional.empty();
    }
}
