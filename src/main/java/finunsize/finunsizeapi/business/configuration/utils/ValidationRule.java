package finunsize.finunsizeapi.business.configuration.utils;

@FunctionalInterface
public interface ValidationRule<T> {
    boolean check();
}