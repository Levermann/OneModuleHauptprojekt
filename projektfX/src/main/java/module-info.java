module MappingAndJFX {
    requires javafx.controls;
    requires javafx.base;
    requires org.hibernate.orm.core;
    requires log4j;
    requires java.sql;
    requires javax.inject;
    requires java.naming;
    requires java.logging;
    requires java.persistence;
    requires javafx.fxml;


    opens MappingAndJFX to javafx.fxml;
    exports MappingAndJFX;
}