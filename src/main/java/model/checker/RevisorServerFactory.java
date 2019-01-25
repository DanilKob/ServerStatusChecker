package model.checker;

import java.util.List;

public interface RevisorServerFactory {
    RevisorServer build();
    RevisorServer build(RevisorServerConfiguration revisorServerConfiguration);
    List<RevisorServer> build(RevisorsConfiguration revisorsConfiguration);
}
