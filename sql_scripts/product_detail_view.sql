CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `halal_products`.`product_detail` AS
    SELECT 
        `s`.`id` AS `id`,
        `s`.`region_id` AS `region_id`,
        `s`.`name` AS `name`,
        `s`.`address` AS `address`,
        `s`.`zipcode` AS `zipcode`,
        `p`.`manufacturer_id` AS `manufacturer_id`
    FROM
        ((((`halal_products`.`product` `p`
        JOIN `halal_products`.`halal_status` `hs` ON ((`p`.`halal_status_id` = `hs`.`id`)))
        JOIN `halal_products`.`manufacturer` `m` ON ((`p`.`manufacturer_id` = `m`.`id`)))
        JOIN `halal_products`.`product_store` `ps` ON ((`ps`.`product_id` = `p`.`id`)))
        JOIN `halal_products`.`store` `s` ON ((`ps`.`store_id` = `s`.`id`)))