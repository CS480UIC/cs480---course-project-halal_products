CREATE DEFINER=`root`@`localhost` PROCEDURE `unavailable_products`()
BEGIN
	Select distinct p.*, m.name as manufacturer_name, c.name as category_name,
    hs.status
	From product p
	Join manufacturer m on p.manufacturer_id = m.id
    Join product_category c on p.category_id = c.id
    Join halal_status hs on p.halal_status_id = hs.id
	Where p.halal_status_id = 1 and (Select Count(*) From product_store ps 
    where ps.product_id = p.id and ps.availability = 1) = 0
    Order By p.name;
END