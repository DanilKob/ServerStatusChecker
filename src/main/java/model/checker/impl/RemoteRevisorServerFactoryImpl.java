package model.checker.impl;

import model.checker.RemoteRevisorServerFactory;
import model.checker.RevisorServer;
import model.checker.RevisorServerConfiguration;
import model.checker.RevisorsConfiguration;

import java.util.List;
import java.util.stream.Collectors;

public class RemoteRevisorServerFactoryImpl implements RemoteRevisorServerFactory {
    @Override
    public RevisorServer build(RevisorServerConfiguration revisorServerConfiguration) {
        RemoteRevisorServer remoteRevisorServer = new RemoteRevisorServer();
        remoteRevisorServer.setRevisorServerConfiguration(revisorServerConfiguration);
        return remoteRevisorServer;
    }

    @Override
    public List<RevisorServer> build(RevisorsConfiguration revisorsConfiguration) {
        return revisorsConfiguration.getRevisorServerConfigurations()
                .stream()
                .map(this::build)
                .collect(Collectors.toList());
    }
}
