package model.checker;

public interface ConfigurationManager<T> {
    T getConfiguration();
    void updateConfiguration(T configuration);
}
