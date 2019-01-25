package model.checker.impl;

import model.checker.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RevisorServerFactoryImpl implements RevisorServerFactory {
    @Override
    public RevisorServer build() {
        RevisorServer revisorServer = new LocalRevisorServer();
        revisorServer.setRevisorServerConfiguration(this.initLocalServerConfiguration());
        return revisorServer;
    }

    @Override
    public RevisorServer build(RevisorServerConfiguration revisorServerConfiguration) {
        RevisorServer revisorServer = new RemoteRevisorServer();
        revisorServer.setRevisorServerConfiguration(revisorServerConfiguration);
        return revisorServer;
    }

    @Override
    public List<RevisorServer> build(RevisorsConfiguration revisorsConfiguration) {
        return revisorsConfiguration.getRevisorServerConfigurations()
                .stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    private RevisorServerConfiguration initLocalServerConfiguration() {
        RevisorServerConfiguration revisorServerConfiguration = new RevisorServerConfiguration(
                CheckerConstant.LOCALHOST,
                CheckerConstant.UNKNOWN_PORT,
                true
        );
        return revisorServerConfiguration;
    }
}
