module cpsc219project.portfoliotracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens cpsc219project.core to javafx.fxml;
    exports cpsc219project.core;
    exports cpsc219project.core.portfolioClasses;
    opens cpsc219project.core.portfolioClasses to javafx.fxml;
    exports cpsc219project.core.util;
    opens cpsc219project.core.util to javafx.fxml;
}