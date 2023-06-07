CREATE TABLE IF NOT EXISTS `tbl_request` (
                                             `id`         INTEGER  PRIMARY KEY AUTO_INCREMENT,
                                             `status` VARCHAR(50) NOT NULL,
    `amount`        INTEGER  NOT NULL
    );

INSERT INTO `tbl_request` (
    `id`,
    `status`,
    `amount`
) VALUES (
             1,
             'SUCCESS',
             20
         );