package model.checker;
// todo separate methods for load from cache and load from repository
// todo Cache
public interface ConfigurationManager<T> {
    T getConfiguration();
    void updateConfiguration(T configuration);
    void isCached(boolean isCached);
}
