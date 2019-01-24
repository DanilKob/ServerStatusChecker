package model.checker;

import java.util.List;

public interface RemoteRevisorServerFactory {
    RevisorServer build(RevisorServerConfiguration revisorServerConfiguration);
    List<RevisorServer> build(RevisorsConfiguration revisorsConfiguration);
}
