package org.example.lld.casestudies.parkinglot.strategies;

import org.example.lld.casestudies.parkinglot.model.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategy(SlotAssignmentStrategyType slotAssignmentStrategyType) {
        if(slotAssignmentStrategyType.equals(SlotAssignmentStrategyType.RANDOM)) {
            return new RandomSlotAssignmentStrategy();
        }
        throw new IllegalArgumentException("Invalid SlotAssignmentStrategyType");
    }
}
