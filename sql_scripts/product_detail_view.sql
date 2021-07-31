CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `halal_products`.`product_detail` AS
    SELECT 
        `p`.`name` AS `product_name`,
        `m`.`name` AS `manufacturer_name`,
        `s`.`name` AS `store_name`,
        `p`.`certifications` AS `certifications`,
        `r`.`name` AS `region_name`
    FROM
        ((((`halal_products`.`product` `p`
        JOIN `halal_products`.`manufacturer` `m` ON ((`p`.`manufacturer_id` = `m`.`id`)))
        JOIN `halal_products`.`product_store` `ps` ON ((`ps`.`product_id` = `p`.`id`)))
        JOIN `halal_products`.`store` `s` ON ((`ps`.`store_id` = `s`.`id`)))
        JOIN `halal_products`.`region` `r` ON ((`s`.`region_id` = `r`.`id`)))
    WHERE
        ((IFNULL(`p`.`halal_status_id`, 0) = 1)
            AND (`p`.`certifications` IS NOT NULL))