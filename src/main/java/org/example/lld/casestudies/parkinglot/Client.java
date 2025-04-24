package org.example.lld.casestudies.parkinglot;

import org.example.lld.casestudies.parkinglot.repository.GateRepository;
import org.example.lld.casestudies.parkinglot.repository.ParkingLotRepository;
import org.example.lld.casestudies.parkinglot.repository.TokenRepository;
import org.example.lld.casestudies.parkinglot.repository.VehicleRepository;
import org.example.lld.casestudies.parkinglot.service.TokenService;
import org.example.lld.casestudies.parkinglot.controller.TokenController;

public class Client {
    public static void main(String[] args) {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TokenRepository tokenRepository = new TokenRepository();
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TokenService tokenService = new TokenService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                tokenRepository
        );

        TokenController tokenController = new TokenController(tokenService);
//        tokenController.issueToken();
    }
}
// Controllers , repo , services
// Controller -> service -> repo